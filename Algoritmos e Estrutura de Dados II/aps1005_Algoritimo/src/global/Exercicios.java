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
        //SelectionSort.ordenacaoCrescente(vetor, n);
        //InsertionSort.ordenacaoCrescente(vetor, n);
        //MergeSort.ordenacao(vetor, n)

        Imprimir.printVetor(vetor);
    }
    private void ex05(){
        int matriz[][] = {{3, 2, 1}, {6, 5, 4}, {9, 8, 7}};
        BubbleSort.ordenarMatriz(matriz);
        //SelectionSort.ordenarMatriz(matriz);
        //InsertionSort.ordenarMatriz(matriz);
        //MergeSort.ordenarMatriz(matriz);

        for (int x=0; x< matriz.length;x++){
            Imprimir.printVetor(matriz[x]);
        }

    }
    private void ex06()/*Não tem numeração então daqui para frente e Ex(n+1)*/{
        int vetor[] = {85, 70, 95, 60, 75, 80};
        double media = 0;
        BubbleSort.ordenacaoCrescente(vetor);
        //SelectionSort.ordenacaoCrescente(vetor);
        //InsertionSort.ordenacaoCrescente(vetor);
        //MergeSort.ordenacao(vetor);

        for (int x=0; x< vetor.length;x++){
            media += vetor[x];
        }
        media = media/ vetor.length;

        Imprimir.printNotas(vetor, media);
    }
    private void ex07()/*6*/{
        int vetor[] = {250, 300, 150, 400, 350};
        /*for (int x=0; x< vetor.length;x++){
            System.out.println("Nota "+(x+1)+": ");
            vetor[x] = sc.nextInt();
        }*/
        BubbleSort.ordenacaoDecrescente(vetor);
        //SelectionSort.ordenacaoDecrescente(vetor);
        //InsertionSort.ordenacaoDecrescente(vetor);
        //MergeSort.ordenacao(-1, vetor);

        Imprimir.printPontos(vetor);

    }
    private void ex08()/*7*/{
        Paciente[] paciente = {new Paciente("João", 3, 5),
                new Paciente("Maria", 3, 10), new Paciente("Lucas",5,2)};

        BubbleSort.ordenarPaciente(paciente);
        //SelectionSort.ordenarPaciente(paciente);

        Imprimir.printPaciente(paciente);

    }
    private void ex09()/*8*/{
        System.out.println("Qual sera o tamanho do vetor");
        int tamanho = sc.nextInt();

        int tipoVetor = 1;

        long tempos[][] = new long[4][3]; //linha tipos de ordenação; coluna tipos de vetor

        for (int x=0; x<3; x++){
            int[] vetor = new int[tamanho];

            if(tipoVetor == 1)vetor = CriacaoVetor.criacaoVetorAleatorio(tamanho);
            else if(tipoVetor == 2)vetor = CriacaoVetor.criacaoVetorInvertidos(tamanho);
            else if (tipoVetor == 3) vetor = CriacaoVetor.criacaoVetorOrdenado(tamanho);



            int[] aux = vetor.clone();
            tempos[0][x] = BubbleSort.ordenacaoCrescenteTempo(aux);
            aux = vetor.clone();
            tempos[1][x] = SelectionSort.ordenacaoCrescenteTempo(aux);
            aux = vetor.clone();
            tempos[2][x] = InsertionSort.ordenacaoCrescenteTempo(aux);
            aux = vetor.clone();
            tempos[3][x] = MergeSort.ordenacaoTempo(aux);

           tipoVetor++;
        }
        int melhores[][] = new int[4][3];

        for (int x=0; x<3; x++){
            for(int y=0; y<4;y++){
                melhores[y][x] = 0;
            }
        }

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 4; y++) {
                int colocacao = 1;

                for (int z = 0; z < 4; z++) {
                    if (tempos[z][x] < tempos[y][x]) {
                        colocacao++;
                    }
                }

                melhores[y][x] = colocacao;
            }
        }
        Imprimir.printColocacao(tempos, melhores);

    }
    private void ex10()/*9*/{
        System.out.println("Qual sera o tamanho do vetor");
        int tamanho = sc.nextInt();

        int tipoVetor = 1;

        long tempos[][] = new long[4][3]; //linha tipos de ordenação; coluna tipos de vetor
        int operacoes[][] = new int[4][3];

        for (int x=0; x<3; x++){
            int[] vetor = new int[tamanho];

            if(tipoVetor == 1)vetor = CriacaoVetor.criacaoVetorAleatorio(tamanho);
            else if(tipoVetor == 2)vetor = CriacaoVetor.criacaoVetorInvertidos(tamanho);
            else if (tipoVetor == 3) vetor = CriacaoVetor.criacaoVetorOrdenado(tamanho);


            int[] aux = vetor.clone();
            tempos[0][x] = BubbleSort.ordenacaoCrescenteTempo(aux);
            aux = vetor.clone();
            tempos[1][x] = SelectionSort.ordenacaoCrescenteTempo(aux);
            aux = vetor.clone();
            tempos[2][x] = InsertionSort.ordenacaoCrescenteTempo(aux);
            aux = vetor.clone();
            tempos[3][x] = MergeSort.ordenacaoTempo(aux);

            aux = vetor.clone();
            operacoes[0][x] = BubbleSort.ordenacaoCrescenteQuantia(aux);
            aux = vetor.clone();
            operacoes[1][x] = SelectionSort.ordenacaoCrescenteQuantia(aux);
            aux = vetor.clone();
            operacoes[2][x] = InsertionSort.ordenacaoCrescenteQuantia(aux);
            aux = vetor.clone();
            operacoes[3][x] = MergeSort.ordenacaoQuantia(aux);


            tipoVetor++;
        }
        int melhores[][] = new int[4][3];

        for (int x=0; x<3; x++){
            for(int y=0; y<4;y++){
                melhores[y][x] = 0;
            }
        }

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 4; y++) {
                int colocacao = 1;

                for (int z = 0; z < 4; z++) {
                    if (tempos[z][x] < tempos[y][x]) {
                        colocacao++;
                    }
                }

                melhores[y][x] = colocacao;
            }
        }

        Imprimir.printAnalise(tempos,melhores,operacoes);
    }


}