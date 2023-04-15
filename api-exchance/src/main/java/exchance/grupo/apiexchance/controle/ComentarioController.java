package exchance.grupo.apiexchance.controle;


import exchance.grupo.apiexchance.entidade.Acomodacao;
import exchance.grupo.apiexchance.entidade.Comentario;
import exchance.grupo.apiexchance.repositorio.AcomodacaoRepository;
import exchance.grupo.apiexchance.repositorio.ComentarioRepository;
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

    @GetMapping
    public ResponseEntity<List<Comentario>> listar() {

        List<Comentario> comentarios = comentarioRepository.findAll();

        if (comentarios.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(comentarios);
    }

    @PostMapping
    public ResponseEntity<Comentario> cadastrar(@RequestBody @Valid Comentario novoComentario) {
        Comentario comentarioCadastrado = this.comentarioRepository.save(novoComentario);
        return ResponseEntity.status(201).body(comentarioCadastrado);
    }
}
