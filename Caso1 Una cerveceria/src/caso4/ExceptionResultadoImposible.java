package caso4;
/**
 * @author Agüero Sebastián, Mujica Juan Manuel, Navarro Pablo, Vucetic Ivo
 * <br>
 * Clase ExceptionResultadoImposible, utilizada para informar que no era posible realizar la operación
 * */
public class ExceptionResultadoImposible extends Exception {
	public ExceptionResultadoImposible(String message){
		super(message);
	}
}
