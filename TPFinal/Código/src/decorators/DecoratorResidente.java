package decorators;
/**
 * @author Imanol V�zquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Ag�ero   
 *<br>
 *Clase decoradora que representa la contrataci�n temporal/residente
 */
public class DecoratorResidente extends DecoratorMedico {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor con un parametro para setear el medico a decorar
	 * <br>
	 * @param encapsulado : parametro de tipo IMedico que representa el medico a decorar
	 */
	public DecoratorResidente(IMedico encapsulado) {
		super(encapsulado);

	}
	/**
	 * Devuelve el honorario del m�dico con un aumento del 5% por su contrataci�n temporal
	 * @return el honorario del medico m�s el 5% 
	 */
	@Override
	public double getHonorario() {
		return this.encapsulado.getHonorario() * 1.05;
	}
	
	public String toString() {
		return encapsulado.toString();// + 
//				"Contratacion: Residente";
	}
}
