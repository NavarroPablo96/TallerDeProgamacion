package excepciones;

public class NoExisteContratacionException extends ImposibleCrearMedicoException
{
	private String contratacionInexistente;

	public NoExisteContratacionException(String arg0, String contratacion)
	{
		super(arg0);
		this.contratacionInexistente = contratacion;
	}

	public String getEspecialidadInexistente()
	{
		return contratacionInexistente;
	}

}
