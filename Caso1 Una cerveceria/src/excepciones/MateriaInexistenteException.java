package excepciones;

public class MateriaInexistenteException extends Exception
{
	public MateriaInexistenteException(String mensaje) {
		super(mensaje);
	}
}
