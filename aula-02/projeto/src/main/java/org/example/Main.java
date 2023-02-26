package org.example;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import org.example.conta.Conta;
import org.example.conta.ContaCorrente;
import org.example.pessoa.Pessoa;

public class Main {
    public static void main(String[] args) {
        
        List<Conta> contas = new ArrayList<>();
        String operacao = "";
        Scanner scanner = new Scanner(System.in);
        while (!operacao.equals("4")){
            System.out.println("1 - Criar \n2 - Listar \n3 - Buscar \n4 - Sair");
            operacao = scanner.next();
            if (operacao.equals("1")){
                System.out.println("Digite o nome:");
                String nome = scanner.next();
                String cpf = scanner.next();
                Float saldo = scanner.nextFloat();
                Float limite = scanner.nextFloat();
                
                Pessoa p = new Pessoa(nome,cpf);
                Conta conta = new ContaCorrente(saldo,p,limite);
                contas.add(conta);
            }
            if (operacao.equals("2")){
                for(Conta c : contas){
                    System.out.println(c);
                }
    
            }
            if (operacao.equals("3")){
                String cpf = scanner.next();
                Conta conta = null;

                for (Conta c : contas){
                    if(c.getPessoa().getCpf().equals(cpf)){
                        conta = c;
                    }
                    if (conta != null){
                        System.out.println(conta);
                    }
                    else{
                        System.out.println("Conta não encontrada");
                    }
                }
            }
        }
    }
}