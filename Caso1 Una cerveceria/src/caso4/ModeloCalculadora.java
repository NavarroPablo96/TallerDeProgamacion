package caso4;

import excepciones.ExceptionParametrosIncorrectos;
import excepciones.ExceptionResultadoImposible;
import excepciones.ExceptionResultadoNull;

/**
 * @author Ag�ero Sebasti�n, Mujica Juan Manuel, Navarro Pablo, Vucetic Ivo
 * <br>
 * Clase ModeloCalculadora 
 * */
public class ModeloCalculadora {
	private Integer ultimoCalculo;
	private boolean huboCalculoExitoso;
	
	/**
	 * Constructor que inicializa el atributo booleano en false, indicando que aun no han realizado un c�lculo exitoso
	 * <br>
	 * */
	public ModeloCalculadora() {
		this.huboCalculoExitoso=false;
	}
	
	
	/**
	 * Metodo Calcular <br>
	 * <b>Pre: </b> Se reciben los par�metros sin validaci�n<br>
	 * <b>Post: </b> Se han validado los par�metros, en caso de error se ha notificado al m�todo invocante<br>
	 * En caso de no haber ningun error, se realiza el calculo y se almacena en el atributo "ultimoCalculo"<br>
	 * 
	 * */
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

	/**
	 * Metodo division <br>
	 * <b>Pre: </b> ambos par�metros son enteros positivo<br>
	 * El segundo par�metro no es cero<br>
	 * <b>Post: </b> Se ha resuelto la operaci�n y se ha almacenado en el atributo "ultimoCalculo"<br>
	 * 
	 * */
	private void division(Integer primerOperando, Integer segundoOperando) {
		assert (primerOperando>=0 && segundoOperando>=0): "Los operandos no son enteros positivos";
		assert (segundoOperando!=0): "El segundoOperando es cero en la divisi�n";
		
		this.ultimoCalculo = primerOperando / segundoOperando;
		
		assert this.ultimoCalculo== primerOperando/segundoOperando : "La divisi�n no se resolvio correctamente";
	}

	/**
	 * Metodo multiplicaci�n <br>
	 * <b>Pre: </b> ambos par�metros son enteros positivo<br>
	 * <b>Post: </b> Se ha resuelto la operaci�n y se ha almacenado en el atributo "ultimoCalculo"<br>
	 * */
	private void multiplicacion(Integer primerOperando, Integer segundoOperando) {
		assert (primerOperando>=0 && segundoOperando>=0): "Los operandos no son enteros positivos";
		
		this.ultimoCalculo = primerOperando * segundoOperando;
		assert this.ultimoCalculo== primerOperando*segundoOperando : "La multiplicaci�n no se resolvio correctamente";
	}
	
	/**
	 * Metodo resta <br>
	 * <b>Pre: </b> ambos par�metros son enteros positivo<br>
	 * <b>Post: </b> Se ha resuelto la operaci�n y se ha almacenado en el atributo "ultimoCalculo"<br>
	 * */
	private void resta(Integer primerOperando, Integer segundoOperando) {
		assert (primerOperando>=0 && segundoOperando>=0): "Los operandos no son enteros positivos";
		
		//al mayor n�mero le resto el menor, por ser la resta en numero naturales
		if(primerOperando>=segundoOperando)	
			this.ultimoCalculo = primerOperando - segundoOperando;
		else 
			this.ultimoCalculo = segundoOperando - primerOperando;
		
		assert this.ultimoCalculo== primerOperando-segundoOperando : "La resta no se resolvio correctamente";
	}
	
	/**
	 * Metodo suma <br>
	 * <b>Pre: </b> ambos par�metros son enteros positivo<br>
	 * <b>Post: </b> Se ha resuelto la operaci�n y se ha almacenado en el atributo "ultimoCalculo"<br>
	 * */
	private void suma(Integer primerOperando, Integer segundoOperando) {
		assert (primerOperando>=0 && segundoOperando>=0): "Los operandos no son enteros positivos";
		
		this.ultimoCalculo = primerOperando + segundoOperando;
		
		assert this.ultimoCalculo== primerOperando+segundoOperando : "La suma no se resolvio correctamente";
	}


	/**
	 * Metodo traerResultado <br>
	 * <b>Post: </b> Se ha retornado el resultado que estaba almacenado en el atributo "ultimoCalculo"<br>
	 * En caso de no haberse realizado un calculo exitoso anteriormente se informa al m�todo invocante
	 * */
	public Integer traerResultado()throws ExceptionResultadoNull{
		if(this.huboCalculoExitoso==false)
			throw new ExceptionResultadoNull("Todav�a no se realizo un calculo exitoso");
		
		return this.ultimoCalculo;
	}

}
