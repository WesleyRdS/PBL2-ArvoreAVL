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
public class Autor {
    private String autor;
    private ListaE l;
    /* construtor
    * @param nome String - Nome do autor.
    */
    public Autor(String nome) {
        this.autor = nome;
    }
    /* construtor
    * @param nome String - Nome do autor.
    * @param l ListaE - Lista de livros publicados pelo autor.
    */
    public Autor(String nome, ListaE l) {
        this.autor = nome;
        this.l = l;
    }
    /* Metodo para retornar o nome do autor
    * @return String - Nome do autor */
    public String getAutor() {
        return autor;
    }
     /* Metodo que seta o nome do autor
    * @param nome String - Valor da string.
    */
    public void setAutor(String nome) {
        this.autor = nome;
    }
    /* Metodo para retornar a lista de livros publicados pelo autor
    * @return ListaE - Lista de livros*/
    public ListaE getL() {
        return l;
    }
    /* Metodo que seta a lista de livros
    * @param l ListaE - Lista de livros.
    */
    public void setL(ListaE l) {
        this.l = l;
    }
    
}
