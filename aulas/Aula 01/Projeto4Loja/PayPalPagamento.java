package Projeto4Loja;

public class PayPalPagamento extends MetodoPagamento {

    public PayPalPagamento() {
        super("PayPal");
    }

    @Override
    public void processaPagamento(double valor) {
        System.out.println("Pagamento de R$ " + valor +
                " feito por " + nomeMetodo + ".");
    }

    @Override
    public void mostraDetalhesPagamento() {
        System.out.println("Metodo: " + nomeMetodo);
        System.out.println("ID do pagamento: " + idPagamento);
    }
}