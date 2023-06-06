package com.mycompany.main;

import com.mycompany.model.ModelContaBancaria;
import com.mycompany.model.ModelBanco;

public class mainBanco {

    public static void main(String[] args) {

        ModelBanco bradesco = new ModelBanco(5);

        bradesco.cadastrarConta(10, "Igor Kaique", 250);
        bradesco.cadastrarConta(20, "Igor Kaique", 250);
        bradesco.cadastrarConta(30, "Igor Kaique", 250);
        bradesco.cadastrarConta(40, "Igor Kaique", 250);
        bradesco.cadastrarConta(50, "Igor Kaique", 250);

        double saldo = bradesco.calcularSaldoTotal();
        System.out.println(saldo);

    }

}
