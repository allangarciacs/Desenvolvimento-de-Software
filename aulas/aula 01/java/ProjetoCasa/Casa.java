package ProjetoCasa;

public class Casa {

    public float calculaPreco(int tamanho) {
        // preco = 100 reais por metro 
        float preco = tamanho * 100;
        return preco;    
    }
    
    public float calculaPreco(int tamanho, int qtdeQuartos) {
        float preco = tamanho * 100;
        float extra = qtdeQuartos * 50;
        preco += extra;      
        return preco;
    }
}
