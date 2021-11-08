package modelo;

import excepciones.PacienteNoEncontradoExcepcion;

/**
 * * Clase sala_privada uso de patron singleton ya que se usa una sola instancia
 * contiene los pacientes ingrsados en la sala privada
 * 
 */
public class Sala_privada extends Sala
{

	/**
	 * @aggregation shared
	 */
	Paciente pac;
	private static Sala_privada _instance = null;

	private Sala_privada()
	{
		super();
	}

	public static Sala_privada getInstace()
	{
		if (_instance == null)
			_instance = new Sala_privada();
		return _instance;
	}

	public void AgregaPaciente(Paciente p)
	{
		this.pac = p;
	}
	
	
	/**
	 * Metodo que retorna el paciente que se encuentra en la sala privada
	 * @return una copia del paciente que esta en la sala privada
	 */
	public Paciente devuelvePaciente()
	{
		Paciente p1;
		p1 = null;
		try
		{
			if (this.pac != null)
				p1 = (Paciente) this.pac.clone();
		} catch (CloneNotSupportedException e)
		{
		}
		return p1;
	}

	/**
	 * Metodo que lista todos los pacientes que se encuentran en el hashmap de
	 * pacientes
	 */
	public void muestraPaciente()
	{
		if (this.pac != null)
		{
			System.out.println("Paciente de la sala privada");
			System.out.println(
					this.pac.getNombre() + " dni: " + this.pac.getDni() + " nro orden: " + this.pac.getNroOrden());
		}

		else
			System.out.println("Sala vacia");
	}

	/**
	 * <b>PRE:</b> dni distinro de null<br>
	 * <b>POST:</b> el paciente cuyo dni coincida con el pasado por parametro es
	 * eliminado del hashmap de pacientes<br>
	 * Metodo que elimina un paciente de la sala privada
	 * 
	 * @param dni String que representa el documento del paciente que se quiere
	 *            retirar de la lsita de pacientes
	 * @throws PacienteNoEncontradoExcepcion Excepcion lanzada en caso de que el dni
	 *                                       pasado por parametro no corresponda con
	 *                                       ningun paciente de los existentes en la
	 *                                       coleccion de pacientes de la sala
	 *                                       privada
	 */
	@Override
	public void QuitaPaciente(String dni) throws PacienteNoEncontradoExcepcion
	{
		if (dni != this.pac.getDni())
			throw new PacienteNoEncontradoExcepcion("El paciente no se encuentra en el hospital.", dni);
		else
			this.pac = null;
	}
}