package exchance.grupo.apiexchance.repositorio;

import exchance.grupo.apiexchance.entidade.Imagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface ImagemRepository extends JpaRepository<Imagem, Integer> {

    Optional<Imagem> findByEstudanteAndIsFoto(Integer estudanteId, boolean isFoto);

    Optional<Imagem> findByEstudanteAndIsDocumento(Integer estudanteId, boolean isDocumento);

    Optional<Imagem> findByHostFamilyAndIsFoto(Integer fkHost, boolean isFoto);

    Optional<Imagem> findByHostFamilyAndIsDocumento(Integer fkHost, boolean isDocumento);
}