package caso4;
/**
 * @author Ag�ero Sebasti�n, Mujica Juan Manuel, Navarro Pablo, Vucetic Ivo
 * <br>
 * Clase NegocioCalculadora 
 * */
public class NegocioCalculadora {
	ModeloCalculadora calculadora;
	
	/**
	 * Constructor que crea una nueva calculadora, que es el �nico atributo que tiene
	 * <br>
	 * */
	public NegocioCalculadora() {
		this.calculadora=new ModeloCalculadora();
	}
	
	/**
	 * Metodo Calcular <br>
	 * <b>Pre: </b> No es null el atributo calculadora<br>
	 * Los par�metros fueron recibidos sin validaci�n<br>
	 * <b>Post: </b> Se le han pasado los par�metros a la calculadora<br>
	 * Si la calculadora envia una excepci�n este m�todo se la envia a la interfaz<br>
	 * 
	 * */
	public void Calcular(Integer primerOperando, Integer segundoOperando, String operacion)throws ExceptionParametrosIncorrectos,ExceptionResultadoImposible {
		assert this.calculadora!=null : "el atributo calculadora de la clase Negocio es null";
		calculadora.Calcular(primerOperando,segundoOperando,operacion);
		
	}

	/**
	 * Metodo traerResultado <br>
	 * <b>Pre: </b> No es null el atributo calculadora<br>
	 * <b>Post: </b> Se le ha delegado este m�todo a la calculadora<br>
	 * Si la calculadora envia una excepci�n este m�todo se la envia a la interfaz<br>
	 * */
	public Integer traerResultado()throws ExceptionResultadoNull{
		assert this.calculadora!=null : "el atributo calculadora de la clase Negocio es null";
		return calculadora.traerResultado();
	}

}
