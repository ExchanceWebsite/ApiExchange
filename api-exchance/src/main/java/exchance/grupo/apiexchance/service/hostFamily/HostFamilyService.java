package exchance.grupo.apiexchance.service.hostFamily;

import exchance.grupo.apiexchance.entidade.HostFamily;
import exchance.grupo.apiexchance.repositorio.HostFamilyRepository;
import exchance.grupo.apiexchance.security.jwt.GerenciadorTokenJwt;
import exchance.grupo.apiexchance.service.hostFamily.autenticacao.dto.HostFamilyLoginDto;
import exchance.grupo.apiexchance.service.hostFamily.autenticacao.dto.HostFamilyTokenDto;
import exchance.grupo.apiexchance.service.hostFamily.dto.HostFamilyDTO;
import exchance.grupo.apiexchance.service.hostFamily.dto.HostFamilyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class HostFamilyService {

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private HostFamilyRepository hostFamilyRepository;

  @Autowired
  private GerenciadorTokenJwt gerenciadorTokenJwt;

  @Autowired
  private AuthenticationManager authenticationManager;

  public void criar(HostFamilyDTO hostFamilyDTO) {
    final HostFamily novoHostFaily = HostFamilyMapper.of(hostFamilyDTO);

    String senhaCriptografada = passwordEncoder.encode(novoHostFaily.getSenha());
    novoHostFaily.setSenha(senhaCriptografada);

    this.hostFamilyRepository.save(novoHostFaily);
  }

  public HostFamilyTokenDto autenticar(HostFamilyLoginDto hostFamilyLoginDto) {

    final UsernamePasswordAuthenticationToken credentials = new UsernamePasswordAuthenticationToken(
            hostFamilyLoginDto.getEmail(),hostFamilyLoginDto.getSenha());

    final Authentication authentication = this.authenticationManager.authenticate(credentials);

   HostFamily hostFamilyAutenticado =
            hostFamilyRepository.findByEmail(hostFamilyLoginDto.getEmail())
                    .orElseThrow(
                            () -> new ResponseStatusException(404, "Email do usuário não cadastrado", null)
                    );

    SecurityContextHolder.getContext().setAuthentication(authentication);

    final String token = gerenciadorTokenJwt.generateToken(authentication);

    return HostFamilyMapper.of(hostFamilyAutenticado, token);
  }
}