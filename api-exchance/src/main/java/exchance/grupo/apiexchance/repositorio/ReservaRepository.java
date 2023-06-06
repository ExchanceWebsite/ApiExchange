package exchance.grupo.apiexchance.repositorio;

import exchance.grupo.apiexchance.entidade.Estudante;
import exchance.grupo.apiexchance.entidade.HostFamily;
import exchance.grupo.apiexchance.entidade.Reserva;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
    List<Reserva> findAllByEstudante(Estudante estudante);

    List<Reserva> findAllByHost(HostFamily hostFamily);
    boolean existsByAcomodacaoIdAcomodacao(int id);
    @Modifying
    @Transactional
    @Query("UPDATE Reserva r SET r.estudante = NULL where r.estudante.idEstudante = :id")
    int updateEstudante(int id);

    @Modifying
    @Transactional
    @Query("UPDATE Reserva r SET r.acomodacao = NULL where r.acomodacao.idAcomodacao = :id")
    int updateAcomodacao(int id);

    @Modifying
    @Transactional
    @Query("UPDATE Reserva r SET r.host = NULL where r.host.idHostFamily = :id")
    int updateHost(int id);

    @Transactional
    @Modifying
    @Query("delete from Reserva r where r.idReserva = :id")
    int deleteById(int id);
}
