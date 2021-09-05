package caso3;

import java.util.ArrayList;
import java.util.Iterator;

import excepciones.CertificadoNoPedidoException;
import excepciones.LegajoInexistenteException;
import excepciones.MateriaInexistenteException;
import excepciones.MateriaNoAprobadaException;

public class Certificado
{
	private String nombreyapellido;
	private int legajo;
	private ArrayList<Materia> materias;
	private String condicion;
	private boolean existe_legajo, cert_pedido;
	
	/**
	 * Genera un certificado base, sin datos.
	 */
	public Certificado()
	{
		this.nombreyapellido = "";
		this.condicion = "";
		this.legajo =0;
		this.materias = new  ArrayList<Materia>();
		this.existe_legajo = false; this.cert_pedido = false;
	}

	public void pedirCertificado(Integer legajo) throws LegajoInexistenteException {
		Alumno alumno_a_cert = null;
		
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
	

	public String traerApellidoyNombre() throws LegajoInexistenteException, CertificadoNoPedidoException{
		if(!this.cert_pedido)
		    throw new CertificadoNoPedidoException("No se pidio hacer ningun certificado");
		else if(!this.existe_legajo) {
			throw new LegajoInexistenteException("No existe el legajo");
		}
		return this.nombreyapellido;
	}
	
	public String traerEstado(String materia) throws CertificadoNoPedidoException, LegajoInexistenteException, MateriaInexistenteException {
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
		}
		
		return mat.getEstado();
	}
	
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
	
	public String traerCondición() throws CertificadoNoPedidoException, LegajoInexistenteException{
		if(!this.cert_pedido)
		    throw new CertificadoNoPedidoException("No se pidio hacer ningun certificado");
		else if(!this.existe_legajo) {
			throw new LegajoInexistenteException("No existe el legajo");
		}
		return this.condicion;
	}
}
