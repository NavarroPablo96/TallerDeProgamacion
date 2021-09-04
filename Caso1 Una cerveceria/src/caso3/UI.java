package caso3;

import excepciones.LegajoInexistenteException;

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
	public void pedirCertificado(Integer legajo) {
		try
		{
			this.negocio.pedirCertificado(legajo);
		} catch (LegajoInexistenteException e)
		{
			e.printStackTrace();
			System.out.print("---Por favor ingrese un legajo de alumno valido---");
		}
	}
	
	public void mostrarEstado(String materia) {
		if(materia != null && !materia.equals(""))
			this.negocio.traerEstado(materia);
		else
			System.out.print("Datos ingresados erroneamente");
	}
	
	public void MostrarCertificado() {
		
	}
}
