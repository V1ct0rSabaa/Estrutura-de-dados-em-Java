package com.cesupa.estrutura_de_dados.estruturas;

import java.util.Arrays;

public class Arranjo {
    public static void main(String[] args) {
        String[] cores = {"red", "green", "blue"};
        final int comprimento = cores.length;

        // mostrar todos os elementos do array com a classe Array
        System.out.printf("%s\n", Arrays.toString(cores));
        // ao chamar o toString do array, por padrão retornara o endereço em hexadecimal, logo ilegivel do objeto
        // percorrer a array de trás para frente
        for (int i = comprimento - 1; i >= 0; i--) { 
            System.out.printf("%s\t", cores[i]);
        }
        
        // criando uma array com dados de outra
        String[] cores2 = Arrays.copyOf(cores, 5);
        cores2[3] = "yellow";
        cores2[4] = "purple";
        System.out.printf("\n%s", Arrays.toString(cores2));
    }
    /* Caracteristas das Arrays
     * tamanho e tipo de dado fixos
     * rápido para encontrar dados
     * dificil para apagar dados
     * ajudam a unir dados parecidos na mesma estrurura
     * podem simular outras estruturas como stacks, queue, heaps...
     * arrays não inicializados recebem valores, como 0, 0.0, false, null ou undefined(js) para evitar raise exceptions
     */
    /* links
     * https://www.geeksforgeeks.org/array-data-structure/
     * https://youtu.be/d3z3FDtVoDw
     * https://www.geeksforgeeks.org/default-array-values-in-java/
     * https://www.freecodecamp.org/portuguese/news/metodos-de-arrays-em-java-como-imprimir-um-array-em-java/
    */
}
