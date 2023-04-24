/*
package exchance.grupo.apiexchance.security.hostFamily;

import exchance.grupo.apiexchance.service.hostFamily.autenticacao.HostFamilyAutenticacaoService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;



public class HostFamilyAutenticacaoProvider implements AuthenticationProvider {

  private final HostFamilyAutenticacaoService hostFamilyAutenticacaoService;
  private final PasswordEncoder passwordEncoder;

  public HostFamilyAutenticacaoProvider(HostFamilyAutenticacaoService hostFamilyAutenticacaoService, PasswordEncoder passwordEncoder) {
    this.hostFamilyAutenticacaoService = hostFamilyAutenticacaoService;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public Authentication authenticate(final Authentication authentication) throws AuthenticationException {

    final String username = authentication.getName();
    final String password = authentication.getCredentials().toString();

    UserDetails userDetails = this.hostFamilyAutenticacaoService.loadUserByUsername(username);

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
*/
