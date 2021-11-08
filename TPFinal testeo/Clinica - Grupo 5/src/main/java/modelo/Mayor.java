package modelo;

import interf.PrioridadAsignacion;

public class Mayor extends Paciente implements PrioridadAsignacion {
	private static final long serialVersionUID = 43000485;
	public Mayor() {
        super();
    }

    public Mayor(String nombre, String apellido, String dni, String domicilo, String ciudad, String telefono) {
        super(nombre, apellido, dni, domicilo, ciudad, telefono);
    }

    @Override
    public boolean establecerPriotodad(Paciente p) {
        if (p==null)    
            return true;
       else
            return p.mayorPregunta();
    }

    @Override
    public boolean ninioPregunta() {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean jovenPregunta() {
        // TODO Implement this method
        return true;
    }

    @Override
    public boolean mayorPregunta() {
        // TODO Implement this method
        return false;
    }
}
