package com.mycompany.estrutura;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int opcao;
        Queue<String> filaPacientes = new LinkedList<>();

        do {
            System.out.println("IgorMed:");
            System.out.println("1 - Adicionar novo paciente");
            System.out.println("2 - Chamar próximo paciente para consulta");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = leia.nextInt();

            switch (opcao) {
                case 1:
                    if (filaPacientes.size() >= 20) {
                        System.out.println("Limite de senhas atingido.");
                    } else {
                        System.out.print("Digite o nome do paciente: ");
                        String nomePaciente = leia.next();
                        filaPacientes.add(nomePaciente);
                        System.out.println("Paciente adicionado na fila.");
                    }
                    break;
                case 2:
                    if (!filaPacientes.isEmpty()) {
                        String proximoPaciente = filaPacientes.poll();
                        System.out.println("Próximo paciente na fila: " + proximoPaciente);
                    } else {
                        System.out.println("Não há pacientes na fila.");
                    }
                    break;
                case 0:
                    System.out.println("Saindo do sistema");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);


    }
}
