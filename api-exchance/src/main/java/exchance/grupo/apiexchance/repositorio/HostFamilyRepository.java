package exchance.grupo.apiexchance.repositorio;

import exchance.grupo.apiexchance.entidade.HostFamily;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HostFamilyRepository extends JpaRepository<HostFamily, Integer> {
    Optional<String> findByEmail(String email);

    Optional<HostFamily> findBySenhaAndEmail(String senha, String email);
}
