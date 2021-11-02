package modelo;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

import java.util.Iterator;

import decorators.IMedico;
import excepciones.PacienteYaExisteException;
import excepciones.MedicoYaExisteException;
import excepciones.NoEstaPacienteException;
import excepciones.NoHayConsultaException;
import excepciones.OrdenFechasIncorrectoException;

/**
 * @author Imanol Vázquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Agüero   
 *<br>
 *Clase que representa a la clínica.
 */

public class Clinica {
    public HashMap<Long, IMedico> getMedicos() {
		return medicos;
	}

	/**
     * @aggregation composite
     */
    private static Clinica instance = null;
	private String nombre;
	private String direccion;
	private String telefono;
	private String ciudad;

    /**
     * @aggregation shared
     */
    private Paciente salaPrivada;
	private HashMap<String,Paciente> patio = new HashMap<String,Paciente>();

    /**
     * @aggregation shared
     */
    private Queue<Paciente> listaEspera = new LinkedList();
	private HashMap<Long,Paciente> listaAtencion = new HashMap<Long,Paciente>();
	private HashMap<String,Habitacion> habitaciones = new HashMap<String,Habitacion>();
	private HashMap<String,Paciente> pacientesRegistrados = new HashMap<String,Paciente>();
	private HashMap<Long,IMedico> medicos = new HashMap<Long,IMedico>();

    /**
     * @aggregation composite
     */
    private TreeSet<Factura> facturas = new TreeSet<>();
	

	DecimalFormat df = new DecimalFormat("#.00");
	
	/**
	 * Constructor para crear la Clínica, con valores ya establecidos.
	 */
	
	private Clinica() {
		this.nombre = "Clinica 1";
		this.direccion = "Colón 2321";
		this.telefono = "223895648";
		this.ciudad = "Mar del Plata";
		this.salaPrivada = null;
	}
	
	/**
	 * Se aplicó Patrón Singleton.
	 * Se obtiene (o se crea en caso que no esté creada) la instancia a la clínica.
	 */
	
	public static Clinica getInstance() {
		if (Clinica.instance == null) {
			Clinica.instance = new Clinica();
		}
		return instance;
	}
	
	
	public Paciente getSalaPrivada() {
		return salaPrivada;
	}

	/**
	 * Agrega un médico al Hashmap de médicos, con su número de matrícula como clave.<br>
	 * <b>Pre: </b> El parametro medico debe ser distinto de null.<br>
	 * <b>Post: </b> Se agrega un medico mas al HashMap de médicos.<br>
	 * @param medico: Parámetro que será agregado al HashMap de médicos.
	 */
	
	public void addMedico(IMedico medico) throws MedicoYaExisteException{
		Iterator it = this.medicos.values().iterator();
    	boolean esta=false;
    	while(it.hasNext() && !esta) {
    		esta=medico.equals(it.next());
    	}
    	if(!esta) {
    		this.medicos.put(medico.getNroMatricula(), medico);
    	}else {
    		throw new MedicoYaExisteException(medico.getNroMatricula());
    	}
		
	}
	
	/**
	 * Módulo de ingreso de un paciente a la clínica.<br>
	 * <b>Pre: </b> El parametro paciente debe ser distinto de null<br>
	 * <b>Post: </b> Si el paciente no estaba registrado, se lo registra con su DNI.<br>
	 * Se agrega al paciente a la lista de espera.<br>
	 * Si la sala privada estaba vacía o si el paciente entrante tiene prioridad sobre el que ya estaba allí, se lo asigna a la sala privada, si no, se lo manda al patio.
	 * @param paciente: Paciente que ingresa a la clínica.
	 */
	
	public void Ingreso(Paciente paciente) {
		if (!pacientesRegistrados.containsKey(paciente.getNroHistoria()))
			pacientesRegistrados.put(paciente.getDni(), paciente);
		listaEspera.add(paciente);
		if (this.salaPrivada == null || paciente.prioridad(salaPrivada))
			salaPrivada = paciente;
		else
			patio.put(paciente.getDni(), paciente);
	}
	
	/**
	 * Módulo que retira al paciente de la espera y lo ubica en la Lista de Pacientes en Atención.<br>
	 * <b>Pre: </b> Debe haber al menos un paciente en la lista de espera.
	 * <b>Post: </b> Se retira al siguiente paciente de la lista de espera y se lo pone en atención.
	 */
	
	public void Atencion() {
		Paciente p = listaEspera.poll();
		listaAtencion.put(p.getNroHistoria(), p);
		if (salaPrivada != null && salaPrivada.equals(p))
			salaPrivada = null;
		else
			patio.remove(p.getDni());
	}
	
