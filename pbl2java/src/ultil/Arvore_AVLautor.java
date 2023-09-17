/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultil;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import model.Autor;
import ultil.ultil.ListaE;


/**
 *
 * @author Wesley Ramos
 */
public class Arvore_AVLautor {
    private NoAutor raiz;
    /* construtor
    */
    public Arvore_AVLautor() {
    }
    
    /* Metodo para inserir na arvore
     * @param no NoAutor - O no da arvore.
    * @param valor Autor - O valor do objeto do tipo Autor.
    */
    public void inserir(NoAutor no, Autor valor){
        if(no == null){
            raiz = new NoAutor(valor,null,null);
            contarBalanceamento(raiz,no);
        }
        else{
            int AE = no.getAlturaE();
            int AD = no.getAlturaD();
            if((valor.getAutor()).compareToIgnoreCase(no.getValor().getAutor())<0){
                if(no.getRamoEsquerdo()!= null){
                    inserir(no.getRamoEsquerdo(),valor);
                }
                else{
                    no.setRamoEsquerdo(new NoAutor(valor,null,null));
                }
            }
            else{
                if(no.getRamoDireito()!= null){
                    inserir(no.getRamoDireito(),valor);
                }
                else{
                    no.setRamoDireito(new NoAutor(valor,null,null));
                }
            }
            contarBalanceamento(raiz,no);
            rotacionar(raiz);
        }
    }
    /* Metodo para inserir na arvore
    * @param valor Autor - O valor do objeto do tipo Autor.
    */
    public void inserir(Autor valor){
        inserir(raiz,valor);
    }
    /* Metodo para rotação a direita
    * @param no NoAutor - O no da arvore.
    */
    public void rodarDireita(NoAutor p){
        NoAutor q;
        NoAutor aux;
        q = p.getRamoEsquerdo();
        aux = p.getRamoDireito();
        q.setRamoDireito(p);
        p.setRamoEsquerdo(aux);
        p = q;
    }
    /* Metodo para rotação a esquerda
    * @param no NoAutor - O no da arvore.
    */
    public void rodarEsquerda(NoAutor p){
        NoAutor q;
        NoAutor aux;
        q = p.getRamoDireito();
        aux = p.getRamoEsquerdo();
        q.setRamoEsquerdo(p);
        p.setRamoEsquerdo(aux);
        p = q;
    }
    /* Metodo para rotação a direita depois a esquerda
    * @param no NoAutor - O no da arvore.
    */
    public void rodarDE(NoAutor p){
        rodarDireita(p.getRamoDireito());
        rodarEsquerda(p);
    }
    /* Metodo para rotação a esquerda depois a direita
    * @param no NoAutor - O no da arvore.
    */
    public void rodarED(NoAutor p){
        rodarEsquerda(p.getRamoEsquerdo());
        rodarDireita(p);
    }
    /* Metodo para verificar balanceamento do no
    * @param no NoAutor - O no da arvore.
    */
    public int FB(NoAutor no){
        return no.getAlturaE() - no.getAlturaD();
    }
    /* Metodo para contar a altura do no
    * @param no NoAutor - O no da arvore.
    * @param usado NoAutor - O no da arvore.
    */
    public void contarBalanceamento(NoAutor no, NoAutor usado){
        int AE = 0;
        int AD = 0;
        if(no!= null && usado != no){
            if(no.getRamoEsquerdo() != null){
                AE += 1;
                if((no.getRamoEsquerdo()).getRamoDireito() != null){
                    AD += 1;
                    no.setAlturaD(AD);
                }
                no.setAlturaE(AE);
                contarBalanceamento(no.getRamoEsquerdo(),usado);
            }if(no.getRamoDireito() != null){
                AD += 1;
                if((no.getRamoDireito()).getRamoEsquerdo() != null){
                    AE += 1;
                    no.setAlturaE(AE);
                }
                no.setAlturaD(AD);
                contarBalanceamento(no.getRamoDireito(),usado);
            }
        }
    }
    /* Metodo para realizar a rotação da arvore
    * @param n NoAutor - O no da arvore.
    */
    public void rotacionar(NoAutor n){
        int balanceamento = FB(n);
        if(balanceamento == 2 && n.getAlturaE()<0){
            rodarED(n);
        }else if(balanceamento == -2 && n.getAlturaD()> 0){
            rodarDE(n);
        }else if(balanceamento == 2){
            rodarEsquerda(n);
        }else if(balanceamento == -2){
            rodarDireita(n);
        }   
    }
    
