package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import modelo.Clinica;
import modelo.ConsultaMedica;
import modelo.Factura;
import modelo.Internacion;
import persistencia.IPersistencia;
import persistencia.Persistencia;
import vista.IVista;
import vista.IVistaFacturacion;
import vista.Ventana_Facturacion;
/**
 * @author Imanol Vázquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Agüero   
 *<br>
 *Controlador para la ventana de facturacion
 */
public class Controlador_Facturacion implements ActionListener,WindowListener{

	private IVistaFacturacion vista = null;
	private boolean isnuevafactura;
	/**
     * Constructor sin parametros, al momento de crear el controlador crea la ventana<br>
     *
     */
	public Controlador_Facturacion()
	{
		this.vista = new Ventana_Facturacion();
		this.vista.addActionListener(this);
		this.vista.addWindowListener(this);
		this.isnuevafactura=true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Factura factura;
		if(e.getActionCommand().equals("Agregar habitacion")) {
			Internacion internacion= new Internacion(this.vista.getCantDias(),this.vista.getHabitacion());
			if(isnuevafactura) { 
				factura = new Factura(this.vista.getPaciente());
				Clinica.getInstance().addFactura(factura);
				this.isnuevafactura = false;
				this.vista.setEnablebtnFacturar(true);
			}else {
				factura = Clinica.getInstance().getUltimaFactura();
			}
			factura.addPrestacion(internacion.getHabitacion().getNumeroHabitacion(), internacion);


		}else if(e.getActionCommand().equals("Agregar consultas")) {
			
			ConsultaMedica consultamedica= new ConsultaMedica(this.vista.getCantConsultas(),this.vista.getMedico());
			if(isnuevafactura) { 
				factura = new Factura(this.vista.getPaciente());
				Clinica.getInstance().addFactura(factura);
				this.isnuevafactura = false;
				this.vista.setEnablebtnFacturar(true);
			}else {
				factura = Clinica.getInstance().getUltimaFactura();
			}
			factura.addPrestacion(consultamedica.getMedico().getNombre(), consultamedica);
		}else if(e.getActionCommand().equals("Facturar")) {
			factura = Clinica.getInstance().getUltimaFactura();
			factura.calculaTotal();
			this.isnuevafactura = true;
			this.vista.setEnablebtnFacturar(false);
		}else if(e.getActionCommand().equals("Borrar ultima")) {
			Clinica.getInstance().borrarUltimaFactura();
		}else if(e.getActionCommand().equals("Borrar todo")) {
			Clinica.getInstance().borrarFacturas();
		}
		
		this.vista.actualizar();
	}

	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
		if(Clinica.getInstance().getUltimaFactura()!=null && Clinica.getInstance().getUltimaFactura().getTotal()==0) {
			Clinica.getInstance().borrarUltimaFactura();
		}
		Controlador_Menu controlador_menu = new Controlador_Menu();
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}

}
