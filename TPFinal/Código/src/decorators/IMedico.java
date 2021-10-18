package decorators;

import java.util.ArrayList;

import modelo.ConsultaMedica;

/**
 * @author Imanol V�zquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Ag�ero   
 *<br>
 *Interfaz que representa los medicos decorados
 */
public interface IMedico{

long getNroMatricula();
double getHonorario();
String getNombre();
String getDni();
String getApellido();
String getDomicilio();
String getCiudad();
String getTelefono();
ArrayList<ConsultaMedica> getConsultas();
void agregarConsulta(ConsultaMedica consulta);
String toString();
}
