package br.com.treinaweb.ediaristas.api.dtos.requests;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(SnakeCaseStrategy.class)
public class UsuarioRequest {

    @NotNull
    @Size(min = 3, max = 255)
    private String nomeCompleto;

    @NotNull
    @Email
    @Size(max = 255)
    private String email;

    @NotNull
    @NotEmpty
    private String password;

    @NotNull
    @NotEmpty
    private String passwordConfirmation;

    @NotNull
    private Integer tipoUsuario;

    @CPF
    @NotNull
    @Size(min = 11, max = 11)
    private String cpf;

    @Past
    @NotNull
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate nascimento;

    @NotNull
    @Size(min = 11, max = 11)
    private String telefone;

    @Size(min = 11, max = 255)
    private String chavePix;
    
}
