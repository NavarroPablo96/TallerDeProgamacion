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
		if (this.estado.equals("acert�") || this.estado.equals("perdi�")) {
			throw new NoPuedeJugarException("El juego fina�iz�, debe iniciar uno nuevo para jugar.");
			//System.out.println("El juego ya termin�. Debe llamar a un nuevo juego.");
		}
		else { //Si pod�a seguir jugando.
			if (numero >= 1 && numero <= 100) {
				throw new NumeroInvalidoException("El n�mero no est� entre 1 y 100.");
			}
			this.cantIntentos++;
			if(numero == this.numAleatorio) {
				this.estado = "acert�";
			}
			else { //Si no acert�.
				if(this.cantIntentos == 10) {
					this.estado = "perdi�";
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
