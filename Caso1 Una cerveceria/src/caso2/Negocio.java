package caso2;

import excepciones.NoExisteSurtidorException;
import excepciones.SurtidorVacioException;

/**
 * @author Agüero Sebastián, Mujica Juan Manuel, Navarro Pablo, Vucetic Ivo

 *
 */
public class Negocio {
	
	private Surtidor surtidor = null;
	
	public Negocio () {
		this.surtidor = Surtidor.getInstanceSurtidor();
	}
	
	/**Metodo que se encarga de inicializar los valores del surtidor<br>
	 * <b>Pre:</b>El parametro carga debe ser mayor a 0 y menor o igual a 2000<br> 
	 * @param carga parametro que representa la cantidad de litros con que se incializa el surtidor
	 * @throws NoExisteSurtidorException excepcion lanzada si no existe el surtidor
	 */
	public void InicializaSurtidor(double carga) throws NoExisteSurtidorException{
		assert carga > 0 : "La carga debe ser mayor a 0";
		assert carga <= 2000: "La carga debe ser menor o igual a 2000";
		if(this.getExistenciaDeposito()) 
			Surtidor.getInstanceSurtidor().InicializarSurtidor(carga);
		else 
			throw new NoExisteSurtidorException("No existe surtidor");
	}
		
	/** Metodo que le indica a la capa modelo que cuantos litros debe cargar al surtidor <br>
	 * <b>Pre:</b> El parametro carga debe ser mayor a 0 y menor o igual a 2000 <br>
	 * @param carga parametro que representa la cantidad de litros que se va a cargar en el surtidor
	 */
	public void cargaSurtidor(double carga) {
		assert carga>0:"La carga debe ser mayo a 0";
		assert carga<=2000:"La carga debe ser menor o igual a 2000";
		Surtidor.getInstanceSurtidor().cargarSurtidor(carga);
	}

	/** Metodo que se encarga de comunicar a la capa modelo que comience la descarga de combustible en la manguera 1
	 * @param carga parametro que representa el combustible que quiere cargar el usuario
	 * @throws SurtidorVacioException pasa la excepcion arrojada en modela a la ui
	 */
	public void activaManguera1(double carga) throws SurtidorVacioException {
		try {
			Surtidor.getInstanceSurtidor().descargaManguera1(carga);
		} catch (SurtidorVacioException e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}
	
	/** Metodo que se encarga de comunicar a la capa modelo que comience la descarga de combustible en la manguera 2
	 * @param carga parametro que representa el combustible que quiere cargar el usuario
	 * @throws SurtidorVacioException pasa la excepcion arrojada en modela a la ui
	 */
	public void activaManguera2(double carga) throws SurtidorVacioException {
		try {
			Surtidor.getInstanceSurtidor().descargaManguera2(carga);
		} catch (SurtidorVacioException e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}
	
	/**Metodo que se encarga de informar a la capa modelo que desactive la manguera 1
	 * 
	 */
	public void desactivaMaguera1() {
		Surtidor.getInstanceSurtidor().setManguera1Activada(false);
	}
	
	/**Metodo que se encarga de informar a la capa modelo que desactive la manguera 2
	 * 
	 */
	public void desactivaMaguera2() {
		Surtidor.getInstanceSurtidor().setManguera2Activada(false);
	}
	
	
	/** Metodo que se encarga de retornar la existencia del surtidor
	 * @return devuelve true si existe el surtidor y false en caso contrario
	 */
	public boolean getExistenciaDeposito() {
		if(Surtidor.instance == null)
			return false;
		else
			return true;
	}
	
	/**Metodo que se encarga de pedirle a la capa modelo el acumulado de la manguera 1 y devuelve el resultado a la capa ui
	 * @return devuelve el acumulado de la manguera 1
	 */
	public double getAcumuladoManguera1() {
		return Surtidor.getInstanceSurtidor().getAcumuladoManguera1();
	}
	
	/**Metodo que se encarga de pedirle a la capa modelo el acumulado de la manguera 2 y devuelve el resultado a la capa ui
	 * @return devuelve el acumulado de la manguera 2
	 */
	public double getAcumuladoManguera2() {
		return Surtidor.getInstanceSurtidor().getAcumuladoManguera2();
	}
	
	/**Metodo que se encarga de pedirle a la capa modelo la ultima venta de la manguera 1 y devuelve el resultado a la capa ui
	 * @return devuelve la ultima venta de la manguera 1
	 */
	public double getUltimaVentaMG1() {
		return Surtidor.getInstanceSurtidor().getUltimaVentaMG1();
	}
	
	/**Metodo que se encarga de pedirle a la capa modelo la ultima venta de la manguera 2 y devuelve el resultado a la capa ui
	 * @return devuelve la ultima venta de la manguera 2
	 */
	public double getUltimaVentaMG2() {
		return Surtidor.getInstanceSurtidor().getUltimaVentaMG2();
	}
	
	
}
