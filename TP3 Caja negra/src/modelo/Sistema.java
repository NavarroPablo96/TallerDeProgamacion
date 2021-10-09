// 
// Decompiled by Procyon v0.5.36
// 

package modelo;

import excepciones.NoEncontradoException;
import java.util.function.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import excepciones.ClaveYaExistenteException;
import excepciones.DatoInvalidoException;

public class Sistema
{
    private IndiceDoble<Alumno> alumnos;
    private IndiceDoble<Profesor> profesores;
    private IndiceDoble<Asignatura> planDeEstudio;
    private IndiceDoble<Cursada> calendario;
    
    public Sistema() {
        this.alumnos = new IndiceDoble<Alumno>();
        this.profesores = new IndiceDoble<Profesor>();
        this.planDeEstudio = new IndiceDoble<Asignatura>();
        this.calendario = new IndiceDoble<Cursada>();
    }
    
    public void agregarAlumno(final Alumno nuevo) throws ClaveYaExistenteException, DatoInvalidoException {
        if (!Persona.validaPersona(nuevo)) {
            throw new DatoInvalidoException(nuevo, "Se encontraron datos inv\u00c3¡lidos.");
        }
        nuevo.setLegajo(Alumno.getNuevoLegajo());
        this.alumnos.agregar(nuevo);
    }
    
    public void agregarProfesor(final Profesor nuevo) throws ClaveYaExistenteException, DatoInvalidoException {
        if (!Persona.validaPersona(nuevo)) {
            throw new DatoInvalidoException(nuevo, "Se encontraron datos inv\u00c3¡lidos.");
        }
        nuevo.setLegajo(Profesor.getNuevoLegajo());
        this.profesores.agregar(nuevo);
    }
    
    public void agregarAsignatura(final Asignatura nuevo) throws ClaveYaExistenteException, DatoInvalidoException {
        if (!Asignatura.validaAsignatura(nuevo)) {
            throw new DatoInvalidoException(nuevo, "Se encontraron datos inv\u00c3¡lidos.");
        }
        nuevo.setIdentificacion(Asignatura.getNuevaIdentificacion());
        this.planDeEstudio.agregar(nuevo);
    }
    
    public void agregarCursada(final Cursada nuevo) throws ClaveYaExistenteException, DatoInvalidoException {
        if (!Cursada.validaCursada(nuevo)) {
            throw new DatoInvalidoException(nuevo, "Se encontraron datos inv\u00c3¡lidos.");
        }
        nuevo.setIdentificacion(Cursada.getNuevaIdentificacion());
        this.calendario.agregar(nuevo);
    }
    
    public void eliminarAlumno(final Alumno elim) {
        this.alumnos.eliminar(elim);
        final Iterator<Cursada> it = this.calendario.elementosPorClavePrimaria();
        while (it.hasNext()) {
            final Cursada aux = it.next();
            if (aux.tieneAlumno(elim)) {
                aux.bajaAlumno(elim);
            }
        }
    }
    
    public void eliminarProfesor(final Profesor elim) {
        this.profesores.eliminar(elim);
        final Iterator<Cursada> it = this.calendario.elementosPorClavePrimaria();
        while (it.hasNext()) {
            final Cursada aux = it.next();
            if (aux.tieneProfesor(elim)) {
                aux.bajaProfesor(elim);
            }
        }
    }
    
    public void eliminarAsignatura(final Asignatura elim) {
        this.planDeEstudio.eliminar(elim);
        this.eliminaAsignaturaEnAlumnos(elim);
        this.eliminaAsignaturaEnProfesores(elim);
        this.eliminaAsignaturaEnCorrelatividades(elim);
        final Iterator<Cursada> it = this.calendario.elementosPorClavePrimaria();
        while (it.hasNext()) {
            final Cursada aux = it.next();
            if (aux.getAsignatura().equals(elim)) {
                this.eliminarCursada(aux);
            }
        }
    }
    
    public void eliminarCursada(final Cursada elim) {
        this.calendario.eliminar(elim);
    }
    
    private void eliminaAsignaturaEnAlumnos(final Asignatura elim) {
        final Iterator<Alumno> it = this.alumnos.elementosPorClavePrimaria();
        while (it.hasNext()) {
            final Alumno aux = it.next();
            if (aux.asignaturaAprobada(elim)) {
                aux.eliminarHistoria(elim);
            }
        }
    }
    
