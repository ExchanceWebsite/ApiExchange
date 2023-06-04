package exchance.grupo.apiexchance.service.Acomodacao;

import exchance.grupo.apiexchance.entidade.Acomodacao;
import exchance.grupo.apiexchance.repositorio.AcomodacaoRepository;
import exchance.grupo.apiexchance.service.Acomodacao.dto.AcomodacaoDTO;
import exchance.grupo.apiexchance.service.Acomodacao.dto.AcomodacaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;


@Service
public class AcomodacaoService {

  private final AcomodacaoRepository acomodacaoRepository;

  public AcomodacaoService(AcomodacaoRepository acomodacaoRepository) {
    this.acomodacaoRepository = acomodacaoRepository;
  }

  public void criar(AcomodacaoDTO acomodacaoDTO) {
    final Acomodacao novaAcomodacao = AcomodacaoMapper.of(acomodacaoDTO);

    this.acomodacaoRepository.save(novaAcomodacao);
  }

  public List<Acomodacao> findAccommodations(Integer localidadeId, LocalDate dataEntrada, LocalDate dataSaida) {
    Specification<Acomodacao> specification = AcomodacaoSpecification.findByLocalidadeIdAndAvailability(localidadeId, dataEntrada, dataSaida);
    return acomodacaoRepository.findAll(specification);
  }
}