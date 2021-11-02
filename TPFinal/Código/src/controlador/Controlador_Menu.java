package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import modelo.Clinica;
import persistencia.IPersistencia;
import persistencia.Persistencia;
import vista.IVistaMenu;
import vista.Ventana_Menu;
/**
 * @author Imanol Vázquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Agüero   
 *<br>
 *Controlador para la ventana del menu
 */
public class Controlador_Menu implements ActionListener,WindowListener{
	private IVistaMenu vista = null;
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
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowClosing(WindowEvent e) {
			
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
