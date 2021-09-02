package caso2;

public class Surtidor {

	private double cantidad_Combustible;
	private double acumulado_Venta;
	private double acumuladoManguera1;
	private double acumuladoManguera2;
	private double ultimaventaManguera1;
	private double ultimaventaManguera2;
	private static double precio_Litro=80;
	
	public Surtidor() {
		super();
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
	
	public String descargaManguera1() {
		//va con una excepcion para saber si se puede descargar o no
		double cantidad_extraida = 0;
		while(this.cantidad_Combustible >= 1) {
			this.cantidad_Combustible -= 1;
			cantidad_extraida += 1;
			this.acumuladoManguera1 += 1;
			//wait de 1 segundo
		}
		return "Se extrajo " + this.
	}
	
	public String descargaManguera2() {
		//va con una excepcion para saber si se puede descargar o no
		double cantidad_extraida = 0;
		while(this.cantidad_Combustible >= 1) {
			this.cantidad_Combustible -= 1;
			cantidad_extraida += 1;
			this.acumuladoManguera2 += 1;
			//wait de 1 segundo
		}
		
		
		
	}
	
	
	
	
	
	
		
}
