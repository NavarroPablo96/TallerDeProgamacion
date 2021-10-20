package persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


/**
 * @author Ivo Vucetic,Juan Manuel Mujica,Pablo Navarro,Sebastián Agüero.<br>
 *Clase representa la persistencia binaria. Implementa IPersistencia.
 */
public class Persistencia implements IPersistencia<Serializable> {
	
    private FileOutputStream fileoutput;
    private FileInputStream fileinput;
    private ObjectOutputStream objectoutput;
    private ObjectInputStream objectinput;

    /**
	 * Método que permite abrir un archivo binario para su lectura.<br>
	 * <b>Pre: </b> El parámetro debe ser distinto de null y distinto de una cadena vacia.<br>
	 * @param nombre: Parámetro de tipo String que representa el nombre del archivo a abrir.<br>
	 * @throws IOException: Es lanzada al ocurrir una interrupción al intentar abrir un archivo.
	 */
    public void abrirInput(String nombre) throws IOException
    {
        fileinput = new FileInputStream(nombre);
        objectinput = new ObjectInputStream(fileinput);
    }

    /**
	 * Método que permite abrir un archivo binario para su escritura.<br>
	 * <b>Pre: </b> El parámetro debe ser distinto de null y distinto de una cadena vacia.<br>
	 * @param nombre: Parámetro de tipo String que representa el nombre del archivo a abrir.<br>
	 * @throws IOException: Es lanzada al ocurrir una interrupción al intentar abrir un archivo.
	 */
    public void abrirOutput(String nombre) throws IOException
    {
        fileoutput = new FileOutputStream(nombre);
        objectoutput = new ObjectOutputStream(fileoutput);
    }

    /**
	 * Método que permite cerrar un archivo abierto previamente para su escritura.<br>
	 * @throws IOException: Es lanzada al ocurrir una interrupción al intentar cerrar un archivo.
	 */
    public void cerrarOutput() throws IOException
    {
        if (objectoutput != null)
            objectoutput.close();

    }

    /**
   	 * Método que permite cerrar un archivo abierto previamente para su lectura.<br>
   	 * @throws IOException: Es lanzada al ocurrir una interrupción al intentar cerrar un archivo.
   	 */
    public void cerrarInput() throws IOException
    {
        if (objectinput != null)
            objectinput.close();

    }

    /**
	 * Método que permite serializar un objeto de tipo Serializable.<br>
	 * <b>Pre: </b> El parámetro debe ser distinto de null.<br>
	 * <b>Post: </b> Serializará la clase enviada por parámetro en el archivo abierto.<br>
	 * @param p: Parámetro de tipo Serializable que representa el objeto a serializar.
	 * @throws IOException: Es lanzada al ocurrir una interrupción al intentar escribir un archivo.
	 */
    public void escribir(Serializable p) throws IOException
    {
        if (objectoutput != null)
            objectoutput.writeObject(p);
    }

    /**
	 * Método que permite deserializar un objeto.<br>
	 * @throws IOException: Es lanzada al ocurrir una interrupción al intentar leer un archivo.
	 * @throws ClassNotFoundException: Es lanzada al intentar cargar una clase y esta no se encuentra.
	 */
    public Serializable leer() throws IOException, ClassNotFoundException
    {
        Serializable p = null;
        if (objectinput != null)
            p = (Serializable) objectinput.readObject();
        return p;
    }
}
