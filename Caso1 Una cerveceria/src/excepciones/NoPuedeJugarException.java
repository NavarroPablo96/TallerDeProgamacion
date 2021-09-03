package excepciones;
/**
 * @author Agüero Sebastián, Mujica Juan Manuel, Navarro Pablo, Vucetic Ivo
 * <br>
 * Clase NoPuedeJugarException, utilizada para informar que no se puede jugar por la cantidad de intentos
 * */
public class NoPuedeJugarException extends Exception {

	public NoPuedeJugarException(String message) {
		super(message);
	}
}
