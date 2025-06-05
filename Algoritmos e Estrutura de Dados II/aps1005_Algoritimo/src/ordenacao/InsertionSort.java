package ordenacao;

public class InsertionSort {

    //Int
    public static void ordenacaoCrescente(int vetor[]){
        int chave ;
        int y;

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

    public static void ordenacaoCrescente(int vetor[], int n){
        int chave ;
        int y;

        for (int x=1;x<n;x++){
            chave = vetor[x];
            y = x-1;
            while (y>=0 && vetor[y]>chave){
                vetor[y+1]= vetor[y];
                y--;
            }
            vetor[y+1] = chave;
        }
    }

    public static void ordenacaoDecrescente(int vetor[]){
        int chave ;
        int y;

        for (int x=1;x<vetor.length;x++){
            chave = vetor[x];
            y = x-1;
            while (y>=0 && vetor[y]<chave){
                vetor[y+1]= vetor[y];
                y--;
            }
            vetor[y+1] = chave;
        }
    }


    //String
    public static void ordenacaoCrescente(String vetor[]){
        String chave ;
        int y;

        for (int x=1;x<vetor.length;x++){
            chave = vetor[x];
            y = x-1;
            while (y>=0 && vetor[y].compareTo(chave)>0){
                vetor[y+1]= vetor[y];
                y--;
            }
            vetor[y+1] = chave;
        }
    }

    //Especiais

    public static void ordenarMatriz(int[][] matriz)/*Matriz*/{
        for(int x=0; x< matriz.length;x++){
            ordenacaoCrescente(matriz[x]);
        }
    }

    public static long ordenacaoCrescenteTempo(int vetor[]){
        long inicio = System.nanoTime();
        int chave ;
        int y;

        for (int x=1;x<vetor.length;x++){
            chave = vetor[x];
            y = x-1;
            while (y>=0 && vetor[y]>chave){
                vetor[y+1]= vetor[y];
                y--;
            }
            vetor[y+1] = chave;
        }
        long fim = System.nanoTime();
        return fim-inicio;
    }

    public static int ordenacaoCrescenteQuantia(int[] vetor)/*Medir tempo e comtar operação*/{
        int quandidade = 0;
        int chave ;
        int y;

        for (int x=1;x<vetor.length;x++){
            chave = vetor[x];
            y = x-1;
            while (y>=0 && vetor[y]>chave){
                vetor[y+1]= vetor[y];
                y--;
            }
            vetor[y+1] = chave;
            quandidade++;
        }

        return quandidade;
    }

}



