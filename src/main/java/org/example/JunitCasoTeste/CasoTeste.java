package org.example.JunitCasoTeste;

import org.example.ContaBancaria;
import org.example.Main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;


public class CasoTeste extends Main {
    static List<ContaBancaria> contas;


    @BeforeEach
    void setUp()throws Exception{
        contas = new ArrayList<>();
        contas = ContaBancaria.abrirConta(contas, "Camila Vincensi", 400);
        contas = ContaBancaria.abrirConta(contas, "João", 500);
        contas = ContaBancaria.abrirConta(contas, "Leticia Vincensi", 50000);

    }



    @Test
    void testSaldo(){
        assertEquals(400.0, ContaBancaria.buscarConta(contas, 1).getSaldo());

    }

    @Test
    void testarSaque(){
        ContaBancaria conta1 = ContaBancaria.buscarConta(contas, 1);
        conta1.sacar(399.0);
        assertEquals(1.0, conta1.getSaldo());
    }

    @Test
    void testarDeposito(){
        ContaBancaria conta2 = ContaBancaria.buscarConta(contas, 3);
        conta2.depositar(600);
        assertEquals(50600.0, conta2.getSaldo());

    }

    @Test
    void testarTransferencia(){
        ContaBancaria c2 = ContaBancaria.buscarConta(contas, 2);
        ContaBancaria c3 = ContaBancaria.buscarConta(contas, 3);
        c2.transferir(c3, 150);
        assertEquals(350.00, c2.getSaldo());
        assertEquals(50150.00, c3.getSaldo());
    }

    @Test
    void testNome(){

        assertEquals("Camila Vincensi", ContaBancaria.buscarConta(contas, 1).getNomeTitular());
    }

    @Test
    void testContaInvalida(){
        ContaBancaria contaNula = ContaBancaria.buscarConta(contas, 0);
        assertNull(contaNula);
    }

  @Test
    void testListarContas(){

      // redireciona a saída padrão para uma string
      ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
      System.setOut(new PrintStream(outputStream));

      // chama a função que escreve na saída padrão
      ContaBancaria.listarContas(contas);
      String resultado = outputStream.toString();

      // Verificando se a saída é a esperada
      String listaEsperada = "Conta #1: Camila Vincensi - Saldo: R$400.0\n"+
              "Conta #2: João - Saldo: R$500.0\n"+
              "Conta #3: Leticia Vincensi - Saldo: R$50000.0\n";
       assertEquals(listaEsperada, resultado);
   }




}
