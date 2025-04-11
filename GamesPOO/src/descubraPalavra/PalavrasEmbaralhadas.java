package descubraPalavra;

import global.ControlJogo;
import global.Main;
import global.Palavras;

public class PalavrasEmbaralhadas {
    static String[] palavraEmbaralhadas = new String[Main.controlJogo.quatidadeDePalavras];

    public void embaralhar() {
        for (int x = 0; x< Main.controlJogo.quatidadeDePalavras; x++) {
            char[] palavraArray = Main.palavras[x].palavra.toUpperCase().toCharArray();
            for (int y = 0; y < palavraArray.length; y++) {
                int indiceAleatorio = Main.random.nextInt(palavraArray.length);


                char temp = palavraArray[y];
                palavraArray[y] = palavraArray[indiceAleatorio];
                palavraArray[indiceAleatorio] = temp;
            }
        palavraEmbaralhadas[x] = new String(palavraArray);
        }
    };

    public void mostrarPalavraEmbaralhada(){
        System.out.println("Palavras: ");
        for (int x=0; x<Main.controlJogo.quatidadeDePalavras; x++){
            System.out.println((x+1) + "°: "+ palavraEmbaralhadas[x]);
        }
    }
}
