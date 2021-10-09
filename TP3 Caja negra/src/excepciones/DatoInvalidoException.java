// 
// Decompiled by Procyon v0.5.36
// 

package excepciones;

public class DatoInvalidoException extends Exception
{
    private Object dato;
    
    public DatoInvalidoException(final Object dato, final String mensaje) {
        super(mensaje);
        this.dato = dato;
    }
    
    public Object getDato() {
        return this.dato;
    }
}