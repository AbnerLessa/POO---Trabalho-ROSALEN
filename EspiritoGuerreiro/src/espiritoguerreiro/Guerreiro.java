/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package espiritoguerreiro;

/**
 *
 * @author abner
 */
public class Guerreiro {
    String nome;
    int qtdvidas;
    
    public Guerreiro() {
    }
    
    // Método para definir o nome do guerreiro
    void setGuerreiro(){
        //Seta o nome do Guerreiro
        this.nome = InOut.leString("Qual seu nome: ");
    }
   
    int getQtdVidas(){
        // Retorna as vida
        return qtdvidas;
    }
    
    String getNome(){
        // Retorna  o nome
        return nome;
    }
    
    void setQtdVidas(int qtdvidas){
        //Seta as vidas do guerreiro
        this.qtdvidas = qtdvidas;
    }
    // Dá a chance do guerreiro tentar outra vez
    String vidaExtra(){
    String var = InOut.leString("Suas vidas se esgotaram\n" + "Suplique de forma correta, e uma chance terá!");
    return var;
}

  
    }



