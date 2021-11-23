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
 * @author Imanol V�zquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Ag�ero   
 *<br>
 *Clase que representa a la cl�nica.
 */

public class Clinica {

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
	 * Constructor para crear la Cl�nica, con valores ya establecidos.
	 */
	
	private Clinica() {
		this.nombre = "Clinica 1";
		this.direccion = "Col�n 2321";
		this.telefono = "223895648";
		this.ciudad = "Mar del Plata";
		this.salaPrivada = null;
	}
	
	/**
	 * Se aplic� Patr�n Singleton.
	 * Se obtiene (o se crea en caso que no est� creada) la instancia a la cl�nica.
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
	 * Agrega un m�dico al Hashmap de m�dicos, con su n�mero de matr�cula como clave.<br>
	 * <b>Pre: </b> El parametro medico debe ser distinto de null.<br>
	 * <b>Post: </b> Se agrega un medico mas al HashMap de m�dicos.<br>
	 * @param medico: Par�metro que ser� agregado al HashMap de m�dicos.
	 * @throws MedicoYaExisteException: Se lanza en caso de que la matricula ya este registrada.
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
	 * M�dulo de ingreso de un paciente a la cl�nica.<br>
	 * <b>Pre: </b> El parametro paciente debe ser distinto de null<br>
	 * <b>Post: </b> Si el paciente no estaba registrado, se lo registra con su DNI.<br>
	 * Se agrega al paciente a la lista de espera.<br>
	 * Si la sala privada estaba vac�a o si el paciente entrante tiene prioridad sobre el que ya estaba all�, se lo asigna a la sala privada, si no, se lo manda al patio.
	 * @param paciente: Paciente que ingresa a la cl�nica.
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
	 * M�dulo que retira al paciente de la espera y lo ubica en la Lista de Pacientes en Atenci�n.<br>
	 * <b>Pre: </b> Debe haber al menos un paciente en la lista de espera.
	 * <b>Post: </b> Se retira al siguiente paciente de la lista de espera y se lo pone en atenci�n.
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
	 * M�dulo que elige un paciente, lo retira de la lista de atenci�n y realiza la facturaci�n correspondiente.<br>
	 * <b>Pre: </b> El parametro paciente debe ser distinto de null.<br>
	 * <b>Post: </b> Se crea una factura, se la agrega a la lista de facturas de la cl�nica y se retira al paciente de la lista de atenci�n.
	 * @param paciente: Paciente que se retira de atenci�n y al cual se le genera la factura.
	 * @param prestaciones: Prestaciones que recibi� el paciente y que figurar�n en la factura.
	 */
	
	public void EgresoYFacturacion(Paciente paciente, HashMap<String, Prestacion> prestaciones) throws NoEstaPacienteException{
		if (listaAtencion.containsKey(paciente.getNroHistoria())) {
			Factura f = new Factura(paciente, prestaciones);
//			paciente.agregarPrestaciones(prestaciones);
			this.facturas.add(f);
			f.mostrarFactura();
			listaAtencion.remove(paciente.getNroHistoria());
		}
		else
			throw new NoEstaPacienteException("El paciente no se encuentra en la lista de atenci�n.");
	}
	
	/**
	 * M�dulo que reporta la actividad de un m�dico entre dos fechas dadas, enumerando los pacientes atendidos.<br>
	 * <b>Pre: </b> Todos los par�metros deben ser distintos de null.<br>
	 * <b>Post: </b> Se muestran las facturas correspondientes al per�odo dado.<br>
	 * @param medico: M�dico del cual se realice el reporte de actividad.
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
	public IMedico getMedico(long nroMatricula) {
		return medicos.get(nroMatricula);
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
	 * <b>Pre: </b> Par�metro tipo Factura distinto de null.<br>
	 * <b>Post: </b> Se agrega una factura al Treeset de facturas.<br>
	 * @param factura: Par�metro de tipo Factura que representa factura a agregar.
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
	 * Borra la �ltima de las facturas, si tiene.<br>
	 */	
	public void borrarUltimaFactura() {
		this.facturas.pollLast();
	}
	
	/**
	 * Devuelve �ltima factura si es que no est� vac�o el treeset de facturas, en caso contrario, lanza excepci�n.<br>
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
	 * En caso contrario, lanza una excepci�n.<br>
	 * <b>Pre: </b> El parametro paciente debe ser distinto de null.<br>
	 * <b>Post: </b> Si se puede, se agrega un paciente mas al HashMap de pacientes.<br>
	 * @param paciente: Par�metro que ser� agregado al HashMap de pacientes.
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
   	 * Borra un paciente pasado por par�metro.<br>
   	 * <b>Pre: </b> Par�metro distinto de null.<br>
   	 * <b>Post: </b> Se borra un paciente del Hashmap de pacientes.<br>
   	 * @param paciente: Par�metro que indica el paciente que ser� borrado del HashMap de asociados.
   	 */	
    public void removePaciente(Paciente paciente) {
       	if(this.pacientesRegistrados.containsKey(paciente.getDni()))
       		this.pacientesRegistrados.remove(paciente.getDni());
    }
    
    /**
     *  Borra un medico pasado por par�metro, siempre y cuando exista su numero de matricula.<br>
   	 * <b>Pre: </b> Par�metro medico =! null y la lista de medicos =! null.<br>
   	 * <b>Post: </b> Se borra un medico del Hashmap de medicos.<br>
   	 * @param medico: Par�metro que indica al medico que ser� borrado del HashMap de medicos.
     */
    public void removeMedico(IMedico medico) {
       	if(this.medicos.containsKey(medico.getNroMatricula()))
       		this.medicos.remove(medico.getNroMatricula());
    }
    
    public HashMap<Long, IMedico> getMedicos() {
    	return this.medicos;
    }
    
    public void agregaHabitacion(Habitacion habitacion) {
    	this.habitaciones.put(habitacion.getNumeroHabitacion(), habitacion);
    }
    
    public double calculoImporteAdicionales(int numeroDeFactura, Calendar fechaDeSolicitud, ArrayList<Double> listaDeInsumos) {
    	
    	double A=0.6, B=0.35, C=1.1, D=0.75;
    	double importeTotal = 0;
    	
    	if(numeroDeFactura < Factura.getSiguienteNumero()) { //Si existe ese nro de factura.
    		boolean encontrado = false;
    		Iterator<Factura> iterator = facturas.iterator();
    		Factura f = null;
    		while (iterator.hasNext() && !encontrado) {
    			f = iterator.next();
    			encontrado = (f.getNroFactura() == numeroDeFactura);
    		}
    		int milisegundosEnUnDia = 86400000;
    		int dias = (int) (fechaDeSolicitud.getTime().getTime() - f.getFecha().getTime().getTime()) / milisegundosEnUnDia;
    		double importeParcial;
    		if(dias < 10){
    			double subTotalImpar=0;
    			int j = 1;
				for(Prestacion i : f.getPrestaciones().values()) {
					if (j%2 == 0) {
						subTotalImpar += i.getSubtotal();
					}
					j++;
				}
    			importeParcial = f.getTotal() - subTotalImpar * A;
    		}
    		else {
    			importeParcial = f.getTotal();
    		}
    		if(f.getPaciente().esMayor()) {
    			importeTotal = importeParcial * C;
    		}
    		else {
    			importeTotal = importeParcial * D;
    		}
    		if((int)(Math.random()*31) + 1 != f.getFecha().DAY_OF_MONTH) {
    			for(double i : listaDeInsumos) {
    				importeTotal += i;
    			}
    		}
    	}
    	return importeTotal;
    	}
    
}