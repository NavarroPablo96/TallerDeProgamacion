package modelo;
import java.io.Serializable;
import java.util.HashMap;

public class HistoriaClinica implements Serializable {
    private static final long serialVersionUID = 182646765;
    private String nombre;
    private String apellido;
    private String dni;
    HashMap<Long,Prestacion> prestacions = new HashMap<>();

    public HashMap<Long, Prestacion> getPrestacions() {
        return prestacions;
    }

    public void setPrestacions(HashMap<Long, Prestacion> prestacions) {
        this.prestacions = prestacions;
    }

    public HistoriaClinica(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public void addPrestacion(Prestacion prestacion){
        this.prestacions.put(prestacion.getId(),prestacion);
    }

    public void eliminaPrestacion(long id){
        this.prestacions.remove(id);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
