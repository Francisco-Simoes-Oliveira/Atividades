package descubraPalavra;

import global.ControlJogo;
import global.GerenciamentoDeDicas;
import global.Main;
import global.Palavras;

public class JogoDaDescoberta {
    public void jogandoDescobraPalavra(){
        PalavrasEmbaralhadas palavrasEmbaralhadasLocal = new PalavrasEmbaralhadas();

        Main.palavras[0].escolherPalavra();
        palavrasEmbaralhadasLocal.embaralhar();

        palavrasEmbaralhadasLocal.mostrarPalavraEmbaralhada();
        while(!Main.controlJogo.acerto){
            String entrada = ControlJogo.mostrarOpcoes();

            if ( Main.controlJogo.verificacaoReposta(entrada) == 1){
                break;
            }
        }
    }
}
