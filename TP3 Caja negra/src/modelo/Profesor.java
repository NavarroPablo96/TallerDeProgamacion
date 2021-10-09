// 
// Decompiled by Procyon v0.5.36
// 

package modelo;

import excepciones.DatoInvalidoException;
import java.util.Iterator;
import excepciones.ClaveYaExistenteException;

public class Profesor extends Persona
{
    private String telefono;
    private IndicePrimario<Asignatura> competencia;
    private static int CANT_PROFESORES;
    
    public Profesor(final String apellidoNombre, final String domicilio, final String mail, final String telefono) {
        super(apellidoNombre, domicilio, mail);
        this.telefono = telefono;
        this.competencia = new IndicePrimario<Asignatura>();
    }
    
    public void setTelefono(final String telefono) {
        this.telefono = telefono;
    }
    
    public String getTelefono() {
        return this.telefono;
    }
    
    public void agregarCompetencia(final Asignatura nuevo) throws ClaveYaExistenteException {
        this.competencia.agregar(nuevo);
    }
    
    public void eliminarCompetencia(final Asignatura elim) {
        this.competencia.eliminar(elim);
    }
    
    public boolean habilitadoParaAsignatura(final Asignatura asignatura) {
        return this.competencia.contieneValor(asignatura);
    }
    
    public static String getNuevoLegajo() {
        ++Profesor.CANT_PROFESORES;
        return String.format("PRO%04d", Profesor.CANT_PROFESORES);
    }
    
    public Iterator<Asignatura> competencias() {
        return this.competencia.elementos();
    }
    
    @Override
    public void modificarDatos(final I_Indexable modif) throws DatoInvalidoException {
        super.modificarDatos(modif);
        this.setTelefono(((Profesor)modif).getTelefono());
    }
    
    public Profesor() {
    }
    
    public static int getCANT_PROFESORES() {
        return Profesor.CANT_PROFESORES;
    }
    
    public static void setCANT_PROFESORES(final int CANT_PROFESORES) {
        Profesor.CANT_PROFESORES = CANT_PROFESORES;
    }
    
    public void setCompetencia(final IndicePrimario<Asignatura> competencia) {
        this.competencia = competencia;
    }
    
    public IndicePrimario<Asignatura> getCompetencia() {
        return this.competencia;
    }
    
    static {
        Profesor.CANT_PROFESORES = 0;
    }
}