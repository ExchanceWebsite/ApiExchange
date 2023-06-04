package exchance.grupo.apiexchance.repositorio;

import exchance.grupo.apiexchance.entidade.HostFamily;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface HostFamilyRepository extends JpaRepository<HostFamily, Integer> {


    Optional<HostFamily> findBySenhaAndEmail(String senha, String email);

    Optional<HostFamily> findByEmail(String email);

    Optional<HostFamily> findByEmailAndNome(String email, String nome);

    boolean existsByAcomodacoesIdAcomodacao(int id);
}
