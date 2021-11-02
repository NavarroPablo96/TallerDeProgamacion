package controlador;

//import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Clinica;
import modelo.Paciente;
import modelo.Factura;
import persistencia.PersistenciaGeneral;
import vista.IVistaPersistencia;
import vista.Ventana_Persistencia;

/**
 * @author Ivo Vucetic,Juan Manuel Mujica,Pablo Navarro,Sebastián Agüero.<br>
 *Controlador para la ventana de persistencia. Implementa ActionListener.
 */
//public class Controlador implements ActionListener {
	
//	private IVistaPersistencia vista= null;
//	/**
//	 * Constructor sin parámetros, al momento de crear el controlador se crea la ventana.<br>
//	 */
//	public Controlador() {
//		this.vista = new Ventana_Persistencia();
//		this.vista.setActionListener(this);
//	}
//
//	/**
//	 * Método actionPerformed que se encarga de escuchar los eventos en la vista, y actua segun el evento recibido <br>
//	 * @param e: Parámetro de tipo ActionEvent que representa el evento recibido.
//	 */
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		if(e.getActionCommand().equals("Guardar")) {
//			if(this.vista.getMesajePersistencia().equals("Pacientes")) {
//				PersistenciaGeneral.guardaInformacionPacientes(Clinica.getInstance().getPacientesRegistrados());
//			} else if(this.vista.getMesajePersistencia().equals("Medicos")) {
//				PersistenciaGeneral.guardaInformacionMedicos(Clinica.getInstance().getMedicos());
//			} else if(this.vista.getMesajePersistencia().equals("Facturas")){
//				PersistenciaGeneral.guardaInformacionFacturas(Clinica.getInstance().getFacturas());
//			}
//			this.vista.habilitaBotonRecuperar();
//		}
//		else if(e.getActionCommand().equals("Recuperar")){
//				if(this.vista.getMesajePersistencia().equals("Pacientes")) {
//					Clinica.getInstance().setPacientesRegistrados(PersistenciaGeneral.recuperaInformacionPacientes());
//					Paciente.setSiguienteNumero(Clinica.getInstance().getPacientesRegistrados().size());
//			//Mostramos dspues de recuperar		
////					for(Paciente i: PersistenciaGeneral.recuperaInformacionPacientes().values()) {
////						System.out.println("Datos personales \n"+ i.toString()+ "\n"+ Paciente.getSiguienteNumero());
////					}
//			//
//				} else if(this.vista.getMesajePersistencia().equals("Medicos")) {
//					Clinica.getInstance().setMedicos(PersistenciaGeneral.recuperaInformacionMedicos());
//			//Mostramos despues de recuperar
////					for(IMedico i:PersistenciaGeneral.recuperaInformacionMedicos().values()) {
////						System.out.println("\nDatos personales del medico \n"+ i.toString()+"\n Consultas:\n");
////						for(ConsultaMedica j: i.getConsultas()) {
////							System.out.println(j.toString());
////						}
////					}
//			//
//				} else if(this.vista.getMesajePersistencia().equals("Facturas")){
//					Clinica.getInstance().setFacturas(PersistenciaGeneral.recuperaInformacionFacturas());
//					Factura.setSiguienteNumero(Clinica.getInstance().getFacturas().size());
//			//Mostramos despues de recuperar
////					for(Factura i:Clinica.getInstance().getFacturas()) {
////						i.mostrarFactura();
////					}
////					System.out.println(Factura.getSiguienteNumero());
//			//
//				}
//		}
//	}
//	
//}
