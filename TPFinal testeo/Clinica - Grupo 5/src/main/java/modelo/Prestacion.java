package modelo;

import interf.IPrestacion;

import java.io.Serializable;
import java.util.Formatter;

public class Prestacion implements Serializable
{
	private static final long serialVersionUID = 79196461;
	private static long cont=1;
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	private IPrestacion prestacion;
	private int cantidad;
	private boolean factured=false;
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public boolean isFactured() {
		return factured;
	}

	public void setFactured(boolean factured) {
		this.factured = factured;
	}

	public Prestacion(IPrestacion prestacion, int cantidad)
	{
		this.prestacion = prestacion;
		this.cantidad = cantidad;
		this.id=Prestacion.cont++;
	}

	public String getPrestacion()
	{
		return this.prestacion.getPrestacion();
	}

	public double getValorUnitarioPrestacion()
	{
		return this.prestacion.getValorUnitarioPrestacion();
	}

	public String getClavePrimariaString()
	{
		return this.prestacion.getClavePrimariaString();
	}

	public int getCantidad()
	{
		return this.cantidad;
	}

	public double getSubTotal()
	{
		return this.cantidad * this.prestacion.getValorUnitarioPrestacion();
	}

	public String mostrarPrestacion()
	{

		StringBuilder sb = new StringBuilder();
		Formatter fmt = new Formatter(sb);
		fmt.format("%19s %17.2f %14d                 $ %8.2f %n", this.getClavePrimariaString(),this.getValorUnitarioPrestacion(),this.cantidad,this.getSubTotal());
		return sb.toString();
	}
}
