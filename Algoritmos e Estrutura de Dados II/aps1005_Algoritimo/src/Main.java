public class Main {
    public static void main(String[] args) {
        int vetor[] = {3, 0, -2, 5, 8};

        BubbleSort.ordenacaoDecrescente(vetor);

        for (int x=0;x<vetor.length;x++){
            System.out.println(vetor[x]);
        }

    }
}