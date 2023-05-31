/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.estrutura;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author igork
 */
public class Ex01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Scanner leia = new Scanner(System.in);
        
        System.out.println("Qual a quantidade de números que deseja cadastrar?");
        int tamanho = leia.nextInt();
        
        int numeros[] = new int [tamanho];
        
        for (int i = 0; i < tamanho; i++) {
            System.out.println("Informe um número para preencher na posição "+i);
            numeros[i] = leia.nextInt();
        }
        
        Arrays.sort(numeros);
        
        System.out.println("Escolha o tipo de pesquisa que você deseja fazer");
        System.out.println("1 - linear");
        System.out.println("2 - binario");
        int escolha = leia.nextInt();
        
        int pesquisar;
        
        while (escolha!=0) {            
             System.out.println("Escolha um número a ser pesquisado");
             pesquisar = leia.nextInt();
             
             switch (escolha) {
                case 1:
                    int posicaoL = linear(numeros, pesquisar);
                    if (posicaoL==-1) {
                        System.out.println("Número "+pesquisar+" não encontrado");  
                    } else {
                        System.out.println("Numero encontrado na posição "+posicaoL);
                    }
                    break;
                case 2:
                    int posicaoB = binario(numeros, pesquisar);
                    if (posicaoB==-1) {
                        System.out.println("Número "+pesquisar+" não encontrado");  
                    } else {
                        System.out.println("Numero encontrado na posição "+posicaoB);
                    }
                    break;
                default:
                    throw new AssertionError();
            }
            System.out.println("Escolha o tipo de pesquisa que você deseja fazer");
            System.out.println("1 - linear");
            System.out.println("2 - binario");
            System.out.println("0 - Sair");
            escolha = leia.nextInt();
        }
    }
    
    public static int linear (int numeros[], int pesquisa){
        
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == pesquisa) {
                return i;
            }
        }
        return -1;
        
    }
    
    public static int binario (int numeros[], int pesquisa){
        
        int esquerda = 0;
        int direita = numeros.length - 1;
        while (esquerda <= direita) {
            int meio = (esquerda + direita) / 2;
            if (numeros[meio] == pesquisa) {
                return meio;
            } else if (pesquisa < numeros[meio]) {
                direita = meio - 1;
            } else {
                esquerda = meio + 1;
            }
        }
        return -1;
        
    }
    
}
