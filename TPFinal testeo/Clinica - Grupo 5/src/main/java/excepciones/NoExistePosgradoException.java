package excepciones;

public class NoExistePosgradoException extends ImposibleCrearMedicoException
{
	private String posgradoInexistente;

	public NoExistePosgradoException(String arg0, String posgrado)
	{
		super(arg0);
		this.posgradoInexistente = posgrado;
	}

	public String getEspecialidadInexistente()
	{
		return posgradoInexistente;
	}

}
