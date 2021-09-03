package excepciones;
/**
 * @author Ag�ero Sebasti�n, Mujica Juan Manuel, Navarro Pablo, Vucetic Ivo
 * <br>
 * Clase NumeroInvalidoException, utilizada para informar que el numero ingresado es invalido
 * */
public class NumeroInvalidoException extends Exception {

	public NumeroInvalidoException(String message) {
		super(message);
	}
}