    private void eliminaAsignaturaEnProfesores(final Asignatura elim) {
        final Iterator<Profesor> it = this.profesores.elementosPorClavePrimaria();
        while (it.hasNext()) {
            final Profesor aux = it.next();
            if (aux.habilitadoParaAsignatura(elim)) {
                aux.eliminarCompetencia(elim);
            }
        }
    }
    
    private void eliminaAsignaturaEnCorrelatividades(final Asignatura elim) {
        final Iterator<Asignatura> it = this.planDeEstudio.elementosPorClavePrimaria();
        while (it.hasNext()) {
            final Asignatura aux = it.next();
            if (aux.tienePrecorrelativa(elim)) {
                aux.eliminarCorrelativa(elim);
            }
        }
    }
    
    private Iterator busquedaPorNombre(final String nombre, final IndiceDoble indice) {
        final Iterator<String> claves = (Iterator<String>)indice.clavesSecundarias();
        final ArrayList aux = new ArrayList();
        final String nombreUpper = nombre.toUpperCase();
        while (claves.hasNext()) {
            final String clave = claves.next();
            if (clave.toUpperCase().contains(nombreUpper)) {
                try {
                    final Iterator<I_Indexable> elementos = indice.buscarPorClaveSecundaria(clave);
                    elementos.forEachRemaining(aux::add);
                }
                catch (NoEncontradoException ex) {}
            }
        }
        return aux.iterator();
    }
    
    public Iterator<Alumno> buscarAlumno(final String nombre) throws NoEncontradoException {
        final Iterator<Alumno> ret = (Iterator<Alumno>)this.busquedaPorNombre(nombre, this.alumnos);
        if (!ret.hasNext()) {
            throw new NoEncontradoException(nombre, "El nombre solicitado no fue encontrado.");
        }
        return ret;
    }
    
    public Iterator<Profesor> buscarProfesor(final String nombre) throws NoEncontradoException {
        final Iterator<Profesor> ret = (Iterator<Profesor>)this.busquedaPorNombre(nombre, this.profesores);
        if (!ret.hasNext()) {
            throw new NoEncontradoException(nombre, "El nombre solicitado no fue encontrado.");
        }
        return ret;
    }
    
    public Iterator<Asignatura> buscarAsignatura(final String nombre) throws NoEncontradoException {
        final Iterator<Asignatura> ret = (Iterator<Asignatura>)this.busquedaPorNombre(nombre, this.planDeEstudio);
        if (!ret.hasNext()) {
            throw new NoEncontradoException(nombre, "El nombre solicitado no fue encontrado.");
        }
        return ret;
    }
    
    public Iterator<Cursada> buscarCursada(final String nombreAsignatura) throws NoEncontradoException {
        final Iterator<Cursada> cursadas = this.calendario.elementosPorClavePrimaria();
        final ArrayList<Cursada> aux = new ArrayList<Cursada>();
        final String nombreUpper = nombreAsignatura.toUpperCase();
        while (cursadas.hasNext()) {
            final Cursada cursada = cursadas.next();
            if (cursada.getAsignatura().getNombre().toUpperCase().contains(nombreUpper)) {
                aux.add(cursada);
            }
        }
        if (aux.isEmpty()) {
            throw new NoEncontradoException(nombreAsignatura, "No se encontr\u00c3³ ninguna cursada cuya asignatura coincida con el nombre dado.");
        }
        return aux.iterator();
    }
    
    public Alumno buscarAlumnoPorLegajo(final String legajo) throws NoEncontradoException {
        return this.alumnos.buscarPorClavePrimaria(legajo);
    }
    
    public Profesor buscarProfesorPorLegajo(final String legajo) throws NoEncontradoException {
        return this.profesores.buscarPorClavePrimaria(legajo);
    }
    
    public Asignatura buscarAsignaturaPorIdentifiacion(final String identificacion) throws NoEncontradoException {
        return this.planDeEstudio.buscarPorClavePrimaria(identificacion);
    }
    
    public Cursada buscarCursadaPorIdentificacion(final String identificacion) throws NoEncontradoException {
        return this.calendario.buscarPorClavePrimaria(identificacion);
    }
    
