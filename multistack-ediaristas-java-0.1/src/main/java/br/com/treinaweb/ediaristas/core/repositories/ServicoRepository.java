package br.com.treinaweb.ediaristas.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.treinaweb.ediaristas.core.models.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long>{
    
}
