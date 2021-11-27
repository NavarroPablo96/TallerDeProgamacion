package modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

import excepciones.MedicoNoEncontradoException;
import excepciones.MismoDniExcepcion;
import excepciones.PacienteNoEncontradoExcepcion;
import interf.IMedico;

/**
 * <br>
 * Clase Clinica encargada de gestionar el sistema, cuyos atributos son:
 * (detalles de implemntacion explicativas para los profesores).</br>
 * <br>
 * -static Clinica instance: Intancia de la clinica para acceder a ella con el
 * patron singleton.</br>
 * <br>
 * - String nombre: Nombre de la clinica.</br>
 * <br>
 * - HashMap<String,Paciente> pacientes: Hash map que contiene los pacientes
 * registrados en la clinica (key=dni).</br>
 * <br>
 * - HashMap<String,Paciente> atencion: Hash map que contiene los pacientes en
 * atencion (key=dni).</br>
 * <br>
 * - HashMap<String,Paciente> medicos: Hash map que contiene los medicos de la
 * clinica (key=dni).</br>
 * <br>
 * -Queue<Paciente> colaDeEspera: Cola que tiene los pacientes ingresados
 * esperando por atencion por orden de llegada.</br>
 * <br>
 * - Sala_privada salaPriv: puede contener 0 o 1 paciente segun prioridad de
 * pacientes para esperar ser atendido.</br>
 * <br>
 * -Patio pat: puede contener 0 o mas pacientes segun prioridad de pacientes
 * para esperar ser atendidos.</br>
 * <br>
 * - static int nroORden: variable statica que asigana numero de orden por orden
 * de llegada a los pacientes en espera para ser atendidos.</br>
 */
public class Clinica
{

	private static Clinica instance = null;
	private String nombre;

	HashMap<String, Paciente> pacientes = new HashMap<String, Paciente>();
	HashMap<String, Habitacion> Habitacion = new HashMap<>();
	HashMap<String, Paciente> atencion = new HashMap<String, Paciente>();
	HashMap<String, IMedico> medicos = new HashMap<String, IMedico>();
	// ArrayList<Prestacion> prestacionesClinica = new ArrayList<Prestacion>();
	// //AGGREGADO 18/10
	HashMap<String, HistoriaClinica> historiaClinicaHashMap = new HashMap<>();

	/**
	 * @aggregation composite
	 */
	private Queue<Paciente> colaDeEspera = new LinkedList<>();

	/**
	 * @aggregation composite
	 */
	private Sala_privada salaPriv;

	/**
	 * @aggregation composite
	 */
	private Patio pat;
	private static int nroORden = 0;

	/**
	 * @aggregation composite
	 */
	ArrayList<Factura> facturas = new ArrayList<>();

	/**
	 * Obtener instancia con patron singleton
	 * 
	 * @return instancia clinica
	 */
	public static Clinica getInstance()
	{
		if (instance == null)
			instance = new Clinica();
		return instance;
	}

	private Clinica()
	{
		super();
		salaPriv = Sala_privada.getInstace();
		pat = Patio.getInstance();
	}

	// ------2do cuatrimestre 2021---------- AGGREGADO 18/10

	// -------PARA-SERIALIZAR-------

	public HashMap<String, Paciente> getAtencion()
	{
		return atencion;
	}

	public void setAtencion(HashMap<String, Paciente> atencion)
	{
		this.atencion = atencion;
	}

	public ArrayList<Factura> getFacturas()
	{
		return facturas;
	}

	public void setFacturas(ArrayList<Factura> facturas)
	{
		this.facturas = facturas;
	}

	public HashMap<String, Paciente> getPacientes()
	{
		return pacientes;
	}

	public void setPacientes(HashMap<String, Paciente> pacientes)
	{
		this.pacientes = pacientes;
		for (String clave : this.pacientes.keySet())
		{
			this.ingresaPaciente(this.pacientes.get(clave));
		}
	}

