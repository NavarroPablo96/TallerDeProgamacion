package caso5;


import excepciones.NoPuedeJugarException;
import excepciones.NumeroInvalidoException;

public class UI {

	private Monitor monitor;
	
	public void Inicializar() {
		this.monitor.Inicializar();
	}
	
	public void Probar(double numero) {
		try {
			this.monitor.Probar(numero);
		}
		catch (NoPuedeJugarException e){
			System.out.println(e.getMessage());
		}
		catch (NumeroInvalidoException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int getCantIntentos() {
		return this.monitor.getCantIntentos();
	}

	public String getEstado() {
		return this.monitor.getEstado();
	}
}
