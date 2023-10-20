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
         Oraculo oracu = new Oraculo(); //objeto oraculo e variaveis criadas para o game
        boolean verifica = true;// Variavel para verificar se ja foi ganho vida extra por fase
        boolean chance;// Variavel para retornar resultado das suplicas de vida extra
        boolean fimJogo = false; //variavel para caso o jogador morra na primeira fase o jogo termina
        InOut.MsgDeInformacao("GAME", "Bem vindo ao desafio do Joao Java.\nBoa Sorte!!!");
        oracu.setOraculoNome();//Nomear oraculo
        oracu.guerr.setGuerNome();//nomear guerreiro
        int vidas = oracu.setVidas();//Instanciar vida guerreiro
        InOut.MsgDeInformacao("Prologo", oracu.prologoFase1());
        InOut.MsgDeAviso("GAME", "Fase 1 iniciada, cuidado com a gargola!");
        while (true){//colocar o jogo em estrutura de repetição para a pessoa poder jogar denovo
            int numSort = oracu.Fase1();
            InOut.MsgDeInformacao("Gargola","Eu sou a gargola, e tenho uma questao...\n"
                    + "Advinhe o numero que estou pensando ou pereca em minha mao!");
            while(true){//While da primeira fase
                System.out.println(vidas);
                if(vidas <= 0){//quando as vidas acabarem ele entra nessa verificação
                    if(verifica){
                        chance = oracu.decidirVidaExtra(oracu.guerr.vidaExtra());//Pelo guerreiro ter sido criado pelo oraculo, pode ser só chamado pelo objeto orach
                        if(chance){
                            InOut.MsgDeAviso("Oraculo", "Com uma vida tu retornas, uma chance ganharas!");
                            vidas = 1;
                            verifica = false;//para negar proxima vida extra
                        }
                    }else{//caso a pessoa ja tenha recebido uma vida extra, ele nao pode receber outra
                        InOut.MsgDeAviso("Oraculo", "Ja lhe foi concedida uma vida nesta batalha. Por isso aqui sua jornada se encerra...");
                        InOut.MsgDeInformacao("Oraculo", oracu.prologoPerdedor());
                        fimJogo = true;//ativa o fim do jogo
                        break;//sai da primeira fase como derrotado
                    }
                }
                int chute = InOut.leInt("Tente advinhar o numero de 1 a 100");//aqui começa os chutes
                if(chute >= 0 && chute < numSort){//caso o numero secreto seja maior, -1 vida
                    InOut.MsgDeInformacao("Oraculo", "Segredo eh MAIOR que o palpite");
                    vidas--;
                }
                else if(chute <= 100 && chute > numSort){//caso o numero secreto seja menor, -1 vida
                    InOut.MsgDeInformacao("Oraculo", "Segredo eh MENOR que o palpite");
                    vidas--;
                }
                else if(chute == numSort){//caso o chute seja certo
                    InOut.MsgDeInformacao("Gargola", "Como isso e possivel??? Porem admito minha derrota...");
                    InOut.MsgDeAviso("Historia", "A gargola esbanjada por uma expressao de desespero e autodesprezo,\n"
                                                      + "morde sua propria lingua e perece engasgado com seu proprio sangue...\n"
                                                      + "Voce segue seu caminho como vencedor.");
                    oracu.guerr.setVidas(vidas);
                    break;
                }
                else{//caso o chute seja muito fora de área, o jogador perde 2 vidas
                    InOut.MsgDeErro("Gargola", "Tolo!!! Como consegue ser um algo tao estupido?");
                    InOut.MsgDeAviso("Oraculo", "Voce perdeu 2 vidas por ter escolhido um numero surreal...");
                    vidas = vidas - 2;
                }
                
            }
            if(fimJogo){//caso voce tenha morrido na primeira fase, quebra o while do jogo sem opção de jogar denovo
                break;
            }
            else{
                verifica = false;//reseta a variavel de verificação de vida extra, pode ter 1 por fase
                InOut.MsgDeInformacao("Oraculo", oracu.prologoFase2());
                InOut.MsgDeAviso("GAME", "Fase 2 iniciada, cuidado com a Efigie!");
                InOut.MsgDeInformacao("Efigie", "Eu sou a Efigie, inteligente e bela.\n"
                        + "Me venca no impar ou par e viveras por eras!");
                while(true){//while da fase 2
                    if(vidas <=0){//Mesma verificação de vidas e suplica da fase 1, caso queira ler volte no código
                        if(verifica){
                            chance = oracu.decidirVidaExtra(oracu.guerr.vidaExtra());
                            if(chance){
                                InOut.MsgDeAviso("Oraculo", "Com uma vida tu retornas, uma chance ganharas!");
                                verifica = false;
                                vidas = 1;
                            }
                        }else{
                            InOut.MsgDeAviso("Oraculo", "Ja lhe foi concedida uma vida nesta batalha. Por isso aqui sua jornada se encerra...");
                            InOut.MsgDeInformacao("Oraculo", oracu.prologoPerdedor());
                            fimJogo = true;
                            break;
                        }
                    }
                    else{
                        int escolha = oracu.Fase2(InOut.leInt("Escolha: \n[0]-impar\n[1]-par!"));
                        if(escolha == 0){//caso a escolha seja fora do desejado perde todas as vidas 
                            InOut.MsgDeErro("Efigie", "Tolo, Fracasado e despojado!\n"
                                    + "Por tal asneira eu tirarei o resto de suas vidas!!");
                            InOut.MsgDeAviso("Oraculo", "Voce perdeu todas as vidas por ter escolhido tal asneira...");
                            vidas = 0;
                        }
                        else if(escolha == 1){//caso você ganhe
                            InOut.MsgDeAviso("Efigie", "Parabéns, voce conseguiu o premio. A amizade.\n"
                                    + "O verdadeiro desafio Joao Java são os amigos que fazemos no caminho...");
                            InOut.MsgDeAviso("Oraculo", oracu.prologoVencedor());
                            InOut.MsgDeInformacao("Historia", "O Oraculo tirou todas as vidas de " + oracu.guerr.getNome() + " para seu plano astral.\n"
                                    + "Agora seu corpo era apenas uma caixa vazia, e a Efigie se colocou em sua ultima \n"
                                    + "duvida existencial... Não seriamos todos apenas receptaculos vazios?");
                            break;//encerra a fase
                        }
                        else{//caso erre perde uma vida
                            InOut.MsgDeAviso("Oraculo", "Essa não! Você errou!!\nLhe será tirado 1 vida.");
                            vidas--;
                        }
                    }
                }    
            }
            int escolhaGame = InOut.leInt( "Fim do Jogo!\nDeseja jogar denovo?\n[all]-Sim\n[1]-Não");
            if(escolhaGame == 1){//jogo acaba
                break;
            }else{
                InOut.MsgDeInformacao("Game", "O Jogo recomeça!");//autoexplicativo
            }
        }
        InOut.MsgDeAviso("Game", "Jogo finalizado!");//fim do jogo
    }
    
}
