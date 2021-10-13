package persistencia;

import java.io.IOException;

import java.io.Serializable;

public interface IPersistencia <E>{
	
	void abrirInput (String nombre) throws IOException;
	
	void abrirOutput(String nombre) throws IOException;
	
	void cerrarInput(String nombre) throws IOException;
	
	void cerrarOutput(String nombre) throws IOException;
	
	void escribir(E objeto) throws IOException;
	
	E leer() throws IOException, ClassNotFoundException;
}
