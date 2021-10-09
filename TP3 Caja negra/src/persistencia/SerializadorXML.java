// 
// Decompiled by Procyon v0.5.36
// 

package persistencia;

import java.beans.XMLDecoder;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import modelo.Cursada;
import modelo.Asignatura;
import modelo.Profesor;
import modelo.Alumno;
import java.beans.XMLEncoder;
import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import modelo.Sistema;

public abstract class SerializadorXML
{
    private static final String ARCHIVO = "Sistema.xml";
    
    public static void guardar(final Sistema sistema) {
        try {
            final XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("Sistema.xml")));
            encoder.writeObject(sistema);
            encoder.writeObject(Alumno.getCANT_ALUMNOS());
            encoder.writeObject(Profesor.getCANT_PROFESORES());
            encoder.writeObject(Asignatura.getCANT_ASIGNATURAS());
            encoder.writeObject(Cursada.getCANT_CURSADAS());
            encoder.close();
        }
        catch (FileNotFoundException e) {
            throw new InternalError("Error fatal al tratar de guardar el sistema");
        }
    }
    
    public static Sistema cargar() {
        Sistema res;
        try {
            final XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("Sistema.xml")));
            res = (Sistema)decoder.readObject();
            Alumno.setCANT_ALUMNOS((int)decoder.readObject());
            Profesor.setCANT_PROFESORES((int)decoder.readObject());
            Asignatura.setCANT_ASIGNATURAS((int)decoder.readObject());
            Cursada.setCANT_CURSADAS((int)decoder.readObject());
            decoder.close();
        }
        catch (FileNotFoundException e) {
            res = new Sistema();
        }
        return res;
    }
}
