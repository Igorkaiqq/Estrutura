package com.mycompany.model;


public class ModelContaBancaria
{

    private int contaNumero;
    private String contaTitular;
    private double contaSaldo, deposito, saque;

    public ModelContaBancaria() {
    }

    public ModelContaBancaria(int contaNumero, String contaTitular, double contaSaldo) {
        this.contaNumero = contaNumero;
        this.contaTitular = contaTitular;
        this.contaSaldo = contaSaldo;
        this.deposito = 0;
        this.saque = 0;
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

    public void sacar (double saque){
        this.contaSaldo -= saque;
        this.saque += saque;
    }

    public void deposito(double deposito){
        this.contaSaldo += deposito;
        this.deposito += deposito;
    }

}
