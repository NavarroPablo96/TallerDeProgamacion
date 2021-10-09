// 
// Decompiled by Procyon v0.5.36
// 

package modelo;

import java.util.Iterator;
import excepciones.ClaveYaExistenteException;
import excepciones.DatoInvalidoException;
import excepciones.DiaInvalidoException;

public class Cursada implements I_Indexable
{
    private Asignatura asignatura;
    private String identificacion;
    private String periodo;
    private Dia dia;
    private String horaInicio;
    private String horaFinalizacion;
    private IndicePrimario<Profesor> profesores;
    private IndicePrimario<Alumno> alumnos;
    private static int CANT_CURSADAS;
    
    public Cursada(final Asignatura asignatura, final String periodo, final Dia dia, final String horaInicio, final String horaFinalizacion) {
        this.asignatura = asignatura;
        this.periodo = periodo;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFinalizacion = horaFinalizacion;
        this.profesores = new IndicePrimario<Profesor>();
        this.alumnos = new IndicePrimario<Alumno>();
    }
    
    @Override
    public Object getClavePrimaria() {
        return this.getIdentificacion();
    }
    
    @Override
    public Object getClaveSecundaria() {
        int ret;
        try {
            ret = Dia.parseInt(this.dia) * 10000 + this.parseInt(this.horaInicio);
        }
        catch (DiaInvalidoException e) {
            ret = -1;
        }
        return ret;
    }
    
    private int parseInt(final String hora) {
        return Integer.parseInt(hora.substring(0, 2)) * 100 + Integer.parseInt(hora.substring(3, 5));
    }
    
    public String getIdentificacion() {
        return this.identificacion;
    }
    
    public void setAsignatura(final Asignatura asignatura) {
        this.asignatura = asignatura;
    }
    
    public Asignatura getAsignatura() {
        return this.asignatura;
    }
    
    public void setIdentificacion(final String identificacion) {
        this.identificacion = identificacion;
    }
    
    public void setPeriodo(final String periodo) {
        this.periodo = periodo;
    }
    
    public String getPeriodo() {
        return this.periodo;
    }
    
    public void setDia(final Dia dia) {
        this.dia = dia;
    }
    
    public Dia getDia() {
        return this.dia;
    }
    
    public void setHoraInicio(final String horaInicio) {
        this.horaInicio = horaInicio;
    }
    
    public String getHoraInicio() {
        return this.horaInicio;
    }
    
    public void setHoraFinalizacion(final String horaFinalizacion) {
        this.horaFinalizacion = horaFinalizacion;
    }
    
    public String getHoraFinalizacion() {
        return this.horaFinalizacion;
    }
    
    public boolean correlativasAprobadas(final Alumno alumno) {
        return this.asignatura.compruebaCorrelativas(alumno);
    }
    
    public boolean aceptaCompetencia(final Profesor profesor) {
        return profesor.habilitadoParaAsignatura(this.asignatura);
    }
    
    public static boolean validaPeriodo(final String periodo) {
        try {
            return periodo.length() == 7 && (periodo.substring(0, 3).equals("01-") || periodo.substring(0, 3).equals("02-")) && Integer.parseInt(periodo.substring(3)) >= 1;
        }
        catch (NumberFormatException nfe) {
            return false;
        }
    }
    
    public static boolean validaHora(final String hora) {
        if (hora == null || hora.length() != 5) {
            return false;
        }
        try {
            final int auxHora = Integer.parseInt(hora.substring(0, 2));
            final int auxMinutos = Integer.parseInt(hora.substring(3));
            return auxHora <= 23 && auxHora >= 0 && auxMinutos <= 59 && auxMinutos >= 0 && hora.charAt(2) == ':';
        }
        catch (NumberFormatException nfe) {
            return false;
        }
    }
    
    public static boolean validaHorario(final String horaInicio, final String horaFinalizacion) {
        return horaInicio.compareTo(horaFinalizacion) < 0;
    }
    
