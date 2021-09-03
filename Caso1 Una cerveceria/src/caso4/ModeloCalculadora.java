package caso4;

public class ModeloCalculadora {
	private Integer ultimoCalculo;
	private boolean huboCalculoExitoso;
	
	public ModeloCalculadora() {
		this.huboCalculoExitoso=false;
	}
	
	

	public void Calcular(Integer primerOperando, Integer segundoOperando, String operacion)throws ExceptionParametrosIncorrectos,ExceptionResultadoImposible {
		
		//Validaci�n de la operaci�n
		if(!operacion.equals("+") && !operacion.equals("-") && !operacion.equals("*") && !operacion.equals("/"))
			throw new ExceptionParametrosIncorrectos(operacion+"no es una operaci�n v�lida Calculadora.Calcular(...)");
		//validaci�n de los operandos
		if(primerOperando<0 || segundoOperando<0)
			throw new ExceptionParametrosIncorrectos("Los n�mero deben ser positivos y enteros op1=" + primerOperando + " op2=" + segundoOperando );
		if(operacion.equals("/")&& segundoOperando==0)
			throw new ExceptionResultadoImposible("No es posible la divisi�n por cero");
		
		this.huboCalculoExitoso=true;
		if(operacion.equals("+")) {
			suma(primerOperando,segundoOperando);
		}
		else if(operacion.equals("-")) {
			resta(primerOperando,segundoOperando);
		}
		else if(operacion.equals("*")) {
			multiplicacion(primerOperando,segundoOperando);
		}
		else if(operacion.equals("/")) {
			division(primerOperando,segundoOperando);
		}
		
	}

	private void division(Integer primerOperando, Integer segundoOperando) {
		this.ultimoCalculo = primerOperando / segundoOperando;	
	}

	private void multiplicacion(Integer primerOperando, Integer segundoOperando) {
		this.ultimoCalculo = primerOperando * segundoOperando;
	}

	private void resta(Integer primerOperando, Integer segundoOperando) {
		//al mayor n�mero le resto el menor, por ser la resta en numero naturales
		if(primerOperando>=segundoOperando)	
			this.ultimoCalculo = primerOperando - segundoOperando;
		else 
			this.ultimoCalculo = segundoOperando - primerOperando;
	}

	private void suma(Integer primerOperando, Integer segundoOperando) {
		this.ultimoCalculo = primerOperando + segundoOperando;
	}



	public Integer traerResultado()throws ExceptionResultadoNull{
		if(this.huboCalculoExitoso==false)
			throw new ExceptionResultadoNull("Todav�a no se realizo un calculo exitoso");
		
		return this.ultimoCalculo;
	}

}
