package com.codigos.projetopoo.model;

public class Diarista extends Pessoa {

    private String name;

    public Diarista(Long id, String nome, String telefone, String cpf, String endereco) {
        super(id, nome, telefone, cpf, endereco);
    }

    public Diarista(String nome, String telefone, String cpf, String endereco) {
        super(null, nome, telefone, cpf, endereco);
    }

    public Diarista() {
    }
}
