package caso4;

/**
 * @author Agüero Sebastián, Mujica Juan Manuel, Navarro Pablo, Vucetic Ivo
 * <br>
 * Clase UICalculadora 
 * */

import java.util.Scanner;

public class UICalculadora {
	private NegocioCalculadora negocio;
	
	
	/**
	 * Constructor que crea un nuevo negocio, que es el único atributo que tiene
	 * <br>
	 * */
	public UICalculadora() {
		this.negocio=new NegocioCalculadora();
	}
	
	/**
	 * Metodo Calcular <br>
	 * <b>Pre: </b> No es null el atributo negocio<br>
	 * <b>Post: </b> Se ha realizado el cálculo indicado y se ha almacenado el resultado ó se ha notificado el debido error <br>
	 * Pasa a la capa de negocio los parámetros sin validar <br>
	 * Si sucede algún excepción se muestra <br>
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
	 * <b>Post: </b> Mostrará en la interfaz el mensaje recibido por parámetro<br>
	 * */
	public void mostrarEstado(String mensaje) {
		System.out.println("Error:"+mensaje);
	}
	
	/**
	 * Metodo mostrarResultado<br>
	 * <b>Pre: </b> No es null el atributo negocio<br>
	 * <b>Post: </b> Se ha mostrado el resultado de la ultima operación exitosa<br>
	 * ó en caso de no haber anteriormente una operación exitosa Muestra el error<br>
	 * */
	public void mostrarResultado() {
		assert this.negocio!=null : "el atributo Negocio de la Interfaz es null";
		try {
			System.out.println("El resultado de la última operación exitosa es: "+ negocio.traerResultado());
		}
		catch(ExceptionResultadoNull e) {
			System.out.println("Error:"+ e.getMessage());
		}
	}
	
	
	
	
	/**
	 * Metodo RealizarOperacion<br>
	 * <b>Pre: </b> Presupone que el usuario ingresa numeros o caraceteres respectivamente cuando lo solicita<br>
	 * <b>Post: </b> Son cargados los parámetros que son enviados al método cálcular<br>
	 * Finalizado éste método debería haber realiza y almacenado el cálculo, o informar el error que corresponda<br>
	 * */
	//Aca se ingresan los operandos sin validar
	public void RealizarOperacion() {
		Scanner operandos = new Scanner(System.in);
		Scanner caracter = new Scanner(System.in);

		Integer op1,op2;
		String operacion;
		
		System.out.println("Ingrese el caracter correspondiente para una operación\t'+'\t'-'\t'*'\t'/'");
		operacion=caracter.next();
		System.out.println("Ingrese dos número enteros y positivos");
		op1=operandos.nextInt();
		op2=operandos.nextInt();
		
		operandos.close();
		caracter.close();
		
		Calcular(op1,op2,operacion);
	}

}
