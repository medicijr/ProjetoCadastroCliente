package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private int codigo;
    private String nome;
    private String email;
    private String telefone;
    private String dataNascimento;

    private List<Endereco> enderecos = new ArrayList<>();
    private List<CartaoPagamento> cartoes = new ArrayList<>();

    public Cliente(int codigo, String nome, String email, String telefone, String dataNascimento) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void adicionarEndereco(Endereco endereco) {
        this.enderecos.add(endereco);
    }

    public void adicionarCartao(CartaoPagamento cartao) {
        this.cartoes.add(cartao);
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public List<CartaoPagamento> getCartoes() {
        return cartoes;
    }

    @Override
    public String toString() {
        return "Cliente:" +
                " Codigo= " + codigo +
                ", Nome= " + nome +
                ", Email= " + email +
                ", Telefone= " + telefone +
                ", DataNascimento= " + dataNascimento +
                "\nEnderecos= " + enderecos +
                "\nCartoes= " + cartoes;
    }
}