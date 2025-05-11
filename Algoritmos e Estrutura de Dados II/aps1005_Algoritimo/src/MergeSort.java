public class MergeSort {

    public static void ordenacao(int vetor[]){
        int aux[] = new int[vetor.length];
        ordenacaoMarge(vetor, aux, 0, vetor.length - 1);
    }
    private static void ordenacaoMarge(int vetor[],int aux[], int inicio, int fim){
        int meio = (inicio + fim)/2;

        if (inicio<fim){
            ordenacaoMarge(vetor,aux,inicio,meio);
            ordenacaoMarge(vetor,aux,meio+1,fim);
            intercalacaoCrecente(vetor, aux, inicio, meio, fim);
        }
    }

    public static void intercalacaoCrecente(int vetor[], int aux[], int inicio, int meio, int fim){

        for (int x=0; x<= fim;x++){
            aux[x] =vetor[x];
        }

        int esquerda = inicio;
        int direita = meio+1;

        for (int x=inicio; x <= fim;x++){
            if(esquerda>meio) {
                vetor[x] = aux[direita++];
            }else if(direita>fim) {
                vetor[x] = aux[esquerda++];
            }else if(aux[esquerda] < aux[direita]) {
                vetor[x] = aux[esquerda++];
            }else {
                vetor[x] = aux[direita++];
            }
        }
    }
}
