/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultil;
import model.Autor;


/**
 *
 * @author Wesley Ramos
 */
public class NoAutor {
    private Autor valor;
    private NoAutor ramoEsquerdo;
    private NoAutor ramoDireito;
    private int alturaE;
    private int alturaD;

    /* construtor
    * @param valor Autor - Nome do autor.
    * @param ramoEsquerdo NoAutor - lado esquerdo da arvore.
    * @param ramoDireito NoAutor - lado direito da arvore.
    */
    public NoAutor(Autor valor, NoAutor ramoEsquerdo, NoAutor ramoDireito) {
        this.valor = valor;
        this.ramoEsquerdo = ramoEsquerdo;
        this.ramoDireito = ramoDireito;

    }
    
    /* Metodo para retornar o valor do No
    * @return Autor - Nome do autor*/
    public Autor getValor() {
        return valor;
    }
    /* Metodo para setar o valor do No
    * @param valor Autor - autor*/
    public void setValor(Autor valor) {
        this.valor = valor;
    }
    /* Metodo para retornar o valor do lado esquerdo do No
    * @return NoAutor - No a esquerda*/
    public NoAutor getRamoEsquerdo() {
        return ramoEsquerdo;
    }
    /*Metodo que seta o valor no No esquerdo
    * @param ramoEsquerdo NoAutor - No a esquerda.
    */
    public void setRamoEsquerdo(NoAutor ramoEsquerdo) {
        this.ramoEsquerdo = ramoEsquerdo;
    }
    /* Metodo para retornar o valor do lado direito do No
    * @return NoAutor - No a direita*/
    public NoAutor getRamoDireito() {
        return ramoDireito;
    }
    /*Metodo que seta o valor no No direito
    * @param ramoDireito NoAutor - No a direita.
    */
    public void setRamoDireito(NoAutor ramoDireito) {
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
