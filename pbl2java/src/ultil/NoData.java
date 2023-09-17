/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultil;

import model.Data;


/**
 *
 * @author Wesley Ramos
 */
public class NoData {
    private Data valor;
    private NoData ramoEsquerdo;
    private NoData ramoDireito;
    private int alturaE;
    private int alturaD;

    /* construtor
    * @param valor Data - Ano de publicação.
    * @param ramoEsquerdo NoData - lado esquerdo da arvore.
    * @param ramoDireito NoData - lado direito da arvore.
    */
    public NoData(Data valor, NoData ramoEsquerdo, NoData ramoDireito) {
        this.valor = valor;
        this.ramoEsquerdo = ramoEsquerdo;
        this.ramoDireito = ramoDireito;

    }
    
    /* Metodo para retornar o valor do No
    * @return Data - Ano de publicação*/
    public Data getValor() {
        return valor;
    }
    /* Metodo para setar o valor do No
    * @param valor Data - Ano de publicação*/
    public void setValor(Data valor) {
        this.valor = valor;
    }
    /* Metodo para retornar o valor do lado esquerdo do No
    * @return NoData - No a esquerda*/
    public NoData getRamoEsquerdo() {
        return ramoEsquerdo;
    }
    /*Metodo que seta o valor no No esquerdo
    * @param ramoEsquerdo NoData - No a esquerda.
    */
    public void setRamoEsquerdo(NoData ramoEsquerdo) {
        this.ramoEsquerdo = ramoEsquerdo;
    }
    /* Metodo para retornar o valor do lado direito do No
    * @return NoData - No a direita*/
    public NoData getRamoDireito() {
        return ramoDireito;
    }
    /*Metodo que seta o valor no No direito
    * @param ramoDireito NoData - No a direita.
    */
    public void setRamoDireito(NoData ramoDireito) {
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
