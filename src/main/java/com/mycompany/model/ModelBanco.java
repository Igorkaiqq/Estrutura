package com.mycompany.model;

public class ModelBanco {

    private ModelContaBancaria[] contas;
    private int numeroDeContas;

    public ModelBanco(int qntContas) {
        contas = new ModelContaBancaria[qntContas];
        numeroDeContas = 0;
    }

    public void cadastrarConta (int contaNumero, String contaTitular, double contaSaldo){
        if (numeroDeContas < contas.length) {
            contas[numeroDeContas] = new ModelContaBancaria(contaNumero, contaTitular, contaSaldo);
            numeroDeContas++;
            System.out.println("Parabéns, "+contaTitular+". Conta criada com sucesso!");
        } else {
            System.out.println("Não foi possivel criar uma nova conta, o banco atingiu o limite de contas.");
        }
    }

    public void ondenarContasNumero(){
        for (int i = 0; i < numeroDeContas; i++){
            for (int j = 0; j < numeroDeContas - 1; j++){
                if (contas[j].getContaNumero() > contas[j+1].getContaNumero()){
                    ModelContaBancaria temp = contas[j];
                    contas[j] = contas[j+1];
                    contas[j+1] = temp;
                }
            }
        }
    }

    public void ordenarContasSaldo(){
        for (int i = 0; i < numeroDeContas; i++){
            for (int j = 0; j < numeroDeContas - 1; j++){
                if (contas[j].getContaSaldo() > contas[j+1].getContaSaldo()){
                    ModelContaBancaria temp = contas[j];
                    contas[j] = contas[j+1];
                    contas[j+1] = temp;
                }
            }
        }
    }

    public void depositar(int numeroConta, double valor){
        for (int i = 0; i < numeroDeContas; i++){
            if (contas[i].getContaNumero() == numeroConta){
                contas[i].deposito(valor);
            }
        }
    }

    public void sacar(int numeroConta, double valor){
        ordenarContasSaldo();
        int contaBuscada = buscaBinaria(numeroConta);
        if (contaBuscada >= 0 ){
            contas[contaBuscada].sacar(valor);
            System.out.println("Obrigado "+contas[contaBuscada].getContaTitular()+
                    ". Saque no valor de R$"+valor+" realizado com sucesso!");
        } else {
            System.out.println("Conta inexistente! Tente novamente.");
        }

    }

    private int buscaBinaria(int numeroConta){
        int inicio = 0;
        int fim = numeroDeContas - 1;

        while(inicio > fim){
            int meio = (inicio + fim) / 2;
            if (contas[meio].getContaNumero() == numeroConta){
                return meio;
            } else if (contas[meio].getContaNumero() < numeroConta){
                inicio = meio + 1;
            } else {
                fim = meio -1;
            }
        }
        return - 1;
    }

    private double calcularSaldoTotal(){
        return a;
    }

}
