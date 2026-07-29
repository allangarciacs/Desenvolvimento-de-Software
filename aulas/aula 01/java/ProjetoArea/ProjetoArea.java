package ProjetoArea;

/**
 2) Crie uma classe FormaGeometrica com um método calcularArea().
 * Em seguida, crie uma classe Triangulo que herda da classe FormaGeometrica e
 * sobrescreve o método calcularArea() para calcular a área do triângulo e
 * imprimir o resultado.
 */

public class ProjetoArea {

    public static void main(String[] args) {
        
        Triangulo tri = new Triangulo();
        
        tri.setBase(10);
        tri.setAltura(5);
        
        tri.calcularArea();
          
    }
}
