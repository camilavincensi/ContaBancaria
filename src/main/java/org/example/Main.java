package org.example;

import java.util.ArrayList;
import java.util.List;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        List<ContaBancaria> contas = new ArrayList<>();

        contas = ContaBancaria.abrirConta(contas, "Camila Vincensi", 400);
        contas = ContaBancaria.abrirConta(contas, "João", 200);

        ContaBancaria c1 = ContaBancaria.buscarConta(contas, 1);

        System.out.println("O saldo do " + c1.getNomeTitular() + " é: R$ " + c1.getSaldo());


        ContaBancaria.listarContas(contas);

    }
}