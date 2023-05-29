package exchance.grupo.apiexchance.controle;


import exchance.grupo.apiexchance.entidade.Integrante;
import exchance.grupo.apiexchance.lista.FilaObj;
import exchance.grupo.apiexchance.repositorio.IntegranteRepository;
import exchance.grupo.apiexchance.service.Integrante.IntegranteService;
import exchance.grupo.apiexchance.service.Integrante.dto.IntegranteDTO;
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

    @Autowired
    private IntegranteService integranteService;

    @GetMapping
    public ResponseEntity<List<Integrante>> listar() {

        List<Integrante> integrantes = integranteRepository.findAll();

        if (integrantes.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(integrantes);
    }

    @PostMapping("/add-integrante")
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid IntegranteDTO integranteDTO) {
        this.integranteService.criar(integranteDTO);


        return ResponseEntity.status(201).build();
    }
}
