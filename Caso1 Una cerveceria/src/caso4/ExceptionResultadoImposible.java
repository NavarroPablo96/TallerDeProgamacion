package caso4;
/**
 * @author Ag�ero Sebasti�n, Mujica Juan Manuel, Navarro Pablo, Vucetic Ivo
 * <br>
 * Clase ExceptionResultadoImposible, utilizada para informar que no era posible realizar la operaci�n
 * */
public class ExceptionResultadoImposible extends Exception {
	public ExceptionResultadoImposible(String message){
		super(message);
	}
}
