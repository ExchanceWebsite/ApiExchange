package exchance.grupo.apiexchance.service.Estudante.autenticacao.dto;

import exchance.grupo.apiexchance.service.Integrante.dto.IntegranteDTO;

public class EstudanteTokenDto {

  private Integer idEstudante;
  private String nome;
  private String email;
  private String token;

  public Integer getIdEstudante() {
    return idEstudante;
  }

  public void setIdEstudante(Integer idEstudante) {
    this.idEstudante = idEstudante;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}
