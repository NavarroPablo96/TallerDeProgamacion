package caso3;

import excepciones.CertificadoNoPedidoException;
import excepciones.LegajoInexistenteException;
import excepciones.MateriaInexistenteException;

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
	
	public String traerEstado(String materia) throws CertificadoNoPedidoException, LegajoInexistenteException, MateriaInexistenteException {
		String estado = null;
		
		estado = this.certificado.traerEstado(materia);
		
		return estado;
	}
	
	public String traerCertificado() throws CertificadoNoPedidoException{
		return this.certificado.armaCertificado();
	}
	
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
}
