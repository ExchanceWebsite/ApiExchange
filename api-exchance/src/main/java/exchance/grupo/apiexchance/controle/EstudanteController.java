package exchance.grupo.apiexchance.controle;



import exchance.grupo.apiexchance.entidade.Estudante;

import exchance.grupo.apiexchance.repositorio.EstudanteRepository;
import exchance.grupo.apiexchance.service.Estudante.EstudanteService;
import exchance.grupo.apiexchance.service.Estudante.autenticacao.dto.EstudanteLoginDto;
import exchance.grupo.apiexchance.service.Estudante.autenticacao.dto.EstudanteTokenDto;
import exchance.grupo.apiexchance.service.Estudante.dto.EstudanteDTO;
import exchance.grupo.apiexchance.service.Imagem.ImagemService;

import exchance.grupo.apiexchance.service.Imagem.dto.ImagemDTO;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import java.io.IOException;
import java.nio.file.Path;
import java.util.List;


@RestController
@RequestMapping("/estudantes")
public class EstudanteController {


    private EstudanteRepository estudanteRepository;


    private EstudanteService estudanteService;


    private ImagemService imagemService;
    private Path diretorioBase;

    //  private Path diretorioBase = Path.of(System.getProperty("user.dir") + "/Downloads");

    public EstudanteController(EstudanteRepository estudanteRepository, EstudanteService estudanteService, ImagemService imagemService) {
        this.estudanteRepository = estudanteRepository;
        this.estudanteService = estudanteService;
        this.imagemService = imagemService;
    }

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

    @PostMapping("/login")
    public ResponseEntity<EstudanteTokenDto> login(@RequestBody EstudanteLoginDto estudanteLoginDto) {
        EstudanteTokenDto estudanteTokenDto = this.estudanteService.autenticar(estudanteLoginDto);

        return ResponseEntity.status(200).body(estudanteTokenDto);
    }

    @DeleteMapping()
    public ResponseEntity<Void> deletar(@RequestParam Integer id) {

       if(this.estudanteService.deletar(id)){
           return ResponseEntity.status(404).build();
       }

        return ResponseEntity.status(400).build();
    }

    @PutMapping()
    public ResponseEntity<Estudante> atualizar(@RequestParam Integer id ,@RequestBody EstudanteDTO estudanteDTO) {

        if(this.estudanteService.atualizar(id, estudanteDTO) == null){
            return ResponseEntity.status(400).build();
        }

        return ResponseEntity.status(200).body(this.estudanteService.atualizar(id, estudanteDTO));
    }


    @GetMapping("/estudante")
    public ResponseEntity<Estudante> buscar(@RequestParam String emai, @RequestParam String nome){

        Estudante estudante = this.estudanteService.buscar(emai, nome);


        if(estudante == null){
            return  ResponseEntity.status(400).build();
        }

        return ResponseEntity.ok(estudante);
    }

    @GetMapping("/id")
    public ResponseEntity<Integer> buscarId(@RequestParam String emai, @RequestParam String nome){

        Estudante estudante = this.estudanteService.buscar(emai, nome);


        if(estudante == null){
            return  ResponseEntity.status(400).build();
        }

        return ResponseEntity.ok(estudante.getIdEstudante());
    }

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Upload concluido."),
            @ApiResponse(responseCode = "400", description = "Houve um problema na requisição."),
            @ApiResponse(responseCode = "401", description = "Não autorizado"),
    })


    @PostMapping("/upload-documento")
    public ResponseEntity<Void> uploadDocumento(@RequestParam MultipartFile image) throws IOException {
        this.imagemService.criarDocumento(image, null, null);


        return ResponseEntity.ok().build();
    }


    @PostMapping(value = "/upload-foto/{id}",consumes = "multipart/form-data")
    public ResponseEntity<ImagemDTO> uploadFoto(@RequestParam("arquivo")MultipartFile file, @PathVariable int id){
        if (file.isEmpty()) {
            return ResponseEntity.status(400).build();
        }
        if (!this.diretorioBase.toFile().exists()) {
            this.diretorioBase.toFile().mkdir();
        }
        if(!this.estudanteRepository.existsById(id)){
            return ResponseEntity.status(404).build();
        }
        file.getOriginalFilename();
       // formatarNomeArquivo();

        return ResponseEntity.ok().build();
    }

}
