package exchance.grupo.apiexchance.service.Estudante;

import exchance.grupo.apiexchance.entidade.Estudante;
import exchance.grupo.apiexchance.repositorio.EstudanteRepository;
import exchance.grupo.apiexchance.security.jwt.GerenciadorTokenJwt;
import exchance.grupo.apiexchance.service.Estudante.autenticacao.dto.EstudanteLoginDto;
import exchance.grupo.apiexchance.service.Estudante.autenticacao.dto.EstudanteTokenDto;
import exchance.grupo.apiexchance.service.Estudante.dto.EstudanteDTO;
import exchance.grupo.apiexchance.service.Estudante.dto.EstudanteMapper;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


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

  public Boolean deletar(Integer id){


    Optional<Estudante> estudanteEncontrado = this.estudanteRepository.findById(id);

    if(estudanteEncontrado.isEmpty()){
      return false;
    }

    this.estudanteRepository.delete(estudanteEncontrado.get());
    return true;
  }

  public Estudante atualizar(Integer id, EstudanteDTO estudanteDTO){

    Optional<Estudante> estudanteEncontrado = this.estudanteRepository.findById(id);

    if(estudanteEncontrado.isEmpty()){
      return null;
    }

    estudanteEncontrado.get().setEmail(estudanteDTO.getEmail());
    estudanteEncontrado.get().setCpf(estudanteDTO.getCpf());
    estudanteEncontrado.get().setDescricao(estudanteDTO.getDescricao());
    estudanteEncontrado.get().setIdade(estudanteDTO.getIdade());
    estudanteEncontrado.get().setNome(estudanteDTO.getNome());
    estudanteEncontrado.get().setSenha(passwordEncoder.encode(estudanteDTO.getSenha()));
    estudanteEncontrado.get().setTelefone(estudanteDTO.getTelefone());
    estudanteEncontrado.get().setIdEstudante(id);
    estudanteEncontrado.get().setLocalidade(estudanteDTO.getLocalidade());

    this.estudanteRepository.save(estudanteEncontrado.get());

    return estudanteEncontrado.get();

  }


  public Estudante buscar(String email, String nome) {
    Optional<Estudante> estudante = this.estudanteRepository.findByEmailAndNome(email, nome);

    return estudante.orElse(null);
  }

  public Estudante buscarPorId(Integer id) {
    Optional<Estudante> estudante = this.estudanteRepository.findById(id);

    return estudante.orElse(null);
  }


  public Integer encontrarId(String email, String senha){
    Optional<Integer> idEstudante = this.estudanteRepository.findIdEstudanteBySenhaAndEmail(senha, email);

    return idEstudante.orElse(null);


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