package exchance.grupo.apiexchance.controle;


import exchance.grupo.apiexchance.entidade.Localidade;
import exchance.grupo.apiexchance.repositorio.LocalidadeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/localidades")
public class LocalidadeController {

    @Autowired
    private LocalidadeRepository localidadeRepository;

    @GetMapping
    public ResponseEntity<List<Localidade>> listar() {

        List<Localidade> localidades = localidadeRepository.findAll();

        if (localidades.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(localidades);
    }

    @PostMapping
    public ResponseEntity<Localidade> cadastrar(@RequestBody @Valid Localidade novaLocalidade) {
        Localidade localidadeCadastrada = this.localidadeRepository.save(novaLocalidade);
        return ResponseEntity.status(201).body(localidadeCadastrada);
    }
}
