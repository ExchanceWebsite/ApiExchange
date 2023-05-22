package exchance.grupo.apiexchance.repositorio;

import exchance.grupo.apiexchance.entidade.Estudante;
import exchance.grupo.apiexchance.entidade.HostFamily;
import exchance.grupo.apiexchance.entidade.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
    List<Reserva> findAllByEstudante(Estudante estudante);

    List<Reserva> findAllByHost(HostFamily hostFamily);
}
