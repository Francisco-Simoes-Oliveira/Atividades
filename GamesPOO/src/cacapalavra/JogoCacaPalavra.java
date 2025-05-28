package cacapalavra;

import global.Main;
import global.Palavras;
import global.Util;

public class JogoCacaPalavra {
    private Tabela tabelaLocal;
    private Palavras palavrasLocal;


    Util util;

    public JogoCacaPalavra(Util util){
        this.util = util;
        tabelaLocal = new Tabela(util.getMain());
        palavrasLocal = new Palavras();
    }


    public void jogarCacaPalavra() {


        boolean sairDoJogo = false;
        while (!sairDoJogo) {
            tabelaLocal = new Tabela(tabelaLocal.getTamanhoTabela(), util.main);
            palavrasLocal = new Palavras();

            tabelaLocal.precherTabela();
            palavrasLocal.escolherPalavra();
            tabelaLocal.esconderPalavra();
            tabelaLocal.mostrarTabela();


            while (!util.controlJogo.getAcerto()) {
                String entrada = util.controlJogo.mostrarOpcoes();

                if (util.controlJogo.verificacaoReposta(entrada) == 1) {
                    break;
                }

            }
            tabelaLocal.mostrarTabela();

            System.out.println("\nDeseja continuar jogando Descubra a palavra (Se sim digite [1] se quer parar [0])");
            int resp = util.sc.nextInt();
            if (resp == 0) sairDoJogo = true;
            else Main.reset(util.main);

        }
    }

    public void setTabelaLocal(Tabela tabelaLocal) {
        this.tabelaLocal = tabelaLocal;
    }
}