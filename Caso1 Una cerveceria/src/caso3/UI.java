package caso3;

import excepciones.CertificadoNoPedidoException;
import excepciones.LegajoInexistenteException;
import excepciones.MateriaInexistenteException;

/**
 * @author Grupo 6
 *Representa la interfaz gráfica del programa.
 *<b>inv:<\b> <br>
 *negocio != null
 */
public class UI
{	
	public static UI instancia_ui = null;
	public Negocio negocio;
	
	/**
	 * Inicializa el enlace con la capa de negocio.
	 */
	public UI() {
		this.negocio = new Negocio();
		
		verificarInvariante();
	}
	
	/**
	 * Obtiene una única instancia de la interfaz.
	 * <b>pos:<\b> Una instancia de la UI. 
	 * @return Una instancia de la UI o la que ya se habia creado.
	 */
	public static UI getInstance() {
		if(instancia_ui == null)
			UI.instancia_ui = new UI();
		return instancia_ui;
	}
	
	/**
	 * Se encarga de informale a la capa de negocio que se pidió hacer un nuevo certificado. Si tuviese algun problema las capas internas 
	 * la UI será la encargada de informar lo sucedido.
	 * <b>pre:</b> El legajo existe y legajo>=0 && legajo<=9999.   
	 * <b>pos:</b> Se informa la solicitud de un nuevo certificado.
	 * @param Legajo: Numero identificativo para la existencia de un alumno, legajo>=0 && legajo<=9999. 
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
	
	/**
	 * Le informa a la capa de negocio que se necesita el estado de una materia en particular de las que cursa un alumno. En el caso 
	 * de que haya ocurrido algun error en las capas internas, se encarga de informalo.
	 * <b>pre:</b> El legajo existe, se pidió previamente el certificado y la materia existe dentro de las que cursa un alumno.
	 * <b>pos:<b> Muestra por pantalla el estado de la materia.
	 * @param materia: Representa una materia institucional. La materia existe entre las que cursa un alumno.
	 */
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
			finally {
				System.out.println("El estado de la materia ingresada es: "+ materia);
			}
		}
		else
			System.out.print("Datos ingresados erroneamente");
	}
	
	
	/**
	 * Muestra el certificado con los ultimos datos que resultan de pedirCertificado.
	 * <b>pre:</b> Se pidió previamente el certificado.
	 * <b>pos:</b> Se muestra el certificado por pantalla con los datos internos.
	 */
	public void MostrarCertificado() {
		String plantilla_cert = null;
		
		try
		{
			plantilla_cert = this.negocio.traerCertificado();
		} catch (CertificadoNoPedidoException e)
		{
			System.out.println("Primero tiene que pedir un certificado para obtener uno.");
		}
		finally {
			System.out.println("-----------Certificado de alumno-----------\n"+ plantilla_cert);
		}
	}
	
	private void verificarInvariante() {
		assert negocio != null: "No existe controlador";
	}
}
