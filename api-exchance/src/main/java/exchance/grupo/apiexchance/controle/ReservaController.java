package exchance.grupo.apiexchance.controle;


import exchance.grupo.apiexchance.entidade.Reserva;
import exchance.grupo.apiexchance.lista.PilhaObj;
import exchance.grupo.apiexchance.repositorio.AcomodacaoRepository;
import exchance.grupo.apiexchance.repositorio.EstudanteRepository;
import exchance.grupo.apiexchance.repositorio.HostFamilyRepository;
import exchance.grupo.apiexchance.repositorio.ReservaRepository;
import exchance.grupo.apiexchance.service.Reserva.ReservaService;
import exchance.grupo.apiexchance.service.Reserva.dto.ReservaDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Stack;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private PilhaObj pilhaObj;
    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private EstudanteRepository estudanteRepository;

    @Autowired
    private HostFamilyRepository hostFamilyRepository;

    @Autowired
    private AcomodacaoRepository acomodacaoRepository;

    @GetMapping
    public ResponseEntity<List<Reserva>> listar() {

        List<Reserva> reservas = reservaRepository.findAll();

        if (reservas.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(reservas);
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid ReservaDTO reservaDTO) {
        this.reservaService.criar(reservaDTO);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/reservas-estudante")
    public ResponseEntity<List<Reserva>> listarReservasEstudante(@RequestParam Integer idEstudante){
        List<Reserva> reservas = this.reservaService.listarReservasEstudante(idEstudante);

        if(reservas.isEmpty()){
            return ResponseEntity.status(204).build();
        }else if(reservas == null){
            return ResponseEntity.status(400).build();
        }

        return ResponseEntity.ok(reservas);
    }

    @GetMapping("/reservas-host")
    public ResponseEntity<List<Reserva>> listarReservasHost(@RequestParam Integer idHost){
        List<Reserva> reservas = this.reservaService.listarReservasHost(idHost);

        if(reservas.isEmpty()){
            return ResponseEntity.status(204).build();
        }else if(reservas == null){
            return ResponseEntity.status(400).build();
        }

        return ResponseEntity.ok(reservas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removerReserva(@PathVariable int id){
        Optional<Reserva> optionalReserva =this.reservaRepository.findById(id);
        if (optionalReserva.isPresent()){
            Reserva reserva = optionalReserva.get();
            pilhaObj.push(reserva);
            if (this.reservaRepository.existsByAcomodacaoIdAcomodacao(id)){
                if (this.hostFamilyRepository.existsByAcomodacoesIdAcomodacao(id)){
                    this.acomodacaoRepository.update(id);
                    this.acomodacaoRepository.deleteById(id);
                    this.reservaRepository.update(id);
                    this.reservaRepository.deleteById(id);
                    return ResponseEntity.status(200).body("Reserva Cancelada!");
                }
            }else{
                this.reservaRepository.update(id);
                this.reservaRepository.deleteById(id);
                return ResponseEntity.status(200).body("Reserva Cancelada!");
            }
            }
        return ResponseEntity.status(404).build();
    }

    @PostMapping("/{id}/restaurar")
    public ResponseEntity<String> restaurarReservaCancelada(@PathVariable int id){
        if (!pilhaObj.isEmpty()){
            Reserva reserva = (Reserva) pilhaObj.pop();
            this.reservaRepository.save(reserva);
            return ResponseEntity
                    .status(200).body("Reserva restaurada com Sucesso!");
        }
        return ResponseEntity.status(404).body("Nenhuma reserva cancelada disponivel para resttauração");
    }


}
