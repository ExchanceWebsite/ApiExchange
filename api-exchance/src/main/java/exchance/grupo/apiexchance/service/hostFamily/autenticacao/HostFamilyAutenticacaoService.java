package exchance.grupo.apiexchance.service.hostFamily.autenticacao;

import exchance.grupo.apiexchance.entidade.HostFamily;
import exchance.grupo.apiexchance.repositorio.HostFamilyRepository;
import exchance.grupo.apiexchance.service.hostFamily.autenticacao.dto.HostFamilyDetalhesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/*@Service
public class HostFamilyAutenticacaoService implements UserDetailsService {

  @Autowired
  private HostFamilyRepository hostFamilyRepository;

  // Método da interface implementada
 *//* @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    Optional<HostFamily> hostFamilyOpt = hostFamilyRepository.findByEmail(username);

    if (hostFamilyOpt.isEmpty()) {

      throw new UsernameNotFoundException(String.format("usuario: %s nao encontrado", username));
    }

    return new HostFamilyDetalhesDto(hostFamilyOpt.get());
  }*//*
}*/
