package app;

import model.CartaoPagamento;
import model.Cliente;
import model.Endereco;
import model.TipoLogradouro;
import repo.ClienteRepo;
import util.Validador;

import java.util.Scanner;

public class Main {

    public static Endereco cadastrarEndereco(Scanner t) {

        System.out.println("Tipo (RUA, AV, TR, AL, PR):");
        String tipoStr = t.nextLine();

        TipoLogradouro tipo = TipoLogradouro.valueOf(tipoStr.toUpperCase());

        System.out.println("-------------------------------INFORME SEU ENDEREÇO-------------------------------");

        System.out.println("Informe seu id:");
        int tipoId = t.nextInt();
        t.nextLine();

        System.out.println("Informe seu logradouro: ");
        String tipoLogradouro = t.nextLine();

        System.out.println("Informe seu numero: ");
        int tipoNumero = t.nextInt();
        t.nextLine();

        System.out.println("Informe seu complemento: ");
        String tipoComplemento = t.nextLine();

        System.out.println("Informe seu CEP: ");
        String tipoCep = t.nextLine();

        return new Endereco(tipoId, tipo, tipoLogradouro, tipoNumero, tipoComplemento, tipoCep);
    }

    public static CartaoPagamento adicionarCartao(Scanner t){

        System.out.println("Informe o numero do cartao: ");
        long numeroCartao = t.nextLong();

        System.out.println("Informe o codigo verificador do cartao: ");
        int codVerif = t.nextInt();
        t.nextLine();

        System.out.println("Informe o ano de validade do cartao: ");
        int anoValid = t.nextInt();
        t.nextLine();

        System.out.println("Informe o mes de validade do cartao: ");
        int mesValid = t.nextInt();
        t.nextLine();

        return new CartaoPagamento(numeroCartao, codVerif, anoValid, mesValid);
    }
    public static void main(String[] args) {

        Scanner t = new Scanner(System.in);
        ClienteRepo repo = new ClienteRepo();

        int opcao = 0;

        while (opcao != 5) {

            System.out.println("\n==== MENU ====");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Listar clientes");
            System.out.println("3 - Buscar cliente");
            System.out.println("4 - Remover cliente");
            System.out.println("5 - Sair");

            opcao = t.nextInt();
            t.nextLine();

            switch (opcao) {

                case 1:
                    System.out.println("Informe seu Codigo:");
                    int codigo = t.nextInt();
                    t.nextLine();

                    // 🔹 EMAIL VALIDADO
                    String email;
                    do {
                        System.out.println("Informe seu Email:");
                        email = t.next();
                        if (!Validador.validarEmail(email)) {
                            System.out.println("Email inválido!");
                        }
                    } while (!Validador.validarEmail(email));

                    // 🔹 TELEFONE VALIDADO
                    String telefone;
                    do {
                        System.out.println("Informe seu Telefone:");
                        telefone = t.next();
                        if (!Validador.validarTelefone(telefone)) {
                            System.out.println("Telefone inválido!");
                        }
                    } while (!Validador.validarTelefone(telefone));

                    // 🔹 DATA VALIDADA
                    String data;
                    do {
                        System.out.println("Data nascimento (dd/MM/yyyy):");
                        data = t.next();
                        if (!Validador.validarData(data)) {
                            System.out.println("Data inválida!");
                        }
                    } while (!Validador.validarData(data));

                    System.out.println("Informe seu Nome:");
                    String nome = t.next();
                    t.nextLine();

                    Cliente cliente = new Cliente(codigo, nome, email, telefone, data);
                    repo.salvar(cliente);

                    System.out.println("Cliente cadastrado!");

                    Endereco endereco = cadastrarEndereco(t);
                    cliente.adicionarEndereco(endereco);


                    CartaoPagamento cartaoPagamento = adicionarCartao(t);
                    cliente.adicionarCartao(cartaoPagamento);

                    break;

                case 2:
                    for (Cliente c : repo.listar()) {
                        System.out.println(c);
                    }
                    break;

                case 3:
                    System.out.println("Digite o codigo:");
                    int codBusca = t.nextInt();

                    Cliente encontrado = repo.buscaPorCodigo(codBusca);

                    if (encontrado != null) {
                        System.out.println(encontrado);
                    } else {
                        System.out.println("Cliente não encontrado");
                    }
                    break;

                case 4:
                    System.out.println("Digite o codigo:");
                    int codRemover = t.nextInt();

                    Cliente clienteRemover = repo.buscaPorCodigo(codRemover);

                    if (clienteRemover != null) {
                        repo.remover(codRemover);
                        System.out.println("Cliente removido!");
                    } else {
                        System.out.println("Cliente não encontrado!");
                    }
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida");
            }
        }

        t.close();
    }
}