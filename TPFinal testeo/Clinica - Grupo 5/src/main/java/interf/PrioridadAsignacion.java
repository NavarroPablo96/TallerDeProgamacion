package interf;


import modelo.Paciente;

/**
 * interface con metodos para establecer la prioridad de asignacion usando el patron de soble dispatch con las clases, joven,ninio y mayor
 */
public interface PrioridadAsignacion
{
    abstract boolean establecerPriotodad(Paciente p);
    abstract boolean ninioPregunta();
    abstract boolean jovenPregunta();
    abstract boolean mayorPregunta();
}
