package global;


import cacapalavra.JogoCacaPalavra;
import descubraPalavra.JogoDaDescoberta;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static ControlJogo controlJogo = new ControlJogo(2);
    public static Random random = new Random();
    public static Palavras[] palavras = new Palavras[controlJogo.quatidadeDePalavras];
    public static GerenciamentoDeDicas dicas = new GerenciamentoDeDicas();


    public static void main(String[] args) {
        for (int i = 0; i < palavras.length; i++) {
            palavras[i] = new Palavras();
        }
        System.out.println("Bem vindo o que deseja jogar: \n  1° Caça Palavra \n  2° Descubra Palavra \nDigite o numero correspondente:");
        int qualJogo = sc.nextInt();
        sc.nextLine();

        if (qualJogo == 1){
            JogoCacaPalavra jogo = new JogoCacaPalavra();
            jogo.jogarCacaPalavra();
        } else if (qualJogo == 2) {
            JogoDaDescoberta jogo = new JogoDaDescoberta();
            jogo.jogandoDescobraPalavra();
        } else {
            System.out.println("Numero escolhido invalido");
        }

    }
}
