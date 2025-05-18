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
}
