/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

public class Guerreiro {
    String nome;
    int vidas;
    
    public Guerreiro() {
    }
    
    
    void setGuerName(){
        //Setar o nome do guerreiro
        this.nome = InOut.leString("Otimo, agora por favor, me diga o seu nome: ");
    }
   
    int getVidas(){
        //Retornar as vidas
        return vidas;
    }
    
    String getNome(){
        //retornar o nome
        return nome;
    }
    
    void setVidas(int vidas){
        //setando as vidas do guerreiro
        this.vidas = vidas;
    }
    
    String vidaExtra(){
    String x = InOut.leString("Acabaram suas vidas, logo voce perecera...\n"
                            + "Mas caso uma boa suplica eu ouvir, talvez uma vida extra ira ganhar!");
    return x;
}
}
