package caso2;

public class activaMangueraState implements IState{

	private Manguera manguera;
	
	 
	public activaMangueraState(Manguera manguera) {
		super();
		this.manguera = manguera;
	}


	@Override
	public void activarManguera() {
		
	}


	@Override
	public void desactivarManguera() {
		this.manguera.setEstado(new desactivaMangueraState(this.manguera));
	}


}
