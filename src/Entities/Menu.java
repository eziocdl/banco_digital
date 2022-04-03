package Entities;

import java.util.Locale;

import java.util.Scanner;

public class Menu {
    Scanner input = new Scanner(System.in);

    Cliente cliente = new Cliente();
    Conta cc = new ContaCorrente(cliente);
    Conta poupanca = new ContaPoupanca(cliente);

    public void menu(){
        double valor;
        String titular;

        System.out.println(" ");

        System.out.println("\n        =========================");
        System.out.println("        O que o sr (a) deseja fazer? ");
        System.out.println("        |     1 - Depositar   |");
        System.out.println("        |     2 - Sacar       |");
        System.out.println("        |     3 - Transferir  |");
        System.out.println("        |     4 - Extrato     |");
        System.out.println("        |     0 - Sair        |");
        System.out.println("          =========================\n");
        System.out.print("Opção desejada: ");
        int op = input.nextInt();

        do {
            switch (op){
                case 1:
                    System.out.print("Qual o nome do titular? ");
                    cliente.setNome(titular = input.next().toUpperCase());
                    try{
                        if(cliente.getNome().substring(0, 1).matches("[A-Z]*")) {
                            System.out.print("Quanto você deseja depositar? ");
                            System.out.print("R$ ");
                            valor = input.nextDouble();
                            cc.depositar(valor);
                        }
                    }catch (StringIndexOutOfBoundsException e){
                        System.out.println("Nome inválido! Digite um nome válido!");
                    }
                    menu();
                    break;
                case 2:
                    System.out.print("Quanto você deseja sacar? ");
                    System.out.print("R$ ");
                    valor = input.nextDouble();
                    cc.sacar(valor);
                    menu();
                    break;
                case 3:
                    System.out.print("Quanto você deseja transferir para a poupança? ");
                    System.out.print("R$ ");
                    valor = input.nextDouble();
                    cc.transferir(valor, poupanca);
                    menu();
                    break;
                case 4:
                    cc.imprimirExtrato();
                    poupanca.imprimirExtrato();
                    menu();
                    break;
                case 0:
                    System.out.print("Você está saindo do menu...");
                    break;
                
                default:
                    System.err.print("Opção inválida!");
                    menu();
                    break;
            }
        }while (op != 0);
    }
}
