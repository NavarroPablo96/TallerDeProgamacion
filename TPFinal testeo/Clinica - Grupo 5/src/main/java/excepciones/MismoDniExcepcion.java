package excepciones;

import modelo.Paciente;

public class MismoDniExcepcion extends Exception {
    String dni;
    @SuppressWarnings("oracle.jdeveloper.java.insufficient-catch-block")
    public MismoDniExcepcion(String dni) {
        super();
            this.dni=dni;
    }

    public String getDni() {
        return dni;
    }
}
