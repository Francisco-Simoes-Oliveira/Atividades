package global;

import termo.JogoTermo;
import cacapalavra.JogoCacaPalavra;
import cacapalavra.Tabela;
import descubraPalavras.JogoDaDescoberta;


public class Main {


    public GerenciamentoDeDicas dicas ;
    public static Util util = new Util();



    public static void main(String[] args) {
        Main main = new Main();
        main.dicas = new GerenciamentoDeDicas();
        util.setMain(main);

        System.out.println("Bem vindo o que deseja jogar: \n  1° Caça Palavra \n  2° Descubra Palavra \n  3° Termo \nDigite o numero correspondente:");
        int qualJogo = util.sc.nextInt();
        util.sc.nextLine();


        if (qualJogo == 1){
            JogoCacaPalavra jogo = new JogoCacaPalavra(util);
            main.gereciamentoDificuldade(qualJogo, jogo);

            jogo.jogarCacaPalavra();
        } else if (qualJogo == 2) {
            JogoDaDescoberta jogo = new JogoDaDescoberta();
            main.gereciamentoDificuldade(qualJogo);
            jogo.jogandoDescobraPalavra();
        } else if (qualJogo == 3) {
            JogoTermo jogo = new JogoTermo();
            util.organazarPalavra();
            jogo.jogandoTermo();
        } else {
            System.out.println("Numero escolhido invalido");
        }

    }



    public void gereciamentoDificuldade( int qualJogo, JogoCacaPalavra jogoC){
        System.out.println("Qual dificuldade vc deseja jogar (Fácil[1], Médio[2], Difícil[3]): ");
        int dificuldade = util.sc.nextInt();
        if (qualJogo == 1){
            if (dificuldade == 2){
                util.controlJogo.quantidadeDePalavras = 3;
                jogoC.setTabelaLocal(new Tabela(15, util.main));
            } else if (dificuldade == 3) {
                util.controlJogo.quantidadeDePalavras = 5;
                jogoC.setTabelaLocal(new Tabela(20,util.main));
            }
        }

        reset(util.main);
    }
    public void gereciamentoDificuldade( int qualJogo){
        System.out.println("Qual dificuldade vc deseja jogar (Fácil[1], Médio[2], Difícil[3]): ");
        int dificuldade = util.sc.nextInt();
        if (qualJogo == 2){
            if (dificuldade == 2){
                util.controlJogo.quantidadeDePalavras = 3;
            } else if (dificuldade == 3) {
                util.controlJogo.quantidadeDePalavras = 5;
            }
        }
        reset(util.main);
    }


    public static void reset(Main main){
        util.sc.nextLine();

        util.controlJogo = new ControlJogo(util.controlJogo.quantidadeDePalavras, util.controlJogo.pontos, main);
        main.dicas = new GerenciamentoDeDicas();
        util.organazarPalavra();

    }
}