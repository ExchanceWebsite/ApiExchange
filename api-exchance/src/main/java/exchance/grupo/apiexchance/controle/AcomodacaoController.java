package exchance.grupo.apiexchance.controle;

import exchance.grupo.apiexchance.entidade.Acomodacao;
import exchance.grupo.apiexchance.entidade.Localidade;
import exchance.grupo.apiexchance.repositorio.AcomodacaoRepository;
import exchance.grupo.apiexchance.repositorio.LocalidadeRepository;
import exchance.grupo.apiexchance.service.Acomodacao.AcomodacaoService;
import exchance.grupo.apiexchance.service.Acomodacao.dto.AcomodacaoDTO;
import exchance.grupo.apiexchance.service.Localidade.LocalidadeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/acomodacoes")
public class AcomodacaoController {


    @Autowired
    private AcomodacaoRepository acomodacaoRepository;

    @Autowired
    private AcomodacaoService acomodacaoService;

    @Autowired
    private LocalidadeService localidadeService;

    @GetMapping
    public ResponseEntity<List<Acomodacao>> listar() {

        List<Acomodacao> acomodacaos = acomodacaoRepository.findAll();

        if (acomodacaos.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(acomodacaos);
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid AcomodacaoDTO acomodacaoDTO) {
        this.acomodacaoService.criar(acomodacaoDTO);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/acomodacoes-cidade-disponivel")
    public ResponseEntity<List<Acomodacao>> listarAcomodacaoLocalidade(@RequestParam String cidade, @RequestParam LocalDate entrada, @RequestParam LocalDate saida){

        Localidade localidade = this.localidadeService.buscarLocalidadePorCidade(cidade);

        List<Acomodacao> acomodacaos = this.acomodacaoService.findAccommodations(localidade.getIdLocalidade(), entrada, saida);

        if(localidade == null || acomodacaos.isEmpty()){
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.ok(acomodacaos);

    }

    @GetMapping("/acomodacoes-pais-disponivel")
    public ResponseEntity<List<Acomodacao>> listarAcomodacaoLocalidadePais(@RequestParam String Pais, @RequestParam LocalDate entrada, @RequestParam LocalDate saida){

        Localidade localidade = this.localidadeService.buscarLocalidadePorPais(Pais);

        List<Acomodacao> acomodacaos = this.acomodacaoService.findAccommodations(localidade.getIdLocalidade(), entrada, saida);

        if(localidade == null || acomodacaos.isEmpty()){
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.ok(acomodacaos);

    }
}
