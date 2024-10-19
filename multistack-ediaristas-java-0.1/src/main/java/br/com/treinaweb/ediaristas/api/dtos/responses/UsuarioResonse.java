package br.com.treinaweb.ediaristas.api.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioResonse {

    private Long id;
    private String nomeCompleto;
    private String email;
    private Integer tipoUsuario;
    private String cpf;
    private LocalDate nascimento;
    private String telefone;
    private String chavePix;
}
