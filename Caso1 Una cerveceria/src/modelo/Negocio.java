package modelo;
import excepciones.CantMesasIncorrectoException;
import excepciones.MesaNoDisponibleException;

/**
 * @author Ag�ero Sebasti�n, Mujica Juan Manuel, Navarro Pablo, Vucetic Ivo
 * <br>
 * Clase Negocio
 * */
public class Negocio {
	
	/**
	 * Metodo abrirLocal 
	 * <br>
	 * */
	public void abrirLocal(int cantMesas)throws CantMesasIncorrectoException  {
		//cantMesas no est� validado
		if(cantMesas<=0 || cantMesas>BeerHouse.getInstance().getCantMesasMaxima())
			throw new CantMesasIncorrectoException("Negocio.abrirLocal() necesita 0<cantMesas<=CantM�xima");
		
		BeerHouse.getInstance().abrirLocal(cantMesas);
		//postCondici�n se debe abrir el local
	}
	
	public Mesa ocuparMesa(int nroMesa) throws CantMesasIncorrectoException,MesaNoDisponibleException{
		Mesa act=null;
		//se debe validad nroMesa
		if(nroMesa<=0 || nroMesa>BeerHouse.getInstance().getCantidadDeMesasHabilitadas())
			throw new CantMesasIncorrectoException("Negocio.ocuparMesa() necesita 0<nroMesa<=CantMesasHabilitadas");
		
		act= BeerHouse.getInstance().ocuparMesa(nroMesa);
		
		//post Condicion:
		assert act!=null : "Negocio.ocuparMesa() la mesa no fue creada";
		return act;
	}
	
	public double cerrarMesa(int nroMesa)throws CantMesasIncorrectoException {
		//se debe validar nroMesa
		if(nroMesa<=0 || nroMesa>BeerHouse.getInstance().getCantidadDeMesasHabilitadas())
			throw new CantMesasIncorrectoException("Negocio.ocuparMesa() necesita 0<nroMesa<=CantMesasHabilitadas");
		
		double act= BeerHouse.getInstance().cerrarMesa(nroMesa);
		
		assert act>=0 : "Negocio.ocuparMesa() importe total negativo";
		return act;
		
	}
}



