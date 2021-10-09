// 
// Decompiled by Procyon v0.5.36
// 

package modelo;

import excepciones.DatoInvalidoException;

public interface I_Indexable
{
    Object getClavePrimaria();
    
    Object getClaveSecundaria();
    
    void modificarDatos(final I_Indexable p0) throws DatoInvalidoException;
}