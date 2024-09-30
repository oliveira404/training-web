package com.codigos.projetopoo;

import java.util.Scanner;
import com.codigos.projetopoo.model.Diarista;
import com.codigos.projetopoo.repository.DiaristaRepository;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        var repository = new DiaristaRepository();

        var opcao = "q";

        do {
            showMenu();

            System.out.print("Enter with an option: ");
            opcao = entrada.nextLine();

            switch (opcao) {
                case "1" -> listarDiaristas(repository);
                case "2" -> cadastrarDiarista(entrada, repository);
                case "3" -> buscarDiaristaPorId(entrada, repository);
                case "4" -> excluirDiarista(entrada, repository);
                case "q" -> System.out.println("saindo do sistema");
                default -> System.out.println("Opção invalida");
            }

            System.out.println("Selected Option: " + opcao);
        } while (!opcao.equals("q"));

        entrada.close();
    }

    private static void excluirDiarista(Scanner entrada, DiaristaRepository repository) {
        System.out.print("id: ");
        var id = entrada.nextLong();
        entrada.nextLine();

        var foiExcluido = repository.excluirPorId(id);
        if (foiExcluido) {
            System.out.println("diarista excluída");
        } else {
            System.out.println("diarista não encontrada!");
        }
    }

    private static void buscarDiaristaPorId(Scanner entrada, DiaristaRepository repository) {
        System.out.print("Digite o id: ");
        var id = entrada.nextLong();
        entrada.nextLine();

        var diarista = repository.buscarPorId(id);
        if (diarista != null) {
            System.out.println(diarista);
        } else {
            System.out.println("diarista nao encontrada");
        }
    }

    private static void cadastrarDiarista(Scanner entrada, DiaristaRepository repository) {
        System.out.print("Nome: ");
        var nome = entrada.nextLine();
        System.out.print("telefone: ");
        var telefone = entrada.nextLine();
        System.out.print("cpf: ");
        var cpf = entrada.nextLine();
        System.out.print("endereco: ");
        var endereco = entrada.nextLine();

        var diarista = new Diarista(nome, telefone, cpf, endereco);
        repository.cadastrar(diarista);
        System.out.println("Diarista cadastrada com sucesso!");
    }

    private static void listarDiaristas(DiaristaRepository repository) {
        var diaristas = repository.buscarTodos();

        if (diaristas.isEmpty()) System.out.println("Não existe diaristas cadastrados");

        diaristas.forEach(System.out::println);
    }

    private static void showMenu() {
        System.out.println();
        System.out.println("1 - listar diaristas");
        System.out.println("2 - cadastrar diaristas");
        System.out.println("3 - buscar diaristas");
        System.out.println("4 - excluir diaristas");
        System.out.println("q - sair");
        System.out.println();
    }
}
