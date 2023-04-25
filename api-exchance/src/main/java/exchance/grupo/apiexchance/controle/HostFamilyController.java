package exchance.grupo.apiexchance.controle;

import exchance.grupo.apiexchance.entidade.HostFamily;
import exchance.grupo.apiexchance.repositorio.HostFamilyRepository;
import exchance.grupo.apiexchance.service.Estudante.autenticacao.dto.EstudanteLoginDto;
import exchance.grupo.apiexchance.service.Estudante.autenticacao.dto.EstudanteTokenDto;
import exchance.grupo.apiexchance.service.Estudante.dto.EstudanteDTO;
import exchance.grupo.apiexchance.service.hostFamily.HostFamilyService;
import exchance.grupo.apiexchance.service.hostFamily.autenticacao.dto.HostFamilyLoginDto;
import exchance.grupo.apiexchance.service.hostFamily.autenticacao.dto.HostFamilyTokenDto;
import exchance.grupo.apiexchance.service.hostFamily.dto.HostFamilyDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hosts")
public class HostFamilyController {

    @Autowired
    private HostFamilyRepository hostFamilyRepository;

    @Autowired
    private HostFamilyService hostFamilyService;

    @GetMapping
    public ResponseEntity<List<HostFamily>> listar() {

        List<HostFamily> hostFamilys = hostFamilyRepository.findAll();

        if (hostFamilys.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(hostFamilys);
    }

    @PostMapping
    @SecurityRequirement(name = "Bearer")
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid HostFamilyDTO hostFamilyDTO) {
        this.hostFamilyService.criar(hostFamilyDTO);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/login")
    public ResponseEntity<HostFamilyTokenDto> login(@RequestBody HostFamilyLoginDto hostFamilyLoginDto) {
        HostFamilyTokenDto hostFamilyTokenDto = this.hostFamilyService.autenticar(hostFamilyLoginDto);

        return ResponseEntity.status(200).body(hostFamilyTokenDto);
    }

    @DeleteMapping()
    public ResponseEntity<Void> deletar(@RequestParam Integer id) {


        if(this.hostFamilyService.deletar(id)){
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.status(400).build();
    }

    @PutMapping()
    public ResponseEntity<HostFamily> atualizar(@RequestParam Integer id ,@RequestBody HostFamilyDTO hostFamilyDTO) {


        if(this.hostFamilyService.atualizar(id, hostFamilyDTO) == null){
            return ResponseEntity.status(400).build();
        }

        return ResponseEntity.status(200).body(this.hostFamilyService.atualizar(id, hostFamilyDTO));
    }
}
