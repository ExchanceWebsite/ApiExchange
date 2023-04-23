package exchance.grupo.apiexchance.service.Integrante;

import exchance.grupo.apiexchance.entidade.Integrante;
import exchance.grupo.apiexchance.repositorio.IntegranteRepository;
import exchance.grupo.apiexchance.service.Integrante.dto.IntegranteDTO;
import exchance.grupo.apiexchance.service.Integrante.dto.IntegranteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IntegranteService {


  @Autowired
  private IntegranteRepository integranteRepository;


  public void criar(IntegranteDTO integranteDTO) {
    final Integrante novoIntegrante = IntegranteMapper.of(integranteDTO);

    this.integranteRepository.save(novoIntegrante);
  }
}