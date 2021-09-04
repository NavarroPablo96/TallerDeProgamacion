package caso3;

import excepciones.CertificadoNoPedidoException;
import excepciones.LegajoInexistenteException;

public class Negocio
{	
	public Certificado certificado;
	
	public Negocio() {
		this.certificado = new Certificado();
	}
	
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
	
	public String traerEstado(String materia) {
		String estado = null;
		
		
		this.certificado.traerEstado(materia);
		
		return estado;
	}
	
	public String traerNota(String materia) {
		return "hola";
	}
	
	public String traerCondición() {
		return "hola";
	}
}
