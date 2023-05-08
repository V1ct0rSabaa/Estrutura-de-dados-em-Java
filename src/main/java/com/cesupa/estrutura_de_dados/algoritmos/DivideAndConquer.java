package com.cesupa.estrutura_de_dados.algoritmos;

import java.util.Arrays;
import java.util.Random;

public class DivideAndConquer {
    public static void main(String[] args) {
        Random random = new Random();
        final int quantidade = 7;
        final int limiteMenor = 10;
        final int limiteMaior = 100;
        int[] arrayTeste = new int[quantidade];
        for (int i = 0; i < quantidade; i++) {
            arrayTeste[i] = random.nextInt(limiteMenor, limiteMaior);
        }
        System.out.printf("Lista original: %s\n", Arrays.toString(arrayTeste));
        //mergeSort(arrayTeste);
        shellSort(arrayTeste);
    }
    
    public static void shellSort(int[] array) {
        // ordenação de Donald Shell
        // melhor caso O(n * log n), pior caso O(n), complexidade de espaço O(1)
        /* Lógica do algoritmo
         * 1- definir o fator k, que normalmente é metade da quantidade dos elementos
         * 2- comparar valores dos indices k e j(iterador), fazendo swap para ordenar
         * 3- diminuir o valor de k em 1
         * 4- repetir passo 2 e 3 até que k seja 0
        */        
        int i, j, temporario;
        final int comprimento = array.length;
        int k = comprimento / 2;
        while(k > 0){
            for(i = k; i < comprimento; i++){
                temporario = array[i];
                j = i - k;
                while(j >= 0 && temporario < array[j]){
                    array[j + k] = array[j];
                    j -= k;
                }
                array[j + k] = temporario;
            }
            k--;
        }
        System.out.printf("Lista ordenada: %s\n", Arrays.toString(array));
    }
    
    private static void merge(int[] arrayOriginal, int[] ladoEsquerdo, int[] ladoDireito){
        final int tamanhoEsquerdo = ladoEsquerdo.length;
        final int tamanhoDireito = ladoDireito.length;
        int i = 0, j = 0, k = 0;
        while(i < tamanhoEsquerdo && j < tamanhoDireito){
            if(ladoEsquerdo[i] <= ladoDireito[j]){
                arrayOriginal[k] = ladoEsquerdo[i];
                i++;
            }
            else{
                arrayOriginal[k] = ladoDireito[j];
                j++;
            }
            k++;
        }
        while(i < tamanhoEsquerdo){
            arrayOriginal[k] = ladoEsquerdo[i];
            i++;
            k++;
        }
        while(j < tamanhoDireito){
            arrayOriginal[k] = ladoDireito[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int[] array) {
        // ordenação por mistura/junção
        // melhor caso O(n * log n), pior caso O(n * log n), complexidade de espaço O(n)
        /* Lógica do algoritmo
         * 1- dividir a lista em listas menores com apenas 1 elemento cada
         * 2- juntar essas listas em pares
         * 2.1 - caso seja uma lista par, vamos ter um trio e o resto de pares
         * 2.2 - unir  e ordenar as listas entre si formando listas com o dobro do comprimento
         * 3 - repetir esse processo até ficar apenas uma lista ordenada 
         */
        final int comprimento = array.length;
        if(comprimento < 2){ 
            return; // para evitar uma recursão infinita
        }
        int metade = comprimento / 2;
        // int[] ladoEsquerdo = Arrays.copyOfRange(array, metade, comprimento);
        // int[] ladoDireito = Arrays.copyOfRange(array, comprimento - metade, comprimento);
        int[] ladoEsquerdo = new int[metade];
        int[] ladoDireito = new int[comprimento - metade];
        for (int i = 0; i < metade; i++) {
            ladoEsquerdo[i] = array[i];
        }
        for (int i = metade; i < comprimento; i++) {
            ladoDireito[i - metade] = array[i];
        }
        mergeSort(ladoEsquerdo);
        mergeSort(ladoDireito);
        merge(array, ladoEsquerdo, ladoDireito);
        // System.out.printf("Lista ordenada: %s\n", Arrays.toString(array));
    }

    private static void swap(int[] array, int index1, int index2){
        // troca 2 elementos de lugar na array
        int temporario = array[index1];
        array[index1] = array[index2];
        array[index2] = temporario;
    }

    public static void quicksort(int[] array, int indexMenor, int indexMaior){
        // ordenação rápida
        // melhor caso O(n * log n), pior caso O(n^2), complexidade de espaço O(log n)
        /* Lógica do algoritmo
         * 1- escolher, aleatoriamente, um pivô(elemento para comparar com os demais da lista)
         * 2- colocar todos os elementos menores a esquerda do pivô e os maiores a direita
         * 3- chamar o algoritmo recursivamente, colocando outro número como pivo
         * 4- repetir até que toda a lista esteja ordenada
         */
        if(indexMenor >= indexMaior){
            return; //evvita recursão infinita por causa das listas de 1 elemento
        }
        int pivo = array[indexMaior];
        int esquerda = indexMenor;
        int direita = indexMaior;
        while(esquerda < direita){
            while(array[esquerda] <= pivo && esquerda < direita){
                esquerda++;
            }
            while(array[direita] >= pivo && esquerda < direita){
                direita--;
            }
            swap(array, esquerda, direita);
        }
        swap(array, esquerda, indexMaior);
        quicksort(array, indexMenor, esquerda - 1);
        quicksort(array, esquerda + 1, indexMaior);
        // System.out.printf("Lista ordenada: %s\n", Arrays.toString(array));
    }

     /* links
     * shell sort:
     * https://www.baeldung.com/java-shell-sort
     * https://youtu.be/YmUCJyc8L7w
     * https://gist.github.com/antonio-abrantes/aa3f452cad97731efd52f4c0e5a54731
     * merge sort:
     * https://youtu.be/5prE6Mz8Vh0
     * https://youtu.be/bOk35XmHPKs
     * https://docs.oracle.com/javase/8/docs/api/java/util/Arrays.html#copyOfRange-int:A-int-int-
     * quick sort:
     * https://youtu.be/h8eyY7dIiN4
     * https://youtu.be/K4in_c9bMHs
     * https://youtu.be/wx5juM9bbFo
     * baeldung.com/java-quicksort
     */
}


    