	public void agregaPrestacion(Prestacion prestacion, String nombre, String apellido, String dni)
	{
		if (this.historiaClinicaHashMap.containsKey(dni))
			getHistoriaClinicaHashMap().get(dni).addPrestacion(prestacion);
		else
		{
			historiaClinicaHashMap.put(dni, new HistoriaClinica(nombre, apellido, dni));
			historiaClinicaHashMap.get(dni).addPrestacion(prestacion);
		}
	}

	public HashMap<String, IMedico> getMedicos()
	{
		return medicos;
	}

	public void setMedicos(HashMap<String, IMedico> medicos)
	{
		this.medicos = medicos;
	}

	public HashMap<String, HistoriaClinica> getHistoriaClinicaHashMap()
	{
		return historiaClinicaHashMap;
	}

	public void setHistoriaClinicaHashMap(HashMap<String, HistoriaClinica> historiaClinicaHashMap)
	{
		this.historiaClinicaHashMap = historiaClinicaHashMap;
	}

	// --------------------------------------------------------------

	/**
	 * <b>PRE:</b> Objeto Imedico distinto de null <br>
	 * <b>POST:</b> Objeto Imedico pasado por parametro se agrega al hashmap de
	 * medicos de la Clinica <br>
	 * Metodo que agrega un medico pasado por parametro a su coleccion de medicos
	 * 
	 * @param medico Objeto de tipo Imedico
	 * @throws MismoDniException Excepcion lanzada en caso de que se intente agregar
	 *                           un medico con un dni igual al de otro medico que ya
	 *                           forme parte de la coleccion
	 */
	public void agregarMedico(IMedico medico) throws MismoDniExcepcion
	{
		if (this.medicos.get(medico.getDni()) != null)
			throw new MismoDniExcepcion(medico.getDni());
		else
			this.medicos.put(medico.getDni(), medico);
	}

	/**
	 * <b>PRE:</b> String dni distinto de cadena vacía y distino de null <br>
	 * <b>POST:</b> Se elimina el medico, cuyo dni es el pasado por parametro, del
	 * hashmap de medicos de la Clinica<br>
	 * Metodo que elimina a un medico pasado por parametro de la coleccion de
	 * medicos de la clinica
	 * 
	 * @param dni String que representa el documento del medico que se quiere
	 *            remover de la lista
	 * @throws MedicoNoEncontradoException Excepcion lanzada en caso de que el dni
	 *                                     pasado por parametro no corresponda con
	 *                                     ningun medico de los existentes en la
	 *                                     coleccion de medicos de la clinica
	 */
	public void removerMedico(String dni) throws MedicoNoEncontradoException
	{
		if (this.medicos.remove(dni) == null)
			throw new MedicoNoEncontradoException("El medico no forma parte del hospital", dni);
	}

	/**
	 * <b>PRE:</b> Objeto Paciente distinto de null <br>
	 * <b>POST:</b> Objeto Paciente pasado por parametro se agrega al hashmap de
	 * pacientes de la Clinica <br>
	 * Metodo que agrega un paciente pasado por parametro a su coleccion de paciente
	 * 
	 * @param p Objeto de tipo Paciente
	 * @throws MismoDniException Excepcion lanzada en caso de que se intente agregar
	 *                           un paciente con un dni igual al de otro paciente
	 *                           que ya forme parte de la coleccion
	 */
	public void altaPaciente(Paciente p) throws MismoDniExcepcion
	{
		if (this.pacientes.get(p.getDni()) != null)
			throw new MismoDniExcepcion(p.getDni());
		else
			this.pacientes.put(p.getDni(), p);
		System.out.println("Paciente agregado con exito");
	}

	/**
	 * <b>PRE:</b> String dni distinto de cadena vacia y distinto de null <br>
	 * 
	 * @param dni String que representa el dni de algun medico
	 * @return Imedico de la coleccion de medicos que tiene como atributo el dni
	 *         pasado por parametro
	 * @throws MedicoNoEncontradoException Excepcion lanzada en caso de que el dni
	 *                                     pasado por parametro no corresponda con
	 *                                     ningun medico de los existentes en la
	 *                                     coleccion de medicos de la clinica
	 */
	public IMedico devuelveMedico(String dni) throws MedicoNoEncontradoException
	{
		if (this.medicos.get(dni) == null)
			throw new MedicoNoEncontradoException("El medico no forma parte del hospital", dni);
		return this.medicos.get(dni);
	}

