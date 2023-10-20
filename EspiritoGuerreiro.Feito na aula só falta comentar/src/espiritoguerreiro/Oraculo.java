/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package espiritoguerreiro;

import java.util.Random;

/**
 *
 * @author abner
 */
import java.util.Random;

public class Oraculo{
    String nome;
    //Quando o oraculo for criado ,o guerreiro também sera instanciado dentro da classe oraculo
    Guerreiro guerr = new Guerreiro(); 

    public Oraculo(){

    }

    public Oraculo(String nome) {
        this.nome = nome;
        this.guerr = guerr;
    }
    // Seta o nome do Oraculo
    void setOraculoNome(){
      nome = InOut.leString("Olá, sou o oraculo deste mundo. Porém bati a cabeca faz pouco tempo e nao consigo me lembrar...\nPode me lembrar de meu nome? ");
    }
    
    int setVidas(){
        //Setando a vida do guerreiro de modo aleatorio entre 9 a 12
        Random random = new Random();
        int vidas = random.nextInt(4) + 9;  //Random de até 4 e o resultado soma 9 para ficar de 9 a 12
        guerr.setVidas(vidas);
        return vidas;
        
    }
    
    String prologoFase1(){
        //Prologo fase 1
        String intro = "Caro Guerreiro " + guerr.getNome() + ", eu, " + this.nome + " lhe concederei >>" + guerr.getVidas() + "<< vidas para esta Jornada.\n"
                + "O Seu primeiro oponente é a gargola, testando sua habilidade de advinhacao, decidira se voce vive ou nao!";
        return intro;
    }
    
    int Fase1(){
        //aleatorização dos numeros de 1 a 100 para a fase 1
        Random random = new Random();
        int numSort = random.nextInt(100);
        return numSort;
    }

    String prologoFase2(){
        //Prologo fase 2
        String intro = "Agora para vencer, deve jogar ou morrer.\nAgora a grande éfigie deve combater! Você ainda tem " + guerr.vidas + " vidas";
        return intro;
    }
    
    int Fase2(int opcao){
        if(opcao !=0 && opcao !=1){
            //Caso escolha opção fora das alternativas
            return 0;
        }
        Random random = new Random();
        int orach = random.nextInt(5);
        int guer = random.nextInt(5);
        int ip = (orach + guer) % 2;
        if(ip == opcao){/*Pois caso seja par ip == 0, mesma int escolhida para par. Caso a soma seja impar, 
                         ip == 1, a mesma int escolhida para impar*/
            //terá ganhado               
            return 1;
        }
        else{
            //terá perdido
            return 2;
        }

    }

    String prologoVencedor(){
        return "Parabens " + guerr.getNome() + " com essa sua vitória eu mereço lhe contar,\n"
                + "meu nome não é " + this.nome + ", mas sim Joao Java. Voce ainda tem " +guerr.vidas + " vidas, então lhe tomarei todas!";
        
    }
   
    String prologoPerdedor(){
        return "Uma triste noticia valente guerreiro,\nsua mente se afoga em confusao enquanto a espada da vida infinca-se em seu coracao.\nAqui sera seu tumulo, Voce foi derrotado.";
    }

    
    boolean decidirVidaExtra(String decisao){
        /*Utilizando o método split() para fragmentar a String  em uma array de strings
        toda vez que for achado um " " (espaço em branco).*/
        String[] separado = decisao.split(" ");
        //Se o tamanho da array retornada for maior que 5, a súplica será aprovada
        if (separado.length > 5) {
            return true;
        } else { 
            return false;
        }
    } 
}