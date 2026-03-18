package app;

import model.CartaoPagamento;
import model.Cliente;
import model.Endereco;
import model.TipoLogradouro;
public class Main {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente(123, "Pedro", "pedro@gmail.com", "8890876543", "29/03/2000");

        Endereco e1 = new Endereco(1, TipoLogradouro.RUA, "Rua das flores", 123, "Casa", "12345-00");
        Endereco e2 = new Endereco(2, TipoLogradouro.AV, "Av das almas", 321, "Ap", "54321-00");

        CartaoPagamento c1 = new CartaoPagamento(1234567890123456L, 123, 2030, 12);
        CartaoPagamento c2 = new CartaoPagamento(654321123456780L, 321, 2040, 11);

        cliente1.adicionarEndereco(e1);
        cliente1.adicionarEndereco(e2);

        cliente1.adicionarCartao(c1);
        cliente1.adicionarCartao(c2);

        System.out.println(cliente1);

        System.out.println("\nEndereços");
        for (Endereco end : cliente1.getEnderecos()) {
            System.out.println(end);
        }

        System.out.println("\nCartões");

        for (CartaoPagamento cartaoPagamento : cliente1.getCartoes()){
            System.out.println(cartaoPagamento);
        }
    }
}
