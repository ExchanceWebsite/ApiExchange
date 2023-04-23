package exchance.grupo.apiexchance.service.Comentario;

import exchance.grupo.apiexchance.entidade.Comentario;
import exchance.grupo.apiexchance.repositorio.ComentarioRepository;
import exchance.grupo.apiexchance.service.Comentario.dto.ComentarioDTO;
import exchance.grupo.apiexchance.service.Comentario.dto.ComentarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ComentarioService {

  @Autowired
  ComentarioRepository comentarioRepository;

  public void criar(ComentarioDTO comentarioDTO) {
    final Comentario novoComentario = ComentarioMapper.of(comentarioDTO);

    this.comentarioRepository.save(novoComentario);
  }

}