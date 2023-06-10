package com.mycompany.model;


public class ModelContaBancaria
{

    private int contaNumero;
    private String contaTitular;
    private double contaSaldo, deposito, saque, movimentacao, totalSaque, totalDeposito;

    public ModelContaBancaria() {
    }

    public ModelContaBancaria(int contaNumero, String contaTitular, double contaSaldo) {
        this.contaNumero = contaNumero;
        this.contaTitular = contaTitular;
        this.contaSaldo = contaSaldo;
        this.deposito = 0;
        this.saque = 0;
        this.totalDeposito = 0;
        this.totalSaque= 0;
    }

    public int getContaNumero() {
        return contaNumero;
    }

    public void setContaNumero(int contaNumero) {
        this.contaNumero = contaNumero;
    }

    public String getContaTitular() {
        return contaTitular;
    }

    public void setContaTitular(String contaTitular) {
        this.contaTitular = contaTitular;
    }

    public double getContaSaldo() {
        return contaSaldo;
    }

    public double getDeposito() {
        return deposito;
    }

    public double getSaque() {
        return saque;
    }

    public double getTotalSaque(){
        return totalSaque;
    }

    public double getTotalDeposito(){
        return totalDeposito;
    }

    public void sacar (double saque){
        this.contaSaldo -= saque;
        totalSaque += saque;
    }

    public void deposito(double deposito){
        this.contaSaldo += deposito;
        totalDeposito += deposito;
    }

}
