package exchance.grupo.apiexchance.service.Comentario;

import exchance.grupo.apiexchance.entidade.Comentario;
import exchance.grupo.apiexchance.entidade.HostFamily;
import exchance.grupo.apiexchance.repositorio.ComentarioRepository;
import exchance.grupo.apiexchance.repositorio.HostFamilyRepository;
import exchance.grupo.apiexchance.service.Comentario.dto.ComentarioDTO;
import exchance.grupo.apiexchance.service.Comentario.dto.ComentarioMapper;
import exchance.grupo.apiexchance.service.hostFamily.HostFamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ComentarioService {

  @Autowired
  ComentarioRepository comentarioRepository;

  @Autowired
  HostFamilyService hostFamilyService;

  public void criar(ComentarioDTO comentarioDTO) {
    final Comentario novoComentario = ComentarioMapper.of(comentarioDTO);

    this.comentarioRepository.save(novoComentario);
  }

  public List<Comentario> listarComentariosHost(Integer idHost){

    Optional<HostFamily> hostEncontrada = this.hostFamilyService.buscarPorID(idHost);

    List<Comentario> Comentarios = this.comentarioRepository.findAllByDestinatario(hostEncontrada.get());

    if(Comentarios.isEmpty() || hostEncontrada.isEmpty()){
      return null;
    }

    return Comentarios;

  }

}