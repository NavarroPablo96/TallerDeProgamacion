// 
// Decompiled by Procyon v0.5.36
// 

package modelo;

import java.util.Iterator;
import excepciones.NoEncontradoException;
import excepciones.ClaveYaExistenteException;
import java.util.ArrayList;
import java.util.TreeMap;

public class IndiceDoble<V extends I_Indexable>
{
    private IndicePrimario<V> indice1;
    private TreeMap<Object, ArrayList<V>> indice2;
    
    public IndiceDoble() {
        this.indice1 = new IndicePrimario<V>();
        this.indice2 = new TreeMap<Object, ArrayList<V>>();
    }
    
    public void agregar(final V nuevo) throws ClaveYaExistenteException {
        this.indice1.agregar(nuevo);
        if (!this.contieneClaveSecundaria(nuevo.getClaveSecundaria())) {
            this.indice2.put(nuevo.getClaveSecundaria(), new ArrayList<V>());
        }
        this.indice2.get(nuevo.getClaveSecundaria()).add(nuevo);
    }
    
    public void eliminar(final V elim) {
        this.indice1.eliminar(elim);
        final ArrayList<V> aux = this.indice2.get(elim.getClaveSecundaria());
        aux.remove(elim);
        if (aux.isEmpty()) {
            this.indice2.remove(elim.getClaveSecundaria());
        }
    }
    
    public V buscarPorClavePrimaria(final Object clave) throws NoEncontradoException {
        return this.indice1.buscarPorClavePrimaria(clave);
    }
    
    public Iterator<V> buscarPorClaveSecundaria(final Object clave) throws NoEncontradoException {
        if (!this.contieneClaveSecundaria(clave)) {
            throw new NoEncontradoException(clave, "Clave no encontrada en el \u00c3\u00adndice.");
        }
        return this.indice2.get(clave).iterator();
    }
    
    public boolean contieneClavePrimaria(final Object clave) {
        return this.indice1.contieneClave(clave);
    }
    
    public boolean contieneClaveSecundaria(final Object clave) {
        return this.indice2.containsKey(clave);
    }
    
    public boolean contieneValor(final V valor) {
        return this.indice1.contieneValor(valor);
    }
    
    public Iterator<V> elementosPorClavePrimaria() {
        return this.indice1.elementos();
    }
    
    public Iterator<ArrayList<V>> elementosPorClaveSecundaria() {
        return this.indice2.values().iterator();
    }
    
    public void modificarValor(final V elem, final V modif) {
        final Object claveAux = elem.getClaveSecundaria();
        this.indice1.modificarValor(elem, modif);
        if (!elem.getClaveSecundaria().equals(claveAux)) {
            final ArrayList<V> cubeta = this.indice2.get(claveAux);
            cubeta.remove(elem);
            if (cubeta.isEmpty()) {
                this.indice2.remove(claveAux);
            }
            if (!this.contieneClaveSecundaria(elem.getClaveSecundaria())) {
                this.indice2.put(elem.getClaveSecundaria(), new ArrayList<V>());
            }
            this.indice2.get(elem.getClaveSecundaria()).add(elem);
        }
    }
    //IndicePrimario<V> 
    public Iterator<?> clavesPrimarias() {
        return this.indice1.clavesPrimarias();
    }
    
    public Iterator<Object> clavesSecundarias() {
        return this.indice2.keySet().iterator();
    }
    
    public void setIndice1(final IndicePrimario<V> indice1) {
        this.indice1 = indice1;
    }
    
    public IndicePrimario<V> getIndice1() {
        return this.indice1;
    }
    
    public void setIndice2(final TreeMap<Object, ArrayList<V>> indice2) {
        this.indice2 = indice2;
    }
    
    public TreeMap<Object, ArrayList<V>> getIndice2() {
        return this.indice2;
    }
}