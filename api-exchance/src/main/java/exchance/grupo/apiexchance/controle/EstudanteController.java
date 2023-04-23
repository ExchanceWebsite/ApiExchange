package exchance.grupo.apiexchance.controle;


import exchance.grupo.apiexchance.entidade.Comentario;
import exchance.grupo.apiexchance.entidade.Estudante;
import exchance.grupo.apiexchance.entidade.HostFamily;
import exchance.grupo.apiexchance.repositorio.ComentarioRepository;
import exchance.grupo.apiexchance.repositorio.EstudanteRepository;
import exchance.grupo.apiexchance.service.Estudante.EstudanteService;
import exchance.grupo.apiexchance.service.Estudante.autenticacao.dto.EstudanteLoginDto;
import exchance.grupo.apiexchance.service.Estudante.autenticacao.dto.EstudanteTokenDto;
import exchance.grupo.apiexchance.service.Estudante.dto.EstudanteDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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

    @Autowired
    private EstudanteService estudanteService;

    @GetMapping
    public ResponseEntity<List<Estudante>> listar() {

        List<Estudante> estudantes = estudanteRepository.findAll();

        if (estudantes.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(estudantes);
    }

    @PostMapping
    @SecurityRequirement(name = "Bearer")
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid EstudanteDTO estudanteDTO) {
        this.estudanteService.criar(estudanteDTO);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/login")
    public ResponseEntity<EstudanteTokenDto> login(@RequestBody EstudanteLoginDto estudanteLoginDto) {
        EstudanteTokenDto estudanteTokenDto = this.estudanteService.autenticar(estudanteLoginDto);

        return ResponseEntity.status(200).body(estudanteTokenDto);
    }
}
