package br.com.treinaweb.ediaristas.web.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlashMassage {

    private String classeCss;
    private String mensagem;
    
}
