package exchance.grupo.apiexchance.service.Estudante;

import exchance.grupo.apiexchance.entidade.Estudante;
import exchance.grupo.apiexchance.repositorio.EstudanteRepository;
import exchance.grupo.apiexchance.security.jwt.GerenciadorTokenJwt;
import exchance.grupo.apiexchance.service.Estudante.autenticacao.dto.EstudanteLoginDto;
import exchance.grupo.apiexchance.service.Estudante.autenticacao.dto.EstudanteTokenDto;
import exchance.grupo.apiexchance.service.Estudante.dto.EstudanteDTO;
import exchance.grupo.apiexchance.service.Estudante.dto.EstudanteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class EstudanteService {

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private EstudanteRepository estudanteRepository;

  @Autowired
  private GerenciadorTokenJwt gerenciadorTokenJwt;

  @Autowired
  private AuthenticationManager authenticationManager;

  public void criar(EstudanteDTO estudanteDTO) {
    final Estudante novoEstudante = EstudanteMapper.of(estudanteDTO);

    String senhaCriptografada = passwordEncoder.encode(novoEstudante.getSenha());
    novoEstudante.setSenha(senhaCriptografada);

    this.estudanteRepository.save(novoEstudante);
  }

  public EstudanteTokenDto autenticar(EstudanteLoginDto estudanteLoginDto) {

    final UsernamePasswordAuthenticationToken credentials = new UsernamePasswordAuthenticationToken(
            estudanteLoginDto.getEmail(), estudanteLoginDto.getSenha());

    final Authentication authentication = this.authenticationManager.authenticate(credentials);

    Estudante estudanteAutenticado =
            estudanteRepository.findByEmail(estudanteLoginDto.getEmail())
                    .orElseThrow(
                            () -> new ResponseStatusException(404, "Email do usuário não cadastrado", null)
                    );

    SecurityContextHolder.getContext().setAuthentication(authentication);

    final String token = gerenciadorTokenJwt.generateToken(authentication);

    return EstudanteMapper.of(estudanteAutenticado, token);
  }
}