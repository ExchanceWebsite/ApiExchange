package exchance.grupo.apiexchance.service.Estudante.dto;


import exchance.grupo.apiexchance.entidade.Estudante;
import exchance.grupo.apiexchance.service.Estudante.autenticacao.dto.EstudanteTokenDto;

public class EstudanteMapper {

  public static Estudante of(EstudanteDTO estudanteDTO) {
    Estudante estudante = new Estudante();

    estudante.setCpf(estudanteDTO.getCpf());
    estudante.setEmail(estudanteDTO.getEmail());
    estudante.setNome(estudanteDTO.getNome());
    estudante.setSenha(estudanteDTO.getSenha());
    estudante.setDescricao(estudanteDTO.getDescricao());
    estudante.setIdade(estudanteDTO.getIdade());
    estudante.setLocalidade(estudanteDTO.getLocalidade());
    estudante.setTelefone(estudanteDTO.getTelefone());


    return estudante;
  }

  public static EstudanteTokenDto of(Estudante estudante, String token) {
    EstudanteTokenDto estudanteTokenDto = new EstudanteTokenDto();

    estudanteTokenDto.setIdEstudante(estudante.getIdEstudante());
    estudanteTokenDto.setEmail(estudante.getEmail());
    estudanteTokenDto.setNome(estudante.getNome());
    estudanteTokenDto.setToken(token);

    return estudanteTokenDto;
  }
}
