package modelo;


import excepciones.PacienteNoEncontradoExcepcion;

public abstract class Sala {
    public Sala() {
        super();
    }
    public abstract void AgregaPaciente(Paciente p);
    
    public abstract void QuitaPaciente(String dni) throws PacienteNoEncontradoExcepcion;

}