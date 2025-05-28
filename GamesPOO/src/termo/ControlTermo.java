package termo;

import global.ControlJogo;
import global.Main;
import global.Util;

public class ControlTermo {
    private boolean[] letrasAcertadas ;
    private char[] palavraArray ;
    protected char[] alfabeto = new char[26];
    protected char[] letrasUsadas = new char[26];

    Util util = Main.util;
    Main main = util.main;
    public ControlTermo(){
        palavraArray = util.palavras[0].palavra.toUpperCase().toCharArray();
        letrasAcertadas = new boolean[palavraArray.length];
        for (int x=0;x<26;x++){
            alfabeto[x] = (char)('A'+x);
            letrasUsadas[x] = (char)('A'+x);
        }
    }

    public boolean validacaoTermo(String entrada){
        ControlJogo controlJogo = util.controlJogo;

        for (int i = 0; i < letrasAcertadas.length; i++) letrasAcertadas[i] = false;
        if(entrada.equals("0")){
            System.out.println("desistil com " + util.controlJogo.tentativas + " tentativas, seu merda,lixo,desperdicio de oxigenio");
            return true;
        }else if(entrada.equals("dica")){
            main.dicas.revelacaoPalavra();
            main.dicas.mostrarDica();
            main.dicas.quantidadeDicas ++;
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
        controlJogo.tentativas++;
        for (boolean acertou : letrasAcertadas) {
            if (!acertou) return false;
        }
        controlJogo.pontos = controlJogo.getPontosAnt() + (controlJogo.quantidadeDePalavras * (100 - ((controlJogo.tentativas - 1) * 6)) - (main.dicas.quantidadeDicas * 18));
        System.out.println("Parabens vc acertou com " + controlJogo.tentativas + " tentativas e " + main.dicas.quantidadeDicas + " dicas usadas, Mais os " + controlJogo.getPontosAnt() + " Pontos das partidas anteriores");
        System.out.println("Resultando em " + controlJogo.pontos + " pontos. \n\n");

        return true;
    }
}
