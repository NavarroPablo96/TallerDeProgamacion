package caso5;


import excepciones.NoPuedeJugarException;
import excepciones.NumeroInvalidoException;
/**
 * @author Agüero Sebastián, Mujica Juan Manuel, Navarro Pablo, Vucetic Ivo
 * <br>
 * Clase UI 
 * */
public class UI {

	private Monitor monitor;
	
	public UI() {
		this.monitor=new Monitor();
		
	}
	
	/**
	 * Metodo Inicializar <br>
	 * <b>Pre: </b> No es null el atributo monitor<br>
	 * <b>Post: </b> Se ha realizado el pedido a la capa de negocio de inicializar un juego nuevo<br>
	 * */
	public void Inicializar() {
		assert monitor!=null : "El atributo monitor es nulo";
		this.monitor.Inicializar();
	}
	
	/**
	 * Metodo Probar <br>
	 * <b>Pre: </b> No es null el atributo monitor<br>
	 * <b>Post: </b> Se ha realizado el pedido a la capa de negocio de probar con un numero que no fue validado<br>
	 * Si hubo un error se informa, en caso contrario se muestra el estado del juego<br>
	 * */
	public void Probar(double numero) {
		assert monitor!=null : "El atributo monitor es nulo";
		try {
			this.monitor.Probar(numero);
		}
		catch (NoPuedeJugarException e){
			System.out.println(e.getMessage());
		}
		catch (NumeroInvalidoException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Estado:"+this.getEstado());
	}
	
	/**
	 * Metodo getCantIntentos <br>
	 * <b>Pre: </b> No es null el atributo monitor<br>
	 * <b>Post: </b> Se ha retornado la cantidad de intentos<br>
	 * */
	public int getCantIntentos() {
		assert monitor!=null : "El atributo monitor es nulo";
		return this.monitor.getCantIntentos();
	}
	
	/**
	 * Metodo getEstado <br>
	 * <b>Pre: </b> No es null el atributo monitor<br>
	 * <b>Post: </b> Se ha retornado el estado<br>
	 * */
	public String getEstado() {
		assert monitor!=null : "El atributo monitor es nulo";
		return this.monitor.getEstado();
	}
}
