package exchance.grupo.apiexchance.security;

import exchance.grupo.apiexchance.entidade.Estudante;
import exchance.grupo.apiexchance.entidade.HostFamily;
import exchance.grupo.apiexchance.repositorio.EstudanteRepository;
import exchance.grupo.apiexchance.repositorio.HostFamilyRepository;
import exchance.grupo.apiexchance.service.Estudante.autenticacao.dto.EstudanteDetalhesDto;
import exchance.grupo.apiexchance.service.hostFamily.autenticacao.dto.HostFamilyDetalhesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticacaoService implements UserDetailsService {

  @Autowired
  private HostFamilyRepository hostFamilyRepository;

  @Autowired
  private EstudanteRepository estudanteRepository;

  // Método da interface implementada
  @Override
  public HostFamilyDetalhesDto loadUserByUsername(String username) throws UsernameNotFoundException {

    Optional<HostFamily> hostFamilyOpt = hostFamilyRepository.findByEmail(username);

    if (hostFamilyOpt.isEmpty()) {

      throw new UsernameNotFoundException(String.format("usuario: %s nao encontrado", username));
    }

    return new HostFamilyDetalhesDto(hostFamilyOpt.get());
  }

  public EstudanteDetalhesDto loadUserByUsername(String username, String source) throws UsernameNotFoundException {

    Optional<Estudante> estudanteOpt = estudanteRepository.findByEmail(username);

    if (estudanteOpt.isEmpty()) {

      throw new UsernameNotFoundException(String.format("usuario: %s nao encontrado", username));
    }

    return new EstudanteDetalhesDto(estudanteOpt.get());
  }

}
