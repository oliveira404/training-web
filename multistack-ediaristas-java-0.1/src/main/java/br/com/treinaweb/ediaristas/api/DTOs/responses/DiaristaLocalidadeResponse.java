package br.com.treinaweb.ediaristas.api.DTOs.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiaristaLocalidadeResponse {

    private String nomeCompleto;
    private Double reputacao;
    private String fotoUsuario;
    private String cidade;
    
}
