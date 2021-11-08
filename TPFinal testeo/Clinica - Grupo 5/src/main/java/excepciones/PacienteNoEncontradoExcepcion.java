package excepciones;

import modelo.Paciente;

public class PacienteNoEncontradoExcepcion extends Exception
{
	String dni = null;
	Paciente paciente = null;

	@SuppressWarnings("oracle.jdeveloper.java.insufficient-catch-block")
	public PacienteNoEncontradoExcepcion(String message, String dni)
	{
		super(message);
		this.dni = dni;
	}

	public PacienteNoEncontradoExcepcion(String message, Paciente paciente)
	{
		super(message);
		this.paciente = paciente;
	}

	public String getDni()
	{
		return dni;
	}

	public Paciente getPaciente()
	{
		return this.paciente;
	}
}
