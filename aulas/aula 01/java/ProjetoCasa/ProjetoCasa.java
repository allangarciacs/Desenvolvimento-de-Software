package ProjetoCasa;

/**
3) Crie uma classe Casa com um método calcularPreco(int tamanho) que retorna o
* preço da casa com base no tamanho em metros quadrados. Sobrecarregue o método
* calcularPreco() para aceitar um número de quartos e retornar o preço da casa
* com base no tamanho e no número de quartos.
 */

public class ProjetoCasa {

    public static void main(String[] args) {
        
        Casa casa = new Casa();
        
        System.out.println("Preco 1: "+casa.calculaPreco(100));
                
        System.out.println("Preco 2: "+casa.calculaPreco(100, 5));      
    
    }
}
