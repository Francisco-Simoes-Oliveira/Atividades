package global;

import java.util.Random;
import java.util.Scanner;

public class Util {
    public Scanner sc = new Scanner(System.in);
    public ControlJogo controlJogo = new ControlJogo();
    public Random random = new Random();
    public Palavras[] palavras;

    public Main main;

    public Util(){
    }
    public Util(Main main){
        this.main = main;
    }



    public void organazarPalavra(){
        palavras = new Palavras[controlJogo.quantidadeDePalavras];
        for (int i = 0; i < palavras.length; i++) {
            palavras[i] = new Palavras();
        }
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Main getMain() {
        return main;
    }
}
