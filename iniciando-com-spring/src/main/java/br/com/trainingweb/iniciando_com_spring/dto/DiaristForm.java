package br.com.trainingweb.iniciando_com_spring.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class DiaristForm {

  private String nome;
  private String telefone;
  private String cpf;
  
}
