package UI;

import Negocio.Negocio;

/**
 * @author Acer
 *
 */
public class UI
{	
	public static UI instancia_ui = null;
	public Negocio negocio;
	
	public UI() {
		this.negocio = new Negocio();
	}
	
	public static UI getInstance() {
		if(instancia_ui == null)
			UI.instancia_ui = new UI();
		return instancia_ui;
	}
	
	/**
	 * 
	 * <b>pre:</b> 
	 * <b>pos:</b>
	 * @param Legajo
	 */
	public void pedirCertificado(Integer Legajo) {
		this.negocio.pedirCertificado(Legajo);
	}
	
	public void mostrarEstado(String Mensaje) {
		
	}
	
	public void MostrarCertificado() {
		
	}
}
