package com.cesupa.estrutura_de_dados.algoritmos;

import java.util.Arrays;

public class AlgoritmosBusca {
    public static int linearSearch(Integer[] array, int valor){
        // também chamado de sequential search, complexidade - O(n)
        int index = -1; // se não achar, retorna -1
        for (Integer num : array) {
            if(num.intValue() == valor){
                index = valor;
            }
        }
        return index;
    }
    public static String binarySearch(Integer[] array, int valor){
        // complexidade - O(log n)
        final Integer index = Arrays.binarySearch(array, valor);
        String texto = index == -1 ? "O valor não está na lista" : "o valor está na posição " + index.toString();
        return texto;
    }
    public static int jumpSearch(Integer[] array, int valor) {
        // complexidade - O(n^1/2)
        final int comprimento = array.length;
        int step = (int)Math.floor(Math.sqrt(comprimento));
        int passoAtual = 0;
        int n = -1;
        if(array[comprimento] < valor){ return n;}
        for(passoAtual = Math.min(step, comprimento)-1; array[passoAtual].intValue() < valor; passoAtual = Math.min(step, comprimento)-1){
            if(array[passoAtual].intValue() == valor){
                break;
            }
            n = step;
            step += (int)Math.floor(Math.sqrt(comprimento));
        }
        // linear search
        for (int i = 0; i < comprimento; i++) {
            if(array[passoAtual].intValue() == valor){
                n = passoAtual;
            }
        }
        return n;
    }
    /* links
     * https://www.geeksforgeeks.org/jump-search/
     * https://www.baeldung.com/cs/jump-search-algorithm
     * https://www.freecodecamp.org/news/search-algorithms-linear-and-binary-search-explained/
     * https://www.freecodecamp.org/news/jump-search-algorithm-explained/
     */
}
