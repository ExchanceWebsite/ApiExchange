package exchance.grupo.apiexchance.repositorio;

import exchance.grupo.apiexchance.entidade.Integrante;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IntegranteRepository extends JpaRepository<Integrante, Integer> {
    Optional<Integrante> findIdIntegranteByNome(String nome);
}
