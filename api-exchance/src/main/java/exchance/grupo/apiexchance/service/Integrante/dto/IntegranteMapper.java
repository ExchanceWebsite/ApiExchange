package exchance.grupo.apiexchance.service.Integrante.dto;


import exchance.grupo.apiexchance.entidade.Integrante;

public class IntegranteMapper {

  public static Integrante of(IntegranteDTO integranteDTO) {
    Integrante integrante = new Integrante();

    integrante.setHost(integranteDTO.getHost());
    integrante.setNome(integranteDTO.getNome());
    integrante.setIdade(integranteDTO.getIdade());
    integrante.setParentesco(integranteDTO.getParentesco());

    return integrante;

  }


}
