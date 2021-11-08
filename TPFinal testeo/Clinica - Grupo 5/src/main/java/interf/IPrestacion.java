package interf;

public interface IPrestacion {

	public String getPrestacion(); //retorna un string de la forma TIPO DE PRESTACION + CLAVE PRIMARIA. Por ej. tipo de prestacion:Medico y clave:Juan Gomez ---> Devuelve Medico: Juan Gomez
	public double getValorUnitarioPrestacion();
	public String getClavePrimariaString(); //retorna el valor de la prestacion -----> nombre del medico, numero de habitacion, etc
	
}
