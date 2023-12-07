package exchance.grupo.apiexchance.service.hostFamily.autenticacao.dto;

public class HostFamilyTokenDto {

  private Integer idHostFamily;
  private String nome;
  private String email;
  private String token;

  public Integer getIdHostFamily() {
    return idHostFamily;
  }

  public void setIdHostFamily(Integer idHostFamily) {
    this.idHostFamily = idHostFamily;
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
