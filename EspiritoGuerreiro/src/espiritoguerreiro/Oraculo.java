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
public class Oraculo {
    String nome;
    // Quando o oraculo for criado , o guerreiro também será criado por dentro da classe oraculo
    Guerreiro guerre = new Guerreiro(); 
    
    
    public Oraculo(){

    }

    public Oraculo(String nome, Guerreiro guerre) {
        this.nome = nome;
        this.guerre = guerre;
    }

    // Método set para o Nome do Oraculo
    void setNomeOraculo(){
        //Seta o nome do oraculo
        nome = InOut.leString("Olá eu sou o oraculo .\n Qual nome gostaria de me chamar? ");
    }
    // Método set para a Vida do Guerreiro
    int setQtdVidas(){
        //Setando a vida do guerreiro de modo aleatorio entre 9 a 12
        Random random = new Random();
        //Random de até 4 e o resultado soma 9 para ficar de 9 a 12
        int qtdvidas = random.nextInt(4) + 9;  
        guerre.setQtdVidas(qtdvidas);
        return qtdvidas;
        
    }
    
    String prologoFase1(){
        //Prologo fase 1
        String introducao = "Ó grande Guerreiro " + guerre.getNome() + ", eu, " + this.nome + " te darei ->" + guerre.getQtdVidas() + "<- vidas para sua Jornada.\n"
                + "Seu oponente será o Gragas o glacinata, testando sua habilidade de advinhar decidira se você soberviverá";
        return introducao;
    }
    
    int Fase1(){
        //Randomizando dos numeros de 1 a 100 para a fase 1
        Random random = new Random();
        int numSorte = random.nextInt(100);
        return numSorte;
    }

    String prologoFase2(){
        //Prologo fase 2
        String introducao = "Para vencer, você deve jogar.\nAgora o poderoso Braum você tem de enfrentar! Você ainda tem " + guerre.qtdvidas + " vidas";
        return introducao;
    }
    
    int Fase2(int opcao){
        if(opcao !=0 && opcao !=1){
            //Caso escolha opção fora das alternativas
            return 0;
        }
        Random random = new Random();
        int oracu = random.nextInt(5);
        int guerr = random.nextInt(5);
        int ip = (oracu + guerr) % 2;
        if(ip == opcao){
            // ganhou              
            return 1;
        }
        else{
            // perdeu
            return 2;
        }

    }
    // Método para o vencedor
    String Vencedor(){
        return "Parabens " + guerre.getNome() + " com isso irei te dizer a verdade. \n"
                + "meu nome não é " + this.nome + ",mas sim Yashiro o Samorai,Voce ainda tem " +guerre.qtdvidas + " vidas, então pegarei todas!";
        
    }
   // Método para o vencedor
    String Perdedor(){
        return "Uma pena , mas você perdeu Guerreiro.\n Você morrerá neste lugar.\n Aqui será seu tumulo...Adeus.";
    }
    // Método da Vida Extra
    boolean decidirVidaExtra(String decisao){
        /*Utilizando o método split() para fragmentar a String  em uma array de strings
        toda vez que for achado um " " (espaço em branco).*/
        String[] tam = decisao.split(" ");
        //Se o tamanho da array retornada for maior que 5, a decisão será aprovada e o guerreiro ganhará uma nova chance
        if (tam.length > 5) {
            return true;
        } else { 
            return false;
        }
    } 
}

