package exchance.grupo.apiexchance.service.Estudante.autenticacao;

import exchance.grupo.apiexchance.entidade.Estudante;
import exchance.grupo.apiexchance.repositorio.EstudanteRepository;
import exchance.grupo.apiexchance.service.Estudante.autenticacao.dto.EstudanteDetalhesDto;
import jdk.jfr.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstudanteAutenticacaoService implements UserDetailsService {

  @Autowired
  private EstudanteRepository estudanteRepository;

  // Método da interface implementada

  @Override
  public EstudanteDetalhesDto loadUserByUsername(String username) throws UsernameNotFoundException {

    Optional<Estudante> estudanteOpt = estudanteRepository.findByEmail(username);

    if (estudanteOpt.isEmpty()) {

      throw new UsernameNotFoundException(String.format("usuario: %s nao encontrado", username));
    }

    return new EstudanteDetalhesDto(estudanteOpt.get());
  }
}

