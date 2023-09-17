/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultil;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import model.Livro;
import ultil.ultil.ListaE;

/**
 *
 * @author Wesley Ramos
 */
public class Arvore_AVL {
    private No raiz;
    /* construtor
    */
    public Arvore_AVL() {
    }
    
    /* Metodo para inserir na arvore
     * @param no No - O no da arvore.
    * @param valor Livro - O valor do objeto do tipo Livro.
    */
    public void inserir(No no, Livro valor){
        if(no == null){
            raiz = new No(valor,null,null);
            contarBalanceamento(raiz,no);
        }
        else{
            int AE = no.getAlturaE();
            int AD = no.getAlturaD();
            if(Integer.parseInt(valor.getN_ebook()) < Integer.parseInt((no.getValor()).getN_ebook())){
                if(no.getRamoEsquerdo()!= null){
                    inserir(no.getRamoEsquerdo(),valor);
                }
                else{
                    no.setRamoEsquerdo(new No(valor,null,null));
                }
            }
            else{
                if(no.getRamoDireito()!= null){
                    inserir(no.getRamoDireito(),valor);
                }
                else{
                    no.setRamoDireito(new No(valor,null,null));
                }
            }
            contarBalanceamento(raiz,no);
            rotacionar(raiz);
        }
    }
    /* Metodo para inserir na arvore
    * @param valor Livro - O valor do objeto do tipo Livro.
    */
    public void inserir(Livro valor){
        inserir(raiz,valor);
    }
    
    /* Metodo para rotação a direita
    * @param no No - O no da arvore.
    */
    public void rodarDireita(No p){
        No q, aux;
        q = p.getRamoEsquerdo();
        aux = p.getRamoDireito();
        q.setRamoDireito(p);
        p.setRamoEsquerdo(aux);
        p = q;
    }
    /* Metodo para rotação a esquerda
    * @param no No - O no da arvore.
    */
    public void rodarEsquerda(No p){
        No q, aux;
        q = p.getRamoDireito();
        aux = p.getRamoEsquerdo();
        q.setRamoEsquerdo(p);
        p.setRamoEsquerdo(aux);
        p = q;
    }
    /* Metodo para rotação a direita depois a esquerda
    * @param no No - O no da arvore.
    */
    public void rodarDE(No p){
        rodarDireita(p.getRamoDireito());
        rodarEsquerda(p);
    }
    /* Metodo para rotação a esquerda depois a direita
    * @param no No - O no da arvore.
    */
    public void rodarED(No p){
        rodarEsquerda(p.getRamoEsquerdo());
        rodarDireita(p);
    }
    /* Metodo para verificar balanceamento do no
    * @param no No - O no da arvore.
    */
    public int FB(No no){
        return no.getAlturaE() - no.getAlturaD();
    }
    /* Metodo para contar a altura do no
    * @param no No - O no da arvore.
    * @param usado No - O no da arvore.
    */
    public void contarBalanceamento(No no, No usado){
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
    * @param n No - O no da arvore.
    */
    public void rotacionar(No n){
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
    /* Metodo para buscar o livro
    * @param num int - O n° de ebook do livro.
    * @return Livro - Valor do objeto
    */
    public Livro buscar(int num){
        Livro valor = null;
        if(existe(num)){
            valor = buscar(raiz,num);
        }else{
            System.out.println("Item inexistente");
        }
        return valor;
    }
    /* Metodo para buscar o livro
    * @param num int - O n° de ebook do livro.
    * @param temp No - O no da arvore.
    * @return Livro - Valor do objeto
    */
    public Livro buscar(No temp, int num){
        Livro valor = new Livro("0","0","0","0","0","0");
        if(Integer.parseInt((temp.getValor()).getN_ebook()) != num || Integer.parseInt(valor.getN_ebook()) != num){
            if(Integer.parseInt((temp.getValor()).getN_ebook()) == num){
                valor = temp.getValor();
            } else if (num < Integer.parseInt((temp.getValor()).getN_ebook())){
                valor = buscar(temp.getRamoEsquerdo(),num);
            } else if (num > Integer.parseInt((temp.getValor()).getN_ebook())){
                valor = buscar(temp.getRamoDireito(),num);
            }
        }
        return valor;
    }
    /* Metodo para veridicar se o livro existe.
    * @param num int - O n° de ebook do livro.
    * @param temp No - O no da arvore.
    * @param valor boolean - Verdadeiro ou Falso.
    * @return boolean- Valor do boleano
    */
    public boolean existe(No temp, int num,boolean valor){
        if(temp == null){
            valor = false;
        }else{
            if(Integer.parseInt((temp.getValor()).getN_ebook()) != num || valor != true){
                if(Integer.parseInt((temp.getValor()).getN_ebook()) == num){
                    valor = true;
                } else if (num < Integer.parseInt((temp.getValor()).getN_ebook())){
                    valor = existe(temp.getRamoEsquerdo(),num,false);
                } else if (num > Integer.parseInt((temp.getValor()).getN_ebook())){
                    valor = existe(temp.getRamoDireito(),num,false);
                }
            }
        }
        return valor;
    }
    /* Metodo para veridicar se o livro existe.
    * @param num int - O n° de ebook do livro.
    * @return boolean- Valor do boleano
    */
    public boolean existe(int num){
        return existe(raiz,num,false);
    }
    /* Metodo para remover livro
    * @param aux No - O no da arvore.
    * @param num int - O n° de e-book do livro.
    * @return No - Valor do no
    */
    public No remover(No aux, int num){
        if(aux == null){
            return null;
        } else if(Integer.parseInt((aux.getValor()).getN_ebook()) > num){
            aux.setRamoEsquerdo(remover(aux.getRamoEsquerdo(),num));
        } else if(Integer.parseInt((aux.getValor()).getN_ebook()) < num){
            aux.setRamoDireito(remover(aux.getRamoDireito(),num));
        }else{
            if(aux.getRamoEsquerdo() == null && aux.getRamoDireito() == null){
                aux = null;
            } else if(aux.getRamoEsquerdo() == null){
                No t = aux;
                aux = aux.getRamoDireito();
            } else if(aux.getRamoDireito() == null){
                No t = aux;
                aux = aux.getRamoEsquerdo();
            } else{
                No f = aux.getRamoEsquerdo();
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
    /* Metodo para remover livro
    * @param num int - O n° de e-book do livro.
    * @return No - Valor do no
    */
    public No remover(int num){
        No valor = null;
        if(existe(num)){
            valor = remover(raiz,num);
            System.out.println("Livro removido com sucesso!!");    
        }else{
            System.out.println("Item inexistente");
        }
        return valor;
    }
    /* Metodo para printar a arvore
     * @param n No - O no da arvore.
    */
    public void printarArvore(No n){
        if(n.getRamoEsquerdo() != null){
            printarArvore(n.getRamoEsquerdo());
        }
        if(n.getRamoDireito()!= null){
            printarArvore(n.getRamoDireito());
        }
        System.out.println(n.getValor().getTitulo());
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
    * @param n No - O no da arvore.
    * @param lista ListaE - lista
    */
    public void retornarArvore(No n,ListaE lista){
        if(n.getRamoEsquerdo() != null){
            retornarArvore(n.getRamoEsquerdo(),lista);
        }
        if(n.getRamoDireito()!= null){
            retornarArvore(n.getRamoDireito(),lista);
        }
        if(n != null){
        lista.adicionaInicio(n.getValor());
        }
    }
    /* Metodo para transformar arvore em uma lista
    * @param lista ListaE - lista
    */
    public void listaEscrita(ListaE lista){
        retornarArvore(raiz,lista);
    }
 

}
