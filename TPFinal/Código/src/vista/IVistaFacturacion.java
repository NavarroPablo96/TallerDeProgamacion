package vista;

import decorators.IMedico;
import modelo.Habitacion;
import modelo.Medico;
import modelo.Paciente;
/**
 * @author Imanol V�zquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Ag�ero   
 *<br>
 *Interfaz de uso para la ventana de facturacion
 */
public interface IVistaFacturacion extends IVista {
	Habitacion getHabitacion();
	int getCantDias();
	Paciente getPaciente();
	public int getCantConsultas();
	public IMedico getMedico();
	public void setEnablebtnFacturar(boolean bool);
	void actualizar();
}