package caso3;

import java.util.ArrayList;
import java.util.Iterator;

import excepciones.CertificadoNoPedidoException;
import excepciones.LegajoInexistenteException;

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

	public String pedirCertificado(Integer legajo) throws LegajoInexistenteException {
		Alumno alumno_a_cert = null;
		
		this.cert_pedido = true;
		
		alumno_a_cert = Institucion.getInstance().buscaAlumno(legajo);
		
		if(alumno_a_cert!=null) {
			this.existe_legajo = true;
			this.nombreyapellido = alumno_a_cert.getNombreyapellido();
			this.legajo = alumno_a_cert.getLegajo();
			this.materias = alumno_a_cert.getMaterias();
		}
		else
			throw new LegajoInexistenteException("El legajo no existe!");
		
		return armaCertificado(); 	
	}
	
	
	private String armaCertificado() {
		byte cont = 0;
		StringBuilder st = new StringBuilder();
		
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
		else
			return this.nombreyapellido;
	}
	
	public String traerEstado(String materia) throws CertificadoNoPedidoException, LegajoInexistenteException {
		Iterator<Materia> it_materia = this.materias.iterator();
		boolean encuent_mat = false;
		Materia mat_act = null;
		
		assert materia != null && materia.equals(""): "Datos erroneos de ingreso";
		
		if(!this.cert_pedido)
		    throw new CertificadoNoPedidoException("No se pidio hacer ningun certificado");
		else if(!this.existe_legajo) {
			throw new LegajoInexistenteException("No existe el legajo");
		}
		else 
		{
			while(it_materia.hasNext() && !encuent_mat)
			{
				mat_act = it_materia.next();
				if(mat_act.getNombre().equals(materia))
					encuent_mat = true;
			}
		}
		
		return "hola";
	}
	
	public String traerNota(String Materia) {
		return "hola";
	}
	
	public String traerCondición() {
		return "hola";
	}
}