    public void quitarCompetenciaAProfesor(final Profesor profesor, final Asignatura asignatura) {
        final Iterator<Cursada> it = this.calendario.elementosPorClavePrimaria();
        while (it.hasNext()) {
            final Cursada aux = it.next();
            if (aux.getAsignatura().equals(asignatura) && aux.tieneProfesor(profesor)) {
                aux.bajaProfesor(profesor);
            }
        }
        profesor.eliminarCompetencia(asignatura);
    }
    
    public void agregarAlumnoEnCursada(final Alumno alumno, final Cursada cursada) throws DatoInvalidoException, ClaveYaExistenteException {
        if (!this.alumnoDisponible(alumno, cursada)) {
            throw new DatoInvalidoException(alumno, "El alumno solicitado se encuentra ocupado en el horario de la cursada.");
        }
        cursada.altaAlumno(alumno);
    }
    
    public void agregarProfesorEnCursada(final Profesor profesor, final Cursada cursada) throws DatoInvalidoException, ClaveYaExistenteException {
        if (!this.profesorDisponible(profesor, cursada)) {
            throw new DatoInvalidoException(profesor, "El profesor solicitado se encuentra ocupado en el horario de la cursada.");
        }
        cursada.altaProfesor(profesor);
    }
    
    public boolean alumnoDisponible(final Alumno alumno, final Cursada cursada) {
        boolean res = true;
        Cursada aux;
        for (Iterator<Cursada> it = this.calendario.elementosPorClavePrimaria(); it.hasNext() && res; res = (!aux.tieneAlumno(alumno) || !aux.hayColision(cursada))) {
            aux = it.next();
        }
        return res;
    }
    
    public boolean profesorDisponible(final Profesor profesor, final Cursada cursada) {
        boolean res = true;
        Cursada aux;
        for (Iterator<Cursada> it = this.calendario.elementosPorClavePrimaria(); it.hasNext() && res; res = (!aux.tieneProfesor(profesor) || !aux.hayColision(cursada))) {
            aux = it.next();
        }
        return res;
    }
    
    public void modificarAlumno(final Alumno alumno, final Alumno modif) throws DatoInvalidoException {
        if (!Persona.validaPersona(modif)) {
            throw new DatoInvalidoException(modif, "Se detectaron par\u00c3¡metros inv\u00c3¡lidos al tratar de modificar.");
        }
        this.alumnos.modificarValor(alumno, modif);
    }
    
    public void modificarProfesor(final Profesor profesor, final Profesor modif) throws DatoInvalidoException {
        if (!Persona.validaPersona(modif)) {
            throw new DatoInvalidoException(modif, "Se detectaron par\u00c3¡metros inv\u00c3¡lidos al tratar de modificar.");
        }
        this.profesores.modificarValor(profesor, modif);
    }
    
    public void modificarAsignatura(final Asignatura asignatura, final Asignatura modif) throws DatoInvalidoException {
        if (!Asignatura.validaAsignatura(modif)) {
            throw new DatoInvalidoException(modif, "Se detectaron par\u00c3¡metros inv\u00c3¡lidos al tratar de modificar.");
        }
        this.planDeEstudio.modificarValor(asignatura, modif);
    }
    
    public void modificarCursada(final Cursada cursada, final Cursada modif) throws DatoInvalidoException {
        if (!Cursada.validaCursada(modif)) {
            throw new DatoInvalidoException(modif, "Se detectaron par\u00c3¡metros inv\u00c3¡lidos al tratar de modificar.");
        }
        this.calendario.modificarValor(cursada, modif);
    }
    
    public void setAlumnos(final IndiceDoble<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
    
    public IndiceDoble<Alumno> getAlumnos() {
        return this.alumnos;
    }
    
    public void setProfesores(final IndiceDoble<Profesor> profesores) {
        this.profesores = profesores;
    }
    
    public IndiceDoble<Profesor> getProfesores() {
        return this.profesores;
    }
    
    public void setPlanDeEstudio(final IndiceDoble<Asignatura> planDeEstudio) {
        this.planDeEstudio = planDeEstudio;
    }
    
    public IndiceDoble<Asignatura> getPlanDeEstudio() {
        return this.planDeEstudio;
    }
    
    public void setCalendario(final IndiceDoble<Cursada> calendario) {
        this.calendario = calendario;
    }
    
    public IndiceDoble<Cursada> getCalendario() {
        return this.calendario;
    }
}
