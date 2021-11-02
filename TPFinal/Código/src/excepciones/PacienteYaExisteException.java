package excepciones;

/**
 * @author Imanol V�zquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Ag�ero   
 *<br>
 *Clase que representa una excepci�n cuando se agregar un Paciente con mismo dni a otro ya guardado. Extiende de Exception.
 */
public class PacienteYaExisteException extends Exception {
	private String dni;
	
	/**
	 * Constructor con un parametro para setear la excepci�n.
	 * <br>
	 * @param dni: parametro de tipo String que representa el dni a mostrar en el mensaje de la excepci�n.
	 */
	public PacienteYaExisteException(String dni) {
		super();
		this.dni=dni;
	}
	@Override
	public String getMessage() {		
		return "El paciente con dni: "+this.dni+" ya esta en la lista";
	}
}
