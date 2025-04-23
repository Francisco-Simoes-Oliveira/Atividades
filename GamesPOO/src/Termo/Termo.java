package Termo;

import global.Main;

public class Termo {
    boolean[] letrasAcertadas ;
    char[] palavraArray ;
    char[] alfabeto = new char[26];
    char[] letrasUsadas = new char[26];

    public Termo(){
        palavraArray = Main.palavras[0].palavra.toUpperCase().toCharArray();
        letrasAcertadas = new boolean[palavraArray.length];
        for (int x=0;x<26;x++){
            alfabeto[x] = (char)('A'+x);
            letrasUsadas[x] = (char)('A'+x);
        }
    }

    public boolean validacaoTermo(String entrada){
        for (int i = 0; i < letrasAcertadas.length; i++) letrasAcertadas[i] = false;
        if(entrada.equals("0")){
            System.out.println("desistil com " + Main.controlJogo.tentativas + " tentativas, seu merda,lixo,desperdicio de oxigenio");
            return true;
            }else if(entrada.equals("dica")){
            Main.dicas.revelacaoPalavra();
            Main.dicas.mostrarDica();
            Main.dicas.quantidadeDicas ++;
            return false;
        }
        for (int x=0; x<letrasAcertadas.length ;x++)letrasAcertadas[x] = false;
        if (entrada.length() == palavraArray.length) {
            String corVerde = "\033[0;32m";
            String corAmarelo = "\033[0;33m";
            String reset = "\033[0m";

            char[] entradaArray = entrada.toUpperCase().toCharArray();
            for (int x = 0; x < palavraArray.length;x++){
                if (palavraArray[x] == entradaArray[x]){
                    System.out.print(corVerde + entradaArray[x] + reset );
                    letrasAcertadas[x] = true;
                } else {
                    boolean achou = false;
                    for (int y=0; y< palavraArray.length;y++){
                        if(entradaArray[x] == palavraArray[y]) {
                            if (!letrasAcertadas[x]) {
                                achou = true;
                                break;
                            }
                        }
                    }
                    if(achou){
                        System.out.print(corAmarelo + entradaArray[x]+ reset);
                    }else{
                        System.out.print(entradaArray[x]+ reset);
                        int nchar = entradaArray[x];
                        alfabeto[nchar-65] = '0';
                    }

                }
            }
            System.out.println();
        } else {
            System.out.println("Burro");
        }
        Main.controlJogo.tentativas++;
        for (boolean acertou : letrasAcertadas) {
            if (!acertou) return false;
        }
        Main.controlJogo.pontos = Main.controlJogo.pontosAnt + (Main.controlJogo.quatidadeDePalavras * (100 - ((Main.controlJogo.tentativas - 1) * 6)) - (Main.dicas.quantidadeDicas * 18));
        System.out.println("Parabens vc acertou com " + Main.controlJogo.tentativas + " tentativas e " + Main.dicas.quantidadeDicas + " dicas usadas, Mais os " + Main.controlJogo.pontosAnt + " Pontos das partidas anteriores");
        System.out.println("Resultando em " + Main.controlJogo.pontos + " pontos. \n\n");

        return true;
    }
}
