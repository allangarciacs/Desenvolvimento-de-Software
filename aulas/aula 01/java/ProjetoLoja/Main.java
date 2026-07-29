package ProjetoLoja;

/**
4) Você foi contratado para desenvolver um sistema de pagamento para uma loja online.
* A loja oferece diferentes métodos de pagamento, como cartão de crédito, PayPal e PIX.
* Cada método de pagamento possui um conjunto específico de informações e processos para
* completar uma transação.
• Crie uma classe abstrata chamada MetodoPagamento com os seguintes atributos:
• nomeMetodo String : O nome do método de pagamento
•idPagamento int : Um identificador único para a pagamento
Implemente um construtor na classe MetodoPagamento que aceite o nome do método e gere um
* idPagamento aleatório.
Crie três classes que herdam de MetodoPagamento : CartaoCreditoPagamento , PayPalPagamento
* e PIXPagamento
Cada classe filha deve implementar os seguintes métodos:
•processaPagamento (double valor): Simula o processamento do pagamento e imprime uma
* mensagem indicando o método de pagamento e o valor.
•mostraDetalhesPagamento (): Exibe os detalhes da transação, incluindo o método de pagamento
* e o idPagamento
Crie um programa principal ( main ) que demonstre o uso das classes. Crie instâncias de cada
* classe de método de pagamento, chame os métodos para processar o pagamento e exibir os detalhes.
Lembre se de que as classes CartaoCreditoPagamento , PayPalPagamento e PIXPagamento devem
* herdar da classe abstrata MetodoPagamento
 */
public class Main {
    public static void main(String[] args) {
        
    }
    
}
