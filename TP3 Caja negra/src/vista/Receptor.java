// 
// Decompiled by Procyon v0.5.36
// 

package vista;

import persistencia.SerializadorXML;
import modelo.Persona;
import excepciones.NoEncontradoException;
import java.util.Iterator;
import excepciones.DatoInvalidoException;
import excepciones.ClaveYaExistenteException;
import modelo.Cursada;
import modelo.Asignatura;
import modelo.Profesor;
import modelo.Alumno;
import modelo.Sistema;

public class Receptor
{
    private Sistema modelo;
    public static final int ALUMNO = 0;
    public static final int PROFESOR = 1;
    public static final int ASIGNATURA = 2;
    public static final int CURSADA = 3;
    
    public Receptor(final Sistema modelo) {
        this.modelo = modelo;
    }
    
    public void alta(final Object obj, final int comando) throws ClaveYaExistenteException, DatoInvalidoException {
        switch (comando) {
            case 0: {
                this.modelo.agregarAlumno((Alumno)obj);
                break;
            }
            case 1: {
                this.modelo.agregarProfesor((Profesor)obj);
                break;
            }
            case 2: {
                this.modelo.agregarAsignatura((Asignatura)obj);
                break;
            }
            case 3: {
                this.modelo.agregarCursada((Cursada)obj);
                break;
            }
        }
    }
    
    public Iterator ubicar(final Object obj, final int comando) throws NoEncontradoException {
        Iterator ret = null;
        switch (comando) {
            case 0: {
                ret = this.modelo.buscarAlumno((String)obj);
                break;
            }
            case 1: {
                ret = this.modelo.buscarProfesor((String)obj);
                break;
            }
            case 2: {
                ret = this.modelo.buscarAsignatura((String)obj);
                break;
            }
            case 3: {
                ret = this.modelo.buscarCursada((String)obj);
                break;
            }
        }
        return ret;
    }
    
    public Object buscar(final Object obj, final int comando) throws NoEncontradoException {
        Object ret = null;
        switch (comando) {
            case 0: {
                ret = this.modelo.buscarAlumnoPorLegajo((String)obj);
                break;
            }
            case 1: {
                ret = this.modelo.buscarProfesorPorLegajo((String)obj);
                break;
            }
            case 2: {
                ret = this.modelo.buscarAsignaturaPorIdentifiacion((String)obj);
                break;
            }
            case 3: {
                ret = this.modelo.buscarCursadaPorIdentificacion((String)obj);
                break;
            }
        }
        return ret;
    }
    
    public void baja(final Object obj, final int comando) throws NoEncontradoException {
        switch (comando) {
            case 0: {
                this.modelo.eliminarAlumno((Alumno)this.buscar(obj, comando));
                break;
            }
            case 1: {
                this.modelo.eliminarProfesor((Profesor)this.buscar(obj, comando));
                break;
            }
            case 2: {
                this.modelo.eliminarAsignatura((Asignatura)this.buscar(obj, comando));
                break;
            }
            case 3: {
                this.modelo.eliminarCursada((Cursada)obj);
                break;
            }
        }
    }
    
    public void modificacion(final Object obj, final int comando, final Iterator eliminar, final Iterator agregar) throws DatoInvalidoException, NoEncontradoException, ClaveYaExistenteException {
        switch (comando) {
            case 0: {
                final Alumno aluViejo = (Alumno)this.buscar(((Alumno)obj).getLegajo(), comando);
                this.modelo.modificarAlumno(aluViejo, (Alumno)obj);
                while (eliminar.hasNext()) {
                    aluViejo.eliminarHistoria((Asignatura)eliminar.next());
                }
                while (agregar.hasNext()) {
                    aluViejo.agregarHistoria((Asignatura)agregar.next());
                }
                break;
            }
            case 1: {
                final Profesor profViejo = (Profesor)this.buscar(((Profesor)obj).getLegajo(), comando);
                this.modelo.modificarProfesor(profViejo, (Profesor)obj);
                while (eliminar.hasNext()) {
                    this.modelo.quitarCompetenciaAProfesor(profViejo, (Asignatura)eliminar.next());
                }
                while (agregar.hasNext()) {
                    profViejo.agregarCompetencia((Asignatura)agregar.next());
                }
                break;
            }
            case 2: {
                final Asignatura asigViejo = (Asignatura)this.buscar(((Asignatura)obj).getIdentificacion(), comando);
                this.modelo.modificarAsignatura(asigViejo, (Asignatura)obj);
                while (eliminar.hasNext()) {
                    asigViejo.eliminarCorrelativa((Asignatura)eliminar.next());
                }
                while (agregar.hasNext()) {
                    asigViejo.agregarCorrelativa((Asignatura)agregar.next());
                }
                break;
            }
            case 3: {
                if (!this.participantesProvisoriosDisponibles((Cursada)obj)) {
                    throw new DatoInvalidoException(obj, "El horario de la cursada no es viable para todos los participantes.");
                }
                final Cursada curViejo = (Cursada)this.buscar(((Cursada)obj).getIdentificacion(), comando);
                this.modelo.modificarCursada(curViejo, (Cursada)obj);
                while (eliminar.hasNext()) {
                    final Persona aux = (Persona)eliminar.next();
                    if (aux.getLegajo().substring(0, 3).equals("ALU")) {
                        curViejo.bajaAlumno((Alumno)aux);
                    }
                    else {
                        if (!aux.getLegajo().substring(0, 3).equals("PRO")) {
                            continue;
                        }
                        curViejo.bajaProfesor((Profesor)aux);
                    }
                }
                while (agregar.hasNext()) {
                    final Persona aux = (Persona)agregar.next();
                    if (aux.getLegajo().substring(0, 3).equals("ALU")) {
                        this.modelo.agregarAlumnoEnCursada((Alumno)aux, curViejo);
                    }
                    else {
                        if (!aux.getLegajo().substring(0, 3).equals("PRO")) {
                            continue;
                        }
                        this.modelo.agregarProfesorEnCursada((Profesor)aux, curViejo);
                    }
                }
                break;
            }
        }
    }
    
    private boolean participantesProvisoriosDisponibles(final Cursada provisorio) {
        boolean res = true;
        final Iterator<Alumno> alumnos = provisorio.alumnos();
        final Iterator<Profesor> profesores = provisorio.profesores();
        while (alumnos.hasNext() && res) {
            res = this.modelo.alumnoDisponible(alumnos.next(), provisorio);
        }
        while (profesores.hasNext() && res) {
            res = this.modelo.profesorDisponible(profesores.next(), provisorio);
        }
        return res;
    }
    
    public void guardar() {
        SerializadorXML.guardar(this.modelo);
    }
}