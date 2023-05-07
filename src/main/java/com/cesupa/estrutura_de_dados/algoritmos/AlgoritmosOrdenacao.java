package com.cesupa.estrutura_de_dados.algoritmos;

import java.util.Arrays;
import java.util.Random;

public class AlgoritmosOrdenacao {
    public static void main(String[] args) {
        Random random = new Random();
        final int quantidade = 8;
        final int limiteMenor = 10;
        final int limiteMaior = 100;
        int[] arrayTeste = new int[quantidade];
        for (int i = 0; i < quantidade; i++) {
            arrayTeste[i] = random.nextInt(limiteMenor, limiteMaior);
        }
        System.out.printf("Lista original: %s\n", Arrays.toString(arrayTeste));
        bubbleSort(arrayTeste);
        reverseBubbleSort(arrayTeste);
    }

    public static void selectionSort(int[] array){
        // ordenação por seleção
        // melhor caso - O(n^2), pior caso - O(n^2), complexidade de espaço O(1)
        /* lógica do algoritmo
         * 1- achar o menor elemento da lista
         * 2- colocar ele na primeira posição
         * 3- achar o menor elemento da parte não ordenada da lsita
         * 4- colocar ele na posição seguinte ao ultimo elemento da parte ordenad
         * 5- repetir  até que a lista esteja ordenada
         */
        final int comprimento = array.length;
         for (int i = 0; i < comprimento - 1; i++) {
            int indiceMenor = i;
            for (int j = i + 1; j < comprimento; j++) {
                if(array[indiceMenor] > array[j]){ //determinando qual o menor elemento
                    indiceMenor = j;
                }
            }
            // swap entre o primeiro elemento e o menor elemento
            int menorNumero = array[indiceMenor];
            array[indiceMenor] = array[i];
            array[i] = menorNumero;
        }
        System.out.printf("Lista ordenada: %s", Arrays.toString(array));
    }
    public static void reverseSelectionSort(int[] array){
        final int comprimentoArray = array.length;
         for (int i = 0; i < comprimentoArray - 1; i++) {
            int indiceMaior = i;
            for (int j = i + 1; j < comprimentoArray; j++) {
                if(array[indiceMaior] < array[j]){
                    indiceMaior = j;
                }
            }
            int menorNumero = array[indiceMaior];
            array[indiceMaior] = array[i];
            array[i] = menorNumero;
        }
        System.out.printf("Lista em ordem decrescente: %s\n", Arrays.toString(array));
    }
    public static void insertionSort(int[] array){
        // ordenação por inserção
        // melhor caso O(n), pior caso O(n^2), complexidade de espaço O(1)
        /* Lógica do algoritmo 
         * 1- comparar o primeiro com o segundo elemento da lista
         * 2- colocar o menor em uma sublista(ordenados), incialmente vazia
         * 3- repetir o passo 1
         * 4- repetir passo 2, colocando em uma posição ordenada, até a lista não estiver mais desordenada
        */
        for (int i = 1; i < array.length; i++) {
            int valorAtual = array[i];
            int indexSublista = i - 1;
            while(indexSublista >= 0  && array[indexSublista] > valorAtual){
                array[indexSublista + 1] = array[indexSublista];
                indexSublista--;
            }
            array[indexSublista + 1] = valorAtual;
        }
        System.out.printf("lista ordenada: %s\n", Arrays.toString(array));
    }
    public static void bubbleSort(int[] array){
        // ordenação por bolha/flutuação
        // melhor caso O(n), pior caso O(n^2), complexidade de espaço O(1)
        boolean continuarSwap = true;
        while(continuarSwap){
            continuarSwap = false;
            for (int i = 0; i < array.length - 1; i++) {
                if(array[i] > array[i + 1]){
                    int temporario = array[i]; //swap de posições
                    array[i] = array[i + 1];
                    array[i + 1] = temporario;
                    continuarSwap = true;
                }
            }
        }
        System.out.printf("lista ordenada: %s\n", Arrays.toString(array));
    }
    public static void reverseBubbleSort(int[] array) {
        boolean continuarSwap = true;
        while(continuarSwap){
            continuarSwap = false;
            for (int i = 0; i < array.length - 1; i++) {
                if(array[i] < array[i + 1]){
                    int temporario = array[i]; 
                    array[i] = array[i + 1];
                    array[i + 1] = temporario;
                    continuarSwap = true;
                }
            }
        }
        System.out.printf("Lista em ordem decrescente: %s\n", Arrays.toString(array));
    }
    /* links
     * selection sort:
     * https://youtu.be/ZT_dT8yn48s 
     * https://youtu.be/kZH0vWXs_Bk
     * https://www.baeldung.com/java-selection-sort
     * insertionSort:
     * https://youtu.be/S5no2qT8_xg
     * https://youtu.be/0lOnnd50cGI
     * https://youtu.be/JU767SDMDvA
     * https://www.freecodecamp.org/news/insertion-sort-algorithm-example-in-java-and-c/
     * https://www.baeldung.com/java-insertion-sort
     * bubbleSort:
     * https://youtu.be/g8qeaEd2jTc
     * https://youtu.be/GiNPe_678Ms
     * https://www.freecodecamp.org/news/bubble-sort-algorithm-in-java-cpp-python-with-example-code/
     * https://www.baeldung.com/java-bubble-sort
     */
}