	/**
	 * <b>PRE:</b> String dni distinto de cadena vacia y distinto de null <br>
	 * 
	 * @param dni String que representa el dni de algun paciente
	 * @return Paciente de la coleccion de pacientes que tiene como atributo el dni
	 *         pasado por parametro
	 * @throws PacienteNoEncontradoExcepcion Excepcion lanzada en caso de que el dni
	 *                                       pasado por parametro no corresponda con
	 *                                       ningun paciente de los existentes en la
	 *                                       coleccion de pacientes de la clinica
	 */
	public Paciente consultarPaciente(String dni) throws PacienteNoEncontradoExcepcion
	{
		Paciente p1;
		p1 = null;
		try
		{
			if (!this.pacientes.isEmpty())
			{
				p1 = this.pacientes.get(dni);
				if (p1 != null)
					p1 = (Paciente) p1.clone();
			}
		} catch (CloneNotSupportedException e)
		{
		}
		if (p1 == null)
			throw new PacienteNoEncontradoExcepcion("El paciente no se encuentra en el hospital.", dni);
		else
			return p1;
	}

	/**
	 * <b>PRE:</b> String dni distinto de cadena vacía y distino de null <br>
	 * <b>POST:</b> Se elimina el paciente, cuyo dni es el pasado por parametro, se
	 * elimina del hashmap de pacientes de la Clinica<br>
	 * Metodo que elimina a un paciente pasado por parametro de la coleccion de
	 * medicos de la clinica
	 * 
	 * @param dni String que representa el documento del medico que se quiere
	 *            remover de la lista
	 * @throws PacienteNoEncontradoExcepcion Excepcion lanzada en caso de que el dni
	 *                                       pasado por parametro no corresponda con
	 *                                       ningun paciente de los existentes en la
	 *                                       coleccion de pacientes de la clinica
	 */
	public void removerPaciente(String dni) throws PacienteNoEncontradoExcepcion
	{
		if (this.pacientes.remove(dni) == null)
			throw new PacienteNoEncontradoExcepcion("El paciente no se encuentra en el hospital.", dni);

	}

	/**
	 * <b>PRE:</b> Strings dni, nom y ape distintos de cadena vacia y distintos de
	 * null<br>
	 * <b>POST:</b> Se modifican el nombre y apellido del paciente con dni pasado
	 * por parametro<br>
	 * Metodo que modifica el nombre y apelldio de un paciente
	 * 
	 * @param dni String que representa el documento del paciente que se quiere
	 *            modificar
	 * @param nom String que representa el nuevo nombre del paciente referenciado
	 * @param ape String que representa el nuevo apellido del paciente referenciado
	 * @throws PacienteNoEncontradoExcepcion Excepcion lanzada en caso de que el dni
	 *                                       pasado por parametro no corresponda con
	 *                                       ningun paciente de los existentes en la
	 *                                       coleccion de pacientes de la clinica
	 */
	public void modPacienteNomyApe(String dni, String nom, String ape) throws PacienteNoEncontradoExcepcion
	{
		Paciente p1;
		p1 = null;
		try
		{
			if (!this.pacientes.isEmpty())
				p1 = (Paciente) this.pacientes.get(dni).clone();
		} catch (CloneNotSupportedException e)
		{
		}
		if (p1 == null)
			throw new PacienteNoEncontradoExcepcion("El paciente no se encuentra en el hospital.", dni);

		else
		{
			p1.setNombre(nom);
			p1.setApellido(ape);
			this.pacientes.remove(p1.getDni());
			this.pacientes.put(p1.getDni(), p1);
		}
	}

