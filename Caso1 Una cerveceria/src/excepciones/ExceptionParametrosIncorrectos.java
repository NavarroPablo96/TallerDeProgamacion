package excepciones;
/**
 * @author Ag�ero Sebasti�n, Mujica Juan Manuel, Navarro Pablo, Vucetic Ivo
 * <br>
 * Clase ExceptionParametrosIncorrectos, utilizada para informar que los parametros no respetaban las precondiciones
 * */
public class ExceptionParametrosIncorrectos extends Exception {

	public ExceptionParametrosIncorrectos(String message){
		super(message);
	}
}
