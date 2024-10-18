package br.com.treinaweb.ediaristas.api.dtos.responses;

import lombok.Data;
import java.util.List;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@Data
@JsonNaming(SnakeCaseStrategy.class)
public class DiaristasLocalidadesPagedResponse {
    
    private List<DiaristaLocalidadeResponse> diaristas;
    private Long quantidadeDiaristas;
    
    public DiaristasLocalidadesPagedResponse(
        List<DiaristaLocalidadeResponse> diaristas, 
        Integer tamanhoPagina, Long totalElementos) {
        this.diaristas = diaristas;
        this.quantidadeDiaristas = totalElementos > tamanhoPagina ? totalElementos - tamanhoPagina : 0;
    }
}
