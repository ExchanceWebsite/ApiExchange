package exchance.grupo.apiexchance.controle;

import exchance.grupo.apiexchance.entidade.HostFamily;
import exchance.grupo.apiexchance.repositorio.HostFamilyRepository;
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

    @GetMapping
    public ResponseEntity<List<HostFamily>> listar() {

        List<HostFamily> hostFamilys = hostFamilyRepository.findAll();

        if (hostFamilys.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(hostFamilys);
    }

    @PostMapping
    public ResponseEntity<HostFamily> cadastrar(@RequestBody @Valid HostFamily novaHost) {
        HostFamily hostFamilyCadastrada = this.hostFamilyRepository.save(novaHost);
        return ResponseEntity.status(201).body(hostFamilyCadastrada);
    }

    @GetMapping
    public ResponseEntity<Void> login(@RequestParam String email, @RequestParam String senha){

        Optional<String> emailEncontrado = hostFamilyRepository.findByEmail(email);

        Optional<String> senhaEncontrada = hostFamilyRepository.findBySenha(senha);

        if(emailEncontrado.isEmpty() || senhaEncontrada.isEmpty()){
            return ResponseEntity.status(404).build();
        }else{
            return ResponseEntity.status(200).build();
        }


    }
}
