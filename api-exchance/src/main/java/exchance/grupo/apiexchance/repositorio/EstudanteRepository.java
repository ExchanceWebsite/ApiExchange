package exchance.grupo.apiexchance.repositorio;

import exchance.grupo.apiexchance.entidade.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstudanteRepository extends JpaRepository<Estudante, Integer > {
    Optional<String> findByEmail(String email);

    Optional<String> findBySenha(String senha);
}
