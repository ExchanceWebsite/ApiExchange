package exchance.grupo.apiexchance.service.hostFamily;

import exchance.grupo.apiexchance.entidade.Estudante;
import exchance.grupo.apiexchance.entidade.HostFamily;
import exchance.grupo.apiexchance.repositorio.HostFamilyRepository;
import exchance.grupo.apiexchance.security.jwt.GerenciadorTokenJwt;
import exchance.grupo.apiexchance.service.Estudante.dto.EstudanteDTO;
import exchance.grupo.apiexchance.service.hostFamily.autenticacao.dto.HostFamilyLoginDto;
import exchance.grupo.apiexchance.service.hostFamily.autenticacao.dto.HostFamilyTokenDto;
import exchance.grupo.apiexchance.service.hostFamily.dto.HostFamilyDTO;
import exchance.grupo.apiexchance.service.hostFamily.dto.HostFamilyMapper;
import org.hibernate.id.IncrementGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

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

    public Boolean deletar(Integer id){


        Optional<HostFamily> hostEncontrado = this.hostFamilyRepository.findById(id);

        if(hostEncontrado.isEmpty()){
            return false;
        }

        this.hostFamilyRepository.delete(hostEncontrado.get());
        return true;
    }

    public HostFamily atualizar(Integer id, HostFamilyDTO hostFamilyDTO){

        Optional<HostFamily> hostEncontrado = this.hostFamilyRepository.findById(id);

        if(hostEncontrado.isEmpty()){
            return null;
        }

        hostEncontrado.get().setNome(hostFamilyDTO.getNome());
        hostEncontrado.get().setVerificado(hostFamilyDTO.getVerificado());
        hostEncontrado.get().setIdHostFamily(id);
        hostEncontrado.get().setEmail(hostFamilyDTO.getEmail());
        hostEncontrado.get().setSenha(passwordEncoder.encode(hostFamilyDTO.getSenha()));
        hostEncontrado.get().setDescricao(hostFamilyDTO.getDescricao());
        hostEncontrado.get().setLocalidade(hostFamilyDTO.getLocalidade());
        hostEncontrado.get().setTelefone(hostFamilyDTO.getTelefone());



        this.hostFamilyRepository.save(hostEncontrado.get());

        return hostEncontrado.get();

    }

    public HostFamily buscar(String email, String nome){
        Optional<HostFamily> hostFamily = this.hostFamilyRepository.findByEmailAndNome(email, nome);

        return hostFamily.orElse(null);

    }

    public Optional<HostFamily> buscarPorID(Integer id){
        Optional<HostFamily> hostFamily = this.hostFamilyRepository.findById(id);

        return hostFamily;

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