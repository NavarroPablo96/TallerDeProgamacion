package modelo;

/**
 * @author Imanol V�zquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Ag�ero   
 *<br>
 *Clase que representa una internaci�n de un paciente en una habitaci�n, se extiende de la clase Prestaci�n.
 */
public class Internacion extends Prestacion {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * @aggregation shared
     */
    private Habitacion habitacion;
	
	/**
     * Constructor con dos parametros para setear la cantidad de consultas y la habitaci�n en la que se lo intern�.<br>
     * <b> Pre: </b> El par�metro cantidad debe ser un entero positivo.<br>
     * El par�metro habitacion debe ser distinto de null.
     * @param cantidad : parametro de tipo int que representa la cantidad de d�as que el paciente permaneci� internado.
     * @param habitacion : parametro de tipo Habitacion que representa la habitaci�n en la que el paciente permaneci� internado.
     */
	public Internacion(int cantidad, Habitacion habitacion) {
		super(cantidad);
		this.habitacion = habitacion;
		super.subtotal = this.habitacion.getCosto(cantidad);
	}
	
	public Habitacion getHabitacion() {
		return habitacion;
	}

	@Override
	public String toString() {
		return "Internacion--> Numero de habitacion: "+ this.habitacion.getNumeroHabitacion() + " \t Costo:" + this.habitacion.getCosto(1) + " \t Cantidad de dias:" + super.getCantidad() + " \t Subtotal:" + super.subtotal + "\n";
	}

	@Override
	public long getPrestacion() {
		return -1;
	}
}
