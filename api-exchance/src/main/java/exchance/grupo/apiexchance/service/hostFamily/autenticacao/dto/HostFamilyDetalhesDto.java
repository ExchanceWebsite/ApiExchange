package exchance.grupo.apiexchance.service.hostFamily.autenticacao.dto;

import exchance.grupo.apiexchance.entidade.HostFamily;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;

public class HostFamilyDetalhesDto implements UserDetails {

  private final String nome;

  private final String email;

  private final String senha;

  public HostFamilyDetalhesDto(HostFamily hostFamily) {
    this.nome = hostFamily.getNome();
    this.email = hostFamily.getEmail();
    this.senha = hostFamily.getSenha();
  }

  public String getNome() {
    return nome;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public String getPassword() {
    return senha;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
