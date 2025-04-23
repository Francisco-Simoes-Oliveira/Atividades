package global;


import Termo.JogoTermo;
import cacapalavra.JogoCacaPalavra;
import descubraPalavra.JogoDaDescoberta;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static ControlJogo controlJogo = new ControlJogo();
    public static Random random = new Random();
    public static Palavras[] palavras;
    public static GerenciamentoDeDicas dicas = new GerenciamentoDeDicas();


    public static void main(String[] args) {


        System.out.println("Bem vindo o que deseja jogar: \n  1° Caça Palavra \n  2° Descubra Palavra \n  3° Termo \nDigite o numero correspondente:");
        int qualJogo = sc.nextInt();
        sc.nextLine();


        if (qualJogo == 1){
            JogoCacaPalavra jogo = new JogoCacaPalavra();
            gereciamentoDificuldade(qualJogo);
            jogo.jogarCacaPalavra();
        } else if (qualJogo == 2) {
            JogoDaDescoberta jogo = new JogoDaDescoberta();
            gereciamentoDificuldade(qualJogo);
            jogo.jogandoDescobraPalavra();
        } else if (qualJogo == 3) {
            JogoTermo jogo = new JogoTermo();
            organazarPalavra();
            jogo.jogandoTermo();
        } else {
            System.out.println("Numero escolhido invalido");
        }

    }

    public static void organazarPalavra(){
        palavras = new Palavras[controlJogo.quatidadeDePalavras];
        for (int i = 0; i < palavras.length; i++) {
            palavras[i] = new Palavras();
        }
    }

    public static void gereciamentoDificuldade( int qualJogo){
        System.out.println("Qual dificuldade vc deseja jogar (Fácil[1], Médio[2], Difícil[3]): ");
        int dificuldade = Main.sc.nextInt();
        if (qualJogo == 1){
            if (dificuldade == 2){
                controlJogo.quatidadeDePalavras = 3;
                JogoCacaPalavra.tabelaLocal.tamanhoTabela = 15;
            } else if (dificuldade == 3) {
                controlJogo.quatidadeDePalavras = 5;
                JogoCacaPalavra.tabelaLocal.tamanhoTabela = 20;
            }
        }
        else if (qualJogo == 2){
            if (dificuldade == 2){
                controlJogo.quatidadeDePalavras = 3;
            } else if (dificuldade == 3) {
                controlJogo.quatidadeDePalavras = 5;
            }
        }
        reset();
    }


    public static void reset(){
        sc.nextLine();

        controlJogo = new ControlJogo(controlJogo.quatidadeDePalavras, controlJogo.pontos);
        dicas = new GerenciamentoDeDicas();
        organazarPalavra();

    }
}