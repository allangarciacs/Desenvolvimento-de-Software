package Projeto4Loja;

public class Main {

    public static void main(String[] args) {

        MetodoPagamento cartao = new CartaoCreditoPagamento();
        MetodoPagamento paypal = new PayPalPagamento();
        MetodoPagamento pix = new PIXPagamento();

        cartao.processaPagamento(111.11);
        cartao.mostraDetalhesPagamento();

        System.out.println();

        paypal.processaPagamento(222.22);
        paypal.mostraDetalhesPagamento();

        System.out.println();

        pix.processaPagamento(333.333);
        pix.mostraDetalhesPagamento();
    }
}