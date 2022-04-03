package Entities;

import java.util.Objects;
import java.util.Random;

public abstract class Conta {
    Random random = new Random();

    private static final int AGENCIA_PADRAO = 1;
    //private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = 1 + random.nextInt(9999);
        this.cliente = cliente;
    }

    public void sacar(double valor) {
        if (saldo >= valor){
            saldo -= valor;
            System.out.print(String.format("Foram sacados R$ %.2f\n",valor));
        }else {
            System.out.println("Saldo insuficiente! Faça um depósito!\n");
        }
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.print(String.format("Foram depositados R$ %.2f\n",valor));
    }

    public void transferir(double valor, Conta contaDestino) {
        if (saldo >= valor){
            this.sacar(valor);
            contaDestino.depositar(valor);
        }else {
            System.out.println("Impossível realizar transferência, saldo insuficiente!\n");
        }
    }

    public void imprimirExtrato() {
        if (Objects.isNull(this.cliente.getNome())){
            System.out.println("Titular: Nome inválido!");
            System.out.println("Agencia: Agência inválida!");
            System.out.println("Numero: Número de conta inválido!");
            System.out.println(String.format("Saldo: R$ %.2f", this.saldo));
        }else {
            System.out.println(String.format("Titular: %s", this.cliente.getNome()));
            System.out.println(String.format("Agencia: %d", this.agencia));
            System.out.println(String.format("Numero: %d", this.numero));
            System.out.println(String.format("Saldo: R$ %.2f", this.saldo));
        }
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }
}