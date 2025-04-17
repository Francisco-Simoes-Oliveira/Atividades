package cacapalavra;

import global.Main;

public class Tabela {
    Integer tamanhoTabela;
    char[][] tabela ;


    public Tabela(){
        tamanhoTabela = 10;
        tabela = new char[tamanhoTabela][tamanhoTabela];
    }

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
            int linha ;
            int coluna ;
            Main.palavras[x].posisao = new int[palavraEscolhida.length()][2];
            boolean valido = false;
            while (!valido){
                if (tipoDeOcutacao == 0) { //Tipo horizontal
                    linha = Main.random.nextInt(tamanhoTabela);
                    coluna = Main.random.nextInt(tamanhoTabela - palavraEscolhida.length());
                    for (int y = 0; y < palavraEscolhida.length(); y++) {
                        Main.palavras[x].posisao[y][0] = linha;
                        Main.palavras[x].posisao[y][1] = coluna;
                        coluna++;
                    }
                    if (!validarPosicao(x)) continue;
                    for (int y = 0; y < palavraEscolhida.length(); y++) {
                        tabela[Main.palavras[x].posisao[y][0]][Main.palavras[x].posisao[y][1] ] = palavraArray[y];
                    }
                }
                if (tipoDeOcutacao == 1) { //Tipo Vertical
                    linha = Main.random.nextInt(tamanhoTabela - palavraEscolhida.length());
                    coluna = Main.random.nextInt(tamanhoTabela);
                    for (int y = 0; y < palavraEscolhida.length(); y++) {
                        Main.palavras[x].posisao[y][0] = linha;
                        Main.palavras[x].posisao[y][1] = coluna;
                        linha++;
                    }
                    if (!validarPosicao(x)) continue;
                    for (int y = 0; y < palavraEscolhida.length(); y++) {
                        tabela[Main.palavras[x].posisao[y][0]][Main.palavras[x].posisao[y][1] ] = palavraArray[y];
                    }
                }
                if (tipoDeOcutacao == 2) {// Tipo diagonal
                    linha = Main.random.nextInt(tamanhoTabela - palavraEscolhida.length());
                    coluna = Main.random.nextInt(tamanhoTabela - palavraEscolhida.length());
                    for (int y = 0; y < palavraEscolhida.length(); y++) {
                        Main.palavras[x].posisao[y][0] = linha;
                        Main.palavras[x].posisao[y][1] = coluna;
                        coluna++;
                        linha++;
                    }
                    if (!validarPosicao(x)) continue;
                    for (int y = 0; y < palavraEscolhida.length(); y++) {
                        tabela[Main.palavras[x].posisao[y][0]][Main.palavras[x].posisao[y][1] ] = palavraArray[y];
                    }

                }
                valido = validarPosicao(x);
            }
        }
    }

    public boolean validarPosicao(int indiceAtual){
        for (int i = 0; i < indiceAtual; i++) { // para verificar todas as palavras passadas
            for (int x = 0; x < Main.palavras[indiceAtual].posisao.length; x++) { // percorres todas as cordenadas da palavra a ser escondida
                for (int y = 0; y < Main.palavras[i].posisao.length; y++) { // palavras anteriores que serão comparadas
                    if (Main.palavras[indiceAtual].posisao[x][0] == Main.palavras[i].posisao[y][0] && Main.palavras[indiceAtual].posisao[x][1] == Main.palavras[i].posisao[y][1]) {
                        return false; // se uma cordenada de uma letra bater com uma ja escondida ele volta falso e sorteia uma escondida diferente
                    }
                }
            }
        }
        return true;
    }

}

