package caso2;

import excepciones.SurtidorVacioException;

/**
 * @author Agüero Sebastián, Mujica Juan Manuel, Navarro Pablo, Vucetic Ivo
 * Invariante de clase: manguera1 y manguera2 deben ser siempre distinto de null
 * 
 *
 */
/**
 * @author rochy
 *
 */
public class Surtidor {

	public static Surtidor instance = null;
	private double cantidad_Combustible;
	private double acumulado_Venta;
	private double acumuladoManguera1;
	private double acumuladoManguera2;
	private double ultimaventaManguera1;
	private double ultimaventaManguera2;
	private Manguera manguera1;
	private Manguera manguera2;
	private static double precio_Litro=80;
	
	private Surtidor() {
		super();
		manguera1 = new Manguera();
		manguera2 = new Manguera();
	}
	
	public static Surtidor getInstanceSurtidor() {
		if(Surtidor.instance==null) 
			Surtidor.instance = new Surtidor();
		return Surtidor.instance;
		
	}
	
	/**Metodo que se encarga de inicializar las variables que corresponden al surtidor<br>
	 * <b>Pre:</b> La variable cantidad_COmbustible debe ser igual a 0<br>
	 * <b> Pos:</b> La variable cantidad_Combustible debe ser menor o igual a 2000<br>
	 * @param carga parametro que resprensenta la cantidad inicial de combustible. 
	 */
	public void InicializarSurtidor(double carga) {
		assert this.cantidad_Combustible==0:"El surtidor no debe contener combustible";
		verificaInvariante();
		if(carga >=0 && carga<=2000) {
			this.cantidad_Combustible = carga;
			this.acumulado_Venta = 0;
			this.acumuladoManguera1 = 0;
			this.acumuladoManguera2 = 0;
			this.ultimaventaManguera1 = 0;
			this.ultimaventaManguera2 = 0;	
		}
		verificaInvariante();
		assert this.cantidad_Combustible<=2000:"La cantidad de combustible debe ser menor o igual a 2000";
	}
	
	/** Metodo que se encarga de la recarga del surtidor
	 * <b> Pre: </b> la variable cantidad_Combustible debe ser >=0 <br>
	 * <b> Pos: </b> la variable cantidad_Combustible debe ser menor o igual a 2000 <br>
	 * @param carga parametro que representa la cantidad de combustible que se le carga al surtidor<br>
	 */
	public void cargarSurtidor(double carga) {
		assert cantidad_Combustible>=0: "La cantidad de combustible en el surtidor debe ser mayor o igual a 0";
		verificaInvariante();
		if(carga>=0 && carga<=2000) {
			this.cantidad_Combustible += carga;
		}
		verificaInvariante();
		assert cantidad_Combustible<=2000:"La cantidad de combustible en el surtidor debe ser menor o igual a 2000";
	}
	
	public void descargaManguera1() throws SurtidorVacioException{
		
		double cantidad_extraida = 0;
		
		if(this.cantidad_Combustible>0) {
			while(this.cantidad_Combustible >= 0) {
				this.cantidad_Combustible -= 1;
				cantidad_extraida += 1;
				this.acumuladoManguera2 += 1;
				//wait de 1 segundo
			}
		}
		else 
			throw new SurtidorVacioException("El surtidor esta vacio");
	}
	
	public void descargaManguera2() throws SurtidorVacioException{
		//va con una excepcion para saber si se puede descargar o no
		double cantidad_extraida = 0;
		
		if(this.cantidad_Combustible>0) {
			while(this.cantidad_Combustible >= 1) {
				this.cantidad_Combustible -= 1;
				cantidad_extraida += 1;
				this.acumuladoManguera2 += 1;
				//wait de 1 segundo
			}
		}
		else 
			throw new SurtidorVacioException("El surtidor esta vacio");
	}
	
	/** Metodo que ser encarga de devolver true o false segun si existe el surtidor<br>
	 * @return retorna true si existe el surtidor o false en caso contrario
	 */
	public boolean getExistenciaDeposito() {
		return Surtidor.instance!=null;
	}
	
	/** Metodo que se encarga de deolver el valor acumulado de combustible descargado por la manguera 1<br>
	 * <b>Pre:</b> La variable acumuladoManguera1 debe ser mayor o igual 0<br>
	 * @return retorna la descarga acumulada en la manguera 1
	 */
	public double getAcumuladoManguera1(){
		assert this.acumuladoManguera1 >= 0: "El combustible descargado por la manguera 1 debe ser mayor o igual a 0";
		this.verificaInvariante();
		return this.acumuladoManguera1;
	}
	
	/** Metodo que se encarga de deolver el valor acumulado de combustible descargado por la manguera 2<br>
	 * <b>Pre:<b> La variable acumuladoManguera2 debe ser mayor o igual a 0<br>
	 * @return retorna la descarga acumulada en la manguera 2
	 */
	public double getAcumuladoManguera2(){
		assert this.acumuladoManguera2 >= 0:"El combustible descargado por la manguera 2 debe ser mayor o igual a 0";
		this.verificaInvariante();
		return this.acumuladoManguera2;
	}
	
	
	/** Metodo que se encarga de retornar el valor en pesos de la ultima venta de la manguera 1<br>
	 * <b>Pre:<b> El valor de la variable ultimaventaM1 debe ser mayor o igual a 0<br>
	 * @return retorna el valor de la variable ultimaventaManguera1
	 */
	public double getUltimaVentaMG1() {
		assert this.ultimaventaManguera1>=0:"El valor de la ultima venta debe ser mayor o igual a 0";
		this.verificaInvariante();
		return this.ultimaventaManguera1;
	}

	/** Metodo que se encarga de retornar el valor en pesos de la ultima venta de la manguera 2<br>
	 * <b>Pre:<b> El valor de la variable ultimaventaM2 debe ser mayor o igual a 0<br>
	 * @return retorna el valor de la variable ultimaventaManguera2
	 */
	public double getUltimaVentaMG2() {
		assert this.ultimaventaManguera2>=0:"El valor de la ultima venta debe ser mayor o igual a 0";
		this.verificaInvariante();
		return this.ultimaventaManguera2;
	}
	
	public void verificaInvariante() {
		assert this.manguera1 != null: "El atributo manguera1 no debe ser null";
		assert this.manguera2 != null: "El atributo manguera2 no debe ser null";
	}
}
