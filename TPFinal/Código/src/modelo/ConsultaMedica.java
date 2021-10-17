package modelo;

import decorators.IMedico;

/**
 * @author Imanol V�zquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Ag�ero   
 *<br>
 *Clase que representa una consulta m�dica realizada por un paciente, se extiende de la clase Prestaci�n.
 */
public class ConsultaMedica extends Prestacion {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * @aggregation shared
     */
    private long nroMatricula;
	private static double valorConsulta = 800;
	private static double porcentajeExtra = 90;

	/**
     * Constructor con dos parametros para setear la cantidad de consultas y el m�dico que las atendi�.<br>
     * <b> Pre: </b> El par�metro cantidad debe ser entero positivo. El m�dico debe existir <br>
     * @param cantidad : parametro de tipo int que representa la cantidad de consultas realizadas por el medico.
     * @param medico : parametro de tipo IMedico que representa el m�dico que atendi� la consulta.
     */
	public ConsultaMedica(int cantidad, IMedico medico) {
		super(cantidad);
		this.nroMatricula = medico.getNroMatricula();
		super.subtotal = ConsultaMedica.valorConsulta * cantidad + medico.getHonorario() * ConsultaMedica.porcentajeExtra;
		Clinica.getInstance().getMedico(this.nroMatricula).agregarConsulta(this);
	}
	
	public IMedico getMedico() {
		return Clinica.getInstance().getMedico(this.nroMatricula);
	}

	public static void setValorConsulta(double valor) {
		ConsultaMedica.valorConsulta = valor;
	}
	
	public static void setPorcentajeExtra(double porcentaje) {
		ConsultaMedica.porcentajeExtra = 1 + porcentaje/100;
	}
	
	@Override
	public String toString() {
		return this.getMedico().getNombre() + " \t\t " + ConsultaMedica.valorConsulta + " \t\t " + super.getCantidad() + " \t\t " + super.subtotal + "\n";
	}

	@Override
	public long getPrestacion() {
		return this.getMedico().getNroMatricula();
	}

}
