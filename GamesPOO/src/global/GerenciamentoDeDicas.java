
package global;

public class GerenciamentoDeDicas {
    public Integer quantidadeDicas = 0;
    public String[] palavraRevelada ;
    public Integer indexPalavrasReveladas = 0;
    public Integer indexCaracter = 0;

    ControlJogo controlJogo;
    Util util = Main.util;

    public GerenciamentoDeDicas(){
        controlJogo = Main.util.controlJogo;
        palavraRevelada = new String[controlJogo.quantidadeDePalavras];
        for (int x = 0; x<controlJogo.quantidadeDePalavras; x++){
            palavraRevelada[x] = "_";
        }
    }
    public GerenciamentoDeDicas(Main main){
        ControlJogo controlJogo = util.controlJogo;

        palavraRevelada = new String[controlJogo.quantidadeDePalavras];
        for (int x = 0; x<controlJogo.quantidadeDePalavras; x++){
            palavraRevelada[x] = "_";
        }
    }

    public void revelacaoPalavra() {
        if (indexCaracter == (util.palavras[indexPalavrasReveladas].palavra.length() - 1) && indexPalavrasReveladas<controlJogo.quantidadeDePalavras && indexPalavrasReveladas != 0){
            indexPalavrasReveladas+= 1;
        }
        while (indexPalavrasReveladas < controlJogo.quantidadeDePalavras && controlJogo.getPalavrasAcertada(indexPalavrasReveladas)) {
            palavraRevelada[indexPalavrasReveladas] = util.palavras[indexPalavrasReveladas].palavra;
            indexPalavrasReveladas++;
            indexCaracter = 0;
        }
        if (indexPalavrasReveladas >= controlJogo.quantidadeDePalavras) {
            return;
        }

        String palavraEscolhida = util.palavras[indexPalavrasReveladas].palavra;
        char[] palavraEscolhidaArray = palavraEscolhida.toCharArray();
        char[] palavraReveladaArray = new char[palavraEscolhida.length()];
        if (!palavraRevelada[indexPalavrasReveladas].equals("_")) {
            palavraReveladaArray = palavraRevelada[indexPalavrasReveladas].toCharArray();
        } else {
            for (int y = 0;y < palavraEscolhida.length(); y++) {
                palavraReveladaArray[y] = '_';
            }
        }



        if (quantidadeDicas == 0 || indexCaracter == 0) {
            palavraReveladaArray[0] = palavraEscolhidaArray[0];
            palavraReveladaArray[palavraReveladaArray.length - 1] = palavraEscolhidaArray[palavraEscolhida.length() - 1];
            indexCaracter +=1;
        } else {
            if (indexCaracter < palavraEscolhidaArray.length - 1) {
                palavraReveladaArray[indexCaracter] = palavraEscolhidaArray[indexCaracter];
                indexCaracter += 1;
            }
        }
        palavraRevelada[indexPalavrasReveladas] = new String(palavraReveladaArray);
    }

    public void mostrarDica(){
        System.out.println("Dicas: ");
        for (int x = 0; x<controlJogo.quantidadeDePalavras; x++){
            System.out.println((x+1)+"°: "+palavraRevelada[x]);
        }
    }

}
