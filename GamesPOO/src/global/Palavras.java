package global;

public class Palavras {
    String opcoesPavras[] = {"formol","acervo","vender","vaso","ator","bobo","livro","carta","garfo","dor","sal"};
    public String palavra = "";



    public void escolherPalavra(){
        for (int x=0;x<Main.controlJogo.quatidadeDePalavras;x++){
            Main.palavras[x].palavra = opcoesPavras[Main.random.nextInt(opcoesPavras.length)];
        }
    }

}
