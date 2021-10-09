// 
// Decompiled by Procyon v0.5.36
// 

package excepciones;

public class NoEncontradoException extends Exception
{
    private Object dato;
    
    public NoEncontradoException(final Object dato, final String mensaje) {
        super(mensaje);
        this.dato = dato;
    }
    
    public Object getDato() {
        return this.dato;
    }
}