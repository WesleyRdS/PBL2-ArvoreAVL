/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultil;

import model.Livro;

/**
 *
 * @author Wesley Ramos
 */
public class No {
    private Livro valor;
    private No ramoEsquerdo;
    private No ramoDireito;
    private int alturaE;
    private int alturaD;

    /* construtor
    * @param valor Livro - livro.
    * @param ramoEsquerdo No - lado esquerdo da arvore.
    * @param ramoDireito No - lado direito da arvore.
    */
    public No(Livro valor, No ramoEsquerdo, No ramoDireito) {
        this.valor = valor;
        this.ramoEsquerdo = ramoEsquerdo;
        this.ramoDireito = ramoDireito;

    }
    
    /* Metodo para retornar o valor do No
    * @return Livro - livro*/
    public Livro getValor() {
        return valor;
    }
    /*Metodo que seta o valor no No
    * @param valor Livro - livro.
    */
    public void setValor(Livro valor) {
        this.valor = valor;
    }
    /* Metodo para retornar o valor do lado esquerdo do No
    * @return No - No a esquerda*/
    public No getRamoEsquerdo() {
        return ramoEsquerdo;
    }
    /*Metodo que seta o valor no No esquerdo
    * @param ramoEsquerdo No - No a esquerda.
    */
    public void setRamoEsquerdo(No ramoEsquerdo) {
        this.ramoEsquerdo = ramoEsquerdo;
    }
    /* Metodo para retornar o valor do lado direito do No
    * @return No - No a direita*/
    public No getRamoDireito() {
        return ramoDireito;
    }
    /*Metodo que seta o valor no No direito
    * @param ramoDireito No - No a direita.
    */
    public void setRamoDireito(No ramoDireito) {
        this.ramoDireito = ramoDireito;
    }
    /* Metodo para retornar o valor da altura do No a esquerda
    * @return int - Valor da altura a esquerda*/
    public int getAlturaE() {
        return alturaE;
    }
    /*Metodo que seta o valor da altura do No esquerdo
    * @param alturaE int - Altura do no esquerdo.
    */
    public void setAlturaE(int alturaE) {
        this.alturaE = alturaE;
    }
     /* Metodo para retornar o valor da altura do No a direita
    * @return int - Valor da altura a direita*/
    public int getAlturaD() {
        return alturaD;
    }
    /*Metodo que seta o valor da altura do No direito
    * @param alturaD int - Altura do no direito.
    */
    public void setAlturaD(int alturaD) {
        this.alturaD = alturaD;
    }
    
    
    
}
