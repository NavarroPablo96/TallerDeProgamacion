package modelo;

/**
 * @author Imanol V�zquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Ag�ero   
 *<br>
 *Clase que representa a una persona joven. Se extiene de Paciente.
 */

public class Joven extends Paciente {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de 7 par�metros donde se setean los atributos de un paciente joven. Se usa super para llamar al constructor de la clase Paciente.
	 * <br>
	 * <b> Pre: </b> El dni debe ser positivo y entero, debe tener al menos 8 digitos, no se debe escribir con puntos ni comas, s�lo n�meros.
	 * El tel�fono debe ser entero y positivo, debe tener al menos 7 d�gitos. <br>
	 * <b> Post: </b> Se crea el obejeto con los parametros dados<br>
	 * @param dni : String que representa el dni de un paciente.
	 * @param nombre : String que representa el nombre de un paciente.
	 * @param apellido : String que representa el apellido de un paciente.
	 * @param domicilio : String que representa el domicilio de una persona.
	 * @param ciudad : String que representa la ciudad de un paciente.
	 * @param telefono : String que representa el numero de telefono de un paciente.
	 */
	
	public Joven(String dni, String nombre, String apellido, String domicilio, String ciudad, String telefono, long nroHistoria) {
		super(dni, nombre, apellido, domicilio, ciudad, telefono, nroHistoria);
	}
	
	public Joven(String dni, String nombre, String apellido, String domicilio, String ciudad, String telefono) {
		super(dni, nombre, apellido, domicilio, ciudad, telefono);
	}
	
	/**
	 * Se sobreescribe el m�todo que decide qui�n tiene prioridad para quedarse en la sala privada de la cl�nica, si el paciente que ya estaba all� o el que reci�n llega.
	 * <br>
	 * <b>Pre: </b> El par�metro otro debe ser distinto de null.<br>
	 * @param otro: par�metro de tipo Persona, contra el que se decidir� la prioridad.
	 * @return devuelve si el paciente que reci�n llega tiene prioridad contra un joven.
	 */

	@Override
	public boolean prioridad(Paciente otro) {
		return otro.prioridadJoven();
	}
	
	/**
	 * Se sobreescribe m�todo que decide si el paciente que ya est� en la sala privada tiene prioridad de quedarse all�, contra un ni�o que reci�n ingresa a la cl�nica.
	 * @return verdadero. Se tiene prioridad contra un ni�o.
	 */
	
	@Override
	public boolean prioridadNinio() {
		return true;
	}

	/**
	 * Se sobreescribe m�todo que decide si el paciente que ya est� en la sala privada tiene prioridad de quedarse all�, contra un joven que reci�n ingresa a la cl�nica.
	 * @return falso. no se tiene prioridad contra un joven.
	 */
	
	@Override
	public boolean prioridadJoven() {
		return false;
	}

	/**
	 * Se sobreescribe m�todo que decide si el paciente que ya est� en la sala privada tiene prioridad de quedarse all�, contra un mayor que reci�n ingresa a la cl�nica.
	 * @return falso. No se tiene prioridad contra un mayor.
	 */
	
	@Override
	public boolean prioridadMayor() {
		return false;
	}

	@Override
	public boolean esMayor() {
		return false;
	}

}
