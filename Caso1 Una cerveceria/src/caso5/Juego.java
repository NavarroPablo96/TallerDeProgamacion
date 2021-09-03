package caso5;

import excepciones.NoPuedeJugarException;
import excepciones.NumeroInvalidoException;

public class Juego {

	private int cantIntentos;
	private int numAleatorio;
	private String estado;
	
	public void Inicializar() {
		this.cantIntentos = 0;
		this.numAleatorio = (int)(Math.random() * 100 + 1);
	}
	
	public void Probar (double numero) throws NoPuedeJugarException, NumeroInvalidoException{
		if (this.estado.equals("acertó") || this.estado.equals("perdió")) {
			throw new NoPuedeJugarException("El juego finañizó, debe iniciar uno nuevo para jugar.");
			//System.out.println("El juego ya terminó. Debe llamar a un nuevo juego.");
		}
		else { //Si podía seguir jugando.
			if (numero >= 1 && numero <= 100) {
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
			
		}
	}

	public int getCantIntentos() {
		return cantIntentos;
	}

	public String getEstado() {
		return estado;
	}
	
}
