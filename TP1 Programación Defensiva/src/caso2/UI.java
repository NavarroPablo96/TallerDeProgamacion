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
	
	/**Metodo que se encarga de pasarle a la capa modelo la cantidad de combustible con la cual el usuario quiere incializar al surtidor. En caso de no se pueda atrapa la excepcion y muestra el mensaje
	 * 
	 */
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
	
	/**
	 * Metodo que se encarga de pasarle a la capa modelo la cantidad de combustible que el usuario quiere cargarle al surtidor
	 */
	public void cargaSurtidor() {
		Scanner sc = new Scanner(System.in);
		double carga = sc.nextDouble();
		
		this.negocio.cargaSurtidor(carga);
		
	
	}
	
	/**
	 * Metodo que se encarga de pedirle a la capa modelo activar la manguera 1 para que comience la descarga. Si no se puede atrapa la excepcion y muestra el mensaje
	 */
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
	
	/**
	 * Metodo que se encarga de pedirle a la capa modelo activar la manguera 2 para que comience la descarga. Si no se puede atrapa la excepcion y muestra el mensaje
	 */
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

	/**
	 * MEtodo que se encarga de decirle a la capa modelo que desactive la manguera 1 y pedirle el acumulado y la ultima venta de la manguera 1
	 */
	public void desactivaManguera1() {
		this.negocio.desactivaMaguera1();
		this.negocio.getAcumuladoManguera1();
		this.negocio.getUltimaVentaMG1();
	}
	
	/**
	 * MEtodo que se encarga de decirle a la capa modelo que desactive la manguera 2 y pedirle el acumulado y la ultima venta de la manguera 1
	 */
	public void desactivaManguera2() {
		this.negocio.desactivaMaguera2();
		this.negocio.getAcumuladoManguera2();
		this.negocio.getUltimaVentaMG2();
	}

	

}
