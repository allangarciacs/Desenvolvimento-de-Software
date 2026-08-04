package Projeto2Area;

public class Triangulo extends FormaGeometrica {
    private int base;
    private int altura;
    
    public int getBase() {
        return base;
    }

    public int getAltura() {
        return altura;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
   
    @Override
    public void calcularArea() {
        float area = base * altura;
        area = area / 2;
        System.out.println(area);
        
    }
 
}