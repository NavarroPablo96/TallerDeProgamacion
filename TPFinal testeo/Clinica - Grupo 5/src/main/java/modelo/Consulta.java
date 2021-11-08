package modelo;

import java.util.GregorianCalendar;

public class Consulta {
    GregorianCalendar fecha;
    Medico medico;
    Paciente paciente;

    public Consulta(GregorianCalendar fecha, Medico medico, Paciente paciente) {
        this.fecha = fecha;
        this.medico = medico;
        this.paciente = paciente;
    }
}
