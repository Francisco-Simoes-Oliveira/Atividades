package cacapalavra;

import global.ControlJogo;
import global.Main;
import global.Palavras;

public class Tabela {
    Integer tamanhoTabela  = 10 ;
    char tabela[][] = new char[tamanhoTabela][tamanhoTabela];


    public void precherTabela() {

        for(int x=0; x<tamanhoTabela;x++){
            for (int y=0; y<tamanhoTabela; y++){
                tabela[x][y] = (char)('A' + Main.random.nextInt(25));
            }
        }
    }

    public void mostrarTabela() {
        for(int x=0; x<tamanhoTabela;x++){
            for (int y=0; y<tamanhoTabela; y++){
                System.out.print(tabela[x][y]+"|");
            }
            System.out.println(" ");
        }
    }

    public void esconderPalavra(){
        for (int x = 0; x< Main.controlJogo.quatidadeDePalavras; x++) {
            String palavraEscolhida = Main.palavras[x].palavra.toUpperCase();
            char[] palavraArray = palavraEscolhida.toCharArray();
            int tipoDeOcutacao = Main.random.nextInt(3);
            int linha = 0;
            int coluna = 0;
            if (tipoDeOcutacao == 0) { //Tipo horizontal
                linha = Main.random.nextInt(10);
                coluna = Main.random.nextInt(10 - palavraEscolhida.length());
                for (int y = 0; y < palavraEscolhida.length(); y++) {
                    tabela[linha][coluna] = palavraArray[y];
                    coluna++;
                }
            }
            if (tipoDeOcutacao == 1) { //Tipo Vertical
                linha = Main.random.nextInt(10 - palavraEscolhida.length());
                coluna = Main.random.nextInt(10);
                for (int y = 0; y < palavraEscolhida.length(); y++) {
                    tabela[linha][coluna] = palavraArray[y];
                    linha++;
                }
            }
            if (tipoDeOcutacao == 2) {// Tipo diagonal
                linha = Main.random.nextInt(10 - palavraEscolhida.length());
                coluna = Main.random.nextInt(10 - palavraEscolhida.length());
                for (int y = 0; y < palavraEscolhida.length(); y++) {
                    tabela[linha][coluna] = palavraArray[y];
                    coluna++;
                    linha++;
                }
            }
        }
    }

}
