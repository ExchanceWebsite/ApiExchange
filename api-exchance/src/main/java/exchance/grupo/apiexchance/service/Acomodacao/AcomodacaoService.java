package exchance.grupo.apiexchance.service.Acomodacao;

import exchance.grupo.apiexchance.entidade.Acomodacao;
import exchance.grupo.apiexchance.entidade.HostFamily;
import exchance.grupo.apiexchance.repositorio.AcomodacaoRepository;
import exchance.grupo.apiexchance.service.Acomodacao.dto.AcomodacaoDTO;
import exchance.grupo.apiexchance.service.Acomodacao.dto.AcomodacaoMapper;
import exchance.grupo.apiexchance.service.hostFamily.HostFamilyService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class AcomodacaoService {

  private final AcomodacaoRepository acomodacaoRepository;
  private final HostFamilyService hostFamilyService;

  public AcomodacaoService(AcomodacaoRepository acomodacaoRepository, HostFamilyService hostFamilyService) {
    this.acomodacaoRepository = acomodacaoRepository;
    this.hostFamilyService = hostFamilyService;
  }

  public void criar(AcomodacaoDTO acomodacaoDTO) {
    final Acomodacao novaAcomodacao = AcomodacaoMapper.of(acomodacaoDTO);

    this.acomodacaoRepository.save(novaAcomodacao);
  }

  public Acomodacao atualizar(Integer id, Acomodacao acomodacaoDTO){

    Optional<Acomodacao> acomodacaoEncontrado = this.acomodacaoRepository.findById(id);

    if(acomodacaoEncontrado.isEmpty()){
      return null;
    }

    acomodacaoEncontrado.get().setIdAcomodacao(id);
    acomodacaoEncontrado.get().setReservado(acomodacaoDTO.getReservado());
    acomodacaoEncontrado.get().setHost(acomodacaoDTO.getHost());
    acomodacaoEncontrado.get().setValorDiaria(acomodacaoDTO.getValorDiaria());
    acomodacaoEncontrado.get().setRegras(acomodacaoDTO.getRegras());
    acomodacaoEncontrado.get().setInicioDisponibilidade(acomodacaoDTO.getInicioDisponibilidade());
    acomodacaoEncontrado.get().setFimDisponibilidade(acomodacaoDTO.getFimDisponibilidade());
    acomodacaoEncontrado.get().setReserva(acomodacaoDTO.getReserva());
    acomodacaoEncontrado.get().setLocalidade(acomodacaoDTO.getLocalidade());
    acomodacaoEncontrado.get().setDescricao(acomodacaoDTO.getDescricao());


    this.acomodacaoRepository.save(acomodacaoEncontrado.get());

    return acomodacaoEncontrado.get();

  }

  public Acomodacao buscarPorId(Integer id) {
    Optional<Acomodacao> acomodacao = this.acomodacaoRepository.findById(id);

    return acomodacao.orElse(null);
  }

  public List<Acomodacao> findAccommodations(Integer localidadeId, LocalDate dataEntrada, LocalDate dataSaida) {


    Specification<Acomodacao> specification = AcomodacaoSpecification.findByLocalidadeIdAndAvailability(localidadeId, dataEntrada, dataSaida);


    return acomodacaoRepository.findAll(specification);
  }


  public List<Acomodacao> listarAcomodacoesHost(Integer idHost) {
    Optional<HostFamily> hostFamily = this.hostFamilyService.buscarPorID(idHost);

    List<Acomodacao> acomodacaos = this.acomodacaoRepository.findAllByHost(hostFamily.get());

    if(acomodacaos.size() >= 1){
      return acomodacaos;
    }else if(hostFamily == null){
      return null;
    }


    return acomodacaos;
  }
}