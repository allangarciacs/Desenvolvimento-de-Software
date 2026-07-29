/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjetoConta;

/**
 *
 * @author laboratorio
 */
public class ContaCorrente {
    private float saldo;
    
    public ContaCorrente(float saldo) {
        this.saldo = saldo;
    }
    
    public float getSaldo() {
        return saldo;
    }
    
    public void definirSaldoIncicial(float valor) {
        saldo = valor;
    }
    
    public void depositar(float deposito) {
        saldo += deposito;
        System.out.println("Deposito de "+deposito+" realizado\n");
    }
    
    public boolean sacar(float valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente!");
            return false;
        } else {
            saldo -= valor;
            System.out.println("Saque de "+valor+" realizado!");
            return true;
        }
    }   

}
