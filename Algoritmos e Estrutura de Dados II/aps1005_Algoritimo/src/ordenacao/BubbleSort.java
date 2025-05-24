package ordenacao;
import global.Paciente;

public class BubbleSort {



    //Int
    public static void ordenacaoCrescente(int[] vetor)/*Ordenar Int de forma Crescente*/{
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

    public static void ordenacaoCrescente(int[] vetor, int n)/*Ordenar Int de forma Crescente, Ate n*/{
        int aux;
        boolean troca;
        for (int x=0;x<n;x++){
            troca = false;
            for (int y=0;y<n -(x+1);y++){
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

    public static void ordenacaoDecrescente(int[] vetor)/*Ordenar Int de forma Decrescente*/{
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


    //Strings
    public static void ordenacaoCrescente(String[] vetor)/*Ordenar String de forma Crescente*/{
        String aux;
        boolean troca;
        for (int x=0;x<vetor.length;x++){
            troca = false;
            for (int y=0;y<vetor.length -(x+1);y++){
                if (vetor[y].compareTo(vetor[y+1]) > 0){
                    aux = vetor[y];
                    vetor[y] = vetor[y+1];
                    vetor[y+1] = aux;

                    troca = true;
                }
            }
            if (!troca) break;
        }
    }


    //Especiais

    public static void ordenarMatriz(int[][] matriz)/*Matriz*/{
        for(int x=0; x< matriz.length;x++){
            ordenacaoCrescente(matriz[x]);
        }
    }

    public static void ordenarPaciente(Paciente paciente[])/*Pacientes*/{
        Paciente aux;
        boolean troca;
        for (int x=0;x<paciente.length;x++){
            troca = false;
            for (int y=0;y<paciente.length -(x+1);y++){
                if (paciente[y].gravidade < paciente[y+1].gravidade){
                    aux = paciente[y];
                    paciente[y] = paciente[y+1];
                    paciente[y+1] = aux;

                    troca = true;
                } else if (paciente[y].gravidade == paciente[y+1].gravidade){
                    if(paciente[y].tempo < paciente[y+1].tempo){
                        aux = paciente[y];
                        paciente[y] = paciente[y+1];
                        paciente[y+1] = aux;

                        troca = true;
                    }
                }
            }
            if (!troca) break;
        }
    }

    public static long ordenacaoCrescenteTempo(int[] vetor)/*Medir tempo*/{
        long inicio = System.nanoTime();
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
        long fim = System.nanoTime();
        return fim - inicio;
    }

}
