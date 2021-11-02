package vista;

import modelo.Paciente;
/**
 * @author Imanol Vázquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Agüero   
 *<br>
 *Interfaz de uso para la ventana de asociado
 */
public interface IVistaPaciente extends IVista{
	String getNombre();
	String getApellido();
	String getDni();
	String getDomicilio();
	String getCiudad();
	String getTelefono();
	Paciente getPaciente();
	void error(String mensaje);
	void actulizarLista();
	String getMensajeRangoEtario();
}
