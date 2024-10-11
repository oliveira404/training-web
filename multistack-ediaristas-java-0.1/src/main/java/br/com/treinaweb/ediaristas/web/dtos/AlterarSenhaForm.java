package br.com.treinaweb.ediaristas.web.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.treinaweb.ediaristas.web.interfaces.IConfirmacaoSenha;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlterarSenhaForm implements IConfirmacaoSenha {

    @NotBlank
    @NotNull
    private String senhaAntiga;

    @NotBlank
    @NotNull
    private String senha;

    @NotBlank
    @NotNull
    private String confirmacaoSenha;
}
