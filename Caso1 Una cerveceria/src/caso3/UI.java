package caso3;

import excepciones.CertificadoNoPedidoException;
import excepciones.LegajoInexistenteException;
import excepciones.MateriaInexistenteException;

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
		String estado;
		
		if(materia != null && !materia.equals("")) {
			try
			{
				estado = this.negocio.traerEstado(materia);
			} catch (CertificadoNoPedidoException e)
			{
			    //Informa sobre el problema
				e.printStackTrace();
			} catch (LegajoInexistenteException e)
			{
				// Informa sobre el problema
				e.printStackTrace();
			} catch (MateriaInexistenteException e)
			{
				//Informa sobre el problema
				e.printStackTrace();
			}
			System.out.println("El estado de la materia ingresada es: "+ materia);
		}
		else
			System.out.print("Datos ingresados erroneamente");
	}
	
	public void MostrarCertificado() {
		String plantilla_cert = null;
		
		try
		{
			plantilla_cert = this.negocio.traerCertificado();
		} catch (CertificadoNoPedidoException e)
		{
			System.out.println("Primero tiene que pedir un certificado para obtener uno.");
		}
		
		System.out.println("-----------Certificado de alumno-----------\n"+ plantilla_cert);
	}
}
