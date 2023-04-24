package exchance.grupo.apiexchance.security.hostFamily;

import exchance.grupo.apiexchance.security.AutenticacaoService;
import exchance.grupo.apiexchance.service.hostFamily.autenticacao.dto.HostFamilyDetalhesDto;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;



public class HostFamilyAutenticacaoProvider implements AuthenticationProvider {

  private final AutenticacaoService autenticacaoService;
  private final PasswordEncoder passwordEncoder;

  public HostFamilyAutenticacaoProvider(AutenticacaoService autenticacaoService, PasswordEncoder passwordEncoder) {
    this.autenticacaoService = autenticacaoService;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public Authentication authenticate(final Authentication authentication) throws AuthenticationException {

    final String username = authentication.getName();
    final String password = authentication.getCredentials().toString();

    HostFamilyDetalhesDto userDetails = this.autenticacaoService.loadUserByUsername(username);

    if (this.passwordEncoder.matches(password, userDetails.getPassword())) {
      return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    } else {
      throw new BadCredentialsException("Usuário ou Senha inválidos");
    }
  }

  @Override
  public boolean supports(final Class<?> authentication) {
    return authentication.equals(UsernamePasswordAuthenticationToken.class);
  }
}

