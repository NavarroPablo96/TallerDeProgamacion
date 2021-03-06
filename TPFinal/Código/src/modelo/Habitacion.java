package modelo;

import java.io.Serializable;

/**
 * @author Imanol V?zquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Ag?ero   
 *<br>
 *Clase abstracta que representa una habitacion
 */
public abstract class Habitacion implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static double costoAsignacion = 1000;
	private String numeroHabitacion;
	/**
	 * Constructor con un parametro para setear la habitacion<br>
	 * <b> Pre: </b> El par?metro numeroHabitacion debe ser un n?mero entero positivo.
	 * @param numeroHabitacion: parametro de tipo int que representa el numero de la habitacion. 
	 * 
	 */
	public Habitacion(String numeroHabitacion) {
		this.numeroHabitacion = numeroHabitacion;
		Clinica.getInstance().agregaHabitacion(this);
	}

	public static void setCostoAsignacion(double costo) {
			Habitacion.costoAsignacion = costo;
	}
	
	public static double getCostoasignacion() {
		return Habitacion.costoAsignacion;
	}

	public String getNumeroHabitacion() {
		return numeroHabitacion;
	}
	
	public abstract double getCostoHabitacion();
	
	public abstract double getCosto(int dias);
	
	public String toString() {
		return this.numeroHabitacion;
	}
	
}
