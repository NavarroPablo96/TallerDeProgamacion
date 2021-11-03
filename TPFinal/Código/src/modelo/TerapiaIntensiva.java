package modelo;
/**
 * @author Imanol V�zquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Ag�ero   
 *<br>
 *Clase representa una habitacion de terapia intensiva, extiende de habitacion.
 */
public class TerapiaIntensiva extends Habitacion {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static double costoTerapiaIntensiva = 1500;
	/**
	 * Constructor con un parametro para setear la habitacion de terapia intensiva.
	 * <br>
	 * @param numeroHabitacion: parametro de tipo int que representa el numero de la habitacion. 
	 * 
	 */
	public TerapiaIntensiva(String numeroHabitacion) {
		super(numeroHabitacion);
	}
	
	public static void setCostoTerapiaIntensiva(double costo) {
		TerapiaIntensiva.costoTerapiaIntensiva = costo;
	}
	
	@Override
	public double getCostoHabitacion() {
		return TerapiaIntensiva.costoTerapiaIntensiva;
	}
	/**
	 * Modulo que devuelve el costo de una habitacion de terapia intensiva segun los dias m�s el costo de asginaci�n.
	 * <br>
	 * <b> Pre: </b> El par�metro dias debe ser positivo.
	 * <b> Pos: </b> Devuelve el costo de una habitacion de terapia intensiva segun los dias m�s el costo de asginaci�n.
	 * @param dias: parametro de tipo int que representa los dias que estuvo el paciente. 
	 * @return devuelve costo de la habitacion compartida elevado por la cantidad de dias m�s el costo de asiganci�n.
	 * 
	 */	
	@Override
	public double getCosto(int dias) {
		return Habitacion.costoAsignacion + Math.pow(TerapiaIntensiva.costoTerapiaIntensiva, dias);
	}
	
	public String toString() {
		return super.toString() + " Terapia Intensiva";
	}

}
