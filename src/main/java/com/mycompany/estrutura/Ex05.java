package com.mycompany.estrutura;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Ex05 {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int opcao;
        Queue<Clientee> filaP= new LinkedList<>();
        Queue<Clientee> filaN = new LinkedList<>();
        int atendimentosPrioritarios = 0;

        do {
            System.out.println("Menu:");
            System.out.println("1 - Adicionar cliente");
            System.out.println("2 - Chamar próximo cliente");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = leia.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    leia.nextLine(); // Limpar o buffer do leia
                    String nomeCliente = leia.nextLine();
                    System.out.print("Digite o ano de nascimento do cliente: ");
                    int anoNascimento = leia.nextInt();
                    Clientee cliente = new Clientee(0, nomeCliente, anoNascimento);

                    if (anoNascimento > 65) {
                        filaP.add(cliente);
                    } else {
                        filaN.add(cliente);
                    }
                    System.out.println("Cliente adicionado na fila de espera.");
                    break;
                case 2:
                    if (!filaP.isEmpty()) {
                        Clientee proximoCliente = filaP.poll();
                        proximoCliente.senha++;
                        atendimentosPrioritarios++;
                        System.out.println("Próximo cliente prioritário para ser atendido caixa: " + proximoCliente.nome);
                        System.out.println("Senha: " + proximoCliente.senha);
                    } else if (!filaN.isEmpty()) {
                        Clientee proximoCliente = filaN.poll();
                        proximoCliente.senha++;
                        System.out.println("Próximo cliente no para ser atendido caixa: " + proximoCliente.nome);
                        System.out.println("Senha: " + proximoCliente.senha);
                    } else {
                        System.out.println("Não tem clientes na fila.");
                    }

                    if (atendimentosPrioritarios == 2) {
                        atendimentosPrioritarios = 0;
                        if (!filaN.isEmpty()) {
                            Clientee proximoCliente = filaN.poll();
                            proximoCliente.senha++;
                            System.out.println("Próximo cliente sem prioridade de atendimento no caixa: " + proximoCliente.nome);
                            System.out.println("Senha: " + proximoCliente.senha);
                        }
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
}
