/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultil.ultil;

/**
 *
 * @author Wesley Ramos
 * @author https://www.caelum.com.br/apostila-java-estrutura-dados/listas-ligadas/
 */
public class ListaE {
    private No primeira_pos;
    private No ultima_pos;
    private int totalItens;
    
    /* Metodo para adicionar no fim da lista
    * @param item Object - Para ser uma lista generica ela recebe como parametro um tipo objeto.
    */
    public void adicionaFim(Object item){
        // Verifica o total de itens na lista e se for 0 adiciona no inicio pois isso indica que a lista esta vazia
        if(this.totalItens == 0){
            this.adicionaInicio(item);
         
        } else{
            //caso não cria um novo no pega a ultima posição da lista e força a proxima posição a receber o novo no criado anteriormente
            No novo = new No(item);
            this.ultima_pos.setProxima(novo);
            novo.setAnterior(this.ultima_pos);
            this.ultima_pos = novo;
            this.totalItens++;
        }
    }
    /* Metodo para adicionar em qualquer posição na lista
     * @param pos int - A posição em que o elemento deve ser adicionado.
    * @param item Object - Para ser uma lista generica ela recebe como parametro um tipo objeto.
    */
    public void adiciona(int pos, Object item){
        if(pos == 0){ //no incio se a posição for 0
            this.adicionaInicio(item);
        }else if(pos == this.totalItens){ //no fim se a posição corresponder ao total de itens
            this.adicionaFim(item);
        } else{
            // se nenhuma das condições anteriores for satisfeita ele seta o no anterior como a posição fornecina menos 1
            No anterior = this.pegarNo(pos - 1);
            // seta a proxima como a posição depois da anterior
            No proxima = anterior.getProxima();
            /* cria um novo no
            * @param item Object - O objeto recebido
            * @param anterior.getProxima() no - Pega a proxima posição
            */
            No nova = new No(anterior.getProxima(),item);
            nova.setAnterior(anterior);
            anterior.setProxima(nova);
            proxima.setAnterior(nova);
            this.totalItens++;
        }
    }
    /* Metodo que obetem o objeto dado a posição
    * @param pos int - A posição em que o elemento a ser obtido
    * @return Object - Valor do objeto
    */
    public Object obter(int pos){
        return this.pegarNo(pos).getItem();
    }
    
    public void remover(int pos){
        if(!this.posOcupada(pos)){
            System.out.println("Index invalido");
        }
        if(pos == 0){
            this.removeInicio();
        } else if(pos == this.totalItens){
            this.removeFim();
        } else{
            No anterior = this.pegarNo(pos-1);
            No atual = anterior.getProxima();
            No proximo = atual.getProxima();
            
            anterior.setProxima(proximo);
            proximo.setAnterior(anterior);
            
            this.totalItens--;
        }
    }
    
    /*Metodo que retornao  tamanho da lista
     * @return int - Tamanho da lista
    */
    public int tamanho(){
        return this.totalItens - 1;
    }
    
    /*Metodo que verifica se ja existe aquele elemento na lista
    * @param item Object - O objeto a ser comparado
    * @return boolean - retorna verdadeiro ou falso
    */
    public boolean contem(Object item){
        // ele assume o No atual como a primeira posiçao
        No atual = this.primeira_pos;
        // encanto o no não estiver apontando pro nulo ele compara o objeto passado como parametro com o objeto guardado no no e se encontrar aquele objeto retorna verdadeiro caso não retorna falo.
        while(atual != null){
            if(atual.getItem().equals(item)){
               return true; 
            }
            atual = atual.getProxima();
        }
        return false;
    }
    
    
    public void adicionaInicio(Object item){
        if(this.totalItens == 0){
            //caso da lista vazia
            No nova = new No(item);
            this.primeira_pos = nova;
            this.ultima_pos = nova;   
        } else{
            No nova = new No(this.primeira_pos,item);
            this.primeira_pos.setAnterior(nova);
            this.primeira_pos = nova;
        }
        this.totalItens++;
    }
    /* Metodo para retornar o valor da lista em uma string.
    * @return String - Retorna a conversão do objeto na lista em string */
    @Override
    public String toString(){
        if(this.totalItens == 0){
            return "{}";
        }
        /*A classe StringBuilder permite criar e modificar strings de forma dinamica*/
        StringBuilder builder = new StringBuilder("{");
        No atual = primeira_pos;
        
        //percorrer ate o ultimo elemento da lista
        for(int i = 0; i < this.totalItens-1; i++){
            builder.append(atual.getItem());
            builder.append(", ");
            atual = atual.getProxima();
        }
        
        //utimo elemento
        builder.append(atual.getItem());
        builder.append("}");
        
        return builder.toString();
    }
    
    /* Metodo para retornar um booleano para a posição valida
    * @param pos int - Valor da posição.
    * @return boolean - retorna verdadeiro caso a condição seja satisfeita e falsa caso não */
    private boolean posOcupada(int pos){
        return pos >= 0 && pos < this.totalItens;
    }
    
    /* Metodo para retornar o no atual e mater a referencia para não peder a sequencia de objetos
    * @param pos int - Valor da posição atual do no.
    * @return No - Valor do no atual */
    private No pegarNo(int pos){
        if(!this.posOcupada(pos)){
            System.out.println("Index invalido");
        }
        
        No atual  = primeira_pos;
        for(int i =0; i < pos; i++){
            atual = atual.getProxima();
        }
        return atual;
    }
    
    public void removeInicio(){
        if(!this.posOcupada(0)){
            System.out.println("Index invalido");
        }
        this.primeira_pos = this.primeira_pos.getProxima();
        this.totalItens--;
        
        if(this.totalItens == 0){
            this.ultima_pos = null;
        }
    }
    
    public void removeFim(){
        if(!this.posOcupada(this.totalItens)){
            System.out.println("Index invalido");
        }
        if(this.totalItens == 1){
            this.removeInicio();
        } else{
            No penultima_pos = this.ultima_pos.getAnterior();
            penultima_pos.setProxima(null);
            this.ultima_pos = penultima_pos;
            this.totalItens--;
        }
    }
}
