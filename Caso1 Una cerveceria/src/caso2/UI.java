package caso2;

import java.util.Scanner;

import excepciones.NoExisteSurtidorException;
import excepciones.SurtidorVacioException;

/**
 * @author Agüero Sebastián, Mujica Juan Manuel, Navarro Pablo, Vucetic Ivo
 *
 */
public class UI {

	Negocio negocio = null;
	
	public UI() {
		this.negocio = new Negocio();
	}
	
	public void inicializaSurtidor() {
		
		Scanner sc = new Scanner(System.in);
		double carga = sc.nextDouble();
		
		try {
			this.negocio.InicializaSurtidor(carga);
		} catch (NoExisteSurtidorException e) {
			e.getMessage();
		}
		System.out.println("Se inicializo el surtidor correctamente");
	}
	
	public void cargaSurtidor() {
		Scanner sc = new Scanner(System.in);
		double carga = sc.nextDouble();
		
		this.negocio.cargaSurtidor(carga);
		
	
	}
	
	public void activaManguera1() {
		Scanner sc = new Scanner(System.in);
		double carga = sc.nextDouble();
		try {
			this.negocio.activaManguera1(carga);
		} catch (SurtidorVacioException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
	
	public void activaManguera2() {
		Scanner sc = new Scanner(System.in);
		double carga = sc.nextDouble();
		try {
			this.negocio.activaManguera2(carga);
		} catch (SurtidorVacioException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}

	public void desactivaManguera1() {
		this.negocio.desactivaMaguera1();
		this.negocio.getAcumuladoManguera1();
		this.negocio.getUltimaVentaMG1();
	}
	
	public void desactivaManguera2() {
		this.negocio.desactivaMaguera2();
		this.negocio.getAcumuladoManguera2();
		this.negocio.getUltimaVentaMG2();
	}

	

}
