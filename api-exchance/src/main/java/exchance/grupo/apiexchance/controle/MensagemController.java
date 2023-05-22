package exchance.grupo.apiexchance.controle;

import exchance.grupo.apiexchance.entidade.Comentario;
import exchance.grupo.apiexchance.entidade.Mensagem;
import exchance.grupo.apiexchance.repositorio.MensagemRepository;
import exchance.grupo.apiexchance.service.Comentario.dto.ComentarioDTO;
import exchance.grupo.apiexchance.service.Mensagem.MensagemService;
import exchance.grupo.apiexchance.service.Mensagem.dto.MensagemDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mensagens")
public class MensagemController {

    @Autowired
    MensagemRepository mensagemRepository;

    @Autowired
    MensagemService mensagemService;


    @GetMapping
    public ResponseEntity<List<Mensagem>> listar() {

        List<Mensagem> mensagens = mensagemRepository.findAll();

        if (mensagens.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(mensagens);
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid MensagemDTO mensagemDTO) {
        this.mensagemService.criar(mensagemDTO);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/mensagens-destinatario-proprietario")
    public ResponseEntity<List<Mensagem>> listarMensagensPorHostEstudante(@RequestParam Integer idHost, @RequestParam Integer idEstudante){

        List<Mensagem> mensagems = this.mensagemService.listarMensagensHostEstudante(idHost, idEstudante);

        if(mensagems.isEmpty()){
            return ResponseEntity.status(204).build();
        }else if(mensagems == null){
            return ResponseEntity.status(400).build();
        }

        return ResponseEntity.ok(mensagems);

    }
}
