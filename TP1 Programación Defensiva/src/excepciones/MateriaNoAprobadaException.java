package excepciones;

public class MateriaNoAprobadaException extends MateriaInexistenteException
{
	public MateriaNoAprobadaException(String mensaje) {
		super(mensaje);
	}
}
