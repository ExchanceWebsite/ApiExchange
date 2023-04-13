package exchance.grupo.apiexchance.repositorio;

import exchance.grupo.apiexchance.entidade.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {
}
