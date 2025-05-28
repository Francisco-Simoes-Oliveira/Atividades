package global;

public class Palavras {
    public String palavra;
    public int[][] posisao;
    private String opcoesPavras[] = {"formol","acervo","vender","vaso","ator","bobo","livro","carta","garfo","dor","sal","achar"
            ,"drama","itens","opala","aluno","neles","linda","colher","pepita","grafia","tronar","bolota","bronze","calcar"
            ,"cair","lima","rijo","cedo","lato","onde","lide","gude"};

    Util util = Main.util;


    public Palavras(){
        escolherPalavra();
    }
    /*
        public void escolherPalavra(int i){

            for (int x = 0; x<controlJogo.quantidadeDePalavras; x++){
                main.palavras[x].palavra = opcoesPavras[main.random.nextInt(opcoesPavras.length)];
                if (x>0){
                    for (int y=0; y < x; y++) {
                        if (main.palavras[x].palavra.equals(main.palavras[y].palavra)){
                            x -= 1;
                            break;
                        }
                    }
                }
            }
        }*/
    public void escolherPalavra(){
        palavra = opcoesPavras[util.random.nextInt(opcoesPavras.length)];
    }

}