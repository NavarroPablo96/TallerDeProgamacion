// 
// Decompiled by Procyon v0.5.36
// 

package modelo;

import java.util.Iterator;
import excepciones.ClaveYaExistenteException;
import excepciones.DatoInvalidoException;

public class Asignatura implements I_Indexable
{
    private String identificacion;
    private String nombre;
    private IndicePrimario<Asignatura> correlatividades;
    private static int CANT_ASIGNATURAS;
    
    public Asignatura(final String nombre) {
        this.nombre = nombre;
        this.correlatividades = new IndicePrimario<Asignatura>();
    }
    
    @Override
    public Object getClavePrimaria() {
        return this.getIdentificacion();
    }
    
    @Override
    public Object getClaveSecundaria() {
        return this.getNombre();
    }
    
    public String getIdentificacion() {
        return this.identificacion;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public void setIdentificacion(final String identificacion) {
        this.identificacion = identificacion;
    }
    
    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }
    
    public void agregarCorrelativa(final Asignatura correlativa) throws ClaveYaExistenteException, DatoInvalidoException {
        if (this.equals(correlativa)) {
            throw new DatoInvalidoException(correlativa, "La asignatura no puede ser correlativa de si misma.");
        }
        this.correlatividades.agregar(correlativa);
    }
    
    public void eliminarCorrelativa(final Asignatura elim) {
        this.correlatividades.eliminar(elim);
    }
    
    public boolean compruebaCorrelativas(final Alumno alumno) {
        Iterator<Asignatura> it;
        boolean ret;
        for (it = this.correlatividades.elementos(), ret = true; it.hasNext() && ret; ret = alumno.asignaturaAprobada(it.next())) {}
        return ret;
    }
    
    public static String getNuevaIdentificacion() {
        ++Asignatura.CANT_ASIGNATURAS;
        return String.format("ASI%04d", Asignatura.CANT_ASIGNATURAS);
    }
    
    public Iterator<Asignatura> precorrelativas() {
        return this.correlatividades.elementos();
    }
    
    public boolean tienePrecorrelativa(final Asignatura asignatura) {
        return this.correlatividades.contieneValor(asignatura);
    }
    
    @Override
    public void modificarDatos(final I_Indexable modif) throws DatoInvalidoException {
        if (this.getClass() != modif.getClass()) {
            throw new DatoInvalidoException(modif, "Tipo de dato inv\u00c3¡lido.");
        }
        this.setNombre(((Asignatura)modif).getNombre());
    }
    
    public static boolean validaAsignatura(final Asignatura asignatura) {
        return !asignatura.getNombre().equals("");
    }
    
    public Asignatura() {
    }
    
    public void setCorrelatividades(final IndicePrimario<Asignatura> correlatividades) {
        this.correlatividades = correlatividades;
    }
    
    public IndicePrimario<Asignatura> getCorrelatividades() {
        return this.correlatividades;
    }
    
    public static void setCANT_ASIGNATURAS(final int CANT_ASIGNATURAS) {
        Asignatura.CANT_ASIGNATURAS = CANT_ASIGNATURAS;
    }
    
    public static int getCANT_ASIGNATURAS() {
        return Asignatura.CANT_ASIGNATURAS;
    }
    
    static {
        Asignatura.CANT_ASIGNATURAS = 0;
    }
}
