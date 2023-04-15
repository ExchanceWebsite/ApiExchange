package exchance.grupo.apiexchance.repositorio;

import exchance.grupo.apiexchance.entidade.Integrante;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntegranteRepository extends JpaRepository<Integrante, Integer> {
}