	/**
	 * Módulo que elige un paciente, lo retira de la lista de atención y realiza la facturación correspondiente.<br>
	 * <b>Pre: </b> El parametro paciente debe ser distinto de null.<br>
	 * <b>Post: </b> Se crea una factura, se la agrega a la lista de facturas de la clínica y se retira al paciente de la lista de atención.
	 * @param paciente: Paciente que se retira de atención y al cual se le genera la factura.
	 * @param prestaciones: Prestaciones que recibió el paciente y que figurarán en la factura.
	 */
	
	public void EgresoYFacturacion(Paciente paciente, HashMap<String, Prestacion> prestaciones) throws NoEstaPacienteException{
		if (listaAtencion.containsKey(paciente.getNroHistoria())) {
			Factura f = new Factura(paciente, prestaciones);
			paciente.agregarPrestaciones(prestaciones);
			this.facturas.add(f);
			f.mostrarFactura();
			listaAtencion.remove(paciente.getNroHistoria());
		}
		else
			throw new NoEstaPacienteException("El paciente no se encuentra en la lista de atención.");
	}
	
	/**
	 * Módulo que reporta la actividad de un médico entre dos fechas dadas, enumerando los pacientes atendidos.<br>
	 * <b>Pre: </b> Todos los parámetros deben ser distintos de null.<br>
	 * <b>Post: </b> Se muestran las facturas correspondientes al período dado.<br>
	 * @param medico: Médico del cual se realice el reporte de actividad.
	 * @param fecha1: Fecha desde la cual se solicita el reporte.
	 * @param fecha2: Fecha hasta la cual se solicita el reporte.
	 */
	
	public void ReporteActividadMedica(IMedico medico, Calendar fecha1, Calendar fecha2) throws NoHayConsultaException, OrdenFechasIncorrectoException {
		if (fecha1.compareTo(fecha2) <= 0) {
			Iterator<Factura> itFacturas = facturas.iterator();
			Factura f1 =  null;
			double total = 0;
			
			boolean condicion = true;
			while (itFacturas.hasNext() && condicion) {
				f1 = itFacturas.next();
				if (f1.getFecha().compareTo(fecha1) >= 0) {
					condicion = false;
				}
			}
			condicion = true;
			
			System.out.println("Paciente \t Cantidad de consultas \t Honorario total \t Fecha");
			while (itFacturas.hasNext() && condicion && f1.getFecha().compareTo(fecha2) < 0) {
				if(f1.getPrestaciones().containsKey(medico.getNombre())) {
					System.out.println(f1.getPaciente().getNombre() + " " + f1.getPaciente().getApellido() + " \t\t " + f1.getPrestaciones().get(medico.getNombre()).getCantidad() + " \t\t " + df.format(f1.getPrestaciones().get(medico.getNombre()).getCantidad() * medico.getHonorario()) + " \t\t "+ f1.getFecha().get(Calendar.DATE) + "/" + (f1.getFecha().get(Calendar.MONTH)+1) + "/" + f1.getFecha().get(Calendar.YEAR));
					total += f1.getPrestaciones().get(medico.getNombre()).getCantidad() * medico.getHonorario();
				}
				f1 = itFacturas.next();
				if (f1.getFecha().compareTo(fecha2) > 0) {
					condicion = false;
				}
			}
			if(f1 != null && f1.getPrestaciones().containsKey(medico.getNombre()) && f1.getFecha().compareTo(fecha2) < 0) {
				System.out.println(f1.getPaciente().getNombre() + " " + f1.getPaciente().getApellido() + " \t\t " + f1.getPrestaciones().get(medico.getNombre()).getCantidad() + " \t\t " + df.format(f1.getPrestaciones().get(medico.getNombre()).getCantidad() * medico.getHonorario()) + " \t\t "+ f1.getFecha().get(Calendar.DATE) + "/" + (f1.getFecha().get(Calendar.MONTH)+1) + "/" + f1.getFecha().get(Calendar.YEAR));
				total += f1.getPrestaciones().get(medico.getNombre()).getCantidad() * medico.getHonorario();
			}
			if (total != 0)
				System.out.println("Total= " + total);
			else
				throw new NoHayConsultaException("No hay ninguna consulta entre esas fechas.");
		}
		else
			throw new OrdenFechasIncorrectoException("El orden de las fechas ingresadas es incorrecto.");
	}

