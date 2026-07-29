package ProjetoLoja;
import java.util.Random;

abstract class MetodoPagamento {
    private String nomeMetodo;
    private int idPagamento;
    
    public MetodoPagamento(String nomeMetodo, int id) {
            this.nomeMetodo = nomeMetodo;
            this.idPagamento = id;
            Random random = new Random();
            idPagamento = random.nextInt(10);
    }
}
