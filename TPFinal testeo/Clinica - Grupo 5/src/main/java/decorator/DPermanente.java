package decorator;


import interf.IMedico;

/**
 * @author Agustin <br>
 *         Clase que se extiende de "DecoratorContratacion" que permite que su
 *         atributo encapsulado de tipo "IMedico" tenga una contratacion de tipo
 *         plantel permanente
 *
 */
public class DPermanente extends DecoratorContratacion
{
	private static final long serialVersionUID = 789999455;

	public DPermanente(IMedico encapsulado)
	{
		super(encapsulado);
	}

	
	/**
	 * Metodo que devuelve en un double, el honorario de su atributo encapsulado,
	 * incrementado en un 10%
	 */
	@Override
	public double getHonorarioBasico()
	{
		double sueldo = super.getEncapsulado().getHonorarioBasico();
		sueldo += sueldo * 0.1;
		return sueldo;
	}

	@Override
	public String toString()
	{
		return super.getEncapsulado().toString() + ", contratacion=plantel permanente]";
	}
	
}
