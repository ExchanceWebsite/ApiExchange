package exchance.grupo.apiexchance.service.Acomodacao;

import exchance.grupo.apiexchance.entidade.Acomodacao;
import exchance.grupo.apiexchance.repositorio.AcomodacaoRepository;
import exchance.grupo.apiexchance.service.Acomodacao.dto.AcomodacaoDTO;
import exchance.grupo.apiexchance.service.Acomodacao.dto.AcomodacaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AcomodacaoService {

  @Autowired
  private AcomodacaoRepository acomodacaoRepository;


  public void criar(AcomodacaoDTO acomodacaoDTO) {
    final Acomodacao novaAcomodacao = AcomodacaoMapper.of(acomodacaoDTO);

    this.acomodacaoRepository.save(novaAcomodacao);
  }


}