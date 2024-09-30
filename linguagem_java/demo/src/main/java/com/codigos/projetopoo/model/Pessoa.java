package com.codigos.projetopoo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public abstract class Pessoa {

    private Long id;
    private String nome;
    private String telefone;
    private String cpf;
    private String endereco;
}