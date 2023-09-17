/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import ultil.ultil.ListaE;


/**
 *
 * @author Wesley Ramos
 */
public class Data {
    private String data;
    private ListaE ld;
    /* construtor
    * @param data String - Ano de publicação do livro.
    */
    public Data(String data) {
        this.data = data;
    }
    /* Metodo para retornar o ano de publicação do livro
    * @return String - ano de publicação */
    public String getData() {
        return data;
    }
    /* Metodo que seta o ano de publicação do livro
    * @param data String - Valor da string.
    */
    public void setData(String data) {
        this.data = data;
    }
    /* Metodo para retornar a lista de livros publicados pelo autor
    * @return ListaE - Lista de livros*/
    public ListaE getLd() {
        return ld;
    }
    /* Metodo que seta a lista de livros
    * @param ld ListaE - Lista de livros.
    */
    public void setLd(ListaE ld) {
        this.ld = ld;
    }

  


}
