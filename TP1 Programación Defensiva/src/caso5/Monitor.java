package caso5;

import excepciones.NoPuedeJugarException;
import excepciones.NumeroInvalidoException;
/**
 * @author Agüero Sebastián, Mujica Juan Manuel, Navarro Pablo, Vucetic Ivo
 * <br>
 * Clase Monitor 
 * */
public class Monitor {

	private Juego juego;
	
	public Monitor() {
		this.juego=new Juego();
	}
	
	/**
	 * Metodo Inicializar <br>
	 * <b>Pre: </b> No es null el atributo juego<br>
	 * <b>Post: </b> Se ha delegado el pedido a la capa de modelo de inicializar un juego nuevo<br>
	 * */
	public void Inicializar() {
		assert juego!=null : "El atributo juego es nulo";
		this.juego.Inicializar();
	}
	
	/**
	 * Metodo Probar <br>
	 * <b>Pre: </b> No es null el atributo juego<br>
	 * <b>Post: </b> Se ha delegado el pedido a la capa de modelo de probar con un numero que no fue validado<br>
	 * Si hubo un error se informa a la UI<br>
	 * @throws NoPuedeJugarException en caso de haber usado los 10 intentos anteriormente<br>
	 * @throws NumeroInvalidoException en caso de intentar con un numero invalido<br>
	 * */
	public void Probar(double numero) throws NoPuedeJugarException, NumeroInvalidoException {
		assert juego!=null : "El atributo juego es nulo";
		this.juego.Probar(numero);
	}
	
	/**
	 * Metodo getCantIntentos <br>
	 * <b>Pre: </b> No es null el atributo juego<br>
	 * <b>Post: </b> Se ha retornado la cantidad de intentos<br>
	 * */
	public int getCantIntentos() {
		assert juego!=null : "El atributo juego es nulo";
		return this.juego.getCantIntentos();
	}
	
	/**
	 * Metodo getEstado <br>
	 * <b>Pre: </b> No es null el atributo juego<br>
	 * <b>Post: </b> Se ha retornado el estado del juego<br>
	 * */
	public String getEstado() {
		assert juego!=null : "El atributo juego es nulo";
		return this.juego.getEstado();
	}
}
