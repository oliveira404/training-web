package br.com.treinaweb.ediaristas.core.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import br.com.treinaweb.ediaristas.core.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    List<Usuario> findByCidadesAtendidasCodigoIbge(String codigoIbge);

    @Query("SELECT count(*) > 0 FROM Usuario u WHERE u.email = :email AND (:id is null OR u.id != :id)")
    Boolean isEmailJaCadastrado(String email, Long id);
    
}
