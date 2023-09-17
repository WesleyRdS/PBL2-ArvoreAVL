/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Wesley Ramos
 */
public class Livro {
    private String n_ebook;
    private String titulo;
    private String autor;
    private String mes;
    private String ano;
    private String link;
    /* construtor
    * @param n_ebook String - N° E-Book do livro.
    * @param titulo String - Titulo do livro.
    * @param autor String - Nome do autor.
    * @param mes String - mês de publicação.
    * @param ano String - ano de publicação.
    * @param link String - link para acesso do livro.
    */
    public Livro(String n_ebook, String titulo, String autor, String mes, String ano, String link) {
        this.n_ebook = n_ebook;
        this.titulo = titulo;
        this.autor = autor;
        this.mes = mes;
        this.ano = ano;
        this.link = link;
    }
    /* construtor
    */
    public Livro() {
    }
    
  
    /* Metodo para retornar o n°de e-book do livro
    * @return String - N° de e-book de publicação */
    public String getN_ebook() {
        return n_ebook;
    }
    /* Metodo que seta o n° do e-book do livro
    * @param n_ebook String - Valor da string.
    */
    public void setN_ebook(String n_ebook) {
        this.n_ebook = n_ebook;
    }
    /* Metodo para retornar o titulo do livro
    * @return String - Titulo de publicação */
    public String getTitulo() {
        return titulo;
    }
    /* Metodo que seta o titulo do livro
    * @param titulo String - Valor da string.
    */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    /* Metodo para retornar o nome do autor do livro
    * @return String - Autor do livro */
    public String getAutor() {
        return autor;
    }
    /* Metodo que seta o nome do autor do livro
    * @param autor String - Valor da string.
    */
    public void setAutor(String autor) {
        this.autor = autor;
    }
    /* Metodo para retornar o link para acesso do livro
    * @return String - Link para acesso do livro */
    public String getLink() {
        return link;
    }
    /* Metodo que seta o link para acesso do livro
    * @param link String - Valor da string.
    */
    public void setLink(String link) {
        this.link = link;
    }
    /* Metodo para retornar o mês de publicação do livro
    * @return String - mês de publicação */
    public String getMes() {
        return mes;
    }
    /* Metodo que seta o mes de publicação do livro
    * @param mes String - Valor da string.
    */
    public void setMes(String mes) {
        this.mes = mes;
    }
    /* Metodo para retornar o ano de publicação do livro
    * @return String - ano de publicação */
    public String getAno() {
        return ano;
    }
    /* Metodo que seta o ano de publicação do livro
    * @param ano String - Valor da string.
    */
    public void setAno(String ano) {
        this.ano = ano;
    }
    
}
