package exchance.grupo.apiexchance.repositorio;

import exchance.grupo.apiexchance.entidade.HostFamily;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HostFamilyRepository extends JpaRepository<HostFamily, Integer> {


    Optional<HostFamily> findBySenhaAndEmail(String senha, String email);

    Optional<HostFamily> findByEmail(String email);
}
