package global;

public class Imprimir {

    public static void printVetor(int vetor[]){
        System.out.print("[");
        for (int x=0; x< vetor.length; x++){
            System.out.print(vetor[x]+", ");
        }
        System.out.print("]\n");
    }
    public static void printVetor(String vetor[]){
        System.out.print("\n[");
        for (int x=0; x< vetor.length; x++){
            System.out.print(vetor[x]+", ");
        }
        System.out.print("]\n");
    }

    public static void printNotas(int vetor[], double media){
        System.out.print("Notas Ordenadas: " );
        Imprimir.printVetor(vetor);
        System.out.println("Mediana: "+media);
    }

    public static void printPontos(int vetor[]){
        System.out.println("Pontuações Ordenadas: ");
        Imprimir.printVetor(vetor);
        System.out.println("Pontuação Mais Alta: "+ vetor[0]);
    }

    public static void printPaciente(Paciente paciente[]){
        for (int x=0; x< paciente.length;x++){
            System.out.print(paciente[x].nome+", ");
        }
        System.out.print("\n");
    }

    public static void printColocacao(long[][] tempos, int[][] melhores){
        String[] nomes = {"BubbleSort","SelectSort","InsertionSort","MergeSort"};
        System.out.println("Vetor Aleatorio");
        int colocacao = 1;
        for (int x=0; x<4; x++){
            for (int y=0; y<4; y++) {
                if (melhores[y][0] == colocacao) {
                    System.out.println((x + 1) + "° " + nomes[y] + ": " + tempos[y][0] + " nanosegundos");
                    colocacao++;
                    break;
                }
            }
        }

        System.out.println("\nVetor Inverço");
        colocacao = 1;
        for (int x=0; x<4; x++){
            for (int y=0; y<4; y++) {
                if (melhores[y][1] == colocacao) {
                    System.out.println((x + 1) + "° " + nomes[y] + ": " + tempos[y][1] + " nanosegundos");
                    colocacao++;
                    break;
                }
            }
        }

        System.out.println("\nVetor Ordenado");
        colocacao = 1;
        for (int x=0; x<4; x++){
            for (int y=0; y<4; y++) {
                if (melhores[y][2] == colocacao) {
                    System.out.println((x + 1) + "° " + nomes[y] + ": " + tempos[y][2] + " nanosegundos");
                    colocacao++;
                    break;
                }
            }
        }
    }

    public static void printAnalise(long[][] tempos, int[][] melhores, int[][] operacoes){
        String[] nomes = {"BubbleSort","SelectSort","InsertionSort","MergeSort"};
        System.out.println("Vetor Aleatorio");
        int colocacao = 1;
        for (int x=0; x<4; x++){
            for (int y=0; y<4; y++) {
                if (melhores[y][0] == colocacao) {
                    System.out.println((x + 1) + "° " + nomes[y] + ": " + tempos[y][0] + " nanosegundos e "+ operacoes[y][0]+" Trocas");
                    colocacao++;
                    break;
                }
            }
        }

        System.out.println("\nVetor Inverço");
        colocacao = 1;
        for (int x=0; x<4; x++){
            for (int y=0; y<4; y++) {
                if (melhores[y][1] == colocacao) {
                    System.out.println((x + 1) + "° " + nomes[y] + ": " + tempos[y][1] + " nanosegundos e "+ operacoes[y][1]+" Trocas");
                    colocacao++;
                    break;
                }
            }
        }

        System.out.println("\nVetor Ordenado");
        colocacao = 1;
        for (int x=0; x<4; x++){
            for (int y=0; y<4; y++) {
                if (melhores[y][2] == colocacao) {
                    System.out.println((x + 1) + "° " + nomes[y] + ": " + tempos[y][2] + " nanosegundos "+ operacoes[y][2]+" Trocas");
                    colocacao++;
                    break;
                }
            }
        }
    }
}