	public void setPacientesRegistrados(HashMap<String, Paciente> pac) {
		// TODO Auto-generated method stub
		for(HashMap.Entry<String,Paciente> i:pac.entrySet()) {
			this.pacientesRegistrados.put(i.getKey(),i.getValue());
		}
	}
	
	public TreeSet<Factura> getFacturas() {
		return facturas;
	}
	
	
	/**
	 * Busca el medico en el hashmap con su numero de matricula y lo retorna<br>
	 * <b>Pre: </b>Debe existir al menos un medico en el Hashmap y el paramtro nroMatricula debe ser de un medico existente
	 *  @param nroMatricula: numero de matricula de un Medico
	 *  @return retorna el medico al que pertenece el numero de matricula
	 */
	public Medico getMedico(long nroMatricula) {
		return (Medico) medicos.get(nroMatricula);
	}

	/**
	 * Busca el paciente en el hashmap con su numero de historia clinica y lo retorna<br>
	 * <b>Pre: </b>Debe existir al menos un paciente en el Hashmap y el paramtro nroHistoriaPaciente debe ser de un Paciente existente
	 *  @param nroHistoriaPaciente: numero de historia clinica de un Pacietne
	 *  @return retorna el Paciente al que pertenece el numero de historia clinica
	 */
	public Paciente getPaciente(long nroHistoriaPaciente) {
		return pacientesRegistrados.get(nroHistoriaPaciente);
	}

	public HashMap<String, Paciente> getPacientesRegistrados() {
		return pacientesRegistrados;
	}

	public void setMedicos(HashMap<Long, IMedico> medicos) {
		this.medicos = medicos;
	}

	public void setFacturas(TreeSet<Factura> facturas) {
		this.facturas = facturas;
	}

	public HashMap<String, Habitacion> getHabitaciones() {
		return habitaciones;
	}
	
	/**
	 * Agrega una Factura al Treeset de facturas.<br>
	 * <b>Pre: </b> Parámetro tipo Factura distinto de null.<br>
	 * <b>Post: </b> Se agrega una factura al Treeset de facturas.<br>
	 * @param factura: Parámetro de tipo Factura que representa factura a agregar.
	 */
	public void addFactura(Factura factura) {
		this.facturas.add(factura);
	}
	
	/**
	 * Borra todas las facturas guardadas.<br>
	 */	
	public void borrarFacturas() {
		this.facturas.clear();
	}
		
	/**
	 * Borra la última de las facturas, si tiene.<br>
	 */	
	public void borrarUltimaFactura() {
		this.facturas.pollLast();
	}
	
	/**
	 * Devuelve última factura si es que no está vacío el treeset de facturas, en caso contrario, lanza excepción.<br>
	 */	
	public Factura getUltimaFactura() {
		try {
		return this.facturas.last();
		}catch(NoSuchElementException e) {
			return null;
		}
	}
	
	/**
	 * Agrega un Paciente al Hashmap de pacientes, con su dni como clave.
	 * Si no hay un paciente agregado con el mismo dni, lo agrega.
	 * En caso contrario, lanza una excepción.<br>
	 * <b>Pre: </b> El parametro paciente debe ser distinto de null.<br>
	 * <b>Post: </b> Si se puede, se agrega un paciente mas al HashMap de pacientes.<br>
	 * @param paciente: Parámetro que será agregado al HashMap de pacientes.
	 */	
    public void addPaciente(Paciente paciente) throws PacienteYaExisteException {
    	Iterator it = this.pacientesRegistrados.values().iterator();
    	boolean esta=false;
    	while(it.hasNext() && !esta) {
    		esta=paciente.equals(it.next());
    	}
    	if(!esta) {
    		this.pacientesRegistrados.put(paciente.getDni(), paciente);
    	}else {
    		throw new PacienteYaExisteException(paciente.getDni());
    	}
    }  
    
    /**
   	 * Borra un paciente pasado por parámetro.<br>
   	 * <b>Pre: </b> Parámetro distinto de null.<br>
   	 * <b>Post: </b> Se borra un paciente del Hashmap de pacientes.<br>
   	 * @param paciente: Parámetro que indica el paciente que será borrado del HashMap de asociados.
   	 */	
    public void removePaciente(Paciente paciente) {
       	if(this.pacientesRegistrados.containsKey(paciente.getDni()))
       		this.pacientesRegistrados.remove(paciente.getDni());
    }
    
    public void removeMedico(IMedico medico) {
       	if(this.medicos.containsKey(medico.getNroMatricula()))
       		this.medicos.remove(medico.getNroMatricula());
    }
}