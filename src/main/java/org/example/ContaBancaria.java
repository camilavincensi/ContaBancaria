package org.example;

import java.util.List;

public class ContaBancaria {

        private int numeroConta;
        private String nomeTitular;
        private double saldo;

        public ContaBancaria(int numeroConta, String nomeTitular, double saldoInicial) {
            this.numeroConta = numeroConta;
            this.nomeTitular = nomeTitular;
            this.saldo = saldoInicial;
        }

        public int getNumeroConta() {
            return numeroConta;
        }

        public String getNomeTitular() {
            return nomeTitular;
        }

        public double getSaldo() {
            return saldo;
        }

        public void depositar(double valor) {
            saldo += valor;
        }

        public void sacar(double valor) {
            saldo -= valor;
        }

        public void transferir(org.example.ContaBancaria outraConta, double valor) {
            this.sacar(valor);
            outraConta.depositar(valor);
        }

        public static List<org.example.ContaBancaria> abrirConta(List <org.example.ContaBancaria> contas, String nomeTitular, double saldoInicial) {
            int numeroConta = contas.size() + 1;
            org.example.ContaBancaria novaConta = new org.example.ContaBancaria(numeroConta, nomeTitular, saldoInicial);
            contas.add(novaConta);
            return contas;
        }

        public static void listarContas(List <ContaBancaria> contas) {
            for (ContaBancaria conta: contas) {
                System.out.println("Conta #" + conta.getNumeroConta() + ": " + conta.getNomeTitular() + " - Saldo: R$" + conta.getSaldo());
            }
        }

        public static org.example.ContaBancaria buscarConta(List <ContaBancaria> contas, int numeroConta) {
            for (org.example.ContaBancaria conta: contas) {
                if (conta.getNumeroConta() == numeroConta) {
                    return conta;
                }
            }
            return null;
        }
    }
