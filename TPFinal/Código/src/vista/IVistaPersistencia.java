package vista;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.HashMap;

public interface IVistaPersistencia {
	
	void setActionListener(ActionListener actionListener);
	String getMesajePersistencia();
	void habilitaBotonRecuperar();
}
