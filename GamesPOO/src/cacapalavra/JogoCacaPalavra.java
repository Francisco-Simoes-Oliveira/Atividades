package cacapalavra;

import global.ControlJogo;
import global.Main;
import global.Palavras;

public class JogoCacaPalavra {

    public void jogarCacaPalavra() {
        boolean sairDoJogo = false;
        while (!sairDoJogo) {
            Tabela tabelaLocal = new Tabela();
            Palavras palavrasLocal = new Palavras();

            tabelaLocal.precherTabela();
            palavrasLocal.escolherPalavra();
            tabelaLocal.esconderPalavra();
            tabelaLocal.mostrarTabela();


            while (!Main.controlJogo.acerto) {
                Main.sc.nextLine();
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
}
