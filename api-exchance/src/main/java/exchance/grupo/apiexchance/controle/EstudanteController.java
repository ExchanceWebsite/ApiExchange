package exchance.grupo.apiexchance.controle;


import exchance.grupo.apiexchance.entidade.Comentario;
import exchance.grupo.apiexchance.entidade.Estudante;
import exchance.grupo.apiexchance.entidade.HostFamily;
import exchance.grupo.apiexchance.repositorio.ComentarioRepository;
import exchance.grupo.apiexchance.repositorio.EstudanteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estudantes")
public class EstudanteController {

    @Autowired
    private EstudanteRepository estudanteRepository;

    @GetMapping
    public ResponseEntity<List<Estudante>> listar() {

        List<Estudante> estudantes = estudanteRepository.findAll();

        if (estudantes.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(estudantes);
    }

    @PostMapping
    public ResponseEntity<Estudante> cadastrar(@RequestBody @Valid Estudante novoEstudante) {
        Estudante estudanteCadastrado = this.estudanteRepository.save(novoEstudante);
        return ResponseEntity.status(201).body(estudanteCadastrado);
    }

    @GetMapping("/login")
    public ResponseEntity<Void> login(@RequestParam String email, @RequestParam String senha){

        Optional<Estudante> contaEncontrada = estudanteRepository.findBySenhaAndEmail(senha, email);

        if(contaEncontrada.isEmpty()){
            return ResponseEntity.status(401).build();
        }else{
            return ResponseEntity.status(200).build();
        }


    }
}
