package Projeto4Loja;

public class CartaoCreditoPagamento extends MetodoPagamento {

    public CartaoCreditoPagamento() {
        super("Cartao de Credito");
    }

    @Override
    public void processaPagamento(double valor) {
        System.out.println("Pagamento de RS " + valor +
                " feito por " + nomeMetodo + ".");
    }

    @Override
    public void mostraDetalhesPagamento() {
        System.out.println("Metodo: " + nomeMetodo);
        System.out.println("ID do pagamento: " + idPagamento);
    }
}
