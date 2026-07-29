/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ProjetoConta;

/**
•Crie uma classe ContaCorrente que obedeça à descrição abaixo:
•A classe possui o atributo saldo do tipo float e os métodos definirSaldoInicial, depositar e sacar.
•O método definirSaldoInicial deve atribuir o valor passado por parâmetro ao atribuito saldo
•O método depositar, deve adicionar o valor passado por parâmetro ao atributo saldo
•O método sacar deve reduzir o valor passado por parâmetro do saldo já existente
•Necessário verificar a condição do valor do saldo ser insuficiente para o saque que se deseja fazer.
•O valor de retorno deve ser true (verdadeiro) quando for possível realizar o saque e false (falso) quando não for possível (public bool sacar(float valor))
•Crie um objeto novaConta do tipo ContaCorrente.
•Chame o método definirSaldoInicial passando o valor 1000 como parâmetro.
•Escreva o valor do atributo saldo
•Realize um saque de 500 reais (utilize o método sacar).
•Faça um depósito de 50 reais (utilize o método depositar)
•Escreva o valor do atributo saldo na tela.
 */

public class ProjetoConta {

    public static void main(String[] args) {
        ContaCorrente novaConta = new ContaCorrente(1000);
       
        novaConta.definirSaldoIncicial(1000);
        System.out.println("Saldo inicial de "+novaConta.getSaldo()+" definido\n");
        
        novaConta.sacar(500);
        novaConta.depositar(50);
        
        System.out.println("Saldo atual: "+novaConta.getSaldo());
        
        novaConta.sacar(600);
        
        System.out.println("Saldo atual: "+novaConta.getSaldo());
        
    
    }
}
