package com.cesupa.estrutura_de_dados.estruturas;

import java.util.Arrays;

public class Matriz { 
    // também conhecidas como array multidimensional, ou seja uma array formada por arrays
    public static void main(String[] args) {
        final int tamanho1d = 3; 
        // nesse caso como as 2 dimensões tem o mesmo comprimento, vou utilizar apenas uma const 
        char[][] campoOriginal = new char[tamanho1d][tamanho1d];
        for (int i = 0; i < tamanho1d; i++) {
            for (int j = 0; j < tamanho1d; j++) {
                campoOriginal[i][j] = '-';
            }
        }
        
        // criando outra matriz e inserindo os dados de cada matriz anteior
        char[][] campo = new char[tamanho1d][tamanho1d];
        for (int i = 0; i < tamanho1d; i++) {
            campo[i] = Arrays.copyOf(campoOriginal[i], tamanho1d);
        }
        
        // mostrar todos os elementos da matriz
        System.out.println(Arrays.deepToString(campoOriginal));
        
        // preenchendo diagonal principal
        for (int i = 0; i < tamanho1d; i++) {
            campo[i][i] = 'X';
        }
        System.out.println(Arrays.deepToString(campo));
    }
}
