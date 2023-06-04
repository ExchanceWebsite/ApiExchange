package exchance.grupo.apiexchance.repositorio;

import exchance.grupo.apiexchance.entidade.Acomodacao;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface AcomodacaoRepository extends JpaRepository<Acomodacao, Integer>, JpaSpecificationExecutor<Acomodacao> {
    List<Acomodacao> findAll(Specification<Acomodacao> specification);
    @Modifying
    @Transactional
    @Query("UPDATE Acomodacao a SET a.host = NULL where a.host.idHostFamily = :id")
    int update(int id);

    @Transactional
    @Modifying
    @Query("delete from Acomodacao a where a.idAcomodacao = :id")
    int deleteById(int id);

}
