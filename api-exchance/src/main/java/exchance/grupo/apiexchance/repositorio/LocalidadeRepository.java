package exchance.grupo.apiexchance.repositorio;

import exchance.grupo.apiexchance.entidade.Localidade;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocalidadeRepository extends JpaRepository<Localidade, Integer> {
    Optional<Localidade> findByEndereco(String endereco);

    Optional<Localidade> findByCidade(String cidade);
}
