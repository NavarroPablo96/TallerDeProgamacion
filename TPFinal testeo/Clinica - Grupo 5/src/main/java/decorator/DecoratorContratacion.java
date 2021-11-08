package decorator;

import interf.IMedico;

import java.io.Serializable;

/**
 * @author Agustin <br>
 *         Clase abstracta decoradora que permite agregarle un tipo de
 *         contratacion a un medico. Contiene un atributo "encapsulado" de tipo
 *         IMedico, que va a ser el medico a decorar. Implementa la interface
 *         IMedico.
 */
public abstract class DecoratorContratacion implements IMedico, Serializable
{
    /**
     * @aggregation composite
     */
	private static final long serialVersionUID = 1877777455;
    private IMedico encapsulado;

	public IMedico getEncapsulado() {
		return encapsulado;
	}

	public void setEncapsulado(IMedico encapsulado) {
		this.encapsulado = encapsulado;
	}

	public DecoratorContratacion(IMedico encapsulado)
	{
		this.encapsulado = encapsulado;
	}
	
	@Override
	public String getPrestacion()
	{
		return "Nombre del medico: " + this.getNombre();
	}
	
	
	/**
	 * Devuelve el honorario final del medico encapsulado (con todos sus respectivos
	 * aumentos) incrementado en un 20%<br>
	 */
	@Override
	public double getValorUnitarioPrestacion()
	{
		double honorario = this.getHonorarioBasico();
		return honorario * INCREMENTO; 
	}

	@Override
	public String getClavePrimariaString()
	{
		return this.getNombre();
	}

	@Override
	public String getNombre()
	{
		return this.encapsulado.getNombre();
	}

	@Override
	public String getDni()
	{
		return encapsulado.getDni();
	}
}
