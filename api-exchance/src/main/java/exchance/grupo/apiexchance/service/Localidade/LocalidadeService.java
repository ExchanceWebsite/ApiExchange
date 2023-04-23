package exchance.grupo.apiexchance.service.Localidade;

import exchance.grupo.apiexchance.entidade.Localidade;
import exchance.grupo.apiexchance.repositorio.LocalidadeRepository;
import exchance.grupo.apiexchance.service.Localidade.dto.LocalidadeDTO;
import exchance.grupo.apiexchance.service.Localidade.dto.LocalidadeMapper;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;



@Service
public class LocalidadeService {


  @Autowired
  private LocalidadeRepository localidadeRepository;



  public void criar(LocalidadeDTO localidadeDTO) {
    final Localidade novaLocalidade = LocalidadeMapper.of(localidadeDTO);


    this.localidadeRepository.save(novaLocalidade);
  }
}