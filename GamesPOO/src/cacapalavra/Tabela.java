package cacapalavra;

import global.ControlJogo;
import global.Main;
import global.Util;

public class Tabela {
    private Integer tamanhoTabela;
    private char[][] tabela ;

    Main main;
    Util util = main.util;
    ControlJogo controlJogo = util.controlJogo;

    public Tabela(Main main){
        this.main= main;
        tamanhoTabela = 10;
        tabela = new char[tamanhoTabela][tamanhoTabela];
    }
    public Tabela(int tamanhoTabela, Main main){
        this.main= main;
        this.tamanhoTabela = tamanhoTabela;
        tabela = new char[tamanhoTabela][tamanhoTabela];
    }

    public void precherTabela() {
        for(int x=0; x<tamanhoTabela;x++){
            for (int y=0; y<tamanhoTabela; y++){
                tabela[x][y] = (char)('A' + util.random.nextInt(25));
            }
        }
    }

    public void mostrarTabela() {

        for(int x=0; x<tamanhoTabela;x++){
            for (int y=0; y<tamanhoTabela; y++){
                if (controlJogo.getQuantidadeDeAcertos()>0){
                    if (colorirTabela(x,y)){
                        System.out.print(tabela[x][y]+"|");
                    }
                } else {
                    System.out.print(tabela[x][y]+"|");
                }

            }
            System.out.println(" ");
        }
    }

    public boolean colorirTabela(int linha, int coluna){
        String cor = "\033[0;32m";
        String reset = "\033[0m";
        for (int x = 0; x<controlJogo.quantidadeDePalavras; x++){ //passar pelas palavras
            if (controlJogo.getPalavrasAcertada(x)){
                for (int y=0; y<util.palavras[x].palavra.length() ;y++){// verificar posição
                    int linhaPalavra = util.palavras[x].posisao[y][0];
                    int colunaPalavra = util.palavras[x].posisao[y][1];
                    if (linhaPalavra == linha && colunaPalavra == coluna){
                        System.out.print(cor+tabela[linha][coluna]+reset+"|");
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void esconderPalavra(){
        for (int x = 0; x< controlJogo.quantidadeDePalavras; x++) {
            String palavraEscolhida = util.palavras[x].palavra.toUpperCase();
            char[] palavraArray = palavraEscolhida.toCharArray();
            int tipoDeOcutacao = util.random.nextInt(3);
            int linha ;
            int coluna ;
            util.palavras[x].posisao = new int[palavraEscolhida.length()][2];
            boolean valido = false;
            while (!valido){
                if (tipoDeOcutacao == 0) { //Tipo horizontal
                    linha = util.random.nextInt(tamanhoTabela);
                    coluna = util.random.nextInt(tamanhoTabela - palavraEscolhida.length());
                    for (int y = 0; y < palavraEscolhida.length(); y++) {
                        util.palavras[x].posisao[y][0] = linha;
                        util.palavras[x].posisao[y][1] = coluna;
                        coluna++;
                    }
                    if (!validarPosicao(x)) continue;
                    for (int y = 0; y < palavraEscolhida.length(); y++) {
                        tabela[util.palavras[x].posisao[y][0]][util.palavras[x].posisao[y][1] ] = palavraArray[y];
                    }
                }
                if (tipoDeOcutacao == 1) { //Tipo Vertical
                    linha = util.random.nextInt(tamanhoTabela - palavraEscolhida.length());
                    coluna = util.random.nextInt(tamanhoTabela);
                    for (int y = 0; y < palavraEscolhida.length(); y++) {
                        util.palavras[x].posisao[y][0] = linha;
                        util.palavras[x].posisao[y][1] = coluna;
                        linha++;
                    }
                    if (!validarPosicao(x)) continue;
                    for (int y = 0; y < palavraEscolhida.length(); y++) {
                        tabela[util.palavras[x].posisao[y][0]][util.palavras[x].posisao[y][1] ] = palavraArray[y];
                    }
                }
                if (tipoDeOcutacao == 2) {// Tipo diagonal
                    linha = util.random.nextInt(tamanhoTabela - palavraEscolhida.length());
                    coluna = util.random.nextInt(tamanhoTabela - palavraEscolhida.length());
                    for (int y = 0; y < palavraEscolhida.length(); y++) {
                        util.palavras[x].posisao[y][0] = linha;
                        util.palavras[x].posisao[y][1] = coluna;
                        coluna++;
                        linha++;
                    }
                    if (!validarPosicao(x)) continue;
                    for (int y = 0; y < palavraEscolhida.length(); y++) {
                        tabela[util.palavras[x].posisao[y][0]][util.palavras[x].posisao[y][1] ] = palavraArray[y];
                    }

                }
                valido = validarPosicao(x);
            }
        }
    }

    public boolean validarPosicao(int indiceAtual){
        for (int i = 0; i < indiceAtual; i++) { // para verificar todas as palavras passadas
            for (int x = 0; x < util.palavras[indiceAtual].posisao.length; x++) { // percorres todas as cordenadas da palavra a ser escondida
                for (int y = 0; y < util.palavras[i].posisao.length; y++) { // palavras anteriores que serão comparadas
                    if (util.palavras[indiceAtual].posisao[x][0] == util.palavras[i].posisao[y][0] && util.palavras[indiceAtual].posisao[x][1] == util.palavras[i].posisao[y][1]) {
                        return false; // se uma cordenada de uma letra bater com uma ja escondida ele volta falso e sorteia uma escondida diferente
                    }
                }
            }
        }
        return true;
    }


    public Integer getTamanhoTabela() {
        return tamanhoTabela;
    }

}

