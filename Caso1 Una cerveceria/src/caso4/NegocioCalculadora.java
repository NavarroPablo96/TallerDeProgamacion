package caso4;
/**
 * @author Agüero Sebastián, Mujica Juan Manuel, Navarro Pablo, Vucetic Ivo
 * <br>
 * Clase NegocioCalculadora 
 * */
public class NegocioCalculadora {
	ModeloCalculadora calculadora;
	
	/**
	 * Constructor que crea una nueva calculadora, que es el único atributo que tiene
	 * <br>
	 * */
	public NegocioCalculadora() {
		this.calculadora=new ModeloCalculadora();
	}
	
	/**
	 * Metodo Calcular <br>
	 * <b>Pre: </b> No es null el atributo calculadora<br>
	 * Los parámetros fueron recibidos sin validación<br>
	 * <b>Post: </b> Se le han pasado los parámetros a la calculadora<br>
	 * Si la calculadora envia una excepción este método se la envia a la interfaz<br>
	 * 
	 * */
	public void Calcular(Integer primerOperando, Integer segundoOperando, String operacion)throws ExceptionParametrosIncorrectos,ExceptionResultadoImposible {
		assert this.calculadora!=null : "el atributo calculadora de la clase Negocio es null";
		calculadora.Calcular(primerOperando,segundoOperando,operacion);
		
	}

	/**
	 * Metodo traerResultado <br>
	 * <b>Pre: </b> No es null el atributo calculadora<br>
	 * <b>Post: </b> Se le ha delegado este método a la calculadora<br>
	 * Si la calculadora envia una excepción este método se la envia a la interfaz<br>
	 * */
	public Integer traerResultado()throws ExceptionResultadoNull{
		assert this.calculadora!=null : "el atributo calculadora de la clase Negocio es null";
		return calculadora.traerResultado();
	}

}
