package exchance.grupo.apiexchance.repositorio;

import exchance.grupo.apiexchance.entidade.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensagemRepository extends JpaRepository<Mensagem, Integer> {
}
