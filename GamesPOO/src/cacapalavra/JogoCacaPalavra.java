package cacapalavra;

import global.ControlJogo;
import global.Main;
import global.Palavras;

public class JogoCacaPalavra {
    public static Tabela tabelaLocal = new Tabela();
    public static Palavras palavrasLocal  = new Palavras();

    public JogoCacaPalavra(){
        tabelaLocal = new Tabela();
        palavrasLocal = new Palavras();
    }



    public void jogarCacaPalavra() {

        boolean sairDoJogo = false;
        while (!sairDoJogo) {
            tabelaLocal = new Tabela(tabelaLocal.tamanhoTabela);
            palavrasLocal = new Palavras();

            tabelaLocal.precherTabela();
            palavrasLocal.escolherPalavra();
            tabelaLocal.esconderPalavra();
            tabelaLocal.mostrarTabela();


            while (!Main.controlJogo.acerto) {
                String entrada = ControlJogo.mostrarOpcoes();

                if (Main.controlJogo.verificacaoReposta(entrada) == 1) {
                    break;
                }

            }
            tabelaLocal.mostrarTabela();

            System.out.println("\nDeseja continuar jogando Descubra a palavra (Se sim digite [1] se quer parar [0])");
            int resp = Main.sc.nextInt();
            if (resp == 0) sairDoJogo = true;
            else Main.reset();

        }
    }

    public void gerenciamentoDificuldade(int dificuldade){
        if (dificuldade == 2){
            Main.controlJogo.quatidadeDePalavras = 3;
            tabelaLocal.tamanhoTabela = 15;
        } else if (dificuldade == 3) {
            Main.controlJogo.quatidadeDePalavras = 5;
            tabelaLocal.tamanhoTabela = 20;
        }
        Main.reset();
    }
}