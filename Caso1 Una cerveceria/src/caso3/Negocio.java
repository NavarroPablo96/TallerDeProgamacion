package caso3;

import excepciones.CertificadoNoPedidoException;
import excepciones.LegajoInexistenteException;
import excepciones.MateriaInexistenteException;

/**
 * @author Grupo 6
 *<b>inv:<\b> <br>
 *certificado != null
 */
public class Negocio
{	
	public Certificado certificado;
	
	/**
	 * Inicializa el enlace con el modelo.
	 */
	public Negocio() {
		this.certificado = new Certificado();
		
		verificarInvariante();
	}
	
    /**
     * Se encarga de pedirle al modelo habilitar hacer un nuevo certificado, en el caso de que ocurra algún problema le debe informar
     * a la UI lo sucedido.
     * <b>pre:<b> El legajo existe y legajo>=0 && legajo<=9999. 
     * <b>pos:</b> Se informa la solicitud de un nuevo certificado.
     * @param legajo: Numero identificativo para la existencia de un alumno, legajo>=0 && legajo<=9999. 
     * @throws LegajoInexistenteException: Cuando no se encuentra al alumno dentro de la lista de la institucion. Se lo informa a la capa que lo llamó.
     */
    public void pedirCertificado(Integer legajo) throws LegajoInexistenteException {
		certificado.pedirCertificado(legajo);
	}
	
	public String traerApellidoyNombre() {
		String apellidoynombre = null;
		try
		{
			apellidoynombre = this.certificado.traerApellidoyNombre();
		} catch (LegajoInexistenteException e)
		{
			e.printStackTrace();
		} catch (CertificadoNoPedidoException e)
		{
			e.printStackTrace();
		}
		return apellidoynombre;
	}
	
	/**
	 * Se encarga de informale a la capa de modelo que se necesita el estado de una materia.
	 * <b>pre:</b> El legajo existe, se pidió previamente el certificado y la materia existe dentro de las que cursa un alumno.
	 * <b>pos:<b> Se devuelve el estado de la materia a la UI para que se muestre por pantalla.
	 * @param materia: Representa una materia institucional. La materia existe entre las que cursa un alumno.
	 * @return Devuelve el estado de la materia o una excepcion en caso de haber ocurrido algún problema.
	 * @throws CertificadoNoPedidoException:Arroja si no se pidió certificado, para informar a la capa que lo llamó.
	 * @throws LegajoInexistenteException:Arroja si el legajo del alumno no existe, para informar a la capa que lo llamó.
	 * @throws MateriaInexistenteException:Arroja si la materia no se conoce del listado del alumno, para informar a la capa que lo llamó.
	 */
	public String traerEstado(String materia) throws CertificadoNoPedidoException, LegajoInexistenteException, MateriaInexistenteException {
		String estado = null;
		
		estado = this.certificado.traerEstado(materia);
		
		return estado;
	}
	
	/**
	 * Se encarga de pedirle al modelo el certificado confeccionado para que lo pueda mostrar la UI por pantalla.
	 * <b>pre:</b> Se pidió previamente el certificado.
	 * <b>pos:</b> El certificado con los datos internos.
	 * @return String del certificado.
	 * @throws CertificadoNoPedidoException:Arroja si no se pidió certificado, para informar a la capa que lo llamó.
	 */
	public String traerCertificado() throws CertificadoNoPedidoException{
		return this.certificado.armaCertificado();
	}
	
	/**
	 * Se encarga de informale a la capa de modelo que se necesita la nota de una materia.
	 * <b>pre:</b> El legajo existe, se pidió previamente el certificado y la materia existe dentro de las que cursa un alumno.
	 * <b>pos:</b> Devuelve la nota de la materia.
	 * @param materia: Representa una materia institucional. La materia existe entre las que cursa un alumno.
	 * @return byte de la nota, o informa/resuelve si se produjo algun problema.
	 */
	public byte traerNota(String materia){
		byte nota = -1;
		try
		{
			nota = this.certificado.traerNota(materia);
		} catch (CertificadoNoPedidoException e)
		{
			e.printStackTrace();
		} catch (LegajoInexistenteException e)
		{
			e.printStackTrace();
		} catch (MateriaInexistenteException e)
		{	
			//No existe o no esta aprobada la materia.
			e.printStackTrace();
		}
		return nota;
	}
	
	/**
	 * Devuelve la condicion del alumno final.
	 * <b>pre:</b>Se pidió previamente el certificado.
	 * <b>pos:</b> Condicion del alumno.
	 * @return String de la condicion.
	 */
	public String traerCondición() {
		String cond = null;
		try
		{
			cond = this.certificado.traerCondición();
		} catch (CertificadoNoPedidoException e)
		{
			e.printStackTrace();
		} catch (LegajoInexistenteException e)
		{
			e.printStackTrace();
		}
		return cond;
	}
	
	private void verificarInvariante() {
		assert certificado != null: "No hay referencia a un certificado";
	}
}
