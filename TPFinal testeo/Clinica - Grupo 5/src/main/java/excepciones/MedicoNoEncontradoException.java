package excepciones;

public class MedicoNoEncontradoException extends Exception
{
	String dni;
    @SuppressWarnings("oracle.jdeveloper.java.insufficient-catch-block")
    public MedicoNoEncontradoException(String message,String dni)
    {   
        super(message);
        this.dni= dni;
    }

    public String getDato() {
        return dni;
    }
}
