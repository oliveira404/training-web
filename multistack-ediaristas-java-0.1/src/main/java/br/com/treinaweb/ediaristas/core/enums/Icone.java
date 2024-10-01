package br.com.treinaweb.ediaristas.core.enums;

public enum Icone {
    TWF_CLEANING_1("twf_cleaning_1"),
    TWF_CLEANING_2("twf_cleaning_2"),
    TWF_CLEANING_3("twf_cleaning_3");

    private String nome;

    private Icone(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
