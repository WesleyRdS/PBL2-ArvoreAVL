/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultil;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import model.Data;
import ultil.ultil.ListaE;


/**
 *
 * @author Wesley Ramos
 */
public class Arvore_AVLdata {
    private NoData raiz;
    /* construtor
    */
    public Arvore_AVLdata() {
    }
    
    /* Metodo para inserir na arvore
     * @param no NoData - O no da arvore.
    * @param valor Data - O valor do objeto do tipo Data.
    */
    public void inserir(NoData no, Data valor){
        if(no == null){
            raiz = new NoData(valor,null,null);
            contarBalanceamento(raiz,no);
        }
        else{
            int AE = no.getAlturaE();
            int AD = no.getAlturaD();
            if(Integer.parseInt(valor.getData()) < Integer.parseInt((no.getValor()).getData())){
                if(no.getRamoEsquerdo()!= null){
                    inserir(no.getRamoEsquerdo(),valor);
                }
                else{
                    no.setRamoEsquerdo(new NoData(valor,null,null));
                }
            }
            else{
                if(no.getRamoDireito()!= null){
                    inserir(no.getRamoDireito(),valor);
                }
                else{
                    no.setRamoDireito(new NoData(valor,null,null));
                }
            }
            contarBalanceamento(raiz,no);
            rotacionar(raiz);
        }
    }
    /* Metodo para inserir na arvore
    * @param valor Data - O valor do objeto do tipo Data.
    */
    public void inserir(Data valor){
        inserir(raiz,valor);
    }
    
    /* Metodo para rotação a direita
    * @param no NoData - O no da arvore.
    */
    public void rodarDireita(NoData p){
        NoData q;
        NoData aux;
        q = p.getRamoEsquerdo();
        aux = p.getRamoDireito();
        q.setRamoDireito(p);
        p.setRamoEsquerdo(aux);
        p = q;
    }
    /* Metodo para rotação a esquerda
    * @param no NoData - O no da arvore.
    */
    public void rodarEsquerda(NoData p){
        NoData q;
        NoData aux;
        q = p.getRamoDireito();
        aux = p.getRamoEsquerdo();
        q.setRamoEsquerdo(p);
        p.setRamoEsquerdo(aux);
        p = q;
    }
    /* Metodo para rotação a direita depois a esquerda
    * @param no NoData - O no da arvore.
    */
    public void rodarDE(NoData p){
        rodarDireita(p.getRamoDireito());
        rodarEsquerda(p);
    }
    /* Metodo para rotação a esquerda depois a direita
    * @param noData No - O no da arvore.
    */
    public void rodarED(NoData p){
        rodarEsquerda(p.getRamoEsquerdo());
        rodarDireita(p);
    }
    /* Metodo para verificar balanceamento do no
    * @param no NoData - O no da arvore.
    */
    public int FB(NoData no){
        return no.getAlturaE() - no.getAlturaD();
    }
    /* Metodo para contar a altura do no
    * @param no NoData - O no da arvore.
    * @param usado NoData - O no da arvore.
    */
    public void contarBalanceamento(NoData no, NoData usado){
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
    * @param n NoData - O no da arvore.
    */
    public void rotacionar(NoData n){
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
    /* Metodo para buscar a data
    * @param num int - O ano de publicação do livro.
    * @return Data - Valor do objeto
    */
    public Data buscar(int num){
        Data valor = null;
        if(existe(num)){
            valor = buscar(raiz,num);
        }else{
            System.out.println("Item inexistente");
        }
        return valor;
    }
    /* Metodo para buscar a data
    * @param temp NoData - O no da arvore.
    * @param num int - O ano de publicação do livro.
    * @return Data - Valor do objeto
    */
    public Data buscar(NoData temp, int num){
        Data valor = new Data("0");
        if(Integer.parseInt((temp.getValor()).getData()) != num || Integer.parseInt(valor.getData()) != num){
            if(Integer.parseInt((temp.getValor()).getData()) == num){
                valor = temp.getValor();
            } else if (num < Integer.parseInt((temp.getValor()).getData())){
                valor = buscar(temp.getRamoEsquerdo(),num);
            } else if (num > Integer.parseInt((temp.getValor()).getData())){
                valor = buscar(temp.getRamoDireito(),num);
            }
        }
        return valor;
    }
    /* Metodo para verificar se a data existe
    * @param temp NoData - O no da arvore.
    * @param num int - O ano de publicação do livro.
    * @param valor boolean - Verdadeiro ou Falso.
    * @return boolean - Valor do boleano
    */
    public boolean existe(NoData temp, int num,boolean valor){
        if(temp == null){
            valor = false;
        }else{
            if(Integer.parseInt((temp.getValor()).getData()) != num || valor != true){
                if(Integer.parseInt((temp.getValor()).getData()) == num){
                    valor = true;
                } else if (num < Integer.parseInt((temp.getValor()).getData())){
                    valor = existe(temp.getRamoEsquerdo(),num,false);
                } else if (num > Integer.parseInt((temp.getValor()).getData())){
                    valor = existe(temp.getRamoDireito(),num,false);
                }
            }
        }
        return valor;
    }
    /* Metodo para buscar a data
    * @param num int - O ano de publicação do livro.
    * @return boolean - Valor do boleano
    */
    public boolean existe(int num){
        return existe(raiz,num,false);
    }
    /* Metodo para remover a data
    * @param aux NoData - O no da arvore.
    * @param num int - A data de publicação do livro
    * @return NoData - Valor do no
    */
    public NoData remover(NoData aux, int num){
        if(aux == null){
            return null;
        } else if(Integer.parseInt((aux.getValor()).getData()) > num){
            aux.setRamoEsquerdo(remover(aux.getRamoEsquerdo(),num));
        } else if(Integer.parseInt((aux.getValor()).getData()) < num){
            aux.setRamoDireito(remover(aux.getRamoDireito(),num));
        }else{
            if(aux.getRamoEsquerdo() == null && aux.getRamoDireito() == null){
                aux = null;
            } else if(aux.getRamoEsquerdo() == null){
                NoData t = aux;
                aux = aux.getRamoDireito();
            } else if(aux.getRamoDireito() == null){
                NoData t = aux;
                aux = aux.getRamoEsquerdo();
            } else{
                NoData f = aux.getRamoEsquerdo();
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
    /* Metodo para remover a data
    * @param num int - A data de publicação do livro
    * @return NoData - Valor do no
    */
    public NoData remover(int num){
        NoData valor = null;
        if(existe(num)){
            valor = remover(raiz,num);
            System.out.println("Livro removido com sucesso!!");    
        }else{
            System.out.println("Item inexistente");
        }
        return valor;
    }
    /* Metodo para printar a arvore
     * @param n NoData - O no da arvore.
    */
    public void printarArvore(NoData n){
        if(n.getRamoEsquerdo() != null){
            printarArvore(n.getRamoEsquerdo());
        }
        if(n.getRamoDireito()!= null){
            printarArvore(n.getRamoDireito());
        }
        System.out.println(n.getValor().getData());
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
    * @param n NoData - O no da arvore.
    * @param lista ListaE - lista
    */
    public void retornarArvore(NoData n,ListaE lista){
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
