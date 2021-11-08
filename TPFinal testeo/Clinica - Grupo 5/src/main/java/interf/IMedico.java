package interf;

public interface IMedico extends IPrestacion
{
	static final double INCREMENTO = 1.2;

	public abstract double getHonorarioBasico();

	public abstract String toString();

	public abstract String getNombre();
	
	public abstract String getDni();

}
