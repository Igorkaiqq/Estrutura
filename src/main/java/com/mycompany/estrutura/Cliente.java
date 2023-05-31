/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.estrutura;

/**
 *
 * @author igork
 */
public class Cliente implements Comparable<Cliente> {

    /**
     * @param args the command line arguments
     */
    private int codigo;
    private String nome;
    private String dataNascimento;
    private String cpf;

    public Cliente(int codigo, String nome, String dataNascimento, String cpf) {
        this.codigo = codigo;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public int compareTo(Cliente outro) {
        return this.codigo - outro.codigo;
    }

    @Override
    public String toString() {
        return "Cliente [codigo= " + codigo + ", nome= " + nome + ", dataNascimento= " + dataNascimento + ", cpf= " + cpf
                + "]";
    }

}
