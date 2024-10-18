package br.com.treinaweb.ediaristas.api.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponse {

    private Integer status;
    private LocalDateTime timeStamp;
    private String mensagem;
    private String path;
}