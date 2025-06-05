package ordenacao;

import global.Paciente;

public class SelectionSort{

    //Int
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

    public static void ordenacaoDecrescente(int[] vetor, int n){
        int menor;
        int aux;
        for (int x=0;x<n-1;x++){
            menor = x;
            for (int y=x+1;y<n;y++){
                if (vetor[menor] < vetor[y]){
                    menor = y;
                }
            }
            aux = vetor[x];
            vetor[x] = vetor[menor];
            vetor[menor] = aux;
        }
    }

    //String
    public static void ordenacaoCrescente(String[] vetor){
        int menor;
        String aux;
        for (int x=0;x<vetor.length-1;x++){
            menor = x;
            for (int y=x+1;y<vetor.length;y++){
                if (vetor[menor].compareTo(vetor[y]) > 0){
                    menor = y;
                }
            }
            aux = vetor[x];
            vetor[x] = vetor[menor];
            vetor[menor] = aux;
        }
    }

    //Especial

    public static void ordenarPaciente(Paciente paciente[])/*Pacientes*/{
        Paciente aux;
        int menor;
        for (int x=0;x<paciente.length;x++){
           menor = x;
            for (int y=x+1;y<paciente.length;y++){
                if (paciente[menor].gravidade > paciente[y].gravidade){
                    menor = y;

                } else if (paciente[menor].gravidade == paciente[y].gravidade){
                    if(paciente[menor].tempo > paciente[y].tempo){
                        menor = y;
                    }
                }
            }
            aux = paciente[x];
            paciente[x] = paciente[menor];
            paciente[menor] = aux;
        }
    }

    public static void ordenarMatriz(int[][] matriz)/*Matriz*/{
        for(int x=0; x< matriz.length;x++){
            ordenacaoCrescente(matriz[x]);
        }
    }

    public static long ordenacaoCrescenteTempo(int[] vetor){
        long inicio = System.nanoTime();
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
        long fim = System.nanoTime();
        return fim - inicio;
    }

    public static int ordenacaoCrescenteQuantia(int[] vetor)/*Medir tempo e comtar operação*/{
        int quandidade = 0;
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
            quandidade++;
        }

        return quandidade;
    }
}
