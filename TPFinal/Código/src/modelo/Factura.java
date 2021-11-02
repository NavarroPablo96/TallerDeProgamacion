package modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

/**
 * @author Imanol Vázquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Agüero   
 *<br>
 *Clase que representa una factura realizada a un paciente ya atendido.
 */
public class Factura implements Comparable,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int siguienteNumero = 0;
	private int nroFactura;
	private Calendar fecha = new GregorianCalendar();

    /**
     * @aggregation shared
     */
    private long nroHistoriaPaciente;
    private String dniPaciente;
	private String nombrePaciente;
	private String apellidoPaciente;
    
	private double total;
	private HashMap<String, Prestacion> prestaciones = new HashMap<String, Prestacion>();
	
	/**
     * Constructor con dos parametros para setear el paciente al que se le adjudica la factura y su lista de prestaciones.<br>
     * <b> Pre: </b> El parámetro paciente debe ser distinto de null. El paciente debe existir<br>
     * <b> Post: </b> el atributo estático siguienteNumero se incrementa en 1.<br>
     * @param paciente : parámetro de tipo Paciente que representa al paciente al que se le realiza la facturación.
     * @param prestaciones : parámetro de tipo HashMap que representa un listado de las prestaciones pertenecientes al paciente.
     */
	public Factura(Paciente paciente, HashMap<String, Prestacion> prestaciones) {
		Factura.siguienteNumero++;
		this.nroFactura = Factura.siguienteNumero;
		this.fecha = Calendar.getInstance();
		this.nroHistoriaPaciente = paciente.getNroHistoria();
		this.prestaciones = prestaciones;
		this.calculaTotal();
		this.dniPaciente = paciente.getDni();
		this.nombrePaciente = paciente.getNombre();
		this.apellidoPaciente = paciente.getApellido();
	}
	
	public Factura(Paciente paciente) {
		Factura.siguienteNumero++;
		this.nroFactura = Factura.siguienteNumero;
		this.fecha = fecha.getInstance();
		this.nroHistoriaPaciente = paciente.getNroHistoria();
		this.dniPaciente = paciente.getDni();
		this.nombrePaciente = paciente.getNombre();
		this.apellidoPaciente = paciente.getApellido();
		this.total=0;
		
	}


	public int getNroFactura() {
		return nroFactura;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public Paciente getPaciente() {
		return Clinica.getInstance().getPaciente(this.nroHistoriaPaciente);
	}

	public double getTotal() {
		return this.total;
	}
	
	public HashMap<String, Prestacion> getPrestaciones() {
		return prestaciones;
	}

	/**
     *Se calcula el total a abonar por las prestaciones tomadas.<br>
     *<b>Post: </b> Se guarda en la variable total la suma de los subtotales de cada prestación. <br>
     */
	public void calculaTotal() {
		this.total = 0;
		for (Prestacion p : prestaciones.values()) {
			this.total += p.getSubtotal();
		}
	}
	
	/**
     *Se compara la factura actual con otra por su fecha y, en el caso de que coincidan, por su número de factura.<br>
     *@param o : parámetro de tipo Object que representa un objeto que será casteado para su comparación.
     *@return int con el valor que determina el resultado de la comparación.
     */
	@Override
	public int compareTo(Object o) {
		Factura f = (Factura) o;
		if(this.fecha.compareTo(f.getFecha()) > 0) {
			return 1;
		}
		else if (this.fecha.compareTo(f.getFecha()) < 0){
			return -1;
		}
		else {
			return (f.getNroFactura() - this.nroFactura);
		}
	}
	
	/**
     *Se imprime la factura mostrando en cada línea: tipo, valor, cantidad y subtotal de cada prestación.
	 * @return 
     */
	public String mostrarFactura() {
		String respuesta = "";
		respuesta+= ("Nombre: " + this.nombrePaciente 
							+"\nApellido: "+ this.apellidoPaciente+ "\nDni: " 
							+this.dniPaciente);
		for (Prestacion p : prestaciones.values()) {
			respuesta+="\n" + p;
		}
		respuesta+=("\n\t\t\t\t\t TOTAL:  " + this.total + "\n");
		return respuesta;
	}

	public static void setSiguienteNumero(int siguienteNumero) {
		Factura.siguienteNumero = siguienteNumero;
	}

	public static int getSiguienteNumero() {
		return siguienteNumero;
	}
	
	/**
	 * Método para agregar una nueva prestación a la factura.
	 * <b> Pre: </b> El parámetro prestacion debe ser distinto de null.
	 * El parámetro key no debe ser un String vacío<br>
     * <b> Post: </b> el atributo estático siguienteNumero se incrementa en 1.<br>
	 * <br>
	 * @param key: parametro de tipo String que representa el número de habitación o el nombre del médico.
	 * @param prestacion: parametro de tipo Prestacion que representa la prestación que se agregará.
	 * */
	public void addPrestacion(String key,Prestacion prestacion) {
		
		this.prestaciones.put(key, prestacion);
	}
	
	
}
