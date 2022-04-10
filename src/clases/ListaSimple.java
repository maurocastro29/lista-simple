/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import javax.swing.JOptionPane;

/**
 *
 * @author Mauricio Castro
 */
public class ListaSimple {
    private Nodo ptr;

    public ListaSimple() {
        this.ptr = null;
    }

    public Nodo getPtr() {
        return ptr;
    }

    public void setPtr(Nodo ptr) {
        this.ptr = ptr;
    }
    
    public boolean isVacia(){
        return this.getPtr() == null;
    }
    
    public Nodo buscarNodo(int codigo){
        if(!this.isVacia()){
            Nodo aux = this.getPtr();
            while(aux!=null){
                if(aux.getDato() == codigo){
                    return aux;
                }
                aux = aux.getSgt();
            }
        }
        return null;
    }

    public void insertarInicio(Nodo nodo){
        if(this.isVacia()){
            this.setPtr(nodo);
            JOptionPane.showMessageDialog(null,"Nodo insertado");
        }else{
            nodo.setSgt(this.getPtr());
            this.setPtr(nodo);
            JOptionPane.showMessageDialog(null,"Nodo insertado");
        }
    }
    public void insertarFinal(Nodo nodo){
        if(this.isVacia()){
            this.setPtr(nodo);
            JOptionPane.showMessageDialog(null,"Nodo insertado");
        }else{
            Nodo aux = this.getPtr();
            while(aux.getSgt() != null){
                aux = aux.getSgt();
            }
            aux.setSgt(nodo);
            JOptionPane.showMessageDialog(null,"Nodo insertado");
        }
    }
    
    public void insertarAntes(Nodo nodo, int dato){
        if(this.isVacia()){
           this.setPtr(nodo);
           JOptionPane.showMessageDialog(null,"Nodo insertado");
        }else{
            Nodo aux = buscarNodo(dato);
            if(aux != null){
                if(aux == this.getPtr()){
                    nodo.setSgt(this.getPtr());
                    this.setPtr(nodo);
                }else{
                    Nodo aux2 = this.getPtr();
                    while(aux2.getSgt()!=aux){
                        aux2 = aux2.getSgt();
                    }
                    nodo.setSgt(aux);
                    aux2.setSgt(nodo);
                }
                JOptionPane.showMessageDialog(null,"Nodo insertado");
            }else{
                JOptionPane.showMessageDialog(null, "Nodo no insertado, no se encontro el dato a buscar.");
            }
        }
    }
    
    public void insertarDespues(Nodo nodo, int dato){
        if(this.isVacia()){
            this.setPtr(nodo);
            JOptionPane.showMessageDialog(null,"Nodo insertado");
        }else{
            Nodo aux = buscarNodo(dato);
            if(aux!=null){
                nodo.setSgt(aux.getSgt());
                aux.setSgt(nodo);
                JOptionPane.showMessageDialog(null,"Nodo insertado");
            }else{
                JOptionPane.showMessageDialog(null, "Nodo no insertado, no se encontro el dato a buscar.");
            }
        }
    }
    
    public void listar(){
        if(!this.isVacia()){
            String datos = "";
            Nodo aux = this.getPtr();
            while(aux!=null){
                datos += "["+aux.getDato()+"]->";
                aux = aux.getSgt();
            }
            datos += "||";
            JOptionPane.showMessageDialog(null, datos);
        }else{
            JOptionPane.showMessageDialog(null,"Lista vacia");
        }
    }
    
    public void ordenarDescendente(){
        if(this.isVacia()){
            JOptionPane.showMessageDialog(null, "Lista vacia");
        }else{
            Nodo aux = this.getPtr();
            Nodo aux2 = this.getPtr().getSgt();
            while(aux.getSgt()!=null && aux2!=null){
                if(aux.getDato() > aux2.getDato()){
                    if(aux == this.getPtr()){
                        aux.setSgt(aux2.getSgt());
                        aux2.setSgt(aux);
                        this.setPtr(aux2);
                        aux2 = aux.getSgt();
                    }else{
                        Nodo aux3 = this.getPtr();
                        while(aux3.getSgt()!=aux){
                            aux3=aux3.getSgt();
                        }
                        aux3.setSgt(aux2);
                        aux.setSgt(aux2.getSgt());
                        aux2.setSgt(aux);
                        aux2 = aux.getSgt();
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Lista ordenada exitosamente");
        }
    }
    public void ordenarAscendente(){
        if(this.isVacia()){
            JOptionPane.showMessageDialog(null, "Lista vacia");
        }else{
            Nodo aux = this.getPtr();
            Nodo aux2 = this.getPtr().getSgt();
            while(aux.getSgt()!=null && aux2!=null){
                if(aux.getDato() < aux2.getDato()){
                    if(aux == this.getPtr()){
                        aux.setSgt(aux2.getSgt());
                        aux2.setSgt(aux);
                        this.setPtr(aux2);
                        aux2 = aux.getSgt();
                    }else{
                        Nodo aux3 = this.getPtr();
                        while(aux3.getSgt()!=aux){
                            aux3=aux3.getSgt();
                        }
                        aux3.setSgt(aux2);
                        aux.setSgt(aux2.getSgt());
                        aux2.setSgt(aux);
                        aux2 = aux.getSgt();
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Lista ordenada exitosamente");
        }
    }
    
    public boolean editarNodo(int datoNuevo, int datoBuscar){
        if(!this.isVacia()){
            Nodo aux = buscarNodo(datoBuscar);
            if(aux!=null){
                aux.setDato(datoNuevo);
                return true;
            }
        }
        return false;
    }
    
    public boolean eliminarNodo(int datoBuscar){
        if(!this.isVacia()){
            Nodo elim = buscarNodo(datoBuscar);
            if(elim!=null){
                if(elim==this.getPtr()){
                    this.setPtr(this.getPtr().getSgt());
                    elim.setSgt(null);
                }else{
                    Nodo aux2 = this.getPtr();
                    while(aux2.getSgt()!=elim){
                        aux2 = aux2.getSgt();
                    }
                    aux2.setSgt(elim.getSgt());
                    elim.setSgt(null);
                }
                return true;
            }
        }
        return false;
    }
}
