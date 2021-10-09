// 
// Decompiled by Procyon v0.5.36
// 

package excepciones;

public class ClaveYaExistenteException extends Exception
{
    private Object clave;
    
    public ClaveYaExistenteException(final Object clave) {
        super("La clave del elemento a agregar ya se encuentra en la colecci\u00c3³n.");
        this.clave = clave;
    }
    
    public Object getClave() {
        return this.clave;
    }
}
