package modelo;

import interf.PrioridadAsignacion;

public class Joven extends Paciente implements PrioridadAsignacion {
	private static final long serialVersionUID = 43299485;
	public Joven() {
        super();
    }

    public Joven(String nombre, String apellido, String dni, String domicilo, String ciudad, String telefono) {
        super(nombre, apellido, dni, domicilo, ciudad, telefono);
    }

    @Override
    public boolean establecerPriotodad(Paciente p) {
        if(p==null)
            return true;
        else
            return p.jovenPregunta();
    }

    @Override
    public boolean ninioPregunta() {
        // TODO Implement this method
        return true;
    }

    @Override
    public boolean jovenPregunta() {
        // TODO Implement this method
        return false;
    }

    @Override
    public boolean mayorPregunta() {
        // TODO Implement this method
        return false;
    }
}
