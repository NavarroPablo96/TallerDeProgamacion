package vista;

import java.awt.event.ActionListener;
/**
 * @author Ivo Vucetic,Juan Manuel Mujica,Pablo Navarro,Sebastián Agüero.<br>
 *Interfaz de uso para la ventana de persistencia.
 */
public interface IVistaPersistencia {
	
	void setActionListener(ActionListener actionListener);
	String getMesajePersistencia();
	void habilitaBotonRecuperar();
}