	/**
	 * <b>PRE:</b> Strings dni y dom distintos de cadena vacia y distintos de
	 * null<br>
	 * <b>POST:</b> Se modifica el domicilio del paciente con dni pasado por
	 * parametro<br>
	 * Metodo que modifica el domicilio de un paciente
	 * 
	 * @param dni String que representa el documento del paciente que se quiere
	 *            modificar
	 * @param dom String que representa el nuevo domicilio del paciente referenciado
	 * @throws PacienteNoEncontradoExcepcion Excepcion lanzada en caso de que el dni
	 *                                       pasado por parametro no corresponda con
	 *                                       ningun paciente de los existentes en la
	 *                                       coleccion de pacientes de la clinica
	 */
	public void modPacienteDom(String dni, String dom) throws PacienteNoEncontradoExcepcion
	{
		Paciente p1;
		p1 = null;
		try
		{
			if (!this.pacientes.isEmpty())
				p1 = (Paciente) this.pacientes.get(dni).clone();
		} catch (CloneNotSupportedException e)
		{
		}
		if (p1 == null)
			throw new PacienteNoEncontradoExcepcion("El paciente no se encuentra en el hospital.", dni);

		else
		{
			p1.setDomicilio(dom);
			this.pacientes.remove(p1.getDni());
			this.pacientes.put(p1.getDni(), p1);
		}
	}

	/**
	 * <b>PRE:</b> Strings dni y tel distintos de cadena vacia y distintos de
	 * null<br>
	 * <b>POST:</b> Se modifica el telefono del paciente con dni pasado por
	 * parametro<br>
	 * Metodo que modifica el telefono de un paciente
	 * 
	 * @param dni String que representa el documento del paciente que se quiere
	 *            modificar
	 * @param dom String que representa el nuevo telefono del paciente referenciado
	 * @throws PacienteNoEncontradoExcepcion Excepcion lanzada en caso de que el dni
	 *                                       pasado por parametro no corresponda con
	 *                                       ningun paciente de los existentes en la
	 *                                       coleccion de pacientes de la clinica
	 */
	public void modPacienteTel(String dni, String tel) throws PacienteNoEncontradoExcepcion
	{
		Paciente p1;
		p1 = null;
		try
		{
			if (!this.pacientes.isEmpty())
				p1 = (Paciente) this.pacientes.get(dni).clone();
		} catch (CloneNotSupportedException e)
		{
		}
		if (p1 == null)
			throw new PacienteNoEncontradoExcepcion("El paciente no se encuentra en el hospital.", dni);

		else
		{
			p1.setTelefono(tel);
			this.pacientes.remove(p1.getDni());
			this.pacientes.put(p1.getDni(), p1);
		}
	}

	/**
	 * <b>PRE:</b> Objeto Paciente distinto de null <br>
	 * <b>POST:</b> Objeto Paciente pasado por parametro se agrega a la sala de
	 * espera y tambien se le asigna un numero de orden para luego (con otro metodo)
	 * ser atendido <br>
	 * Metodo que ingresa un paciente a la sala de espera (en la sala privada o
	 * patio) dependiendo de su rango etario
	 * 
	 * @param p Objeto de tipo Paciente
	 */
	public void ingresaPaciente(Paciente p)
	{
		Paciente pSalaPriv;
		pSalaPriv = null;
		colaDeEspera.add(p);
		p.setNroOrden(nroORden++);
		pSalaPriv = salaPriv.devuelvePaciente();
		if (p.establecerPriotodad(pSalaPriv))
		{
			salaPriv.AgregaPaciente(p);
			if (pSalaPriv != null)
				pat.AgregaPaciente(pSalaPriv);
		} else
			pat.AgregaPaciente(p);
	}

