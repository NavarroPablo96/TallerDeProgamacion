package caso2;

public class Manguera {
	
	private IState estado;
	
	public Manguera () {
		this.estado = new activaMangueraState(this);
	}
	
	public void setEstado(IState estado) {
		this.estado = estado;
	}
	
	public void activarManguera() {
		this.estado.activarManguera();
	}
	
	public void desactivarManguera() {
		this.estado.desactivarManguera();
	}
	
	
}
