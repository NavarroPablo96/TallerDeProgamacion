package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import vista.IVistaPersistencia;
import vista.Ventana_Persistencia;

public class Controlador implements ActionListener {
	
	private IVistaPersistencia vista= null;
	
	public Controlador() {
		this.vista = new Ventana_Persistencia();
		
		this.vista.setActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Guardar")) {
			if(this.vista.getMesajePersistencia().equals("Pacientes")) {
				
			} else if(this.vista.getMesajePersistencia().equals("Medicos")) {
				
			} else {
				
			}
		}	else {
				if(this.vista.getMesajePersistencia().equals("Pacientes")) {
					
				} else if(this.vista.getMesajePersistencia().equals("Medicos")) {
					
				} else {
					
				}
			}
		
	}
	
}