	/**
	 * <b>POST:</b> El paciente con el siguiente numero de orden es ingresado en el
	 * hasmap de atencion (en caso de que haya pacientes en las distintas salas de
	 * espera)<br>
	 * Metodo que atiende al siguiente paciente de las salas de espera, en caso de
	 * que no haya pacientes en espera, lo indica
	 */
	public void atenderPaciente()
	{
		Paciente p = null;
		try
		{
			p = colaDeEspera.remove();
			atencion.put(p.getDni(), p);
			try
			{
				this.pat.QuitaPaciente(p.getDni());
			} catch (PacienteNoEncontradoExcepcion e)
			{
				try
				{
					this.salaPriv.QuitaPaciente(e.getDni());
				} catch (PacienteNoEncontradoExcepcion f)
				{
					System.out.println("Paciente no encontrado en Ingreso");
				}
			}
		} catch (NoSuchElementException e)
		{
			System.out.println("No quedan pacientes por ser atendidos");
		}

	}

	/**
	 * Metodo que muestra los pacientes en el hashmap de atencion e indica en caso
	 * de que esta coleccion este vacia
	 */
	public void muestraPacientesAtencion()
	{
		Paciente p;
		p = null;
		Iterator<Paciente> it = this.atencion.values().iterator();
		if (this.atencion.isEmpty())
			System.out.println("Atencion vacia");
		else
		{
			System.out.println("Pacientes en atecion");
			while (it.hasNext())
			{
				try
				{
					p = (Paciente) it.next().clone();
				} catch (CloneNotSupportedException e)
				{
				}
				System.out.println(p.getNombre() + " " + p.getDni());
			}
		}
	}

	public void muestraPacSalaPriv()
	{
		this.salaPriv.muestraPaciente();
	}

	public void muestraPacPatio()
	{
		this.pat.muestraPacientes();
	}

