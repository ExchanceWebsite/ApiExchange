package exchance.grupo.apiexchance.repositorio;

import exchance.grupo.apiexchance.entidade.Estudante;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EstudanteRepository extends JpaRepository<Estudante, Integer > {
    Optional<Estudante> findBySenhaAndEmail(String senha, String email);

    Optional<Estudante> findByEmail(String username);


    Optional<Estudante> findByEmailAndNome(String emai, String nome);

    Optional<Integer> findIdEstudanteBySenhaAndEmail(String senha, String email);
}
