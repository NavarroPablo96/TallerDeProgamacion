package caso1;


public class Mesa {
	private static int numeroDeMesa=0;
	private int numero;
	private boolean ocupada;
	private double importe=0;
	
	public Mesa(){
		Mesa.numeroDeMesa++;
		this.numero=Mesa.numeroDeMesa;
		this.ocupada=false;
	}
	
	public void agregarConsumision(int cantidad, Producto producto) {
		this.importe+= (cantidad * producto.getPrecio());
	}

	public boolean isOcupada() {
		return ocupada;
	}

	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}

	public int getNumero() {
		return numero;
	}
	
	public double getImporte() {
		return this.importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}
	
	
}
