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
public class Ex02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Scanner leia = new Scanner(System.in);

        Cliente[] clientes = new Cliente[10];
        int cliCadastrado = 0;

        System.out.println("Informe o código do cliente (ou 0 para sair): ");
        int codigo = leia.nextInt();
        
        while (codigo!=0) {

            System.out.println("Informe o nome do cliente: ");
            String nome = leia.next();

            System.out.println("Informe a data de nascimento do cliente (dd/mm/aaaa): ");
            String dataNascimento = leia.next();

            System.out.println("Informe o CPF do cliente: ");
            String cpf = leia.next();

            clientes[cliCadastrado] = new Cliente(codigo, nome, dataNascimento, cpf);
            System.out.println("Cliente cadastrado com sucesso");
            System.out.println(clientes[cliCadastrado].toString());
            cliCadastrado++;
            
            System.out.println("Digite o código de um novo cliente (ou 0 para sair): ");
            codigo = leia.nextInt();
            
        }

        Arrays.sort(clientes, 0, cliCadastrado);

        System.out.println("Lista dos clientes cadastrados, ordenada por código:");

        for (int i = 0; i < cliCadastrado; i++) {
            System.out.println(clientes[i]);
        }

        System.out.println("Digite o código do cliente a ser pesquisado: ");
        int pesquisar = leia.nextInt();

        int posicao = buscaBinaria(clientes, cliCadastrado, pesquisar);

        if (posicao == -1) {
            System.out.println("Cliente não encontrado.");
        } else {
            System.out.println("Cliente encontrado na posição: "+posicao+".\n Dados do cliente: "+clientes[posicao]);
        }

    }
    
    public static int buscaBinaria(Cliente[] clientes, int count, int codigo) {
        int esquerda = 0;
        int direita = count - 1;

        while (esquerda <= direita) {
            int meio = (esquerda + direita) / 2;

            if (clientes[meio].getCodigo() == codigo) {
                return meio;
            }

            if (clientes[meio].getCodigo() < codigo) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }

        return -1;
    }
    
}
