package caso2;

public class Negocio {
	
	
	public void InicializaSurtidor(double carga) {
		Surtidor.getInstanceSurtidor().InicializarSurtidor(carga);
	}
		
	public void cargaSurtidor(double carga) {
		Surtidor.getInstanceSurtidor().cargarSurtidor(carga);
	}
	// ----------------------------------------------------------------------
	public void activaManguera1() {
		Surtidor.getInstanceSurtidor().descargaManguera1();
	}
	
	public void activaManguera2() {
		Surtidor.getInstanceSurtidor().descargaManguera2();
	}
	
	public void desactivaMaguera1() {
		
	}
	
	public void desactivaMaguera2() {
		
	}
	
	
	//------------------------------------------------------------------
	public boolean getExistenciaDeposito() {
		return Surtidor.getInstanceSurtidor().getExistenciaDeposito();
	}
	
	public double getAcumuladoManguera1() {
		return Surtidor.getInstanceSurtidor().getAcumuladoManguera1();
	}
	
	public double getAcumuladoManguera2() {
		return Surtidor.getInstanceSurtidor().getAcumuladoManguera2();
	}
	
	public double getUltimaVentaMG1() {
		return Surtidor.getInstanceSurtidor().getUltimaVentaMG1();
	}
	
	public double getUltimaVentaMG2() {
		return Surtidor.getInstanceSurtidor().getUltimaVentaMG2();
	}
	
	
}
