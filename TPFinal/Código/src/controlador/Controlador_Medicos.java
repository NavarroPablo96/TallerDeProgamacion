package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

import decorators.IMedico;
import excepciones.MedicoYaExisteException;
import excepciones.PacienteYaExisteException;
import modelo.Clinica;
import modelo.Joven;
import modelo.Mayor;
import modelo.Medico;
import modelo.MedicoFactory;
import modelo.Niño;
import modelo.Paciente;
import persistencia.PersistenciaGeneral;
import vista.IVista;
import vista.IVistaMedicos;
import vista.IVistaPaciente;
import vista.Ventana_Medicos;
import vista.Ventana_Paciente;

/**
 * @author Imanol Vázquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Agüero   
 *<br>
 *Controlador para la ventana de asociados
 */
public class Controlador_Medicos implements ActionListener, WindowListener{
	private IVistaMedicos vista = null;
	/**
     * Constructor sin parametros, al momento de crear el controlador crea la ventana<br>
     *
     */
	public Controlador_Medicos()
	{
		this.vista = new Ventana_Medicos();
		this.vista.addActionListener(this);
		this.vista.addWindowListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Agregar")) {
			try {
				IMedico medico = MedicoFactory.getMedico(this.vista.getMensajeEspecialidad(),this.vista.getMensajeContratacion(),this.vista.getMensajeTitulo(),this.vista.getDni(),this.vista.getNombre(),this.vista.getApellido(),this.vista.getDomicilio(),this.vista.getCiudad(),this.vista.getTelefono(),Long.parseLong(this.vista.getMatricula()));
				Clinica.getInstance().addMedico(medico);
			} catch (MedicoYaExisteException e1) {
			
				this.vista.error(e1.getMessage());
			}
			this.vista.actulizarLista();

		}else if(e.getActionCommand().equals("Eliminar")) {
			Clinica.getInstance().removeMedico(this.vista.getMedico());
			this.vista.actulizarLista();
		}
	}
	
	
	@Override
	public void windowOpened(WindowEvent e) {	
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		PersistenciaGeneral.guardaInformacionMedicos(Clinica.getInstance().getMedicos());
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
