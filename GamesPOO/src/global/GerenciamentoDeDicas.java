package global;

public class GerenciamentoDeDicas {
    public Integer quantidadeDicas = 0;
    public String[] palavraRevelada ;
    static Integer indexPalavrasReveladas = 0;


    public GerenciamentoDeDicas(){
        palavraRevelada = new String[Main.controlJogo.quatidadeDePalavras];
        for (int x=0; x<Main.controlJogo.quatidadeDePalavras;x++){
            palavraRevelada[x] = "_";
        }
    }

    public void revelacaoPalavra() {
        //if (quantidadeDicas == (palavraRevelada[indexPalavrasReveladas].length() - 1) && indexPalavrasReveladas<ControlJogo.quatidadeDePalavras){
        //    indexPalavrasReveladas+= 1;
        //}

        String palavraEscolhida = Main.palavras[indexPalavrasReveladas].palavra;
        char[] palavraEscolhidaArray = palavraEscolhida.toCharArray();
        char[] palavraReveladaArray = new char[palavraEscolhida.length()];
        if (!palavraRevelada[0].equals("_")) {
            palavraReveladaArray = palavraRevelada[indexPalavrasReveladas].toCharArray();
        } else {
            for (int y = 0;y < palavraEscolhida.length(); y++) {
                palavraReveladaArray[y] = '_';
            }
        }

        if (quantidadeDicas == 0 || quantidadeDicas == palavraEscolhida.length()) {
            palavraReveladaArray[0] = palavraEscolhidaArray[0];
            palavraReveladaArray[palavraReveladaArray.length - 1] = palavraEscolhidaArray[palavraEscolhida.length() - 1];
        } else {
            palavraReveladaArray[quantidadeDicas] = palavraEscolhidaArray[quantidadeDicas];
        }
        palavraRevelada[indexPalavrasReveladas] = new String(palavraReveladaArray);
    }

    public void mostrarDica(){
        System.out.println("Dicas: ");
        for (int x=0; x<Main.controlJogo.quatidadeDePalavras;x++){
            System.out.println((x+1)+"°: "+palavraRevelada[x]);
        }
    }
}