	public void agregarPrestacionAPaciente(Paciente paciente, Prestacion prestacion)
	{
		agregaPrestacion(prestacion, paciente.getNombre(), paciente.getApellido(), paciente.getDni());
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public String getNombre()
	{
		return this.nombre;
	}

///////////////////////////// MODULO DE EGRESO Y FACTURACION////////////////////////////////////////////////////////// 
	/**
	 * <b>pre:</b> fecha formato valido y paciente distinto de null<br>
	 * Metodo que da de alta al paciente pasado por parametro y genera la factura
	 * del mismo teniendo en cuenta sus prestaciones
	 * 
	 * @param paciente Nombre del paciente a dar de alta y facturar
	 * @param fecha    Fecha en que se factura (en un caso real no se tomaria este
	 *                 parametro, se tomaria la fecha del sistema)
	 * @return String que contiene la factura del paciente pasado por parametro
	 * @throws PacienteNoEncontradoExcepcion Si el paciente no esta en la clinica se
	 *                                       lanza la excepcion
	 */
	public String darAltaYFacturar(Paciente paciente, GregorianCalendar fecha) throws PacienteNoEncontradoExcepcion
	{
		StringBuilder sb = new StringBuilder();
		sb.setLength(0);
		if (!this.atencion.containsKey(paciente.getDni()))
		{
			throw new PacienteNoEncontradoExcepcion("El paciente no se encuentra en la clinica", paciente);
		}

		Iterator<Prestacion> it = historiaClinicaHashMap.get(paciente.getDni()).getPrestacions().values().iterator();
		Prestacion prestacion;
		Factura factura = new Factura(fecha, paciente);
		while (it.hasNext())
		{
			prestacion = it.next();
			if (!prestacion.isFactured())
			{
				prestacion.setFactured(true);
				factura.getPrestaciones().add(prestacion);
			}
		}
		sb.append("\n\n\n\n---------------------------FACTURA - CLINICA: " + this.nombre
				+ "---------------------------------\n\n");
		facturas.add(factura);
		sb.append(factura.muestraFactura());
		sb.append("\nTOTAL: $" + this.facturas.get(facturas.size() - 1).totalFactura()

				+ "\n\"-----------------------------------------------------------------------------------------------");
		this.atencion.remove(paciente.getDni());
		return sb.toString();

	}

///////////////////////////// REPORTE DE ACTIVIDAD MEDICA /////////////////////////////////////////////////////////////		

	/**
	 * <b>pre:</b> medico existe en el hashmap de medicos, fecha con formato valido
	 * y hasta > desde<br>
	 * Metodo que reporta la actividad de un medico dentro un rango de fechas . <br>
	 * 
	 * @param medico Medico del cual se reporta su actividad
	 * @param desde  Limite inferior del rango de fecha a mostrar
	 * @param hasta  Limite superior del rango de fecha a mostrar
	 */

	public void reporteActividadMedica(IMedico medico, GregorianCalendar desde, GregorianCalendar hasta)
	{
		StringBuilder sb = new StringBuilder();

		int i = 0;
		int n = facturas.size();
		double total;

		total = 0;

		while (i < n && facturas.get(i).getFecha().compareTo(desde) < 0)// BUSCO EN EL ARRAY DE FACTURAS HASTA ENCONTRAR
			// LA FECHA "desde" o una mayor
			i++;
		if (i < n)
		{ // Encontre una fecha perteneciente al intervalo

			System.out.println("\nConsultas atendidas por el medico/a " + medico.getNombre() + " desde "
					+ this.muestraFecha(desde) + " hasta " + this.muestraFecha(hasta));
			System.out.println(
					"    NOMBRE DEL PACIENTE         HONORARIO             CANTIDAD DE CONSULTAS PRACTICADAS          FECHA                 SUBTOTAL");

			while (i < n && facturas.get(i).getFecha().compareTo(hasta) <= 0)
			{ // entro a este ciclo siempre que la
				// factura corresponda al intervalo de
				// fecha
				// [desde;hasta]

				total += facturas.get(i).muestraPrestacionMedico(medico); // busca en la factura si el medico pasado por
				// parametro atendio al
				// paciente de dicha factura, de ser asi
				// muestra el informe
				i++;
			}
			System.out.println("El total recaudado por el medico " + medico.getNombre() + " es: $" + total);
		} else // No se encontro ninguna fecha perteneciente al intervalo
			System.out.println("No hay facturas que involucren a el medico " + medico.getNombre()
					+ " en el rango de fechas solicitado");
	}

	/**
	 * Metodo que reporta la actividad de todos los medicos dentro un rango de
	 * fechas . <br>
	 *
	 * @param desde Limite inferior del rango de fecha a mostrar
	 * @param hasta Limite superior del rango de fecha a mostrar
	 *
	 *              <b>pre:</b> formato valido y hasta > desde<br>
	 */
	public void muestraFacturaRangoFechas(GregorianCalendar desde, GregorianCalendar hasta)
	{

		int i = 0;
		int n = facturas.size();

		while (i < n && facturas.get(i).getFecha().compareTo(desde) < 0)// BUSCO EN EL ARRAY DE FACTURAS HASTA ENCONTRAR
			// LA FECHA "desde" o una mayor
			i++;

		if (i < n)
		{ // Encontre una fecha perteneciente al intervalo

			System.out.println(
					"\nFacturas/a " + " desde " + this.muestraFecha(desde) + " hasta " + this.muestraFecha(hasta));

			while (i < n && facturas.get(i).getFecha().compareTo(hasta) <= 0)
			{ // entro a este ciclo siempre que la factura corresponda al intervalo de fecha
				// [desde;hasta]
				System.out.println(facturas.get(i).muestraFactura());
				i++;
			}
		}
	}

	public String muestraFecha(GregorianCalendar fecha)
	{
		if (fecha.get(Calendar.MONTH) == 0) // hacemos esto debido a que cuando el mes es 12, por alguna razon, el mes
											// cambia su valor a 0 y el anio se incrementa en 1
			return fecha.get(Calendar.DATE) + "/12/" + (fecha.get(Calendar.YEAR) - 1);
		else
			return fecha.get(Calendar.DATE) + "/" + fecha.get(Calendar.MONTH) + "/" + fecha.get(Calendar.YEAR);
	}

	public Queue<Paciente> getColaDeEspera() {
		return colaDeEspera;
	}
	
	

}
