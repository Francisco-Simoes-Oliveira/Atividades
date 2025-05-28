package descubraPalavras;

import global.ControlJogo;
import global.Main;
import global.Util;


public class PalavrasEmbaralhadas {
    Main main = new Main();
    Util util = main.util;
    ControlJogo controlJogo = util.controlJogo;
    private String[] palavraEmbaralhadas = new String[controlJogo.quantidadeDePalavras];

    public void embaralhar() {
        for (int x = 0; x< controlJogo.quantidadeDePalavras; x++) {
            char[] palavraArray = util.palavras[x].palavra.toUpperCase().toCharArray();
            for (int y = 0; y < palavraArray.length; y++) {
                int indiceAleatorio = util.random.nextInt(palavraArray.length);


                char temp = palavraArray[y];
                palavraArray[y] = palavraArray[indiceAleatorio];
                palavraArray[indiceAleatorio] = temp;
            }
            palavraEmbaralhadas[x] = new String(palavraArray);
        }
    }

    public void mostrarPalavraEmbaralhada(){
        System.out.println("Palavras: ");
        for (int x = 0; x<controlJogo.quantidadeDePalavras; x++){
            System.out.println((x+1) + "°: "+ palavraEmbaralhadas[x]);
        }
    }
}