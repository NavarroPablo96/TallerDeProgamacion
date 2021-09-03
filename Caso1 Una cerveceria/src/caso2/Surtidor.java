package caso2;

import excepciones.SurtidorVacioException;

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
	
	public void InicializarSurtidor(double carga) {
		this.cantidad_Combustible = carga;
		this.acumulado_Venta = 0;
		this.acumuladoManguera1 = 0;
		this.acumuladoManguera2 = 0;
		this.ultimaventaManguera1 = 0;
		this.ultimaventaManguera2 = 0;
	}
	
	public void cargarSurtidor(double carga) {
		this.cantidad_Combustible += carga;
	}
	
	public void descargaManguera1() throws SurtidorVacioException{
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
	
	public boolean getExistenciaDeposito() {
		return Surtidor.instance!=null;
	}
	
	public double getAcumuladoManguera1(){
		return this.acumuladoManguera1;
	}
	
	public double getAcumuladoManguera2(){
		return this.acumuladoManguera2;
	}
	
	public double getUltimaVentaMG1() {
		return this.ultimaventaManguera1;
	}
	
	public double getUltimaVentaMG2() {
		return this.ultimaventaManguera2;
	}
	
		
}
