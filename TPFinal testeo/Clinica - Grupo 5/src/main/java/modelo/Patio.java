package modelo;

import java.util.HashMap;
import java.util.Iterator;

import excepciones.PacienteNoEncontradoExcepcion;

/**
 * Clase patio uso de patron singleton ya que se usa una sola instancia contiene
 * los pacientes ingrsados en el patio
 */
public class Patio extends Sala
{
	HashMap<String, Paciente> pacientes = new HashMap<String, Paciente>();
	private static Patio _instance = null;

	public static Patio getInstance()
	{
		if (_instance == null)
			_instance = new Patio();
		return _instance;
	}

	private Patio()
	{
		super();
	}

	/**
	 * <b>PRE:</b> objeto paciente distinto de null<br>
	 * <b>POST:</b> el paciente cuyo dni coincida con el pasado por parametro es
	 * agregado al hashmap de pacientes<br>
	 * Metodo que agrega un paciente al patio
	 * 
	 * @param p Objeto de tipo Paciente que se quiere agregar al patio
	 */
	@Override
	public void AgregaPaciente(Paciente p)
	{
		this.pacientes.put(p.getDni(), p);
	}

	/**
	 * <b>PRE:</b> dni distinro de null<br>
	 * <b>POST:</b> el paciente cuyo dni coincida con el pasado por parametro es
	 * eliminado del hashmap de pacientes<br>
	 * Metodo que elimina un paciente del patio
	 * 
	 * @param dni String que representa el documento del paciente que se quiere
	 *            retirar de la lsita de pacientes
	 * @throws PacienteNoEncontradoExcepcion Excepcion lanzada en caso de que el dni
	 *                                       pasado por parametro no corresponda con
	 *                                       ningun paciente de los existentes en la
	 *                                       coleccion de pacientes del patio
	 */
	@Override
	public void QuitaPaciente(String dni) throws PacienteNoEncontradoExcepcion
	{
		if (this.pacientes.get(dni) != null)
			this.pacientes.remove(dni);
		else
			throw new PacienteNoEncontradoExcepcion("El paciente no se encuentra en el hospital.", dni);
	}

	/**
	 * Metodo que devuelve la coleccion de pacientes del patio
	 * 
	 * @return una copia del hashmap de pacientes del patio
	 */
	public HashMap<String, Paciente> listaPacientes()
	{
		Paciente p;
		HashMap<String, Paciente> copia = new HashMap<String, Paciente>();
		Iterator<Paciente> it = this.pacientes.values().iterator();
		while (it.hasNext())
		{
			try
			{
				p = (Paciente) it.next().clone();
				copia.put(p.getDni(), p);
			} catch (CloneNotSupportedException e)
			{
			}
		}
		return copia;
	}

	/**
	 * Metodo que lista todos los pacientes que se encuentran en el hashmap de
	 * pacientes
	 */
	public void muestraPacientes()
	{
		Paciente p;
		p = null;
		Iterator<Paciente> it = this.pacientes.values().iterator();
		if (this.pacientes.isEmpty())
			System.out.println("Patio vacio");
		else
		{
			System.out.println("Pacientes patio");
			while (it.hasNext())
			{
				try
				{
					p = (Paciente) it.next().clone();
				} catch (CloneNotSupportedException e)
				{
				}
				System.out.println(p.getNombre() + " dni: " + p.getDni() + " nro orden." + p.getNroOrden());
			}
		}
	}
}
