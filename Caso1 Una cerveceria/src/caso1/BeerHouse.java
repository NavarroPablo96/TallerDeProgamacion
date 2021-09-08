package caso1;
/**
 * @author Agüero Sebastián, Mujica Juan Manuel, Navarro Pablo, Vucetic Ivo
 * <br>
 * Clase BeerHouse 
 * */
import java.util.HashMap;

import excepciones.MesaNoDisponibleException;

public class BeerHouse {
	
	private int cantidadDeMesasHabilitadas;
	private int cantidadDeProductos;
	private HashMap<Integer, Mesa> mesas = new HashMap<Integer,Mesa>();
	private boolean open=false;
	
	
	public HashMap<Integer, Mesa> getMesas() {
		return mesas;
	}

	public boolean isOpen() {
		return this.open;
	}

	public int getCantMesasMaxima() {
		return this.mesas.size();
	}

	public BeerHouse() {
		this.cantidadDeMesasHabilitadas=0;
		this.cantidadDeProductos=0;
	}
	
	
	private void desocuparMesas() {
		Mesa actual=null;
		for(int i=0 ; i<=this.mesas.size(); i++) {
			actual=this.mesas.get(i);
			actual.setOcupada(false);
		}
	}
	
	
	private boolean verificaMesasVacias() {
		Mesa actual=null;
		boolean cumpleLibres=true;
		int i=0;
		while(cumpleLibres && i<=this.mesas.size()) {
			actual=this.mesas.get(i);
			if(actual.isOcupada())
				cumpleLibres=false;
			i++;
		}
		return cumpleLibres;
	}
	
	
	/**
	 * <b>Pre: </b> parámetro cantMesas debe ser positivo<br>
	 * <b>Post: </b> todas las mesas estan desocupadas <br>
	 * la carta esta actualizada con todos los productos disponibles <br>
	 */
	public void abrirLocal(int cantMesas) {
		verificaInvariante();
		assert cantMesas>0 : "BeerHouse.abrirLocal() cantMesas no es positiva";
		
		desocuparMesas();
		this.cantidadDeProductos=0;
		this.cantidadDeMesasHabilitadas=cantMesas;
		this.open=true;
		
		assert verificaMesasVacias() : "BeerHouse.abrirLocal() Las mesas no están vacias";
		verificaInvariante();
	}
	
	public void agregarMesa() {
		Mesa mesa= new Mesa();
		
		this.mesas.put(mesa.getNumero(),mesa);
		
	}
	
	public Mesa ocuparMesa(int nroMesa)throws MesaNoDisponibleException {
		Mesa aux;
		verificaInvariante();
		
		//¿Deberia este metodo verificar si el local está abierto?
		//podría ser un invariante
		aux=this.mesas.get(nroMesa);
		if(aux.isOcupada())
			throw new MesaNoDisponibleException("La mesa ya está ocupada");
		aux.setOcupada(true);
		
		verificaInvariante();
		return aux;
	}
	
	public double cerrarMesa(int nroMesa) {
		verificaInvariante();
		
		double aux=this.mesas.get(nroMesa).getImporte();
		this.mesas.get(nroMesa).setOcupada(false);
		this.mesas.get(nroMesa).setImporte(0);
		
		verificaInvariante();
		return aux;
	}
	
	private void verificaInvariante() {
		assert cantidadDeMesasHabilitadas>=1 : "No cumple invariante de clase"; 
		assert cantidadDeProductos>=1 :  "No cumple invariante de clase";
	}

	public int getCantidadDeMesasHabilitadas() {
		return cantidadDeMesasHabilitadas;
	}
	public int getCantidadDeProductos() {
		return cantidadDeProductos;
	}
	
}
