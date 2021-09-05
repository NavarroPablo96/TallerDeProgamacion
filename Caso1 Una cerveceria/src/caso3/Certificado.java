package caso3;

import java.util.ArrayList;
import java.util.Iterator;

import excepciones.CertificadoNoPedidoException;
import excepciones.LegajoInexistenteException;
import excepciones.MateriaInexistenteException;
import excepciones.MateriaNoAprobadaException;

/**
 * @author Grupo 6
 *Representa la estructura de un certificado para un alumno, con los datos identificatorios, como el nombreyapellido y legajo,<br>
 *también se lista las materias con sus respectivas notas y la condicion del alumno.
 */
public class Certificado
{
	private String nombreyapellido;
	private int legajo;
	private ArrayList<Materia> materias;
	private String condicion;
	private boolean existe_legajo, cert_pedido;
	
	/**
	 * Genera un certificado base, sin datos.
	 * <b>pos:<\b> Se genera un certificado vacio. Tambien se inicializan variables como la referencia a las materias cursadas por
	 * un alumno e iniciliza booleanas de existencia de un legajo dado y si se pide hacer un certificado para su posterior uso.
	 */
	public Certificado()
	{
		this.nombreyapellido = "";
		this.condicion = "";
		this.legajo =0;
		this.materias = new  ArrayList<Materia>();
		this.existe_legajo = false; this.cert_pedido = false;
	}

	/**
	 * Clase que prepara el proceso para armar un nuevo certificado.
	 * <b>pos: Se actualizan las variables internas con los datos del alumno a certificar.<\b> 
	 * @param legajo: Numero entero de 4 digitos que identifica a un alumno.
	 * @throws LegajoInexistenteException: Cuando no se encuentra al alumno dentro de la lista de la institucion. Se lo informa a la capa que lo llamó.
	 */
	public void pedirCertificado(Integer legajo) throws LegajoInexistenteException {
		Alumno alumno_a_cert = null;
		
		assert legajo>=0 && this.legajo<=9999: "El legajo tiene que ser un numero de 4 digitos";
		
		alumno_a_cert = Institucion.getInstance().buscaAlumno(legajo);
		
		if(alumno_a_cert!=null) {
			this.existe_legajo = true;
			this.nombreyapellido = alumno_a_cert.getNombreyapellido();
			this.legajo = alumno_a_cert.getLegajo();
			this.materias = alumno_a_cert.getMaterias();
		}
		else
			throw new LegajoInexistenteException("El legajo no existe!");
		
		this.cert_pedido = true;
	}
	
	
	/**
	 * Genera el certificado de un alumno. Cuenta con los datos identificatorios(nombre,apellido y legajo), listado de materias junto
	 * con sus notas y estado de cada una y por ultimo la condicion posterior a la cursada.
	 * <b>pre:<\b> El alumno existe.
	 * <b>pos:<\b> Se genera el certificado con los datos del alumno. 
	 * @return String del certificado.
	 * @throws CertificadoNoPedidoException: Cuando no se pidió hacer ningún certificado, por ende no va haber datos para cargar a la estructura.
	 * se lo informa a la capa que lo llamó.
	 */
	public String armaCertificado() throws CertificadoNoPedidoException{
		byte cont = 0;
		StringBuilder st = new StringBuilder();
		
		if(!cert_pedido)
			throw new CertificadoNoPedidoException("Primero pida un certificado");
		else {
			st.append(this.toString());
		
			for(Materia materia: this.materias) {
				st.append(materia.toString());
				if(materia.getEstado().contentEquals("a cursar"))
					cont++;
			}
			if(cont >= 2)
				this.condicion = "Regular";
			else
				this.condicion = "Irregular";
		
			st.append(this.condicion);
		
			return st.toString();
		}
	}
	
	@Override
	public String toString()
	{
		return "--------Certificado de alumno--------"
				+ "Nombre y Apellido = " + nombreyapellido + ", Legajo=" + legajo;
	}
	

