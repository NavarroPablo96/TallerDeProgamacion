package caso2;

public class desactivaMangueraState implements IState{

	private Manguera manguera;
	
	
	public desactivaMangueraState(Manguera manguera) {
		super();
		this.manguera = manguera;
	}

	@Override
	public void activarManguera() {
		this.manguera.setEstado(new activaMangueraState(this.manguera));
	}

	@Override
	public void desactivarManguera() {
		// TODO Auto-generated method stub
		
	}

}
