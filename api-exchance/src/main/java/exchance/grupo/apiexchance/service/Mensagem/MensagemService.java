package exchance.grupo.apiexchance.service.Mensagem;

import exchance.grupo.apiexchance.entidade.Comentario;
import exchance.grupo.apiexchance.entidade.Estudante;
import exchance.grupo.apiexchance.entidade.HostFamily;
import exchance.grupo.apiexchance.entidade.Mensagem;
import exchance.grupo.apiexchance.repositorio.ComentarioRepository;
import exchance.grupo.apiexchance.repositorio.MensagemRepository;
import exchance.grupo.apiexchance.service.Comentario.dto.ComentarioDTO;
import exchance.grupo.apiexchance.service.Comentario.dto.ComentarioMapper;
import exchance.grupo.apiexchance.service.Estudante.EstudanteService;
import exchance.grupo.apiexchance.service.Mensagem.dto.MensagemDTO;
import exchance.grupo.apiexchance.service.Mensagem.dto.MensagemMapper;
import exchance.grupo.apiexchance.service.hostFamily.HostFamilyService;
import org.apache.catalina.Host;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MensagemService {

    @Autowired
    MensagemRepository mensagemRepository;
    @Autowired
    EstudanteService estudanteService;
    @Autowired
    HostFamilyService hostFamilyService;

    public void criar(MensagemDTO mensagemDTO) {
        final Mensagem novaMensagem = MensagemMapper.of(mensagemDTO);

        this.mensagemRepository.save(novaMensagem);
    }

    public List<Mensagem> listarMensagensHostEstudante(Integer idHost, Integer idEstudante){

        Optional<HostFamily> hostEncontrada = this.hostFamilyService.buscarPorID(idHost);

        Estudante estudanteEncontrado = this.estudanteService.buscarPorId(idEstudante);

        if(hostEncontrada.isEmpty() || estudanteEncontrado == null){
            return null;
        }

        List<Mensagem> Mensagens = this.mensagemRepository.findAllByDestinatarioAndProprietario(hostEncontrada.get(), estudanteEncontrado);

        return Mensagens;
    }
}

