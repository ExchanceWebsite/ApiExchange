package exchance.grupo.apiexchance.controle;



import exchance.grupo.apiexchance.entidade.Localidade;
import exchance.grupo.apiexchance.repositorio.LocalidadeRepository;
import exchance.grupo.apiexchance.service.Localidade.LocalidadeService;
import exchance.grupo.apiexchance.service.Localidade.dto.LocalidadeDTO;
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

    @Autowired
    private LocalidadeService localidadeService;

    @GetMapping
    public ResponseEntity<List<Localidade>> listar() {

        List<Localidade> localidades = localidadeRepository.findAll();

        if (localidades.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(localidades);
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid LocalidadeDTO localidadeDTO) {
        this.localidadeService.criar(localidadeDTO);
        return ResponseEntity.status(200).build();
    }
}
