package exchance.grupo.apiexchance.service.Comentario;

import exchance.grupo.apiexchance.entidade.Comentario;
import exchance.grupo.apiexchance.entidade.HostFamily;
import exchance.grupo.apiexchance.repositorio.ComentarioRepository;
import exchance.grupo.apiexchance.repositorio.HostFamilyRepository;
import exchance.grupo.apiexchance.service.Comentario.dto.ComentarioDTO;
import exchance.grupo.apiexchance.service.Comentario.dto.ComentarioMapper;
import exchance.grupo.apiexchance.service.hostFamily.HostFamilyService;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ComentarioService {

  private final ComentarioRepository comentarioRepository;
  private final HostFamilyService hostFamilyService;

  public ComentarioService(ComentarioRepository comentarioRepository, HostFamilyService hostFamilyService) {
    this.comentarioRepository = comentarioRepository;
    this.hostFamilyService = hostFamilyService;
  }

  public void criar(ComentarioDTO comentarioDTO) {
    final Comentario novoComentario = ComentarioMapper.of(comentarioDTO);

    this.comentarioRepository.save(novoComentario);
  }

  public List<Comentario> listarComentariosHost(Integer idHost){
    List<Comentario> Comentarios = null;

    Optional<HostFamily> hostEncontrada = this.hostFamilyService.buscarPorID(idHost);

    if (hostEncontrada.isPresent()){
      Comentarios = this.comentarioRepository.findAllByDestinatario(hostEncontrada.get());

      if(Comentarios.size() >= 1){
        return Comentarios;
      }

    }

    return Comentarios;

  }

}