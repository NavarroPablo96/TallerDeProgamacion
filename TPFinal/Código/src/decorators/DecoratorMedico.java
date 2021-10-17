package decorators;

import java.io.Serializable;
import java.util.ArrayList;

import modelo.ConsultaMedica;
import modelo.Medico;

/**
 * @author Imanol Vázquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Agüero   
 *<br>
 *Se utiliza el Patrón Decorator.
 *Clase abstacta padre de todos los decoradores de medico
 */
public abstract class DecoratorMedico implements IMedico,Serializable{

    /**
     * @aggregation shared
     */
    protected IMedico encapsulado;
	/**
	 * Constructor con un parametro para setear el medico a decorar
	 * <br>
	 * @param encapsulado : parametro de tipo IMedico que representa el medico a decorar
	 */
	public DecoratorMedico(IMedico encapsulado) {
		this.encapsulado = encapsulado;
	}
	
	@Override
	public long getNroMatricula() {
		return this.encapsulado.getNroMatricula();
	}
	
	@Override
	public String getNombre() {
		return this.encapsulado.getNombre();
	}
	
	public String getDni() {
		return this.encapsulado.getDni();
	}

	public String getApellido() {
		return this.encapsulado.getApellido();
	}

	public String getDomicilio() {
		return this.encapsulado.getDomicilio();
	}

	public String getCiudad() {
		return this.encapsulado.getCiudad();
	}

	public String getTelefono() {
		return this.encapsulado.getTelefono();
	}
	
	public ArrayList<ConsultaMedica> getConsultas(){
		return this.encapsulado.getConsultas();
	}
	
	public void agregarConsulta(ConsultaMedica consulta) {
		this.encapsulado.agregarConsulta(consulta);
	}
}
