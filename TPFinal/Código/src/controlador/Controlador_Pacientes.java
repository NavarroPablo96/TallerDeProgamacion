package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

import excepciones.PacienteYaExisteException;
import modelo.Clinica;
import modelo.Joven;
import modelo.Mayor;
import modelo.Ninio;
import modelo.Paciente;
import persistencia.PersistenciaGeneral;
import vista.IVista;
import vista.IVistaPaciente;
import vista.Ventana_Paciente;

/**
 * @author Ivo Vucetic,Juan Manuel Mujica,Pablo Navarro,Sebasti�n Ag�ero  
 *<br>
 *Controlador para la ventana de Pacientes.
 */
public class Controlador_Pacientes implements ActionListener, WindowListener{
	private IVistaPaciente vista = null;
	
	/**
     * Constructor sin parametros, al momento de crear el controlador crea la ventana<br>
     *
     */
	public Controlador_Pacientes()
	{
		this.vista = new Ventana_Paciente();
		this.vista.addActionListener(this);
		this.vista.addWindowListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Agregar")) {
			try {
				if(this.vista.getMensajeRangoEtario().equals("Ninio")) {
					Clinica.getInstance().addPaciente(new Ninio(this.vista.getDni(),this.vista.getNombre(),this.vista.getApellido(),this.vista.getDomicilio(),this.vista.getCiudad(),this.vista.getTelefono()));
				} else if(this.vista.getMensajeRangoEtario().equals("Joven")) {
					Clinica.getInstance().addPaciente(new Joven(this.vista.getDni(),this.vista.getNombre(),this.vista.getApellido(),this.vista.getDomicilio(),this.vista.getCiudad(),this.vista.getTelefono()));
				} else if(this.vista.getMensajeRangoEtario().equals("Mayor")) {
					Clinica.getInstance().addPaciente(new Mayor(this.vista.getDni(),this.vista.getNombre(),this.vista.getApellido(),this.vista.getDomicilio(),this.vista.getCiudad(),this.vista.getTelefono()));
				}
			} catch (PacienteYaExisteException e1) {
				
				Paciente.decrementaSiguienteNum();
				this.vista.error(e1.getMessage());
			}
			this.vista.actulizarLista();
		}else if(e.getActionCommand().equals("Eliminar")) {
			Clinica.getInstance().removePaciente(this.vista.getPaciente());
			this.vista.actulizarLista();
		}
		
	}
	
	
	@Override
	public void windowOpened(WindowEvent e) {
	}
	
	/**
	 *
	 * Metodo que se encarga de generar un archivo Pacientes.dat con todos los pacientes luego de cerrar la ventana.<br>
	 *<b>Post:<b>Se genera un archivo Pacientes.dat, con los pacientes ingresados o un archivo vacio en caso de no haberse cargado datos.
	 */
	@Override
	public void windowClosing(WindowEvent e) {
		PersistenciaGeneral.guardaInformacionPacientes(Clinica.getInstance().getPacientesRegistrados());
		Controlador_Menu controlador_menu = new Controlador_Menu();
		
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
