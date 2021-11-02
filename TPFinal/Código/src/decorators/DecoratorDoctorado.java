package decorators;
/**
 * @author Imanol V�zquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Ag�ero   
 *<br>
 *Clase decoradora que representa la posgrado de Doctorado
 */
public class DecoratorDoctorado extends DecoratorMedico {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor con un parametro para setear el medico a decorar
	 * <br>
	 * @param encapsulado : parametro de tipo IMedico que representa el medico a decorar
	 */
	public DecoratorDoctorado(IMedico encapsulado) {
		super(encapsulado);

	}
	/**
	 * Devuelve el honorario del m�dico con un aumento del 10% por su posgrado de Doctorado
	 * @return el honorario del medico m�s el 10% 
	 */
	@Override
	public double getHonorario() {
		return this.encapsulado.getHonorario() * 1.1;
	}
	
	public String toString() {
		return encapsulado.toString(); //+ 
//				"Posgrado: Doctorado";
	}
}
