public class BubbleSort {
    public static void ordenacaoCrescente(int[] vetor){
        int aux;
        boolean troca;
        for (int x=0;x<vetor.length;x++){
            troca = false;
            for (int y=0;y<vetor.length -(x+1);y++){
                if (vetor[y] > vetor[y+1]){
                    aux = vetor[y];
                    vetor[y] = vetor[y+1];
                    vetor[y+1] = aux;

                    troca = true;
                }
            }
            if (!troca) break;
        }
    }

    public static void ordenacaoDecrescente(int[] vetor){
        int aux;
        boolean troca;
        for (int x=0;x<vetor.length;x++){
            troca = false;
            for (int y=0;y<vetor.length -(x+1);y++){
                if (vetor[y] < vetor[y+1]){
                    aux = vetor[y];
                    vetor[y] = vetor[y+1];
                    vetor[y+1] = aux;

                    troca = true;
                }
            }
            if (!troca) break;
        }
    }
}