    /* Metodo para buscar o autor
    * @param num String - O nome do autor do livro.
    * @return Autor - Valor do objeto
    */
    public Autor buscar(String num){
        Autor valor = null;
        if(existe(num)){
            valor = buscar(raiz,num);
        }else{
            System.out.println("Item inexistente");
        }
        return valor;
    }
    /* Metodo para buscar o autor
    * @param no NoAutor - O no da arvore.
    * @param num String - O nome do autor do livro.
    * @return Autor - Valor do objeto
    */
    public Autor buscar(NoAutor temp, String num){
        Autor valor = new Autor("0");
        if(!(temp.getValor()).getAutor().equals(num) || !valor.getAutor().equals(num)){
            if((temp.getValor()).getAutor().equals(num)){
                valor = temp.getValor();
            } else if (num.compareToIgnoreCase((temp.getValor()).getAutor()) < 0){
                valor = buscar(temp.getRamoEsquerdo(),num);
            } else if (num.compareToIgnoreCase((temp.getValor()).getAutor()) > 0){
                valor = buscar(temp.getRamoDireito(),num);
            }
        }
        return valor;
    }
    /* Metodo para verificar se o autor existe
    * @param no NoAutor - O no da arvore.
    * @param num String - O nome do autor do livro.
    * @param valor boolean - Verdadeiro ou Falso.
    * @return boolean - Valor do boleano
    */
    public boolean existe(NoAutor temp, String num,boolean valor){
        if(temp == null){
            valor = false;
        }else{
            if(!(temp.getValor()).getAutor().equals(num) || valor != true){
                if((temp.getValor()).getAutor().equals(num)){
                    valor = true;
                } else if (num.compareToIgnoreCase((temp.getValor()).getAutor()) < 0){
                    valor = existe(temp.getRamoEsquerdo(),num,false);
                } else if (num.compareToIgnoreCase((temp.getValor()).getAutor()) > 0){
                    valor = existe(temp.getRamoDireito(),num,false);
                }
            }
        }
        return valor;
    }
     /* Metodo para verificar se o autor existe
    * @param num String - O nome do autor do livro.
    * @return boolean - Valor do boleano
    */
    public boolean existe(String num){
        return existe(raiz,num,false);
    }
    /* Metodo para remover o autor
    * @param aux NoAutor - O no da arvore.
    * @param num String - O nome do autor do livro
    * @return NoAutor - Valor do no
    */
    public NoAutor remover(NoAutor aux, String num){
        if(aux == null){
            return null;
        } else if(num.compareToIgnoreCase((aux.getValor()).getAutor()) < 0){
            aux.setRamoEsquerdo(remover(aux.getRamoEsquerdo(),num));
        } else if(num.compareToIgnoreCase((aux.getValor()).getAutor()) > 0){
            aux.setRamoDireito(remover(aux.getRamoDireito(),num));
        }else{
            if(aux.getRamoEsquerdo() == null && aux.getRamoDireito() == null){
                aux = null;
            } else if(aux.getRamoEsquerdo() == null){
                NoAutor t = aux;
                aux = aux.getRamoDireito();
            } else if(aux.getRamoDireito() == null){
                NoAutor t = aux;
                aux = aux.getRamoEsquerdo();
            } else{
                NoAutor f = aux.getRamoEsquerdo();
                while(f.getRamoDireito() != null){
                    f = f.getRamoDireito();
                }
                aux.setValor(f.getValor());
                f.setValor(null);
                aux.setRamoEsquerdo(remover(aux,num));
            }
            contarBalanceamento(raiz,aux);
            rotacionar(raiz);
        }
        return aux;
    }
    /* Metodo para remover o autor
    * @param num String - O nome do autor do livro
    * @return NoAutor - Valor do no
    */
    public NoAutor remover(String num){
        NoAutor valor = null;
        if(existe(num)){
            valor = remover(raiz,num);
            System.out.println("Livro removido com sucesso!!");    
        }else{
            System.out.println("Item inexistente");
        }
        return valor;
    }
    /* Metodo para printar a arvore
     * @param n NoAutor - O no da arvore.
    */
    public void printarArvore(NoAutor n){
        if(n.getRamoEsquerdo() != null){
            printarArvore(n.getRamoEsquerdo());
        }
        if(n.getRamoDireito()!= null){
            printarArvore(n.getRamoDireito());
        }
        System.out.println(n.getValor().getAutor());
    }
    
   
    /* Metodo para printar a arvore
    */
    public void imprimir(){
        if(raiz == null){
            System.out.println("Arvore vazia");
        }else{
            printarArvore(raiz);
        }
    }
    /* Metodo para transformar arvore em uma lista
    * @param n NoAutor - O no da arvore.
    * @param lista ListaE - lista
    */
    public void retornarArvore(NoAutor n,ListaE lista){
        if(n.getRamoEsquerdo() != null){
            retornarArvore(n.getRamoEsquerdo(),lista);
        }
        if(n.getRamoDireito()!= null){
            retornarArvore(n.getRamoDireito(),lista);
        }
        lista.adicionaInicio(n.getValor());
    }
    /* Metodo para transformar arvore em uma lista
    * @param lista ListaE - lista
    */
    public void listaEscrita(ListaE lista){
        retornarArvore(raiz,lista);
    }

    
 

}
