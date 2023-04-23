package exchance.grupo.apiexchance.service.Reserva;

import exchance.grupo.apiexchance.entidade.Reserva;
import exchance.grupo.apiexchance.repositorio.ReservaRepository;
import exchance.grupo.apiexchance.service.Reserva.dto.ReservaDTO;
import exchance.grupo.apiexchance.service.Reserva.dto.ReservaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReservaService {

  @Autowired
  private ReservaRepository reservaRepository;


  public void criar(ReservaDTO reservaDTO) {
    final Reserva novaReserva = ReservaMapper.of(reservaDTO);

    this.reservaRepository.save(novaReserva);
  }

}