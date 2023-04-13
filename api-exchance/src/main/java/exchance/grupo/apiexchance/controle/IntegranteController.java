package exchance.grupo.apiexchance.controle;


import exchance.grupo.apiexchance.entidade.Integrante;
import exchance.grupo.apiexchance.repositorio.IntegranteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/integrantes")
public class IntegranteController {

    @Autowired
    private IntegranteRepository integranteRepository;

    @GetMapping
    public ResponseEntity<List<Integrante>> listar() {

        List<Integrante> integrantes = integranteRepository.findAll();

        if (integrantes.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(integrantes);
    }

    @PostMapping
    public ResponseEntity<Integrante> cadastrar(@RequestBody @Valid Integrante novoIntegrante) {
        Integrante integranteCadastrado = this.integranteRepository.save(novoIntegrante);
        return ResponseEntity.status(201).body(integranteCadastrado);
    }
}
