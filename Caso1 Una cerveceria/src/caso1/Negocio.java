package caso1;
import excepciones.CantMesasIncorrectoException;
import excepciones.MesaNoDisponibleException;

/**
 * @author Agüero Sebastián, Mujica Juan Manuel, Navarro Pablo, Vucetic Ivo
 * <br>
 * Clase Negocio
 * */
public class Negocio {
	
	private BeerHouse cerveceria=null;
	
	public Negocio() {
		this.cerveceria=new BeerHouse();
	}
	
	public BeerHouse getCerveceria() {
		return cerveceria;
	}

	
	/**
	 * Metodo abrirLocal <br>
	 * Delega en la capa de modelo su tarea <br>
	 * Valida los parametros y los pasa a la capa de modelo <br>
	 * Si sucede algún excepción se muestra <br>
	 * 
	 * <b>Post: </b> Se abrio el negocio <br>
	 * @throws 
	 * */
	public void abrirLocal(int cantMesas)throws CantMesasIncorrectoException  {
		//cantMesas no está validado
		if(cantMesas<=0 || cantMesas>this.cerveceria.getCantMesasMaxima())
			throw new CantMesasIncorrectoException("Negocio.abrirLocal() necesita 0<cantMesas<=CantMáxima");
		
		this.cerveceria.abrirLocal(cantMesas);
		//postCondición se debe abrir el local
	}
	
	public Mesa ocuparMesa(int nroMesa) throws CantMesasIncorrectoException,MesaNoDisponibleException{
		Mesa act=null;
		//se debe validad nroMesa
		if(nroMesa<=0 || nroMesa>this.cerveceria.getCantidadDeMesasHabilitadas())
			throw new CantMesasIncorrectoException("Negocio.ocuparMesa() necesita 0<nroMesa<=CantMesasHabilitadas");
		
		act= this.cerveceria.ocuparMesa(nroMesa);
		
		//post Condicion:
		assert act!=null : "Negocio.ocuparMesa() la mesa no fue creada";
		return act;
	}
	
	public double cerrarMesa(int nroMesa)throws CantMesasIncorrectoException {
		//se debe validar nroMesa
		if(nroMesa<=0 || nroMesa>this.cerveceria.getCantidadDeMesasHabilitadas())
			throw new CantMesasIncorrectoException("Negocio.ocuparMesa() necesita 0<nroMesa<=CantMesasHabilitadas");
		
		double act= this.cerveceria.cerrarMesa(nroMesa);
		
		assert act>=0 : "Negocio.ocuparMesa() importe total negativo";
		return act;
		
	}
}



