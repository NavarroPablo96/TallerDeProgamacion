package caso1;
/**
 * @author Agüero Sebastián, Mujica Juan Manuel, Navarro Pablo, Vucetic Ivo<br>
 * Invariante de clase los atributos cantidadDeMesasHabilitadas y cantidadDeProductos deben ser positivos<br>
 * El atributo mesas y carta debe ser distinto de null<br>
 * Clase BeerHouse 
 * */
import java.util.HashMap;
import excepciones.MesaNoDisponibleException;

public class BeerHouse {
	
	private int cantidadDeMesasHabilitadas;
	private int cantidadDeProductos;
	private HashMap<Integer, Mesa> mesas = new HashMap<Integer,Mesa>();
	private HashMap<Integer, Producto> carta = new HashMap<Integer,Producto>();
	
	private boolean open=false;
	
	/**
	 * Constructor. Se inicializan algunos valores iniciales en cero
	 * <br>
	 * */
	public BeerHouse() {
		this.cantidadDeMesasHabilitadas=0;
		this.cantidadDeProductos=0;
	}

	//esto es para un assert
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
	 * Metodo abrirLocal <br>
	 * <b>Pre: </b> parámetro cantMesas debe ser positivo<br>
	 * El atributo mesas y carta debe ser distinto de null<br>
	 * <b>Post: </b> Se abrió el negocio <br>
	 * todas las mesas estan desocupadas <br>
	 * la carta esta actualizada con todos los productos disponibles <br>
	 * */
	public void abrirLocal(int cantMesas) {
		assert this.mesas!=null :"El atributo mesas es null, de la clase BeerHouse";
		assert this.carta!=null :"El atributo carta es null, de la clase BeerHouse";
		assert cantMesas>0 : "BeerHouse.abrirLocal() cantMesas no es positiva";
		
		//desocupar mesas
		Mesa actual=null;
		for(int i=0 ; i<=cantMesas; i++) {
			actual= new Mesa();
			this.mesas.put(actual.getNumero(),actual);
			actual.setOcupada(false);
		}
		
		//cargar productos
		this.carta.put(1, new Producto(140,1, "Pinta de Cerveza negra"));
		this.carta.put(2, new Producto(100,2, "Pinta de Cerveza rubia"));
		this.carta.put(3, new Producto(350,3, "Muzzarella "));
		this.carta.put(4, new Producto(100,4, "Gaseosa"));
		this.carta.put(5, new Producto(90,5, "agua"));
		
		
		this.cantidadDeProductos=5;
		this.cantidadDeMesasHabilitadas=cantMesas;
		this.open=true;
		
		assert verificaMesasVacias() : "BeerHouse.abrirLocal() Las mesas no están vacias";
		assert this.open=true :"El local no se abrió";
		verificaInvariante();
	}
	
	
	/**
	 * Metodo ocuparMesa <br>
	 * <b>Pre: </b> el parámetro nroMesa debe ser positivo<br>
	 * <b>Post: </b> Se retorna una referencia no nula de la Mesa dada por el parámetro nroMesa<br>
	 * Se ocupa la mesa recibida por parámetro<br>
	 * @throws MesaNoDisponibleException en caso de intentar ocupar una mesa ya ocupada<br>
	 * */
	public Mesa ocuparMesa(int nroMesa)throws MesaNoDisponibleException {
		verificaInvariante();
		assert nroMesa>0 : "BeerHouse.ocuparMesa() nroMesa no es positivo";
		
		Mesa aux;
		aux=this.mesas.get(nroMesa);
		if(aux.isOcupada())
			throw new MesaNoDisponibleException("La mesa ya está ocupada");
		aux.setOcupada(true);
		
		assert aux!=null : "BeerHouse.ocuparMesa() aux es null";
		assert aux.isOcupada(): "BeerHouse.ocuparMesa() No se ocupo la mesa";
		verificaInvariante();
		return aux;
	}
	
	
	
	/**
	 * Metodo cerrarMesa <br>
	 * <b>Pre: </b> el parámetro nroMesa debe ser positivo<br>
	 * el parámetro nroMesa debe ser menor al atributo cantidad de mesas habilitadas<br>
	 * <b>Post: </b> Se cerro la mesa, se retorno un importe positivo<br>
	 * */
	public double cerrarMesa(int nroMesa) {
		verificaInvariante();
		assert nroMesa>0 && nroMesa<=this.cantidadDeMesasHabilitadas : "BeerHouse.cerrarMesa() nroMesa es incorrecto";
		
		double aux=this.mesas.get(nroMesa).getImporte();
		this.mesas.get(nroMesa).setOcupada(false);
		this.mesas.get(nroMesa).setImporte(0);
		
		assert this.mesas.get(nroMesa).isOcupada() == false : "BeerHouse.cerrarMesa() No se cerro la mesa";
		assert aux>0 : "BeerHouse.cerrarMesa() aux no es positivo";
		verificaInvariante();
		return aux;
	}
	
	private void verificaInvariante() {
		assert cantidadDeMesasHabilitadas>=1 : "La cantidad de Mesas Habilitadas no es positiva";
		assert cantidadDeProductos>=1 :  "La cantidad de productos no es positiva";
		assert this.mesas!=null :"El atributo mesas es null, de la clase BeerHouse";
		assert this.carta!=null :"El atributo carta es null, de la clase BeerHouse";
	}
	
	public HashMap<Integer, Mesa> getMesas() {
		return mesas;
	}

	public boolean isOpen() {
		return this.open;
	}

	public int getCantMesasMaxima() {
		return this.mesas.size();
	}
	
	public int getCantidadDeMesasHabilitadas() {
		return cantidadDeMesasHabilitadas;
	}
	public int getCantidadDeProductos() {
		return cantidadDeProductos;
	}
	
}
