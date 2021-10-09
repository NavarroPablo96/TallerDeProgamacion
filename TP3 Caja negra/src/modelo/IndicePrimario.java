// 
// Decompiled by Procyon v0.5.36
// 

package modelo;

import excepciones.DatoInvalidoException;
import java.util.Iterator;
import excepciones.NoEncontradoException;
import excepciones.ClaveYaExistenteException;
import java.util.TreeMap;

public class IndicePrimario<V extends I_Indexable>
{
    private TreeMap<Object, V> elementos;
    
    public IndicePrimario() {
        this.elementos = new TreeMap<Object, V>();
    }
    
    public void agregar(final V nuevo) throws ClaveYaExistenteException {
        if (this.contieneClave(nuevo.getClavePrimaria())) {
            throw new ClaveYaExistenteException(nuevo.getClavePrimaria());
        }
        this.elementos.put(nuevo.getClavePrimaria(), nuevo);
    }
    
    public void eliminar(final V elim) {
        this.elementos.remove(elim.getClavePrimaria());
    }
    
    public V buscarPorClavePrimaria(final Object clave) throws NoEncontradoException {
        if (!this.contieneClave(clave)) {
            throw new NoEncontradoException(clave, "No se encontr\u00c3³ la clave solicitada en el \u00c3\u00adndice.");
        }
        return this.elementos.get(clave);
    }
    
    public boolean contieneClave(final Object clave) {
        return this.elementos.containsKey(clave);
    }
    
    public boolean contieneValor(final V valor) {
        return this.elementos.containsValue(valor);
    }
    
    public Iterator<V> elementos() {
        return this.elementos.values().iterator();
    }
    
    public void modificarValor(final V elem, final V modif) {
        final Object aux = elem.getClavePrimaria();
        try {
            elem.modificarDatos(modif);
            if (!elem.getClavePrimaria().equals(aux)) {
                this.elementos.remove(aux);
                this.elementos.put(elem.getClavePrimaria(), elem);
            }
        }
        catch (DatoInvalidoException ex) {}
    }
    
    public Iterator<Object> clavesPrimarias() {
        return this.elementos.keySet().iterator();
    }
    
    public void setElementos(final TreeMap<Object, V> elementos) {
        this.elementos = elementos;
    }
    
    public TreeMap<Object, V> getElementos() {
        return this.elementos;
    }
}
