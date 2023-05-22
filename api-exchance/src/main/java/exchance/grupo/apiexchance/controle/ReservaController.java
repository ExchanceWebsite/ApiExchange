package exchance.grupo.apiexchance.controle;


import exchance.grupo.apiexchance.entidade.Comentario;
import exchance.grupo.apiexchance.entidade.Reserva;
import exchance.grupo.apiexchance.repositorio.ReservaRepository;
import exchance.grupo.apiexchance.service.Reserva.ReservaService;
import exchance.grupo.apiexchance.service.Reserva.dto.ReservaDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private ReservaService reservaService;

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
}
