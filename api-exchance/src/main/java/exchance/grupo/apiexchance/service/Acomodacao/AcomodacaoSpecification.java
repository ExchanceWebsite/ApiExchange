package exchance.grupo.apiexchance.service.Acomodacao;

import exchance.grupo.apiexchance.entidade.Acomodacao;
import exchance.grupo.apiexchance.entidade.HostFamily;
import exchance.grupo.apiexchance.entidade.Localidade;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.time.LocalDate;

public class AcomodacaoSpecification {

    public static Specification<Acomodacao> findByLocalidadeIdAndAvailability(Integer localidadeId, LocalDate dataEntrada, LocalDate dataSaida) {
        return (Root<Acomodacao> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            Join<Acomodacao, Localidade> localidadeJoin = root.join("localidade");

            Predicate predicate = criteriaBuilder.and(
                    criteriaBuilder.equal(localidadeJoin.get("idLocalidade"), localidadeId),
                    criteriaBuilder.lessThanOrEqualTo(root.get("inicioDisponibilidade"), dataEntrada),
                    criteriaBuilder.greaterThanOrEqualTo(root.get("fimDisponibilidade"), dataSaida),
                    criteriaBuilder.equal(root.get("reservado"), false)
            );

            return query.where(predicate).getRestriction();
        };
    }
}