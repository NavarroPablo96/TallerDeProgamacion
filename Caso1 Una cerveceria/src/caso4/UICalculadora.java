package caso4;

import java.util.Scanner;

public class UICalculadora {
	NegocioCalculadora Negocio;
	
	public UICalculadora() {
		this.Negocio=new NegocioCalculadora();
		
	}
	
	public void Calcular(Integer PrimerOperando,Integer segundoOperando, String Operacion) {
		try {
			Negocio.Calcular(PrimerOperando,segundoOperando,Operacion);
		}
		catch (ExceptionParametrosIncorrectos e){
			mostrarEstado(e.getMessage());
		}
		catch (ExceptionResultadoImposible e){
			mostrarEstado(e.getMessage());
		}
	}
	
	public void mostrarEstado(String mensaje) {
		System.out.println("Error:"+mensaje);
	}
	
	public void mostrarResultado() {
		try {
			System.out.println("El resultado de la última operación exitosa es: "+ Negocio.traerResultado());
		}
		catch(ExceptionResultadoNull e) {
			System.out.println("Error:"+ e.getMessage());
		}
	}
	
	
	
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
