package exchance.grupo.apiexchance.security.estudante;

import exchance.grupo.apiexchance.service.Estudante.autenticacao.EstudanteAutenticacaoService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;



public class AutenticacaoProvider implements AuthenticationProvider {

  private final EstudanteAutenticacaoService estudanteAutenticacaoService;
  private final PasswordEncoder passwordEncoder;

  public AutenticacaoProvider(EstudanteAutenticacaoService estudanteAutenticacaoService, PasswordEncoder passwordEncoder) {
    this.estudanteAutenticacaoService = estudanteAutenticacaoService;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public Authentication authenticate(final Authentication authentication) throws AuthenticationException {

    final String username = authentication.getName();
    final String password = authentication.getCredentials().toString();

    UserDetails userDetails = this.estudanteAutenticacaoService.loadUserByUsername(username);

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
