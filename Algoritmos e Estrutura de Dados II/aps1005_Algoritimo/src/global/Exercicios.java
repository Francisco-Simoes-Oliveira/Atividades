package global;

import ordenacao.BubbleSort;
import ordenacao.InsertionSort;
import ordenacao.SelectionSort;
import ordenacao.MergeSort;

import java.util.Scanner;

public class Exercicios {
    public Scanner sc = new Scanner(System.in);
    public void ex(int n){

        if (n == 1) ex01();
        else if (n == 3) ex03();
        else if (n == 2) ex02();
        else if (n == 4) ex04();
        else if (n == 5) ex05();
        else if (n == 6) ex06();
        else if (n == 7) ex07();
        else if (n == 8) ex08();
        else if (n == 9) ex09();
        else if (n == 10) ex10();
        else System.out.println("Exercício invlido");
    }

    private void ex01(){
        int vetor[] = {3, 4, 9, 2, 5, 8, 2, 1, 7};
        BubbleSort.ordenacaoCrescente(vetor);
        //SelectionSort.ordenacaoCrescente(vetor);
        //InsertionSort.ordenacaoCrescente(vetor);
        //MergeSort.ordenacao(vetor);
        Imprimir.printVetor(vetor);
    }
    private void ex02(){
        int vetor[] = {3, 0, -2, 5, 8};
        BubbleSort.ordenacaoDecrescente(vetor);
        //SelectionSort.ordenacaoDecrescente(vetor);
        //InsertionSort.ordenacaoDecrescente(vetor);
        //MergeSort.ordenacao(vetor); pegar no notbook
        Imprimir.printVetor(vetor);
    }
    private void ex03(){
        String vetor[] = {"bbb", "aaa", "ccc"};
        BubbleSort.ordenacaoCrescente(vetor);
        //SelectionSort.ordenacaoCrescente(vetor);
        //InsertionSort.ordenacaoCrescente(vetor);
        //MergeSort.ordenacao(vetor);
        Imprimir.printVetor(vetor);
    }
    private void ex04(){
        int vetor[] = {8, 4, 3, 7, 6, 5, 2};
        Imprimir.printVetor(vetor);
        System.out.println("Ate que posição deseja ordenar: ");
        int n = sc.nextInt();

        BubbleSort.ordenacaoCrescente(vetor, n);
        Imprimir.printVetor(vetor);
    }
    private void ex05(){
        int matriz[][] = {{3, 2, 1}, {6, 5, 4}, {9, 8, 7}};
        BubbleSort.ordenarMatriz(matriz);

        for (int x=0; x< matriz.length;x++){
            Imprimir.printVetor(matriz[x]);
        }

    }
    private void ex06()/*Não tem numeração então daqui para frente e Ex(n+1)*/{
        int vetor[] = {85, 70, 95, 60, 75, 80};
        double media = 0;
        BubbleSort.ordenacaoCrescente(vetor);

        for (int x=0; x< vetor.length;x++){
            media += vetor[x];
        }
        media = media/ vetor.length;

        Imprimir.printNotas(vetor, media);
    }
    private void ex07(){
        int vetor[] = {250, 300, 150, 400, 350};
        /*for (int x=0; x< vetor.length;x++){
            System.out.println("Nota "+(x+1)+": ");
            vetor[x] = sc.nextInt();
        }*/
        BubbleSort.ordenacaoDecrescente(vetor);
        Imprimir.printPontos(vetor);

    }
    private void ex08(){
        Paciente[] paciente = {new Paciente("João", 3, 5),
                new Paciente("Maria", 3, 10), new Paciente("Lucas",5,2)};

        BubbleSort.ordenarPaciente(paciente);
        Imprimir.printPaciente(paciente);

    }
    private void ex09(){

    }
    private void ex10(){
    }


}