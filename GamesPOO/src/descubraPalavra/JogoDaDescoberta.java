package descubraPalavra;

import global.ControlJogo;
import global.Main;


public class JogoDaDescoberta {
    public void jogandoDescobraPalavra(){

        boolean sairDoJogo = false;

        while (!sairDoJogo) {
            PalavrasEmbaralhadas palavrasEmbaralhadasLocal = new PalavrasEmbaralhadas();

            Main.palavras[0].escolherPalavra();
            palavrasEmbaralhadasLocal.embaralhar();

            palavrasEmbaralhadasLocal.mostrarPalavraEmbaralhada();
            while (!Main.controlJogo.acerto) {
                String entrada = ControlJogo.mostrarOpcoes();

                if (Main.controlJogo.verificacaoReposta(entrada) == 1) {
                    break;
                }
            }
            System.out.println("\nDeseja continuar jogando Descubra a palavra (Se sim digite [1] se quer parar [0])");
            int resp = Main.sc.nextInt();
            if (resp == 0) sairDoJogo = true;
            else Main.reset();
        }
    }

    public void gerenciamentoDificuldade(int dificuldade){
        if (dificuldade == 2){
            Main.controlJogo.quatidadeDePalavras = 3;
        } else if (dificuldade == 3) {
            Main.controlJogo.quatidadeDePalavras = 5;
        }
        Main.reset();
    }
}