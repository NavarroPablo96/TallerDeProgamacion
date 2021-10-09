// 
// Decompiled by Procyon v0.5.36
// 

package modelo;

import java.util.Iterator;
import excepciones.ClaveYaExistenteException;

public class Alumno extends Persona
{
    private IndicePrimario<Asignatura> historia;
    private static int CANT_ALUMNOS;
    
    public Alumno(final String apellidoNombre, final String domicilio, final String mail) {
        super(apellidoNombre, domicilio, mail);
        this.historia = new IndicePrimario<Asignatura>();
    }
    
    public void agregarHistoria(final Asignatura nuevo) throws ClaveYaExistenteException {
        this.historia.agregar(nuevo);
    }
    
    public void eliminarHistoria(final Asignatura elim) {
        this.historia.eliminar(elim);
    }
    
    public boolean asignaturaAprobada(final Asignatura asignatura) {
        return this.historia.contieneValor(asignatura);
    }
    
    public static String getNuevoLegajo() {
        ++Alumno.CANT_ALUMNOS;
        return String.format("ALU%04d", Alumno.CANT_ALUMNOS);
    }
    
    public Iterator<Asignatura> historiaAcademica() {
        return this.historia.elementos();
    }
    
    public Alumno() {
    }
    
    public void setHistoria(final IndicePrimario<Asignatura> historia) {
        this.historia = historia;
    }
    
    public IndicePrimario<Asignatura> getHistoria() {
        return this.historia;
    }
    
    public static void setCANT_ALUMNOS(final int CANT_ALUMNOS) {
        Alumno.CANT_ALUMNOS = CANT_ALUMNOS;
    }
    
    public static int getCANT_ALUMNOS() {
        return Alumno.CANT_ALUMNOS;
    }
    
    static {
        Alumno.CANT_ALUMNOS = 0;
    }
}