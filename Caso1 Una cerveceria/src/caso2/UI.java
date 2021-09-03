package caso2;

import java.util.Scanner;

public class UI {

	Negocio negocio = null;
	
	public UI() {
		this.negocio = new Negocio();
	}
	
	public void inicializaSurtidor() {
		
		Scanner sc = new Scanner(System.in);
		double carga = sc.nextDouble();
		
		negocio.InicializaSurtidor(carga);
		//aca puede ir un try catch
	}
	
	public void cargaSurtidor() {
		Scanner sc = new Scanner(System.in);
		double carga = sc.nextDouble();
		
		negocio.cargaSurtidor(carga);
		
		//se puede hacer un try catch
	
	}
	
	public void activaManguera1() {
		negocio.activaManguera1();
	}
	
	public void activaManguera2() {
		negocio.activaManguera2();
	}

	public void desactivaManguera1() {
		
	}
	
	public void desactivaManguera2() {
		
	}

	

}
