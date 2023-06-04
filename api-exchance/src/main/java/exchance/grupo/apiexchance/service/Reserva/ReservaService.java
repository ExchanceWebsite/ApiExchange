package exchance.grupo.apiexchance.service.Reserva;

import exchance.grupo.apiexchance.entidade.Estudante;
import exchance.grupo.apiexchance.entidade.HostFamily;
import exchance.grupo.apiexchance.entidade.Reserva;
import exchance.grupo.apiexchance.repositorio.ReservaRepository;
import exchance.grupo.apiexchance.service.Estudante.EstudanteService;
import exchance.grupo.apiexchance.service.Reserva.dto.ReservaDTO;
import exchance.grupo.apiexchance.service.Reserva.dto.ReservaMapper;
import exchance.grupo.apiexchance.service.hostFamily.HostFamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ReservaService {

  @Autowired
  private ReservaRepository reservaRepository;

  @Autowired
  private EstudanteService estudanteService;

  @Autowired
  private HostFamilyService hostFamilyService;


  public void criar(ReservaDTO reservaDTO) {
    final Reserva novaReserva = ReservaMapper.of(reservaDTO);

    this.reservaRepository.save(novaReserva);
  }


  public List<Reserva> listarReservasEstudante(Integer idestudante){

    Estudante estudante = this.estudanteService.buscarPorId(idestudante);

    List<Reserva> Reservas = this.reservaRepository.findAllByEstudante(estudante);

    if(estudante == null || Reservas.isEmpty()){
      return null;
    }


    return Reservas;
  }

  public List<Reserva> listarReservasHost(Integer idHost){

    Optional<HostFamily> hostFamily = this.hostFamilyService.buscarPorID(idHost);

    List<Reserva> Reservas = this.reservaRepository.findAllByHost(hostFamily.get());

    if(hostFamily.isEmpty() || Reservas.isEmpty()){
      return null;
    }


    return Reservas;
  }

}