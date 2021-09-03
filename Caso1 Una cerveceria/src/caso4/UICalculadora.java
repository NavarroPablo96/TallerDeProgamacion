package caso4;

/**
 * @author Ag�ero Sebasti�n, Mujica Juan Manuel, Navarro Pablo, Vucetic Ivo
 * <br>
 * Clase UICalculadora 
 * */

import java.util.Scanner;

public class UICalculadora {
	private NegocioCalculadora negocio;
	
	
	/**
	 * Constructor que crea un nuevo negocio, que es el �nico atributo que tiene
	 * <br>
	 * */
	public UICalculadora() {
		this.negocio=new NegocioCalculadora();
	}
	
	/**
	 * Metodo Calcular <br>
	 * <b>Pre: </b> No es null el atributo negocio<br>
	 * <b>Post: </b> Se ha realizado el c�lculo indicado y se ha almacenado el resultado � se ha notificado el debido error <br>
	 * Pasa a la capa de negocio los par�metros sin validar <br>
	 * Si sucede alg�n excepci�n se muestra <br>
	 * 
	 * */
	public void Calcular(Integer PrimerOperando,Integer segundoOperando, String Operacion) {
		
		assert this.negocio!=null : "el atributo Negocio de la Interfaz es null";
		try {
			negocio.Calcular(PrimerOperando,segundoOperando,Operacion);
		}
		catch (ExceptionParametrosIncorrectos e){
			mostrarEstado(e.getMessage());
		}
		catch (ExceptionResultadoImposible e){
			mostrarEstado(e.getMessage());
		}
	}
	
	/**
	 * Metodo mostrarEstado <br>
	 * 
	 * <b>Post: </b> Mostrar� en la interfaz el mensaje recibido por par�metro<br>
	 * */
	public void mostrarEstado(String mensaje) {
		System.out.println("Error:"+mensaje);
	}
	
	/**
	 * Metodo mostrarResultado<br>
	 * <b>Pre: </b> No es null el atributo negocio<br>
	 * <b>Post: </b> Se ha mostrado el resultado de la ultima operaci�n exitosa<br>
	 * � en caso de no haber anteriormente una operaci�n exitosa Muestra el error<br>
	 * */
	public void mostrarResultado() {
		assert this.negocio!=null : "el atributo Negocio de la Interfaz es null";
		try {
			System.out.println("El resultado de la �ltima operaci�n exitosa es: "+ negocio.traerResultado());
		}
		catch(ExceptionResultadoNull e) {
			System.out.println("Error:"+ e.getMessage());
		}
	}
	
	
	
	
	/**
	 * Metodo RealizarOperacion<br>
	 * <b>Pre: </b> Presupone que el usuario ingresa numeros o caraceteres respectivamente cuando lo solicita<br>
	 * <b>Post: </b> Son cargados los par�metros que son enviados al m�todo c�lcular<br>
	 * Finalizado �ste m�todo deber�a haber realiza y almacenado el c�lculo, o informar el error que corresponda<br>
	 * */
	//Aca se ingresan los operandos sin validar
	public void RealizarOperacion() {
		Scanner operandos = new Scanner(System.in);
		Scanner caracter = new Scanner(System.in);

		Integer op1,op2;
		String operacion;
		
		System.out.println("Ingrese el caracter correspondiente para una operaci�n\t'+'\t'-'\t'*'\t'/'");
		operacion=caracter.next();
		System.out.println("Ingrese dos n�mero enteros y positivos");
		op1=operandos.nextInt();
		op2=operandos.nextInt();
		
		operandos.close();
		caracter.close();
		
		Calcular(op1,op2,operacion);
	}

}
