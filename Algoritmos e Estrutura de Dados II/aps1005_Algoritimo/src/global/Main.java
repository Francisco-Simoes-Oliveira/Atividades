package global;


import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Exercicios exercicios = new Exercicios();

        System.out.println("Qual Exercício você quer rodar: ");
        int n = sc.nextInt();
        exercicios.ex(n);
    }

}