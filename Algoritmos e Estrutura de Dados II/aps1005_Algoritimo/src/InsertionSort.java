public class InsertionSort {

    public static void ordenacaoCrescente(int vetor[]){
        int chave ;
        int y;
        boolean achou;

        for (int x=1;x<vetor.length;x++){
            chave = vetor[x];
            y = x-1;
            while (y>=0 && vetor[y]>chave){
                vetor[y+1]= vetor[y];
                y--;
            }
            vetor[y+1] = chave;
        }
    }
}
