package ordenacao;

import global.Imprimir;

public class MergeSort {

    public static int quandidade = 0;

    public static void ordenacao(int vetor[]){
        int aux[] = new int[vetor.length];
        ordenacaoMarge(vetor, aux, 0, vetor.length - 1,1);
    }

    public static void ordenacao(int vetor[], int n){
        int aux[] = new int[vetor.length];
        ordenacaoMarge(vetor, aux, 0, n- 1,1);
    }

    public static void ordenacao(int tipo,int vetor[]){
        int aux[] = new int[vetor.length];
        ordenacaoMarge(vetor, aux, 0, vetor.length - 1,tipo);
    }

    private static void ordenacaoMarge(int vetor[],int aux[], int inicio, int fim,int tipo){
        int meio = (inicio + fim)/2;

        if (inicio<fim){
            ordenacaoMarge(vetor,aux,inicio,meio,tipo);
            ordenacaoMarge(vetor,aux,meio+1,fim,tipo);
            if (tipo == 1)intercalacaoCrecente(vetor, aux, inicio, meio, fim);
            else if (tipo == -1)intercalacaoDecrecente(vetor, aux, inicio, meio, fim);
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
    public static void intercalacaoDecrecente(int vetor[], int aux[], int inicio, int meio, int fim){

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
            }else if(aux[esquerda] > aux[direita]) {
                vetor[x] = aux[esquerda++];
            }else {
                vetor[x] = aux[direita++];
            }
        }
    }



    //---------------String----------------------------//

    public static void ordenacao(String vetor[]){
        String aux[] = new String[vetor.length];
        ordenacaoMarge(vetor, aux, 0, vetor.length - 1,1);
    }
    public static void ordenacao(int tipo ,String vetor[]){
        String aux[] = new String[vetor.length];
        ordenacaoMarge(vetor, aux, 0, vetor.length - 1,tipo);
    }


    private static void ordenacaoMarge(String vetor[],String aux[], int inicio, int fim,int tipo){
        int meio = (inicio + fim)/2;

        if (inicio<fim){
            ordenacaoMarge(vetor,aux,inicio,meio,tipo);
            ordenacaoMarge(vetor,aux,meio+1,fim,tipo);
            if (tipo == 1)intercalacaoCrecente(vetor, aux, inicio, meio, fim);
            else if (tipo == -1)intercalacaoDecrecente(vetor, aux, inicio, meio, fim);
        }
    }

    public static void intercalacaoCrecente(String vetor[], String aux[], int inicio, int meio, int fim){

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
            }else if(aux[esquerda].compareTo(aux[direita]) < 0) {
                vetor[x] = aux[esquerda++];
            }else {
                vetor[x] = aux[direita++];
            }
        }
    }
    public static void intercalacaoDecrecente(String vetor[], String aux[], int inicio, int meio, int fim){

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
            }else if(aux[esquerda].compareTo(aux[direita]) > 0) {
                vetor[x] = aux[esquerda++];
            }else {
                vetor[x] = aux[direita++];
            }
        }
    }


    //Especiais

    public static void ordenarMatriz(int[][] matriz)/*Matriz*/{
        for(int x=0; x< matriz.length;x++){
            ordenacao(matriz[x]);
        }
    }

    public static long ordenacaoTempo(int vetor[]){
        long inicio = System.nanoTime();
        int aux[] = new int[vetor.length];
        ordenacaoMarge(vetor, aux, 0, vetor.length - 1,1);
        long fim = System.nanoTime();
        return fim - inicio;
    }

    public static int ordenacaoQuantia(int vetor[]){
        quandidade = 0;
        int aux[] = new int[vetor.length];
        ordenacaoMarge(vetor, aux, 0, vetor.length - 1,1, 0);
        return quandidade;
    }

    private static void ordenacaoMarge(int vetor[],int aux[], int inicio, int fim,int tipo, int n){
        int meio = (inicio + fim)/2;

        if (inicio<fim){
            ordenacaoMarge(vetor,aux,inicio,meio,tipo);
            ordenacaoMarge(vetor,aux,meio+1,fim,tipo);
            if (tipo == 1)intercalacaoCrecente(vetor, aux, inicio, meio, fim, n);
            //else if (tipo == -1)intercalacaoDecrecente(vetor, aux, inicio, meio, fim, quandidade);
        }
    }

    public static void intercalacaoCrecente(int vetor[], int aux[], int inicio, int meio, int fim, int n){

        for (int x=0; x<= fim;x++){
            aux[x] =vetor[x];
        }

        int esquerda = inicio;
        int direita = meio+1;

        for (int x=inicio; x <= fim;x++){
            if(esquerda>meio) {
                vetor[x] = aux[direita++];
                quandidade++;
            }else if(direita>fim) {
                vetor[x] = aux[esquerda++];
                quandidade++;
            }else if(aux[esquerda] < aux[direita]) {
                vetor[x] = aux[esquerda++];
                quandidade++;
            }else if(aux[esquerda] > aux[direita]){
                vetor[x] = aux[direita++];
                quandidade++;
            }

        }

    }

}
