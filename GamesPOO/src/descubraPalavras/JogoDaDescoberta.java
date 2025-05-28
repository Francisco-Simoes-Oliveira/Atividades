package descubraPalavras;


import global.Main;
import global.Util;


public class JogoDaDescoberta {
    public void jogandoDescobraPalavra(){
        Util util = Main.util;
        boolean sairDoJogo = false;

        while (!sairDoJogo) {
            PalavrasEmbaralhadas palavrasEmbaralhadasLocal = new PalavrasEmbaralhadas();

            util.palavras[0].escolherPalavra();
            palavrasEmbaralhadasLocal.embaralhar();

            palavrasEmbaralhadasLocal.mostrarPalavraEmbaralhada();
            while (!util.controlJogo.getAcerto()) {
                String entrada = util.controlJogo.mostrarOpcoes();

                if (util.controlJogo.verificacaoReposta(entrada) == 1) {
                    break;
                }
            }
            System.out.println("\nDeseja continuar jogando Descubra a palavra (Se sim digite [1] se quer parar [0])");
            int resp = util.sc.nextInt();
            if (resp == 0) sairDoJogo = true;
            else Main.reset(util.main);
        }
    }

}