/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import junit.framework.Assert;
import model.Autor;
import model.Data;
import model.Livro;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ultil.Arvore_AVL;
import ultil.Arvore_AVLautor;
import ultil.Arvore_AVLdata;
import ultil.No;
import ultil.ultil.ListaE;

/**
 *
 * @author Admin
 */
public class databaseTest {
    Arvore_AVL avl;
    ListaE lista;
    ListaE listaA;
    ListaE listaD;
    database d;
    Arvore_AVLautor avla;
    Arvore_AVLdata avld;
    public databaseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        d = new database();
        avl = new Arvore_AVL();
        avld = d.data;
        avla = d.nome;
        lista = new ListaE();
        listaA = new ListaE();
        listaD = new ListaE();
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     *Teste do metodo de leitura de arquivo
     */
    @Test
    public void testLerArquivo() throws Exception {
        // Testando se a base de dados foi carregada na arvore
        d.lerArquivo(avl);
        Assert.assertNotNull(avl);
        // Testando se determinado n° de ebook foi cadastrado
        String s = "190113";
        Livro l = avl.buscar(190113);
        assertEquals(s,l.getN_ebook());
        //testando se todos os dados estão carregados
        avl.listaEscrita(lista);
        assertEquals(1527,lista.tamanho()+1);
    }

    /**
     * Teste do metodo de adição e de escrita do novo livro.
     */
    @Test
    public void testEscrever() throws Exception {
        Livro l = new Livro("10","a","b","jan","1900","asas");
        FileWriter f = new FileWriter("C:\\Users\\Admin\\Documents\\NetBeansProjects\\pbl2java\\build\\classes\\controller\\catalogo.csv",true);
        BufferedWriter escrever = new BufferedWriter(f);
        escrever.append(l.getN_ebook()+";"+l.getTitulo()+";"+l.getAutor()+";"+l.getMes()+";"+l.getAno()+";"+l.getLink()+"\n");
        escrever.close();
        avl.inserir(l);
        //testar se o livro foi adicionado a arvore
        Livro livro = avl.buscar(10);
        assertEquals(l,livro);
        // testar se o livro realmente foi gerado;
        assertNotNull(l);
        assertNotNull(livro);
    }

    /**
     * Teste do metodo de autor/quantidade de livros.
     */
    @Test
    public void testAutorQuantidade() throws Exception {
        d.lerArquivo(avl);
        avla.listaEscrita(listaA);
        //testando se todos os dados estão carregados
        assertEquals(237,listaA.tamanho()+1);
        //Testando se a lista não esta vazia
        assertNotNull(listaA);
        Livro lv = avl.buscar(190111);
        Autor autor = d.buscarAutor(lv.getAutor());
        Autor a = avla.buscar("Frank L Packard");
        assertEquals(autor.getAutor(),a.getAutor());
    }

    /**
     * Teste do metodo onde dado o nome do autor todos os seus livros são exibidos.
     */
    @Test
    public void testAutorLivro() throws Exception {
        d.lerArquivo(avl);
        avla.listaEscrita(listaA);
        Autor a = avla.buscar("Frank L Packard");
        // testando se os dados estão sendo realmente obtidos
        assertNotNull(listaA);
        assertNotNull(a);
        //Testando a quantidade de livros que o autor tem no sistema
        assertEquals(4,a.getL().tamanho()+1);
        
    }

    /**
     * Teste onde dada a data de publicação todos os livros publicados no ano serão exibidos
     */
    @Test
    public void testLivroAno() throws Exception {
        d.lerArquivo(avl);
        avld.listaEscrita(listaD);
        Data dt = avld.buscar(2019);
        // testando se os dados estão sendo realmente obtidos
        assertNotNull(listaD);
        assertNotNull(dt);
        //Testando a quantidade de livros que o autor tem no sistema
        assertEquals(101,dt.getLd().tamanho()+1);
    }

    /**
     * Teste do metodo de remoção de livro
     */
    @Test
    public void testRemover() throws Exception {
        Livro lv = new Livro("99","a","b","jan","1900","asas");
        // Testando se o livro foi criado
        assertNotNull(lv);
        avl.inserir(lv);
        Livro inserido = avl.buscar(99);
        // Testando se realmente o livro foi inserido
        assertNotNull(inserido);
        avl.remover(99);
        // Testando se o livro foi removido 
        No removido = avl.remover(99);
        assertNull(removido);
    }

    /**
     * Test of buscar method, of class database.
     */
    @Test
    public void testBuscar() throws Exception {
       String link = "";
       d.lerArquivo(avl);
       Livro l = avl.buscar(190113);
       if(l!=null){
           link = l.getLink();
       }
       //Testando se o livro foi encontrado
       assertNotNull(l);
       assertNotEquals("",link);
       //Testando se o link é o mesmo
       assertEquals(link,l.getLink());
       
    }
    
}
