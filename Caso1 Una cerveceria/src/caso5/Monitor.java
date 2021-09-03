package caso5;

import excepciones.NoPuedeJugarException;
import excepciones.NumeroInvalidoException;

public class Monitor {

	private Juego juego;
	
	public void Inicializar() {
		this.juego.Inicializar();
	}
	
	public void Probar(double numero) throws NoPuedeJugarException, NumeroInvalidoException {
		this.juego.Probar(numero);
	}
	
	public int getCantIntentos() {
		return this.juego.getCantIntentos();
	}

	public String getEstado() {
		return this.juego.getEstado();
	}
}