    public static boolean validaCursada(final Cursada cursada) {
        return validaPeriodo(cursada.getPeriodo()) && cursada.dia != null && validaHora(cursada.getHoraInicio()) && validaHora(cursada.getHoraFinalizacion()) && validaHorario(cursada.getHoraInicio(), cursada.getHoraFinalizacion());
    }
    
    public static String getNuevaIdentificacion() {
        ++Cursada.CANT_CURSADAS;
        return String.format("CUR%04d", Cursada.CANT_CURSADAS);
    }
    
    public void altaAlumno(final Alumno nuevo) throws DatoInvalidoException, ClaveYaExistenteException {
        if (!this.correlativasAprobadas(nuevo)) {
            throw new DatoInvalidoException(nuevo, "El alumno no tiene todas las precorrelatividades aprobadas.");
        }
        if (nuevo.asignaturaAprobada(this.asignatura)) {
            throw new DatoInvalidoException(nuevo, "El alumno ya tiene aprobada la asignatura.");
        }
        this.alumnos.agregar(nuevo);
    }
    
    public void bajaAlumno(final Alumno elim) {
        this.alumnos.eliminar(elim);
    }
    
    public void altaProfesor(final Profesor nuevo) throws DatoInvalidoException, ClaveYaExistenteException {
        if (!this.aceptaCompetencia(nuevo)) {
            throw new DatoInvalidoException(nuevo, "El profesor no est\u00c3¡ habilitado para la asignatura.");
        }
        this.profesores.agregar(nuevo);
    }
    
    public void bajaProfesor(final Profesor elim) {
        this.profesores.eliminar(elim);
    }
    
    public boolean hayColision(final Cursada otro) {
        return !this.getIdentificacion().equals(otro.getIdentificacion()) && this.getPeriodo().equals(otro.getPeriodo()) && this.getDia() == otro.getDia() && this.getHoraInicio().compareTo(otro.getHoraFinalizacion()) < 0 && this.getHoraFinalizacion().compareTo(otro.getHoraInicio()) > 0;
    }
    
    public boolean tieneAlumno(final Alumno alumno) {
        return this.alumnos.contieneValor(alumno);
    }
    
    public boolean tieneProfesor(final Profesor profesor) {
        return this.profesores.contieneValor(profesor);
    }
    
    public Iterator<Alumno> alumnos() {
        return this.alumnos.elementos();
    }
    
    public Iterator<Profesor> profesores() {
        return this.profesores.elementos();
    }
    
    @Override
    public void modificarDatos(final I_Indexable modif) throws DatoInvalidoException {
        if (this.getClass() != modif.getClass()) {
            throw new DatoInvalidoException(modif, "Tipo de dato inv\u00c3¡lido.");
        }
        final Cursada aux = (Cursada)modif;
        this.setAsignatura(aux.getAsignatura());
        this.setPeriodo(aux.getPeriodo());
        this.setDia(aux.getDia());
        this.setHoraInicio(aux.getHoraInicio());
        this.setHoraFinalizacion(aux.getHoraFinalizacion());
    }
    
    public Cursada() {
    }
    
    public void setProfesores(final IndicePrimario<Profesor> profesores) {
        this.profesores = profesores;
    }
    
    public IndicePrimario<Profesor> getProfesores() {
        return this.profesores;
    }
    
    public void setAlumnos(final IndicePrimario<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
    
    public IndicePrimario<Alumno> getAlumnos() {
        return this.alumnos;
    }
    
    public static void setCANT_CURSADAS(final int CANT_CURSADAS) {
        Cursada.CANT_CURSADAS = CANT_CURSADAS;
    }
    
    public static int getCANT_CURSADAS() {
        return Cursada.CANT_CURSADAS;
    }
    
    static {
        Cursada.CANT_CURSADAS = 0;
    }
}
