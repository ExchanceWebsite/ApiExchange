package exchance.grupo.apiexchance.service.Integrante;

import exchance.grupo.apiexchance.entidade.Estudante;
import exchance.grupo.apiexchance.entidade.Integrante;
import exchance.grupo.apiexchance.repositorio.IntegranteRepository;
import exchance.grupo.apiexchance.service.Integrante.dto.IntegranteDTO;
import exchance.grupo.apiexchance.service.Integrante.dto.IntegranteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class IntegranteService {


  @Autowired
  private IntegranteRepository integranteRepository;


  public void criar(IntegranteDTO integranteDTO) {
    final Integrante novoIntegrante = IntegranteMapper.of(integranteDTO);

    this.integranteRepository.save(novoIntegrante);
  }

  public Integrante buscarIdPorNome(String nome){

    Optional<Integrante> integrante = this.integranteRepository.findIdIntegranteByNome(nome);

    if(integrante.isEmpty()){
      return null;
    }

    return integrante.get();

  }

  public Integrante buscarIdPorNomeHost(String nome, Integer idHost){

    Optional<Integrante> integrante = this.integranteRepository.findIdIntegranteByNomeAndHost(nome, idHost);

    if(integrante.isEmpty()){
      return null;
    }

    return integrante.get();

  }


  public void remover(Integrante integrante){

    this.integranteRepository.delete(integrante);

  }
}