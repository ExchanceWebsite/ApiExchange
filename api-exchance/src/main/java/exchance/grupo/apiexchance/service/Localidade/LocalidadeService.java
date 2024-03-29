package exchance.grupo.apiexchance.service.Localidade;

import exchance.grupo.apiexchance.entidade.Localidade;
import exchance.grupo.apiexchance.repositorio.LocalidadeRepository;
import exchance.grupo.apiexchance.service.Localidade.dto.LocalidadeDTO;
import exchance.grupo.apiexchance.service.Localidade.dto.LocalidadeMapper;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class LocalidadeService {


  private final LocalidadeRepository localidadeRepository;

  public LocalidadeService(LocalidadeRepository localidadeRepository) {
    this.localidadeRepository = localidadeRepository;
  }


  public Localidade criar(LocalidadeDTO localidadeDTO) {
    final Localidade novaLocalidade = LocalidadeMapper.of(localidadeDTO);


    return this.localidadeRepository.save(novaLocalidade);
  }

  public Integer findTopLocalidadeId() {
    return localidadeRepository.findTopLocalidadeId();
  }


  public Localidade buscarLocalidadePorEndereco(String endereco){

    Optional<Localidade> enderecoEncontrado = this.localidadeRepository.findByEndereco(endereco);

    if(enderecoEncontrado.isEmpty()){
      return null;
    }

    return enderecoEncontrado.get();

  }

  public Localidade buscarLocalidadePorCidade(String cidade){

    Optional<Localidade> enderecoEncontrado = this.localidadeRepository.findByCidade(cidade);

    if(enderecoEncontrado.isEmpty()){
      return null;
    }

    return enderecoEncontrado.get();

  }

  public Localidade buscarLocalidadePorPais(String pais){

    Optional<Localidade> enderecoEncontrado = this.localidadeRepository.findByPais(pais);

    if(enderecoEncontrado.isEmpty()){
      return null;
    }

    return enderecoEncontrado.get();

  }
}