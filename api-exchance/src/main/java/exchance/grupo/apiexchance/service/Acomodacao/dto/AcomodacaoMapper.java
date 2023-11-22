package exchance.grupo.apiexchance.service.Acomodacao.dto;


import exchance.grupo.apiexchance.entidade.Acomodacao;

public class AcomodacaoMapper {

  public static Acomodacao of(AcomodacaoDTO acomodacaoDTO) {
    Acomodacao acomodacao = new Acomodacao();

    acomodacao.setDescricao(acomodacaoDTO.getDescricao());
    acomodacao.setLocalidade(acomodacaoDTO.getLocalidade());
    acomodacao.setReservado(false);
    acomodacao.setHost(acomodacaoDTO.getHost());
    acomodacao.setRegras(acomodacaoDTO.getRegras());
    acomodacao.setFimDisponibilidade(acomodacaoDTO.getFimDisponibilidade());
    acomodacao.setInicioDisponibilidade(acomodacaoDTO.getInicioDisponibilidade());
    acomodacao.setValorDiaria(acomodacaoDTO.getValorDiaria());


    return acomodacao;
  }
}
