package persistencia;

import java.io.IOException;

/**
 * @author Ivo Vucetic,Juan Manuel Mujica,Pablo Navarro,Sebastián Agüero.<br>
 *Interfaz que representa los metodos para lograr la persistencia.
 */
public interface IPersistencia <E>{
	
	void abrirInput (String nombre) throws IOException;
	
	void abrirOutput(String nombre) throws IOException;
	
	void cerrarInput() throws IOException;
	
	void cerrarOutput() throws IOException;
	
	void escribir(E objeto) throws IOException;
	
	E leer() throws IOException, ClassNotFoundException;
}
