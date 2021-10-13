package modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

/**
 * @author Imanol V�zquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Ag�ero   
 *<br>
 *Clase que representa una factura realizada a un paciente ya atendido.
 */
public class Factura implements Comparable{
	private static int siguienteNumero = 0;
	private int nroFactura;
	private Calendar fecha = new GregorianCalendar();

    /**
     * @aggregation shared
     */
    private Paciente paciente;
	
	private double total;private HashMap<String, Prestacion> prestaciones = new HashMap<String, Prestacion>();
	
	/**
     * Constructor con dos parametros para setear el paciente al que se le adjudica la factura y su lista de prestaciones.<br>
     * <b> Pre: </b> El par�metro paciente debe ser distinto de null.<br>
     * <b> Post: </b> el atributo est�tico siguienteNumero se incrementa en 1.<br>
     * @param paciente : par�metro de tipo Paciente que representa al paciente al que se le realiza la facturaci�n.
     * @param prestaciones : par�metro de tipo HashMap que representa un listado de las prestaciones pertenecientes al paciente.
     */
	public Factura(Paciente paciente, HashMap<String, Prestacion> prestaciones) {
		Factura.siguienteNumero++;
		this.nroFactura = Factura.siguienteNumero;
		this.fecha = fecha.getInstance();
		this.paciente = paciente;
		this.prestaciones = prestaciones;
		this.calculaTotal(prestaciones);
	}

	public int getNroFactura() {
		return nroFactura;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public double getTotal() {
		return this.total;
	}
	
	public HashMap<String, Prestacion> getPrestaciones() {
		return prestaciones;
	}

	/**
     *Se calcula el total a abonar por las prestaciones tomadas.<br>
     *<b>Post: </b> Se guarda en la variable total la suma de los subtotales de cada prestaci�n. <br>
     *@param prestaciones : par�metro de tipo HashMap que representa un listado de las prestaciones efectuadas por el paciente.
     */
	private void calculaTotal(HashMap<String, Prestacion> prestaciones) {
		this.total = 0;
		for (Prestacion p : prestaciones.values()) {
			this.total += p.getSubtotal();
		}
	}
	
	/**
     *Se compara la factura actual con otra por su fecha y, en el caso de que coincidan, por su n�mero de factura.<br>
     *@param o : par�metro de tipo Object que representa un objeto que ser� casteado para su comparaci�n.
     *@return int con el valor que determina el resultado de la comparaci�n.
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
     *Se imprime la factura mostrando en cada l�nea: tipo, valor, cantidad y subtotal de cada prestaci�n.
     */
	public void mostrarFactura() {
		System.out.println("Factura: \n"
		+ "prestacion \t valor \t\t cantidad \t subtotal\n");
		for (Prestacion p : prestaciones.values()) {
			System.out.println(p);
		}
		System.out.println("\t\t\t\t\t TOTAL:  " + this.total);
	}
	
}
