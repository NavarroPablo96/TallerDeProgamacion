package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import excepciones.MismoDniExcepcion;
import excepciones.NoExisteContratacionException;
import excepciones.NoExisteEspecialidadException;
import excepciones.NoExistePosgradoException;
import excepciones.NoHayContratacionException;
import excepciones.NoHayEspecialidadException;
import modelo.Clinica;
import interf.IMedico;
import factory.MedicoFactory;
import modelo.Paciente;
import factory.PacienteFactory;
import vista.Interfaz;
import persistencia.CargaYDescarga;

public class Controlador implements ActionListener{

	
	private Interfaz ventanaPrincipal;
	private CargaYDescarga persistencia = new CargaYDescarga();
	
	
	/**
	 * Constructor del controlador
	 */
	public Controlador(Interfaz ventana) {
		this.ventanaPrincipal = ventana;
		this.ventanaPrincipal.setControlador(this);
	
	}


	
	
	
	
	/**
	 * <b>PRE:<b> Los parametros nombre, apellido, DNI, domicilio, ciudad, telefono y tangoEtario deben ser distintos de null y estar compuestos por al menos un caracter.<br>
	 * 			  Ademas nombre, apellido, ciudad y rangoEtario solo deben tener caracteres alfabeticos y/o espacios. <br>
	 * 			  Por otra parte el DNI y el telefono deben estar comformados unicamente por numeros del 0 al 9.<br>
	 * @param nombre: Nombre del paciente.<br>
	 * @param apellido: Apellido del paciente.<br>
	 * @param DNI: DNI del paciente.<br>
	 * @param domicilio: domicilio del paciente.<br>
	 * @param ciudad: ciudad del paciente.<br>
	 * @param telefono: telefono del paciente
	 * @param rangoEtario: Rango etario del paciente (niño, joven, mayor).<br>
	 * @throws MismoDniExcepcion: En caso de ya existir un paciente registrado con el mismo DNI que el parametro 'DNI' se lanza la excepcion.<br>
	 * 
	 * Metodo que se encarga de llamar al modelo para que registre un paciente.<br>
	 */
	
	public void altaPaciente(String nombre, String apellido, String DNI, String domicilio, String ciudad, String telefono, String rangoEtario) throws MismoDniExcepcion {
		
		Paciente p = PacienteFactory.getPaciente(nombre,apellido,DNI,domicilio,ciudad,telefono,rangoEtario);
		
		Clinica.getInstance().altaPaciente(p);
		
		persistencia.guardarPacientes();
		
	}
	
	
	
	/**
	 *  <b>PRE:<b> Los parametros nombre, apellido, DNI, domicilio, ciudad, telefono, sueldoBase, especialidad, posgrado y contratacion deben ser distintos de null y estar compuestos por al menos un caracter.<br>
	 * 			  Ademas nombre, apellido, ciudad, especialidad, posgrado y contratacion solo deben tener caracteres alfabeticos y/o espacios. 
	 * 			  Por otra parte el DNI, el telefono y el sueldoBase deben estar comformados unicamente por numeros del 0 al 9.<br>
	 * 			  El sueldoBase debe ser un numero positivo.<br>
	 * @param nombre: Nombre del medico<br>
	 * @param apellido: Apellido del medico<br>
	 * @param DNI: DNI del medico<br>
	 * @param domicilio: Domicilio del medico<br>
	 * @param ciudad: Ciudad del medico<br>
	 * @param telefono: Telefono del medico<br>
	 * @param sueldoBase: Sueldo base del medico<br>
	 * @param especialidad: Especialidad del medico (clinico, cirujano o pediatra)<br>
	 * @param posgrado: Posgrado del medico (doctor o magister)<br>
	 * @param contratacion: Contratacion del medico (residente o permanente)<br>
	 * @throws MismoDniExcepcion: En caso de ya existir un medico registrado con el mismo DNI que el parametro 'DNI' se lanza la excepcion.<br>
	 * 
	 * Metodo que se encarga de llamar al modelo para que registre un medico.<br>
	 * 
	 */
	public void agregarMedico(String nombre, String apellido, String DNI, String domicilio, String ciudad, String telefono, double sueldoBase, String especialidad, String posgrado, String contratacion) throws MismoDniExcepcion  {
		IMedico m;
		try {
			m = MedicoFactory.getMedico(nombre, apellido, DNI, domicilio, ciudad, telefono, sueldoBase, especialidad, posgrado, contratacion);
			Clinica.getInstance().agregarMedico(m);
		} catch (NoHayEspecialidadException e) { //nunca se van a capturar ya que se ingresa a traves de radioButton
		} catch (NoHayContratacionException e) {
		} catch (NoExistePosgradoException e) {
		} catch (NoExisteContratacionException e) {
		} catch (NoExisteEspecialidadException e) {
		}
		
		persistencia.guardarMedicos();

	}



	
	
	/**
	 * <b>PRE:<b> La fecha inicial debe ser anterior a la fecha final. Los años deben ser positivos, los meses entre el rango [1;12] y los dias deben ser validos segun el mes [1;29] , [1;30] o [1;31]
	 * @param diaI: Dia de la fecha inicial
	 * @param mesI: Mes de la fecha inicial
	 * @param anioI: Año de la fecha inicial
	 * @param diaF: Dia de la fecha final
	 * @param mesF: Mes de la fecha final
	 * @param anioF: Año de la fecha final
	 * 
	 * Metodo que manda un mensaje al modelo para que muestre todas las facturas comprendidas entre el rango de fechas pasado por parametro.
	 */
	public void muestraFacturaRangoFechas (int diaI, int mesI, int anioI,int diaF, int mesF,int anioF){
		GregorianCalendar desde, hasta;
		desde= new GregorianCalendar(anioI,mesI,diaI);
		hasta= new GregorianCalendar(anioF,mesF,diaF);
		Clinica.getInstance().muestraFacturaRangoFechas(desde, hasta);
	}
	
	
	
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
				
	}



	
	
	
	
}
