package vista;

import decorators.IMedico;
/**
 * @author Imanol Vázquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Agüero   
 *<br>
 *Interfaz de uso para la ventana de asociado
 */
public interface IVistaMedicos extends IVista{
	String getNombre();
	String getApellido();
	String getDni();
	String getDomicilio();
	String getCiudad();
	String getTelefono();
	String getMatricula();
	IMedico getMedico();
	void error(String mensaje);
	void actulizarLista();
	String getMensajeEspecialidad();
	String getMensajeContratacion();
	String getMensajeTitulo();
}
