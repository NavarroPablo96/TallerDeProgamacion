package excepciones;

public class NoExisteEspecialidadException extends ImposibleCrearMedicoException
{
	private String especialidadInexistente;

	public NoExisteEspecialidadException(String arg0, String especialidad)
	{
		super(arg0);
		this.especialidadInexistente = especialidad;
	}

	public String getEspecialidadInexistente()
	{
		return especialidadInexistente;
	}

}
