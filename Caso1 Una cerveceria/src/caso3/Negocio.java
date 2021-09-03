package caso3;

import excepciones.LegajoInexistenteException;

public class Negocio
{	
	public Certificado certificado;
	
	public Negocio() {
		this.certificado = new Certificado();
	}
	
    public void pedirCertificado(Integer Legajo) throws LegajoInexistenteException {
		certificado.pedirCertificado(Legajo);
	}
	
	public String traerApellidoyNombre() {
		return "hola";
	}
	
	public String traerEstado(String Materia) {
		return "hola";
	}
	
	public String traerNota(String Materia) {
		return "hola";
	}
	
	public String traerCondición() {
		return "hola";
	}
}
