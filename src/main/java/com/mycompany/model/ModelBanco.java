package com.mycompany.model;

public class ModelBanco {

    private final ModelContaBancaria[] contas;
    private int numeroDeContas;

    public ModelBanco(int qntContas) {
        contas = new ModelContaBancaria[qntContas];
        numeroDeContas = 0;
    }

    public void cadastrarConta (int contaNumero, String contaTitular, double contaSaldo){

        if (verificaContaExistente(contaNumero)){
            System.out.println("Conta existente! Tente novamente com outro número de conta");
        } else {
            if (numeroDeContas < contas.length) {
                contas[numeroDeContas] = new ModelContaBancaria(contaNumero, contaTitular, contaSaldo);
                numeroDeContas++;
                System.out.println("Parabéns, "+contaTitular+". Conta criada com sucesso!");
            } else {
                System.out.println("Não foi possivel criar uma nova conta, o banco atingiu o limite de contas.");
            }
        }
    }

    public boolean verificaContaExistente(int conta){
        for (int i = 0; i < contas.length;i++){
            if (contas[i] != null){
                if (conta == contas[i].getContaNumero()){
                    return true;
                }
            }
        }

        return false;
    }

    public void ordenarContasNumero(){
        for (int i = 0; i < contas.length; i++){
            if (contas[i] != null) {
                for (int j = 0; j < contas.length - 1; j++) {
                    if (contas[j + 1] != null) {
                        if (contas[j].getContaNumero() > contas[j + 1].getContaNumero()) {
                            ModelContaBancaria temp = contas[j];
                            contas[j] = contas[j + 1];
                            contas[j + 1] = temp;
                        }
                    }
                }
            }
        }
    }

    public void ordenarContasSaldo(){
        for (int i = 0; i < contas.length; i++){
            if (contas[i] != null) {
                for (int j = 0; j < contas.length - 1; j++) {
                    if (contas[j + 1] != null) {
                        if (contas[j].getContaSaldo() > contas[j + 1].getContaSaldo()) {
                            ModelContaBancaria temp = contas[j];
                            contas[j] = contas[j + 1];
                            contas[j + 1] = temp;
                        }
                    }
                }
            }
        }
    }

    public void depositar(int numeroConta, double valor){
        double saldoAnterior = 0;
        boolean saquei = false;
        for (ModelContaBancaria conta : contas) {
            if (conta != null) {
                if (conta.getContaNumero() == numeroConta) {
                    saldoAnterior = conta.getContaSaldo();
                    conta.deposito(valor);
                    System.out.println("Deposito realizado com sucesso!" +
                            "\nSaldo Anterior: R$" + saldoAnterior +
                            "\nSaldo Atual: R$" + conta.getContaSaldo());
                    saquei = true;
                }
            }
        }
        if (!saquei){
            System.out.println("Conta inexistente!");
        }
    }

    public void listarContas(){
        for (int i = 0; i < contas.length; i++) {
            if (contas[i] != null){
                System.out.println("---------------------------------------------------");
                System.out.println("Numero da conta: " + contas[i].getContaNumero());
                System.out.println("Titular da conta: " + contas[i].getContaTitular());
                System.out.println("Saldo da conta: " + contas[i].getContaSaldo());
            }
        }
    }

    public void listarContasPorSaldo(){
        ordenarContasSaldo();
        listarContas();
    }

    public void listarContasPorNumero(){
        ordenarContasNumero();
        listarContas();
    }
    public void sacar(int numeroConta, double valor){
        ordenarContasNumero();
        double saldoAnterior = 0;
        int contaBuscada = buscaBinaria(numeroConta);
        if (contaBuscada >= 0 ){
            if (contas[contaBuscada].getContaSaldo() < valor){
                System.out.println("O valor do saque é maior que o saldo da conta! Tente novamente");
            } else {
                saldoAnterior = contas[contaBuscada].getContaSaldo();
                contas[contaBuscada].sacar(valor);
                System.out.println("Obrigado "+contas[contaBuscada].getContaTitular()+
                        "\nSaldo Anterior: R$"+saldoAnterior+
                        "\nSaldo Atual: R$"+contas[contaBuscada].getContaSaldo());
            }

        } else {
            System.out.println("Conta inexistente! Tente novamente.");
        }
    }

    private int buscaBinaria(int numeroConta) {
        int inicio = 0;
        int fim = numeroDeContas - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            if (contas[meio].getContaNumero() == numeroConta) {
                return meio;
            } else if (contas[meio].getContaNumero() < numeroConta) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return -1;
    }



    private double calcularSaldoTotalRecursivo(int i) {
        if (i == contas.length || contas[i] == null) {
            return 0;
        } else {
            double saldo = contas[i].getContaSaldo();
            double saldoRestante = calcularSaldoTotalRecursivo(i + 1);
            return saldo + saldoRestante;
        }
    }

    public double calcularSaldoTotal() {
        if (contas != null){
            return calcularSaldoTotalRecursivo(0);
        } else {
            return 0;
        }
    }

    

    private void verificarSaldosNegativosRecursivo(int i) {
        if (i == contas.length || contas[i] == null) {
            return;
        }

        double saldo = contas[i].getContaSaldo();
        if (saldo < 0) {
            System.out.println("Conta " + contas[i].getContaNumero() + " possui saldo negativo: -R$" + contas[i].getContaSaldo()*(-1));
        }

        verificarSaldosNegativosRecursivo(i + 1);
    }

    public void verificarSaldosNegativos() {
        if (contas != null){
            verificarSaldosNegativosRecursivo(0);
        }
    }

    public double totalMovimentacaoDeposito(int conta){
        for (int i = 0; i < contas.length; i++){
            if (contas[i] != null){
                if (contas[i].getContaNumero() == conta){
                    return contas[i].getTotalDeposito();
                }
            }
        }
        return 0;
    }

    public double totalMovimentacaoSaque(int conta){
        for (int i = 0; i < contas.length; i++){
            if (contas[i] != null){
                if (contas[i].getContaNumero() == conta){
                    return contas[i].getTotalSaque();
                }
            }
        }
        return 0;
    }

    public void totalMovimentacaoConta(int conta){
        double totalMovimentacao = 0;
        for (int i = 0; i < contas.length; i++){
            if (contas[i] != null){
                if (contas[i].getContaNumero() == conta){
                    totalMovimentacao = contas[i].getTotalSaque() + contas[i].getTotalDeposito();
                    System.out.println("Total de movimentação da conta: R$"+totalMovimentacao);
                    System.out.println("Total de depósitos realizado na conta: R$"+contas[i].getTotalDeposito());
                    System.out.println("Total de saques realizado na conta: R$"+contas[i].getTotalSaque());
                }
            }
        }
    }

    public double totalMovimentacaoContaSaque(int conta){
        return 0;
    }

    public double totalMovimentacaoContaDeposito (int conta){
        return 0;
    }

}
