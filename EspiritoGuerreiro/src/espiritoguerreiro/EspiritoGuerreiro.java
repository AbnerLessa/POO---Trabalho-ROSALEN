/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package espiritoguerreiro;

/**
 *
 * @author abner
 */
public class EspiritoGuerreiro {
    public static void main(String[] args) {
        //Cria o objeto oracu
        Oraculo oracu = new Oraculo(); 
        //Variavel para verificar se ja foi ganho vida extra por fase
        boolean verificar = true;
        //Variavel para retornar o resultado da chance extra 
        boolean chance;
        //Variavel para se ocorrer do jogador morrer na primeira fase e dar FIM DE JOGO
        boolean fimJogo = false; 
        InOut.MsgDeInformacao("JOGO", "Bem vindo ao desafio do Yashiro Samorai.\n Que você consiga completar, Boa sorte..");
        // Nomeia o Oraculo
        oracu.setNomeOraculo();
        // Nomeia o Guerreiro
        oracu.guerre.setGuerreiro();
        //Instancia a vida guerreiro
        int vidas = oracu.setQtdVidas();
        //Prologo do Jogo
        InOut.MsgDeInformacao("PROLOGO", oracu.prologoFase1());
        //Inicio da fase 1
        InOut.MsgDeAviso("JOGO", "Fase 1 começou, de olho no Gragas!");
        //Coloca um while para o jogador poder jogar novamente
        while (true){
            int numSorte = oracu.Fase1();
            InOut.MsgDeInformacao("Gragas", 
                                             "Eu sou o Gragas e tenho uma pergunta,\n"
                                            + " Advinhe o numero que estou pensando ou morra em minhas mãos!");
            // While da Fase 1
            while(true){
                System.out.println(vidas);
                //Se as vidas acabaram ele verifica
                if(vidas <= 0){
                    if(verificar){
                        chance = oracu.decidirVidaExtra(oracu.guerre.vidaExtra());//Pelo guerreiro ter sido criado pelo oraculo, pode ser só chamado pelo objeto orach
                        if(chance){
                            InOut.MsgDeAviso("Oraculo", "Você ganhou uma nova chance, Boa sorte!");
                            vidas = 1;
                         // Nega a vida extra
                            verificar  = false;
                        }
                     //Caso ja tenha recebido a vida extra ele não pode receber outra
                    }else{
                        InOut.MsgDeAviso("Oraculo", "Você já teve uma nova chance. Por isso , aqui se encerra sua jornada.");
                        InOut.MsgDeInformacao("Oraculo", oracu.Perdedor());
                        // Liga o FIM DE JOGO
                        fimJogo= true;
                        //Finaliza o jogo na primeira fase
                        break;
                    }
                
                }
                
                //Aqui o jogador tenta adivinhar o numero de 1 a 100
                int advinhar  = InOut.leInt("Tente advinhar o numero de 1 a 100");
                //caso o numero secreto for maior o jogador perde 1 vida
                    if(advinhar >= 0 && advinhar < numSorte){
                    InOut.MsgDeInformacao("Oraculo", "O número é MAIOR que o palpite");
                    vidas--;
                    
                }
                 //Caso o numero secreto for menor o jogador perde 1 vida
                    else if(advinhar <= 100 && advinhar > numSorte){
                    InOut.MsgDeInformacao("Oraculo", "Segredo é MENOR que o palpite");
                    vidas--;
                    
                }
                    //Caso o advinhe o número 
                     else if(advinhar == numSorte){
                 InOut.MsgDeInformacao("Gragas", "Como isso foi acontecer !!! mas aceito que fui derrotado...");
                    InOut.MsgDeAviso("Historia", 
                                                    "Gragas o Badernista , que demonstra raiva e ódio em suas expressões e ações,\n"
                                                + "morde sua propria lingua e perece engasgado com seu proprio sangue...\n"
                                                + "Voce segue seu caminho como vencedor.");
                    oracu.guerre.setQtdVidas(vidas);
                    break;
                }
               // Caso o jogador tente adivinhar um numero muito distante ele perde 2 vidas
                else{
                    InOut.MsgDeErro("Gragas", "Como você pode pensar nisso , você pagará o dobro por isso...");
                    InOut.MsgDeAviso("Oraculo", "Voce perdeu 2 vidas por escolhido um número muito distante...");
                    vidas = vidas - 2;
                }
            
        //caso voce tenha morrido na primeira fase, quebra o loop e o jogador não pode jogar denovo
            if(fimJogo){
                break;
            }
            else{
                //Reseta a vida extra, sendo 1 por fase
                verificar = false;
                InOut.MsgDeInformacao("Oraculo", oracu.prologoFase2());
                InOut.MsgDeAviso("JOGO", "Fase 2 começou , cuidado com o poderoso Braum!!!");
                InOut.MsgDeInformacao("Braum", 
                                               "Eu sou o poderoso Braum , um glacinada do Reino de Freijord,\n"
                                                  + "muitos me temem desde as antigas eras...");
   
                // Loop while da fase 2
                while(true){ 
                // Mesma verificação de vidas da fase 1
                    if(vidas <=0)
                        if(verificar){
                            chance = oracu.decidirVidaExtra(oracu.guerre.vidaExtra());
                            if(chance){
                                InOut.MsgDeAviso("Oraculo", "Com essa nova vida você retorna , e tera uma nova chance ");
                                verificar = false;
                                vidas = 1;
                            }
                        }else{
                            InOut.MsgDeAviso("Oraculo", "Você já teve uma nova chance. Por isso , aqui se encerra sua jornada.");
                            InOut.MsgDeInformacao("Oraculo", oracu.Perdedor());
                            fimJogo = true;
                            break;
                        }
                    
                    else{
                        int escolha = oracu.Fase2(InOut.leInt("Faça sua escolha: \n [0]-Impar \n [1]-Par"));
                        //caso a escolha seja errada perde todas as vidas
                        if(escolha == 0){
                            InOut.MsgDeErro("Braum",
                                                     "Você foi um tolo jogador,\n"
                                                   + "por tal atitude levarei todas as suas vidas...");
                                                    
                            InOut.MsgDeAviso("Oraculo", "Voce perdeu todas as vidas por ter tomado tal decisão...");
                            vidas = 0;
                        }
                         // Caso o jogador ganhe 
                        else if(escolha == 1){
                            InOut.MsgDeAviso("Braum", """
                                                      Parabéns, você  conquistou a Bravura,
                                                      e completou o Desafio do Yashiro Samorai...
                                                      """);
                            InOut.MsgDeAviso("Oraculo", oracu.Vencedor());
                            InOut.MsgDeInformacao("Historia", "O Oraculo tirou todas as vidas de " + oracu.guerre.getNome() + " para seu plano astral.\n"
                                    + "Agora seu corpo era apenas uma caixa vazia, e Braum se colocou em sua ultima \n"
                                    + "duvida existencial... Não seriamos todos apenas receptaculos vazios?");
                            break;//encerra a fase
                        }
                        // Caso erre perde uma vida
                        else{
                            InOut.MsgDeAviso("Oraculo", "Você errou \n você perdeu uma vida.");
                            vidas--;
                        }
                    }
                    
                }    
            }
            int escolhaJogo = InOut.leInt( "FIM DE JOGO!\n Deseja jogar novamente:\n [] Jogar Novamente \n [1] Jogo Acaba");
            // faz o Jogo Acabar
            if(escolhaJogo == 1){
                break;
            }else{
                InOut.MsgDeInformacao("JOGO", "O Jogo recomeça!");
            }
        }
         // FIM do Jogo
        InOut.MsgDeAviso("JOGO", "Jogo finalizado!");
    }    
}
}

