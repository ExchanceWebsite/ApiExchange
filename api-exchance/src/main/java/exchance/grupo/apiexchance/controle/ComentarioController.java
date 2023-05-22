package exchance.grupo.apiexchance.controle;


import com.azure.core.annotation.Get;
import exchance.grupo.apiexchance.entidade.Acomodacao;
import exchance.grupo.apiexchance.entidade.Comentario;
import exchance.grupo.apiexchance.repositorio.AcomodacaoRepository;
import exchance.grupo.apiexchance.repositorio.ComentarioRepository;
import exchance.grupo.apiexchance.service.Comentario.ComentarioService;
import exchance.grupo.apiexchance.service.Comentario.dto.ComentarioDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private ComentarioService comentarioService;

    @GetMapping
    public ResponseEntity<List<Comentario>> listar() {

        List<Comentario> comentarios = comentarioRepository.findAll();

        if (comentarios.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(comentarios);
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid ComentarioDTO comentarioDTO) {
        this.comentarioService.criar(comentarioDTO);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/comentarios-host")
    public ResponseEntity<List<Comentario>> listarComentariosHost(@RequestParam Integer idHost){

        List<Comentario> comentarios = this.comentarioService.listarComentariosHost(idHost);

        if(comentarios.isEmpty()){
            return ResponseEntity.status(204).build();
        }else if(comentarios == null){
            return ResponseEntity.status(400).build();
        }

        return ResponseEntity.ok(comentarios);

    }
}
