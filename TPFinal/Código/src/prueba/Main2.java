package prueba;

import controlador.Controlador_Menu;
import modelo.Compartida;
import modelo.Habitacion;
import modelo.Privada;
import modelo.TerapiaIntensiva;

//USEN ESTE MAIN PARA TESTEAR LAS VENTANAS Y ESAS COSAS

public class Main2 {

	public static void main(String[] args) {
		
		//Preformateo de las diferentes habitaciones.
		Habitacion h1 = new Privada("55");
		Habitacion h2 = new Compartida("10");
		Habitacion h3 = new TerapiaIntensiva("12");
		
		
		Controlador_Menu contralorMenu = new Controlador_Menu();
	}

}
