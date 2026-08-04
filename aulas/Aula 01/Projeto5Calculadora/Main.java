package Projeto5Calculadora;

public class Main {
    
    public static void main(String[] args) {

        ICalculadora calc = new Calculadora();

        System.out.println("Soma: " + calc.somar(100, 20));
        System.out.println("Subtracao: " + calc.subtrair(100, 50));
        System.out.println("Multiplicacao: " + calc.multiplicar(5, 5));
        System.out.println("Divisao: " + calc.dividir(20, 5));
        System.out.println("Raiz Quadrada: " + calc.raizquadrada(100, 0));
        System.out.println("Potencia: " + calc.elevarPotencia(2, 3));
        System.out.println("Logaritmo base 10: " + calc.logaritmo10(-100));
    }
}