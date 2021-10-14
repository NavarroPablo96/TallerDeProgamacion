package modelo;

import java.io.Serializable;

/**
 * @author Imanol Vázquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Agüero   
 *<br>
 *Clase abstracta que representa una habitacion
 */
public abstract class Habitacion implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected double costoAsignacion=1000;
	private String numeroHabitacion;
	/**
	 * Constructor con un parametro para setear la habitacion<br>
	 * <b> Pre: </b> El parámetro numeroHabitacion debe ser un número entero positivo.
	 * @param numeroHabitacion: parametro de tipo int que representa el numero de la habitacion. 
	 * 
	 */
	public Habitacion(String numeroHabitacion) {
		this.numeroHabitacion = numeroHabitacion;
	}

	public void setCostoAsignacion(double costo) {
			this.costoAsignacion = costo;
	}
	
	public double getCostoasignacion() {
		return costoAsignacion;
	}

	public String getNumeroHabitacion() {
		return numeroHabitacion;
	}
	
	public abstract double getCostoHabitacion();
	
	public abstract double getCosto(int dias);
	
	
}
