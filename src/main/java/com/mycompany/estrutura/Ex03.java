package com.mycompany.estrutura;

import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int somaTotal = somar(50);
        System.out.println("Soma total dos numeros de 0 até 50 é "+somaTotal);

        System.out.println("Você deseja fazer o fatorial de que número?");
        int fatorial = leia.nextInt();
        int fatorialResultado = calcularFatorial(fatorial);
        System.out.println("Fatorial do numero "+fatorial+" é "+fatorialResultado);

        System.out.println("Você deseja fazer a sequencia fibonacci de que tamanho?");
        int sequencia = leia.nextInt();
        System.out.println("Sequencia fibonacci de tamanho "+sequencia);
        for (int i = 0; i < sequencia; i++){
            System.out.print(fibonacci(i)+" ");
        }



    }

    public static int somar(int numero) {
        if (numero == 0) {
            return 0;
        } else {
            return numero + somar(numero - 1);
        }
    }

    public static int calcularFatorial(int numero) {
        if (numero == 0 || numero == 1) {
            return 1;
        } else {
            return numero * calcularFatorial(numero - 1);
        }
    }

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

}
