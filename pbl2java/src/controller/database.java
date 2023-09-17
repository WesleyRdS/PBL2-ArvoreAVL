/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Scanner;
import model.Autor;
import model.Data;
import model.Livro;
import ultil.Arvore_AVL;
import ultil.Arvore_AVLautor;
import ultil.Arvore_AVLdata;
import ultil.ultil.ListaE;


/**
 *
 * @author Wesley Ramos
 */
public class database {
    
    Arvore_AVLautor nome = new Arvore_AVLautor();
    Arvore_AVLdata data = new Arvore_AVLdata();

    /* Metodo para ler o arquivo
    * @param avl Arvore_AVL - Arvore onde os livros da base de dados serão inseridos.
    */
    public void lerArquivo(Arvore_AVL avl) throws IOException{
        InputStream e = new FileInputStream("C:\\Users\\Admin\\Documents\\NetBeansProjects\\pbl2java\\build\\classes\\controller\\catalogo.csv");
        InputStreamReader f = new InputStreamReader(e);
        BufferedReader ler = new BufferedReader(f);
        String linha;
        int cont = 0;
        int j = 0;
        while((linha = ler.readLine()) != null){
            j = 0;
            if(cont < 2){
                cont=cont+1;
            }else{
                String NeBook = "";
                String titulo = "";
                String autor = "";
                String mes= "";
                String ano = "";
                String link = "";
                for(String str : linha.split(";")){
                    if(j == 0){
                        NeBook = str;
                    }
                    if(j == 1){
                        titulo = str;
                    }
                    if(j == 2){
                        autor = str;
                    }
                    if(j == 3){
                        mes = str;
                    }
                    if(j == 4){
                        ano = str;
                    }
                    if(j == 5){
                        link = str;
                    }
                    j=j+1;

                }             
                Livro livro = new Livro(NeBook,titulo,autor,mes,ano,link);
               
                if(livro.getN_ebook()!="" && livro.getTitulo()!="" &&  livro.getAno()!=null && livro.getLink()!="" && livro.getMes()!="" && linha != null){
                    avl.inserir(livro);
                    Autor a = buscarAutor(livro.getAutor());
                    if(nome.existe(livro.getAutor())){
                        Autor x = buscarAutor(livro.getAutor());
                        x.getL().adicionaInicio(livro);
                    }else{
                        
                        Autor n = new Autor(livro.getAutor());
                        ListaE l = new ListaE();
                        n.setL(l);
                        n.getL().adicionaInicio(livro);
                        nome.inserir(n);
                    }
                    if(buscarData(Integer.parseInt(livro.getAno())) != null){
                        Data y = buscarData(Integer.parseInt(livro.getAno()));
                        y.getLd().adicionaInicio(livro);
                    }else{
                        Data d = new Data(livro.getAno());
                        ListaE lista1 = new ListaE();
                        d.setLd(lista1);
                        d.getLd().adicionaInicio(livro);
                        data.inserir(d);
                    }
                }
                System.out.println(livro.getTitulo());
            }
            
        }
        System.out.println("Base de dados carregada com sucesso");
        ler.close();
 
    }
    
    
    /* Metodo para adicionar o novo livro ao sistema.
    * @param avl Arvore_AVL - Arvore onde sera inserida o novo livro cadastrado no sistema.
    */
    public Livro adicionarLivro(Arvore_AVL avl) throws IOException{
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite o numero de E_book do livro");
        String e = ler.nextLine();
        System.out.println("Digite o titulo do livro");
        String t = ler.nextLine();
        System.out.println("Digite o nome do autor");
        String a = ler.nextLine();
        System.out.println("Digite o mes de lançamento");
        String m = ler.nextLine();
        System.out.println("Digite o ano de lançamento");
        String ano = ler.nextLine();
        System.out.println("Digite o link do livro");
        String link = ler.nextLine();
        Livro l = new Livro(e,t,a,m,ano,link);
        if(avl.existe(Integer.parseInt(e))== true){
            System.out.println("Livro ja cadastrado");
        } else{
            avl.inserir(l);
            if(nome.existe(l.getAutor())){
                        Autor x = buscarAutor(l.getAutor());
                        x.getL().adicionaInicio(l);
                    }else{
                        Autor n = new Autor(l.getAutor());
                        ListaE lista = new ListaE();
                        n.setL(lista);
                        n.getL().adicionaInicio(l);
                        nome.inserir(n);
                       
                    }
                    if(buscarData(Integer.parseInt(l.getAno())) != null){
                        Data y = buscarData(Integer.parseInt(l.getAno()));
                        y.getLd().adicionaInicio(l);
                    }else{
                        Data d = new Data(l.getAno());
                        ListaE lista1 = new ListaE();
                        d.setLd(lista1);
                        d.getLd().adicionaInicio(l);
                        data.inserir(d);
                    }
        }
        return l;
    }
    /* Metodo para escrever o novo livro criado no sistema.
    * @param avl Arvore_AVL - Arvore onde esta o novo livro criado.
    */
    public void escrever(Arvore_AVL avl) throws IOException{
        Livro l = adicionarLivro(avl);
        FileWriter f = new FileWriter("C:\\Users\\Admin\\Documents\\NetBeansProjects\\pbl2java\\build\\classes\\controller\\catalogo.csv",true);
        BufferedWriter escrever = new BufferedWriter(f);
        escrever.append(l.getN_ebook()+";"+l.getTitulo()+";"+l.getAutor()+";"+l.getMes()+";"+l.getAno()+";"+l.getLink()+"\n");
        escrever.close();
    }
    /* Metodo que criara um novo arquivo para toda busca realizada pelo sistema.
    * @param o String - String que recebera o tipo de busca e o salvara como nome do arquivo.
    * @param s String - String que recebera o conteudo da busca.
    */
    public void escreverBusca(String o,String s) throws IOException{
        StringBuilder ender = new StringBuilder();
        ender.append("C:\\Users\\Admin\\Documents\\NetBeansProjects\\pbl2java\\build\\classes\\controller\\").append(o).append(".txt");
        FileWriter as = new FileWriter(ender.toString(),true);
        BufferedWriter escrever = new BufferedWriter(as);
        escrever.append(s);
        escrever.close();
    }
 
  
  /* Metodo que busca autor na arvore de autores.
   * @param autor String - String que recebera o nome do autor.
   * @return Autor - Autor encontado na arvore de autores
   */
  public Autor buscarAutor(String autor){
      Autor retorno = null;
      if(nome.existe(autor)){
          retorno = nome.buscar(autor);
      }
      return retorno;
  }
  /* Metodo que busca a o livro com a data passada.
   * @param dt int - Data para busca.
   * @return Data - Data encontrada na arvore de datas
   */
  public Data buscarData(int dt){
      Data retorno = null;
      if(data.existe(dt)){
          retorno = data.buscar(dt);
      }
      
      return retorno;
  }
  /* Metodo que retorna todos os autores com a quantidade de livros publicados pelo autor.
   */
  public void autorQuantidade() throws IOException{
      ListaE aq = new ListaE();
      nome.listaEscrita(aq);
      for(int i = 0; i < aq.tamanho();i++){
          Autor autor = (Autor)aq.obter(i);
          System.out.println("Autor: "+autor.getAutor()+" "+"Quantidade: "+(autor.getL().tamanho()+1));
          escreverBusca("Autor quantidade",autor.getAutor()+";"+autor.getL().tamanho()+"\n");
      }
  }
  /* Metodo que busca todos os livros publicados pelo autor.
   */
  public void autorLivro() throws IOException{
      Scanner ler = new Scanner(System.in);
      System.out.println("Digito o nome do autor: ");
      String lendo = ler.nextLine();
      Autor a = buscarAutor(lendo);
      for(int i = 0; i < a.getL().tamanho(); i++){
          Livro livro = (Livro) a.getL().obter(i);
          System.out.println("Livro: "+livro.getTitulo());
          escreverBusca(lendo,livro.getTitulo()+";");
          
      }
      escreverBusca(lendo,"\n");
  }
  /* Dado o ano de publicação o metodo retorna todos os livros publicados naquele ano.
   */
  public void livroAno() throws IOException{
      Scanner ler = new Scanner(System.in);
      System.out.println("Digito a data: ");
      int lendo = ler.nextInt();
      Data d = buscarData(lendo);
      String x ="";
      String ano = "";
      for(int i = 0; i < d.getLd().tamanho();i++){
          Livro l = (Livro) d.getLd().obter(i);
          ano = l.getAno();
          System.out.println("N° eBook: "+l.getN_ebook()+" "+"Titulo: "+l.getTitulo()+" "+"Autor: "+l.getAutor()+" "+"Mês de lançamento: "+l.getMes()+" "+"Link: "+l.getLink());
          x += l.getN_ebook()+";"+l.getTitulo()+";"+l.getAutor()+";"+l.getMes()+";"+l.getLink()+"\n";
      }
      escreverBusca(ano,x);

  }
  /* Metodo para remover livro do sistema
    * @param avl Arvore_AVL - Arvore onde os livros da base de dados serão inseridos.
    */
  public void remover(Arvore_AVL avl) throws IOException{
      Scanner dado = new Scanner(System.in);
      System.out.println("Digite o n° de eBook:");
      int book = dado.nextInt();
      if(avl.existe(book)){
        Livro livro = avl.buscar(book);
        Data d = buscarData(Integer.parseInt(livro.getAno()));
        Autor a = buscarAutor(livro.getAutor());
        ListaE ano = d.getLd();
        ListaE autor = a.getL();
        for(int i = 0; i < autor.tamanho();i++){
            Livro la = (Livro) autor.obter(i);
            if(Integer.parseInt(la.getN_ebook()) == book){
                autor.remover(i);
            }
        }   
        for(int i = 0; i < ano.tamanho();i++){
            Livro ld = (Livro) ano.obter(i);
            if(Integer.parseInt(ld.getN_ebook()) == book){
                ano.remover(i);
            }
        }      
        avl.remover(book);
        ListaE lista = new ListaE();
        avl.listaEscrita(lista);
        for(int i = 0;i<lista.tamanho();i++){
            if(i == 0){
                FileWriter f = new FileWriter("C:\\Users\\Admin\\Documents\\NetBeansProjects\\pbl2java\\build\\classes\\controller\\catalogo.csv",false);
                BufferedWriter escrever = new BufferedWriter(f);
                escrever.append(""+";"+""+";"+""+";"+""+";"+""+";"+""+"\n");
                escrever.close();
                FileWriter ai = new FileWriter("C:\\Users\\Admin\\Documents\\NetBeansProjects\\pbl2java\\build\\classes\\controller\\catalogo.csv",true);
                BufferedWriter esc = new BufferedWriter(ai);
                esc.append("N_EBOOK"+";"+"TITULO"+";"+"AUTOR"+";"+"MES"+";"+"ANO"+";"+"LINK"+"\n");
                esc.close();
            }

            Livro li = (Livro) lista.obter(i);
            FileWriter f = new FileWriter("C:\\Users\\Admin\\Documents\\NetBeansProjects\\pbl2java\\build\\classes\\controller\\catalogo.csv",true);
            BufferedWriter escrever = new BufferedWriter(f);
            escrever.append(li.getN_ebook()+";"+li.getTitulo()+";"+li.getAutor()+";"+li.getMes()+";"+li.getAno()+";"+li.getLink()+"\n");
            escrever.close();
        }
        for(int i = 0;i<lista.tamanho();i++){
            lista.remover(i);
        }
      }else{
          System.out.println("Livro inexistente!!");
      }
  }
  /* Metodo para dado o n° de E-book achar seu respectivo livro e printar o seu link de acesso
    * @param avl Arvore_AVL - Arvore onde os livros da base de dados serão inseridos.
    */
  public void buscar(Arvore_AVL avl) throws IOException{
       Scanner dado = new Scanner(System.in);
       System.out.println("Digite o n° de eBook:");
       int ebook = dado.nextInt();
       String link = "";
       if(avl.existe(ebook)){
        Livro l = avl.buscar(ebook);
        System.out.println(l.getLink());
        escreverBusca(l.getN_ebook(),l.getLink()+";");
       }
      }
    
}
