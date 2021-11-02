package vista;

import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
/**
 * @author Imanol Vázquez,Juan Manuel Mujica,Francisco Stimmler,Sebastian Agüero   
 *<br>
 *Interfaz de uso general de todas las ventanas
 */
public interface IVista {
	void addActionListener(ActionListener listener);
	void addWindowListener(WindowListener windowListener);
}
