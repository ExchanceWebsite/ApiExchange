package exchance.grupo.apiexchance.service.Mensagem;

import exchance.grupo.apiexchance.entidade.Comentario;
import exchance.grupo.apiexchance.entidade.Mensagem;
import exchance.grupo.apiexchance.repositorio.ComentarioRepository;
import exchance.grupo.apiexchance.repositorio.MensagemRepository;
import exchance.grupo.apiexchance.service.Comentario.dto.ComentarioDTO;
import exchance.grupo.apiexchance.service.Comentario.dto.ComentarioMapper;
import exchance.grupo.apiexchance.service.Mensagem.dto.MensagemDTO;
import exchance.grupo.apiexchance.service.Mensagem.dto.MensagemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MensagemService {

    @Autowired
    MensagemRepository mensagemRepository;

    public void criar(MensagemDTO mensagemDTO) {
        final Mensagem novaMensagem = MensagemMapper.of(mensagemDTO);

        this.mensagemRepository.save(novaMensagem);
    }
}
