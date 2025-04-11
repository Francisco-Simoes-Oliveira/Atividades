package cacapalavra;

import global.ControlJogo;
import global.Main;
import global.Palavras;

public class JogoCacaPalavra {

    public void jogarCacaPalavra(){
        boolean sairDoJogo = false;
        
        Tabela tabelaLocal = new Tabela();
        Palavras palavrasLocal = new Palavras();

        tabelaLocal.precherTabela();
        palavrasLocal.escolherPalavra();
        tabelaLocal.esconderPalavra();
        tabelaLocal.mostrarTabela();

        while (!Main.controlJogo.acerto){
            String entrada = ControlJogo.mostrarOpcoes();

            if ( Main.controlJogo.verificacaoReposta(entrada) == 1){
                break;
            }

        }

        
    }

}
