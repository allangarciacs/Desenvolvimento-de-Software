package Projeto5Calculadora;

public class Calculadora implements ICalculadora {

    @Override
    public double somar(double n1, double n2) {
        return n1 + n2;
    }

    @Override
    public double subtrair(double n1, double n2) {
        return n1 - n2;
    }

    @Override
    public double multiplicar(double n1, double n2) {
        return n1 * n2;
    }

    @Override
    public double dividir(double n1, double n2) {
        if (n2 == 0) {
            System.out.println("Nao pode dividr por zero");
            return 0;
        }
        return n1 / n2;
    }

    @Override
    public double raizquadrada(double n1, double n2) {
        if (n1 < 0) {
            System.out.println("Nao tem raiz quadrada d numero negativo");
            return 0;
        }
        return Math.sqrt(n1);
    }

    @Override
    public double elevarPotencia(double n1, double n2) {
        return Math.pow(n1, n2);
    }

    @Override
    public double logaritmo10(double n1) {
        if (n1 <= 0) {
            System.out.println("Nao tem logaritmo de numero negativo");
            return 0;
        }
        return Math.log10(n1);
    }
}