package decorators;
/**
 * @author Imanol V�zquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Ag�ero   
 *<br>
 *Se utiliza el Patr�n Decorator.
 *Clase abstacta padre de todos los decoradores de medico
 */
public abstract class DecoratorMedico implements IMedico{

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
	
}
