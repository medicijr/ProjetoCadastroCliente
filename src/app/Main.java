package app;

import model.Cliente;
import repo.ClienteRepo;
import util.Validador;

import java.util.Scanner;

public class Main {

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

            switch (opcao) {

                case 1:
                    System.out.println("Codigo:");
                    int codigo = t.nextInt();

                    // 🔹 EMAIL VALIDADO
                    String email;
                    do {
                        System.out.println("Email:");
                        email = t.next();
                        if (!Validador.validarEmail(email)) {
                            System.out.println("Email inválido!");
                        }
                    } while (!Validador.validarEmail(email));

                    // 🔹 TELEFONE VALIDADO
                    String telefone;
                    do {
                        System.out.println("Telefone:");
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

                    System.out.println("Nome:");
                    String nome = t.next();

                    Cliente cliente = new Cliente(codigo, nome, email, telefone, data);
                    repo.salvar(cliente);

                    System.out.println("Cliente cadastrado!");
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