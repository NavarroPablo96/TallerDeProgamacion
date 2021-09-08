package caso1;

import java.util.Scanner;
import excepciones.CantMesasIncorrectoException;
import excepciones.MesaNoDisponibleException;

/**
 * @author Agüero Sebastián, Mujica Juan Manuel, Navarro Pablo, Vucetic Ivo
 * <br>
 * Invariante de clase el atributo Cerveceria distinto de null
 * Clase UI del caso 1
 * */

public class UI {
	private Negocio negocio=null;
	
	/**
	 * Constructor. Se crea una nueva interfaz gráfica, y crea una instancia de tipo negocio
	 * <br>
	 * */
	public UI() {
		this.negocio = new Negocio();
		
		verificaInvariante();
	}
	
	private void verificaInvariante() {
		assert this.negocio!=null : "Cervecería debe ser distinto de null";
	}
	
	/**
	 * Metodo abrirLocal <br>
	 * Delega en la capa de negocio su tarea <br>
	 * Pasa a la capa de negocio los parámetros sin validar <br>
	 * Si sucede algún excepción se muestra <br>
	 * 
	 * <b>Post: </b> Se abrio el negocio <br>
	 * */
	public void abrirLocal() {
		verificaInvariante();
		
		Scanner entrada= new Scanner(System.in);
		int cantMesas = entrada.nextInt();
		try {
			this.negocio.abrirLocal(cantMesas);
		}
		catch (CantMesasIncorrectoException e){
			System.out.println(e.getMessage());
		}
		entrada.close();
		
		assert this.negocio.getCerveceria().isOpen() : "La cerveceria está cerrada";
		verificaInvariante();
	}
	
	/**
	 * Metodo cerrarMesa <br>
	 * Delega en la capa de negocio su tarea <br>
	 * Pasa a la capa de negocio los parámetros sin validar <br>
	 * Si sucede algún excepción se muestra <br>
	 * <b>Post: </b> Se cerro la mesa<br>
	 * */
	public void cerrarMesa() {
		verificaInvariante();
		
		Scanner entrada= new Scanner(System.in);
		int nroMesa = entrada.nextInt();
		
		try {
			System.out.println("El importe de la mesa"+nroMesa+"es: $"+this.negocio.cerrarMesa(nroMesa));
		}
		catch (CantMesasIncorrectoException e){
			System.out.println(e.getMessage());
		}
		entrada.close();
		assert this.negocio.getCerveceria().getMesas().get(nroMesa).isOcupada(): "La mesa no se cerro";
		verificaInvariante();
	}
	
	/**
	 * Metodo ocuparMesa <br>
	 * Delega en la capa de negocio su tarea <br>
	 * Pasa a la capa de negocio los parámetros sin validar <br>
	 * Si sucede algún excepción se muestra <br>
	 * <b>Post: </b> Se ocupo la mesa<br>
	 * */
	public void ocuparMesa() {
		verificaInvariante();
		
		Scanner entrada= new Scanner(System.in);
		int nroMesa = entrada.nextInt();
		Mesa mesaCerrada=null;
		try {
			mesaCerrada= this.negocio.ocuparMesa(nroMesa);
		}catch (CantMesasIncorrectoException e){
			System.out.println(e.getMessage());
		}catch (MesaNoDisponibleException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Se cerro la mesa numero"+mesaCerrada.getNumero());
		entrada.close();
		
		assert !this.negocio.getCerveceria().getMesas().get(nroMesa).isOcupada(): "La mesa no se ocupo";
		verificaInvariante();
	}
	
	
}
