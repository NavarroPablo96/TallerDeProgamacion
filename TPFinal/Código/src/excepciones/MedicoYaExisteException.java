package excepciones;

/**
 * @author Imanol Vázquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Agüero   
 *<br>
 *Clase que representa una excepción cuando se agregar un Paciente con mismo dni a otro ya guardado. Extiende de Exception.
 */
public class MedicoYaExisteException extends Exception {
	private Long matricula;

	/**
	 * Constructor con un parametro para setear la excepción.
	 * <br>
	 * @param dni: parametro de tipo String que representa el dni a mostrar en el mensaje de la excepción.
	 */
	public MedicoYaExisteException(Long matricula) {
		super();
		this.matricula=matricula;
	}
	@Override
	public String getMessage() {		
		return "El paciente con dni: "+this.matricula+" ya esta en la lista";
	}
}