	/**
	 * Devuelve el nombre y apellido de un alumno.
	 * <b>pos:Nombre y apellido<\b> 
	 * @return String
	 * @throws LegajoInexistenteException: Arroja si el legajo del alumno no existe, para informar a la capa que lo llamó.
	 * @throws CertificadoNoPedidoException Arroja si no se pidió certificado, para informar a la capa que lo llamó.
	 */
	public String traerApellidoyNombre() throws LegajoInexistenteException, CertificadoNoPedidoException{
		if(!this.cert_pedido)
		    throw new CertificadoNoPedidoException("No se pidio hacer ningun certificado");
		else if(!this.existe_legajo) {
			throw new LegajoInexistenteException("No existe el legajo");
		}
		return this.nombreyapellido;
	}
	
	/**
	 * Devuelve el estado de una materia en particular del listado de un alumno.
	 * <b>pre:<\b> materia != null y !materia.equals("")
	 * <b>pos:<\b> Se devuelve el estado de la materia. 
	 * @param materia: Representa una materia institucional. 
	 * @return String del estado.
	 * @throws CertificadoNoPedidoException:Arroja si no se pidió certificado, para informar a la capa que lo llamó.
	 * @throws LegajoInexistenteException:Arroja si el legajo del alumno no existe, para informar a la capa que lo llamó.
	 * @throws MateriaInexistenteException:Arroja si la materia no se conoce del listado del alumno, para informar a la capa que lo llamó.
	 */
	public String traerEstado(String materia) throws CertificadoNoPedidoException, LegajoInexistenteException, MateriaInexistenteException {
		Materia mat = null;
		Alumno alumno = null;
		
		if(!this.cert_pedido)
		    throw new CertificadoNoPedidoException("No se pidio hacer ningun certificado");
		else if(!this.existe_legajo) {
			throw new LegajoInexistenteException("No existe el legajo");
		}
		else {
			alumno = Institucion.getInstance().buscaAlumno(legajo);
			mat = alumno.buscaMateria(materia);
			if(mat == null)
				throw new MateriaInexistenteException("No existe La materia a buscar en el alumno");
		}
		
		return mat.getEstado();
	}
	
	/**
	 * Devuelve la nota de una materia APROBADA de un alumno.
	 * <b>pos:<\b> Nota de la materia.
	 * @param materia: Representa una materia institucional.
	 * @return Devuelve la nota de la materia, caso contrario arroja una exception del tipo MateriaNoAprobadaException. 
	 * @throws CertificadoNoPedidoException:Arroja si no se pidió certificado, para informar a la capa que lo llamó.
	 * @throws LegajoInexistenteException:Arroja si el legajo del alumno no existe, para informar a la capa que lo llamó.
	 * @throws MateriaInexistenteException:Arroja si la materia no se conoce del listado del alumno, para informar a la capa que lo llamó. 
	 */
	public byte traerNota(String materia) throws CertificadoNoPedidoException, LegajoInexistenteException, MateriaInexistenteException {
		Materia mat = null;
		Alumno alumno = null;
		
		assert materia != null && materia.equals(""): "Datos erroneos de ingreso";
		
		if(!this.cert_pedido)
		    throw new CertificadoNoPedidoException("No se pidio hacer ningun certificado");
		else if(!this.existe_legajo) {
			throw new LegajoInexistenteException("No existe el legajo");
		}
		else {
			alumno = Institucion.getInstance().buscaAlumno(legajo);
			mat = alumno.buscaMateria(materia);
			if(mat == null)
				throw new MateriaInexistenteException("No existe La materia a buscar en el alumno");
			else if(!mat.getEstado().equals("aprobada"))
				throw new MateriaNoAprobadaException("Tiene que estar aprobada la materia para dar la nota");
			}
		return mat.getNota();
	}
	
	/**
	 * Devuelve la condicion de regularidad o irregularidad de un alumno.
	 * <b>pos:<\b> Condicion del alumno.
	 * @return String.
	 * @throws CertificadoNoPedidoException:Arroja si no se pidió certificado, para informar a la capa que lo llamó.
	 * @throws LegajoInexistenteException:Arroja si el legajo del alumno no existe, para informar a la capa que lo llamó.
	 */
	public String traerCondición() throws CertificadoNoPedidoException, LegajoInexistenteException{
		if(!this.cert_pedido)
		    throw new CertificadoNoPedidoException("No se pidio hacer ningun certificado");
		else if(!this.existe_legajo) {
			throw new LegajoInexistenteException("No existe el legajo");
		}
		return this.condicion;
	}
}
