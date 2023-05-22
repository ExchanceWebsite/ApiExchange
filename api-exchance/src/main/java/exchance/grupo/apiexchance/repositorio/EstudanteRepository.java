package exchance.grupo.apiexchance.repositorio;

import exchance.grupo.apiexchance.entidade.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstudanteRepository extends JpaRepository<Estudante, Integer > {
    Optional<Estudante> findBySenhaAndEmail(String senha, String email);

    Optional<Estudante> findByEmail(String username);

<<<<<<< HEAD
    Optional<Estudante> findByEmailAndNome(String emai, String nome);
=======
    Optional<Integer> findIdEstudanteBySenhaAndEmail(String senha, String email);

>>>>>>> 69206142dccc965efd966af3183b4686d5bb34ae
}
