public class SelectionSort {

    public static void ordenacaoCrescente(int[] vetor){
        int menor;
        int aux;
        for (int x=0;x<vetor.length-1;x++){
            menor = x;
            for (int y=x+1;y<vetor.length;y++){
                if (vetor[menor] > vetor[y]){
                    menor = y;
                }
            }
            aux = vetor[x];
            vetor[x] = vetor[menor];
            vetor[menor] = aux;
        }
    }

    public static void ordenacaoDecrescente(int[] vetor){
        int menor;
        int aux;
        for (int x=0;x<vetor.length-1;x++){
            menor = x;
            for (int y=x+1;y<vetor.length;y++){
                if (vetor[menor] < vetor[y]){
                    menor = y;
                }
            }
            aux = vetor[x];
            vetor[x] = vetor[menor];
            vetor[menor] = aux;
        }
    }
}
