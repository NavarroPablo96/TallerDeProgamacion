package caso4;

public class NegocioCalculadora {
	ModeloCalculadora calculadora;
	
	public NegocioCalculadora() {
		this.calculadora=new ModeloCalculadora();
	}
	
	public void Calcular(Integer primerOperando, Integer segundoOperando, String operacion)throws ExceptionParametrosIncorrectos,ExceptionResultadoImposible {

		calculadora.Calcular(primerOperando,segundoOperando,operacion);
		
	}

	public Integer traerResultado()throws ExceptionResultadoNull{
		return calculadora.traerResultado();
	}

}
