package caso5;

import excepciones.NoPuedeJugarException;
import excepciones.NumeroInvalidoException;
/**
 * @author Agüero Sebastián, Mujica Juan Manuel, Navarro Pablo, Vucetic Ivo
 * <br>
 * Clase Juego 
 * */
public class Juego {

	private int cantIntentos;
	private int numAleatorio;
	private String estado;
	
	public Juego() {
		
	}
	
	private void verificaInvariante() {
		assert (this.cantIntentos>=0 && this.cantIntentos<=10): "el atributo cantIntentos no es valido";
		assert (this.numAleatorio>0 && this.numAleatorio<=100): "el atributo numAleatorio no es valido";
		assert (this.estado!=null): "el atributo estado es nulo";
	}
	/**
	 * Metodo Inicializar <br>
	 * <b>Post: </b> Ha generado correctamente un número aleatorio entre 1 y 100<br>
	 * La cantidad de intentos está en cero<br>
	 * */
	public void Inicializar() {
		this.cantIntentos = 0;
		this.numAleatorio = (int)(Math.random() * 100 + 1);
		this.estado="";
		

	}
	
	/**
	 * Metodo Probar <br>
	 * 
	 * <b>Post: </b> Se ha realizado un intento con el numero recibido<br>
	 * el parametro numero es validado<br>
	 * Si hubo un error se informa a la capa de negocios<br>
	 * @throws NoPuedeJugarException en caso de haber usado los 10 intentos anteriormente<br>
	 * @throws NumeroInvalidoException en caso de intentar con un numero invalido<br>
	 * */
	public void Probar (double numero) throws NoPuedeJugarException, NumeroInvalidoException{
		verificaInvariante();
		
		if (this.estado.equals("acertó") || this.estado.equals("perdió")) {
			throw new NoPuedeJugarException("El juego finalizó, debe iniciar uno nuevo para jugar.");
		}
	
		if (numero < 1 || numero > 100) {
			throw new NumeroInvalidoException("El número no está entre 1 y 100.");
		}
		this.cantIntentos++;
		if(numero == this.numAleatorio) {
			this.estado = "acertó";
		}
		else { //Si no acertó.
			if(this.cantIntentos == 10) {
				this.estado = "perdió";
			}
			else if (numero < this.numAleatorio) {
				this.estado = "bajo";
			}
			else {
				this.estado = "alto";
			}
		}
		
		verificaInvariante();
	}
	
	/**
	 * Metodo getCantIntentos <br>
	 * <b>Post: </b> Se ha retornado la cantidad de intentos<br>
	 * */
	public int getCantIntentos() {
		verificaInvariante();
		return cantIntentos;
	}
	/**
	 * Metodo getEstado <br>
	 * <b>Post: </b> Se ha retornado el estado del juego<br>
	 * */
	public String getEstado() {
		verificaInvariante();
		return estado;
	}
	
}
