/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbl2java;

import controller.database;
import java.io.IOException;
import java.util.Scanner;
import model.Livro;
import ultil.Arvore_AVL;
import ultil.ultil.ListaE;

/**
 *
 * @author Admin
 */
public class Pbl2java {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        database d = new database();
        Arvore_AVL avl = new Arvore_AVL();
        while(true){
             System.out.println("------------------------------Bem vindo ao banco de dados de eBooks----------------------------------");
                    System.out.println("Digite 1: Para cadastrar livro e gravar arquivo");
                    System.out.println("Digite 2: Para carregar base de dados");
                    System.out.println("Digite 3: Para listar autores e quantidades de livros");
                    System.out.println("Digite 4: Para pesquisar todos os livros publicados pelo autor");
                    System.out.println("Digite 5: Para listagem de livro");
                    System.out.println("Digite 6: Para buscar livros pelo n° de eBook");
                    System.out.println("Digite 7: Para listar livros por ano de publicação");
                    System.out.println("Digite 8: Para excluir livros");
                    System.out.println("Digite 9: Para sair");
                    Scanner dado = new Scanner(System.in);
                    int option = dado.nextInt();
                    switch(option){
                        case 1:
                            d.escrever(avl);
                            break;
                        case 2:
                            d.lerArquivo(avl);
                            break;
                        case 3:
                            d.autorQuantidade();
                            break;
                        case 4:
                            d.autorLivro();
                            break;
                        case 5:
                            avl.imprimir();
                            break;
                        case 6:
                            d.buscar(avl);
                            break;
                        case 7:
                            d.livroAno();
                            break;
                        case 8:
                            d.remover(avl);
                            break;
                        case 9:
                            System.out.println("Desconectando do sistema!!");
                            break;
                        default:
                            System.out.println("Opção invalida!!");
                            break;  
                    }
                    if(option == 9){
                        break;
                    }
                }
            }
        }
   
