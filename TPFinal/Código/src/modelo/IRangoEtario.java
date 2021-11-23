package modelo;

/**
 * @author Imanol V�zquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Ag�ero   
 *<br>
 *Interfaz que representa el rango etario que posee un paciente.
 *Para determinar las prioridades de los pacientes se utiliza Double Dispatch.
 */

public interface IRangoEtario {

	/**
	 * M�todo que decide qui�n tiene prioridad para quedarse en la sala privada de la cl�nica, si el paciente que ya estaba all� o el que reci�n llega.
	 * <br>
	 * <b>Pre: </b> El par�metro otro debe ser distinto de null.<br>
	 * @param otro: par�metro de tipo Persona, contra el que se decidir� la prioridad.
	 */
	
	boolean prioridad(Paciente otro);
	
	/**
	 * M�todo que decide si el paciente que ya est� en la sala privada tiene prioridad de quedarse all�, contra un ni�o que reci�n ingresa a la cl�nica.
	 */
	
	boolean prioridadNinio();
	
	/**
	 * M�todo que decide si el paciente que ya est� en la sala privada tiene prioridad de quedarse all�, contra un joven que reci�n ingresa a la cl�nica.
	 */
	
	boolean prioridadJoven();
	
	/**
	 * M�todo que decide si el paciente que ya est� en la sala privada tiene prioridad de quedarse all�, contra un mayor que reci�n ingresa a la cl�nica.
	 */
	
	boolean prioridadMayor();
	
	boolean esMayor();
}
