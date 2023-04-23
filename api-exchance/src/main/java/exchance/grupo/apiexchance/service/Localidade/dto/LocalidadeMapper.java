package exchance.grupo.apiexchance.service.Localidade.dto;


import exchance.grupo.apiexchance.entidade.Localidade;

public class LocalidadeMapper {

  public static Localidade of(LocalidadeDTO localidadeDTO) {

    Localidade localidade = new Localidade();

    localidade.setCep(localidadeDTO.getCep());
    localidade.setCidade(localidadeDTO.getCidade());
    localidade.setEndereco(localidadeDTO.getEndereco());
    localidade.setPais(localidadeDTO.getPais());

    return localidade;
  }
}
