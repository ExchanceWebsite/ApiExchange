package exchance.grupo.apiexchance.repositorio;

import exchance.grupo.apiexchance.entidade.Localidade;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalidadeRepository extends JpaRepository<Localidade, Integer> {
}
