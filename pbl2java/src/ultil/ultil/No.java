/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultil.ultil;

/**
 *
 * @author Wesley Ramos
 * @author https://www.caelum.com.br/apostila-java-estrutura-dados/listas-ligadas
 */
public class No {
    private No proxima;
    private No anterior;
    private Object item;
    
    /* construtor
    * @param proxima No - proxima posição.
    * @param item Object - objeto.
    */
    public No(No proxima, Object item) {
        this.proxima = proxima;
        this.item = item;
    }
    
    /*Metodo que seta o objeto no No
    * @param item Object - objeto.
    */
    public No(Object item){
        this.item = item;
    }
    
    /* Metodo que seta  a proxima posição
    * @param proxima No - proxima posição.
    */
    public void setProxima(No proxima) {
        this.proxima = proxima;
    }
    
    /* Metodo para retornar o valor da proxima posição
    * @return No - Valor da proxima posição */
    public No getProxima() {
        return proxima;
    }
    
    /* Metodo para retornar o valor do objeto
    * @return Object - Valor do objeto */
    public Object getItem() {
        return item;
    }
    
    /* Metodo para retornar o valor da posição anterior
    * @return No - Valor da posição anterior */
    public No getAnterior() {
        return anterior;
    }
    
    /* Metodo que seta  a posição anterior
    * @param anterior No - posição anterior.
    */
    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }   
}
