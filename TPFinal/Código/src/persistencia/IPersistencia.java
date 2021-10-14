package persistencia;

import java.io.IOException;
import java.util.Set;

import modelo.Factura;


public interface IPersistencia <E>{
	
	void abrirInput (String nombre) throws IOException;
	
	void abrirOutput(String nombre) throws IOException;
	
	void cerrarInput() throws IOException;
	
	void cerrarOutput() throws IOException;
	
	void escribir(E objeto) throws IOException;
	
	E leer() throws IOException, ClassNotFoundException;
}
