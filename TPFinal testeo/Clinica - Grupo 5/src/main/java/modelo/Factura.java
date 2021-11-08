package modelo;

import interf.IMedico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Factura implements Serializable {

	private static int cantFacturas = 0;
	private int numFactura;
	GregorianCalendar fecha;
	Paciente paciente;

    /**
     * @aggregation shared
     */
    ArrayList<Prestacion> prestaciones = new ArrayList<>();

	public Factura(GregorianCalendar fecha, Paciente paciente) {
		this.fecha = fecha;
		this.paciente = paciente;
		Factura.cantFacturas++;
		this.numFactura = Factura.cantFacturas;
	}

	public Factura(GregorianCalendar fecha, Paciente paciente, ArrayList<Prestacion> prestaciones) {
		this.fecha = fecha;
		this.paciente = paciente;
		this.prestaciones = prestaciones;
		Factura.cantFacturas++;
		this.numFactura = Factura.cantFacturas;
	}

	public ArrayList<Prestacion> getPrestaciones() {
		return prestaciones;
	}

	public void setPrestaciones(ArrayList<Prestacion> prestaciones) {
		this.prestaciones = prestaciones;
	}

	public int getNumFactura() {
		return numFactura;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	
	
	
	/**
	 * <b>PRE:</b> Objeto Imedico distinto de null <br>
	 * Muestra todas las prestacion de un medico de una factura determinada<br>.
	 * @param medico medico del que se quieren mostrar sus prestaciones
	 * @return el total del monto a pagar de la factura
	 */
	public double muestraPrestacionMedico(IMedico medico)
	{ // subTotal tiene que pasar por referencia
		int i = 0;
		int n = this.prestaciones.size();
		double subTotal,totalFactura=0;
		String nombreMedico = medico.getClavePrimariaString(); //tambien podria ser medico.getNombre();
		
		while (i < n) {

			if ( this.prestaciones.get(i).getClavePrimariaString().equals(nombreMedico) )   // el medico atendio al paciente
			{ 
				subTotal = this.prestaciones.get(i).getSubTotal();
				totalFactura+=subTotal; 
				System.out.printf("%22s %17.2f %25d   %35s              $ %8.2f %n",this.paciente.getNombre(),
						this.prestaciones.get(i).getValorUnitarioPrestacion() * 0.8,this.prestaciones.get(i).getCantidad()
						,this.muestraFecha(),subTotal);
			}
			i++;
		}
		return totalFactura;
	}


	/**
	 * Metodo que genera un string con todos los datos de la factura<br>.
	 * @return String con los datos de la factura
	 */
	public String muestraFactura() {
		StringBuilder sb = new StringBuilder();
		sb.append("Numero de factura: " + this.numFactura + "\nFecha: " + this.muestraFecha() + "\nPaciente: "
				+ this.paciente.getNombre()
				+ "\n\n------------------------------------------ Listado de prestaciones ----------------------------------\n"
				+ "       Prestacion              Valor           Cantidad               Subtotal    \n");



		for (int i = 0; i < this.prestaciones.size(); i++) {
			sb.append(this.prestaciones.get(i).mostrarPrestacion());
		}

		return sb.toString();

	}


	public String muestraFecha() {
		return this.fecha.get(Calendar.DATE) + "/" + this.fecha.get(Calendar.MONTH) + "/"
				+ this.fecha.get(Calendar.YEAR);
	}

	public double totalFactura() {

		double total = 0;
		for (int i = 0; i < this.prestaciones.size(); i++) {
			total += this.prestaciones.get(i).getSubTotal();
		}
		return total;
	}

}
