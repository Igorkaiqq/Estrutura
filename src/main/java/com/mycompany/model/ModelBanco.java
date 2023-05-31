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

    }

    public void depositar(){

    }

    public void sacar(){

    }

    private int buscaBinaria(int NumeroConta){
        return numeroConta;
    }

    private double calcularSaldoTotal(){
        return a;
    }

}
