package modelo;

import java.util.ArrayList;

import decorators.IMedico;
/**
 * @author Imanol V�zquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Ag�ero   
 *<br>
 *Clase que representa a los medicos se extiende de la clase Persona e implementa la interfaz Imedico
 */
public class Medico extends Persona implements IMedico{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long nroMatricula;
	private static double honorarioBase = 1200;
	private ArrayList<ConsultaMedica> consultas = new ArrayList<ConsultaMedica>();
	/**
	 * Constructor con siete parametros para setear el medico
	 * <br>
	 * @param dni: parametro de tipo String que representa el dni del medico 
	 * @param nombre: parametro de tipo String que representa el nombre del medico 
	 * @param apellido: parametro de tipo String que representa el apellido del medico
	 * @param domicilio: parametro de tipo String que representa la domicilio donde reside el medico
	 * @param ciudad: parametro de tipo String que representa la ciudad donde reside el medico
	 * @param telefono: parametro de tipo String que representa el telefono del medico
	 * @param nroMatricula: parametro de tipo long que representa el numero de Matricula del medico

	 */
	public Medico(String dni, String nombre, String apellido, String domicilio, String ciudad, String telefono,long nroMatricula) {
		super(dni, nombre, apellido, domicilio, ciudad, telefono);
		this.nroMatricula = nroMatricula;
		Clinica.getInstance().addMedico(this);
	}
	
	@Override
	public long getNroMatricula() {
		return nroMatricula;
	}

	@Override
	public double getHonorario() {
		return honorarioBase;
	}
	
	public void agregarConsulta(ConsultaMedica consulta) {
		this.consultas.add(consulta);
	}
	
	public static void setHonorarioBase(double h) {
		Medico.honorarioBase = h;
	}

	public ArrayList<ConsultaMedica> getConsultas() {
		return consultas;
	}
	
	public String toString() {
		return "Matricula: " + this.getNroMatricula()+
				"\nNombre y apellido: " + this.getNombre() +" "+ this.getApellido()+ 
				"\nDni: " + this.getDni()+
				"\nCiudad y domicilio: " + this.getCiudad() + this.getDomicilio()+
				"\nTelefono:" + this.getTelefono() + "\n";
	}	
	
	
	
}
