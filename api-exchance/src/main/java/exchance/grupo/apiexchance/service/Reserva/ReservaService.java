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

  private final ReservaRepository reservaRepository;
  private final EstudanteService estudanteService;
  private final HostFamilyService hostFamilyService;

  public ReservaService(ReservaRepository reservaRepository, EstudanteService estudanteService, HostFamilyService hostFamilyService) {
    this.reservaRepository = reservaRepository;
    this.estudanteService = estudanteService;
    this.hostFamilyService = hostFamilyService;
  }


  public void criar(ReservaDTO reservaDTO) {
    final Reserva novaReserva = ReservaMapper.of(reservaDTO);

    this.reservaRepository.save(novaReserva);
  }


  public List<Reserva> listarReservasEstudante(Integer idestudante){

    Estudante estudante = this.estudanteService.buscarPorId(idestudante);

    List<Reserva> Reservas = this.reservaRepository.findAllByEstudante(estudante);

    if(Reservas.size() >= 1){
      return Reservas;
    }else if(estudante == null){
      return null;
    }


    return Reservas;
  }

  public List<Reserva> listarReservasHost(Integer idHost){

    Optional<HostFamily> hostFamily = this.hostFamilyService.buscarPorID(idHost);

    List<Reserva> Reservas = this.reservaRepository.findAllByHost(hostFamily.get());

    if(Reservas.size() >= 1){
      return Reservas;
    }else if(hostFamily == null){
      return null;
    }


    return Reservas;
  }

}