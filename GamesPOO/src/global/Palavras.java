package global;

public class Palavras {
    public String palavra = "";
    public int[][] posisao;


    public void escolherPalavra(){
        String opcoesPavras[] = {"formol","acervo","vender","vaso","ator","bobo","livro","carta","garfo","dor","sal"};
        for (int x=0;x<Main.controlJogo.quatidadeDePalavras;x++){
            Main.palavras[x].palavra = opcoesPavras[Main.random.nextInt(opcoesPavras.length)];
            if (x>0){
                for (int y=0; y < x; y++) {
                    if (Main.palavras[x].palavra.equals(Main.palavras[y].palavra)){
                        x -= 1;
                        break;
                    }
                }
            }
        }
    }

}
