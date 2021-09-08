package caso1;

import excepciones.CantMesasIncorrectoException;
import excepciones.MesaNoDisponibleException;

/**
 * @author Agüero Sebastián, Mujica Juan Manuel, Navarro Pablo, Vucetic Ivo
 * <br>
 * Invariante de clase el atributo cerveceria distinto de null
 * Clase Negocio
 * */
public class Negocio {
	
	private BeerHouse cerveceria=null;
	
	/**
	 * Constructor. Se crea una instancia de tipo BeerHouse
	 * <br>
	 * */
	public Negocio() {
		this.cerveceria=new BeerHouse();
		
		verificaInvariante();
	}
	
	public BeerHouse getCerveceria() {
		verificaInvariante();
		
		return cerveceria;
	}

	private void verificaInvariante() {
		assert this.cerveceria!=null : "El atributo cerveceria de la clase Negocio es null";
		
	}
	
	/**
	 * Metodo abrirLocal <br>
	 * Delega en la capa de modelo su tarea <br>
	 * Valida los parametros y los pasa a la capa de modelo <br>
	 * 
	 * <b>Post: </b> Se abrió el negocio <br>
	 * @throws CantMesasIncorrectoException en caso de intentar con un numero incorrecto de mesa<br>
	 * */
	public void abrirLocal(int cantMesas)throws CantMesasIncorrectoException  {
		verificaInvariante();
		
		if(cantMesas<=0 || cantMesas>this.cerveceria.getCantMesasMaxima())
			throw new CantMesasIncorrectoException("Negocio.abrirLocal() necesita 0<cantMesas<=CantMáxima");
		
		this.cerveceria.abrirLocal(cantMesas);

		assert this.cerveceria.isOpen(): "El local no se abrió";
		verificaInvariante();
	}
	
	/**
	 * Metodo ocuparMesa <br>
	 * Delega en la capa de modelo su tarea <br>
	 * valida los parámetros y los pasa a la capa de modelo <br>
	 * <b>Post: </b> Se retorna una referencia no nula de la Mesa dada por el parámetro nroMesa<br>
	 * @throws CantMesasIncorrectoException en caso de intentar con un numero incorrecto de mesa<br>
	 * @throws MesaNoDisponibleException en caso de intentar ocupar una mesa ya ocupada<br>
	 * */
	public Mesa ocuparMesa(int nroMesa) throws CantMesasIncorrectoException,MesaNoDisponibleException{
		verificaInvariante();
		
		Mesa act=null;
		if(nroMesa<=0 || nroMesa>this.cerveceria.getCantidadDeMesasHabilitadas())
			throw new CantMesasIncorrectoException("Negocio.ocuparMesa() necesita 0<nroMesa<=CantMesasHabilitadas");
		
		act= this.cerveceria.ocuparMesa(nroMesa);

		assert act!=null : "Negocio.ocuparMesa() la mesa no fue creada";
		verificaInvariante();
		return act;
	}
	
	/**
	 * Metodo cerrarMesa <br>
	 * Delega en la capa de modelo su tarea <br>
	 * Valida los parámetros y los pasa a la capa de modelo <br>
	 * 
	 * <b>Post: </b> Se cerro la mesa, se retorno un importe positivo<br>
	 * @throws CantMesasIncorrectoException en caso de intentar con un numero incorrecto de mesa<br>
	 * */
	public double cerrarMesa(int nroMesa)throws CantMesasIncorrectoException {
		verificaInvariante();
		
		
		if(nroMesa<=0 || nroMesa>this.cerveceria.getCantidadDeMesasHabilitadas())
			throw new CantMesasIncorrectoException("Negocio.ocuparMesa() necesita 0<nroMesa<=CantMesasHabilitadas");
		
		double act= this.cerveceria.cerrarMesa(nroMesa);
		
		
		assert act>=0 : "Negocio.ocuparMesa() importe total negativo";
		verificaInvariante();
		return act;
		
	}
}



