package com.mycompany.main;

import com.mycompany.model.ModelBanco;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        
        Scanner leia = new Scanner(System.in);
        ModelBanco banco = new ModelBanco(4);

        System.out.println("=== BEM VINDO AO BANCO Igor'Corp ===");
        System.out.println("Deseja cadastrar uma conta?");
        System.out.println("1 - Sim");
        System.out.println("0 - Não");
        int opcao = leia.nextInt();

        if (opcao==1) {

            while (opcao!=0){
                switch (opcao) {
                    case 1:
                        System.out.print("Número da conta: ");
                        int numeroConta = leia.nextInt();
                        leia.nextLine(); // Limpar o buffer do teclado
                        System.out.print("Nome do titular: ");
                        String nomeTitular = leia.nextLine();
                        System.out.print("Saldo inicial: ");
                        double saldoInicial = leia.nextDouble();
                        banco.cadastrarConta(numeroConta, nomeTitular, saldoInicial);
                        break;
                    case 2:
                        banco.listarContasPorNumero();
                        System.out.println("Contas ordenadas por número.");
                        break;
                    case 3:
                        banco.listarContasPorSaldo();
                        System.out.println("Contas ordenadas por saldo.");
                        break;
                    case 4:
                        System.out.print("Número da conta: ");
                        int numeroContaDeposito = leia.nextInt();
                        System.out.print("Valor do depósito: ");
                        double valorDeposito = leia.nextDouble();
                        banco.depositar(numeroContaDeposito, valorDeposito);
                        break;
                    case 5:
                        System.out.print("Número da conta: ");
                        int numeroContaSaque = leia.nextInt();
                        System.out.print("Valor do saque: ");
                        double valorSaque = leia.nextDouble();
                        banco.sacar(numeroContaSaque, valorSaque);
                        break;
                    case 6:
                        double saldoTotal = banco.calcularSaldoTotal();
                        System.out.println("Saldo total do banco: " + saldoTotal);
                        break;
                    case 7:
                        banco.verificarSaldosNegativos();
                        break;
                    case 8:
                        System.out.println("Qual o número da conta que você deseja saber o total de movimentações?");
                        int contaMovimentacao = leia.nextInt();
                        banco.totalMovimentacaoConta(contaMovimentacao);

                    case 0:
                        System.out.println("Saindo do sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
                System.out.println("=== Sistema Bancário IgorCorp ===");
                System.out.println("1 - Cadastrar uma nova conta.");
                System.out.println("2 - Ordenar as contas por número.");
                System.out.println("3 - Ordenar as contas por saldo.");
                System.out.println("4 - Realizar um depósito.");
                System.out.println("5 - Realizar um saque.");
                System.out.println("6 - Calcular saldo total do banco.");
                System.out.println("7 - Verificar os saldos negativos.");
                System.out.println("8 - Verificar a movimentação total de uma conta.");
                System.out.println("0 - Sair.");
                opcao = leia.nextInt();
            }
        }
    }
    
}
