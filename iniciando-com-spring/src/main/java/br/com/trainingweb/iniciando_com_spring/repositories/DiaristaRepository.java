package br.com.trainingweb.iniciando_com_spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.trainingweb.iniciando_com_spring.models.Diarista;

public interface DiaristaRepository extends JpaRepository<Diarista, Long> {

}
