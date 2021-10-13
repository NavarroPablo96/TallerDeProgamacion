package excepciones;
/**
 * @author Imanol V�zquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Ag�ero   
 *<br>
 *Clase que representa una excepci�n que el paciente no se encuentra.
 */
public class NoEstaPacienteException extends Exception{
	/**
	 * Constructor con un parametro para setear la excepci�n.
	 * <br>
	 * @param message: parametro de tipo String que representa el mensaje de la excepci�n.
	 */
	public NoEstaPacienteException(String message) {
		super(message);
	}

}
