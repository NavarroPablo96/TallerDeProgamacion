// 
// Decompiled by Procyon v0.5.36
// 

package excepciones;

public class DiaInvalidoException extends Exception
{
    private Object dato;
    
    public DiaInvalidoException(final Object dato) {
        super("El d\u00c3\u00ada ingresado es inv\u00c3¡lido");
        this.dato = dato;
    }
    
    public Object getDato() {
        return this.dato;
    }
}
