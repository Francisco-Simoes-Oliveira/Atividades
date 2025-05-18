package global;
import java.util.Random;

public class criacaoVetor {
    static Random random = new Random();

    public static int[] criacaoVetorOrdenado(int tamanho){
        int[] vetor = new int[tamanho];

        int n = random.nextInt(100);
        for(int x=0; x<tamanho; x++){
            vetor[x] = n++;
        }
        return vetor;
    }

    public static int[] criacaoVetorInvertidos(int tamanho){
        int[] vetor = new int[tamanho];
        int n = random.nextInt(100);
        for(int x=0; x<tamanho; x++){
            vetor[x] = n--;
        }
        return vetor;
    }

    public static int[] criacaoVetorAleatorio(int tamanho){
        int[] vetor = new int[tamanho];
        for(int x=0; x<tamanho; x++){
            int n = random.nextInt(100);
            vetor[x] = n;
        }
        return vetor;
    }
}
