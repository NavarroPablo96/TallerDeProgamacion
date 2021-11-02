package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

import modelo.Clinica;
import modelo.Factura;
import modelo.Paciente;
import persistencia.IPersistencia;
import persistencia.Persistencia;
import persistencia.PersistenciaGeneral;
import vista.IVistaMenu;
import vista.Ventana_Menu;
/**
 * @author Imanol Vázquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Agüero   
 *<br>
 *Controlador para la ventana del menu
 */
public class Controlador_Menu implements ActionListener,WindowListener{
	private IVistaMenu vista = null;
	private boolean isRecuperado = false;
	/**
     * Constructor sin parametros, al momento de crear el controlador crea la ventana<br>
     *
     */
	public Controlador_Menu() {
		this.vista = new Ventana_Menu();
		this.vista.addActionListener(this);
		this.vista.addWindowListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Medico")) {
			Controlador_Medicos controlador_medicos = new Controlador_Medicos();
			this.vista.cerrar();
		}else if(e.getActionCommand().equals("Facturacion")) {
			Controlador_Facturacion controlador_facturacion= new Controlador_Facturacion();
			this.vista.cerrar();
		}else if(e.getActionCommand().equals("Paciente")) {
			Controlador_Pacientes controlador_pacientes = new Controlador_Pacientes();
			this.vista.cerrar();
		}  	
	}


	@Override
	public void windowOpened(WindowEvent e) {
		File archivoFacturas = new File("Facturas.dat");
		File archivoPacientes = new File("Pacientes.dat");
		File archivoMedicos = new File("Medicos.dat");
		
		if(!this.isRecuperado) {
			if(archivoPacientes.exists()) {
				Clinica.getInstance().setPacientesRegistrados(PersistenciaGeneral.recuperaInformacionPacientes());
				Paciente.setSiguienteNumero(Clinica.getInstance().getPacientesRegistrados().size());				
			}
			if(archivoMedicos.exists())
				Clinica.getInstance().setMedicos(PersistenciaGeneral.recuperaInformacionMedicos());
			if(archivoFacturas.exists()) {
				Clinica.getInstance().setFacturas(PersistenciaGeneral.recuperaInformacionFacturas());
				Factura.setSiguienteNumero(Clinica.getInstance().getFacturas().size());				
			}
			this.isRecuperado=true;
		}
	}


	@Override
	public void windowClosing(WindowEvent e) {
//		PersistenciaGeneral.guardaInformacionPacientes(Clinica.getInstance().getPacientesRegistrados());
//		PersistenciaGeneral.guardaInformacionMedicos(Clinica.getInstance().getMedicos());
//		PersistenciaGeneral.guardaInformacionFacturas(Clinica.getInstance().getFacturas());
	}


	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
