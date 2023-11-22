package exchance.grupo.apiexchance.controle;



import exchance.grupo.apiexchance.entidade.Estudante;

import exchance.grupo.apiexchance.entidade.Imagem;
import exchance.grupo.apiexchance.repositorio.EstudanteRepository;
import exchance.grupo.apiexchance.repositorio.ImagemRepository;
import exchance.grupo.apiexchance.service.Estudante.EstudanteService;
import exchance.grupo.apiexchance.service.Estudante.autenticacao.dto.EstudanteLoginDto;
import exchance.grupo.apiexchance.service.Estudante.autenticacao.dto.EstudanteTokenDto;
import exchance.grupo.apiexchance.service.Estudante.dto.EstudanteDTO;
import exchance.grupo.apiexchance.service.Imagem.ImagemService;

import exchance.grupo.apiexchance.service.Imagem.dto.ImagemDTO;
import exchance.grupo.apiexchance.service.Imagem.dto.ImagemMapper;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/estudantes")
public class EstudanteController {

    @Autowired
    private EstudanteRepository estudanteRepository;

    @Autowired
    private EstudanteService estudanteService;

    @Autowired
    private ImagemService imagemService;
    @Autowired
    private ImagemRepository imagemRepository;

    private Path diretorioBase = Path.of(System.getProperty("user.dir") + "/Downloads");


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
        //comparação do estudante

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
    public ResponseEntity<ImagemDTO> uploadFoto(@RequestParam("imagem")MultipartFile file, @PathVariable int id){
        if (file.isEmpty()) {
           return ResponseEntity.status(400).build();
        }
        if (!this.diretorioBase.toFile().exists()) {
            this.diretorioBase.toFile().mkdir();
        }
        if(!this.estudanteRepository.existsById(id)){
            return ResponseEntity.status(404).build();
        }
        String nome = formatarNomeArquivo(file.getOriginalFilename());

        String filePath = this.diretorioBase + "/" + nome;

        File dest = new File(filePath);
        try{
            file.transferTo(dest);
        }catch (IOException erro){
            erro.printStackTrace();
            throw new ResponseStatusException(422, "Não foi possivel salvar o arquivo", null);

        }

        Imagem imagem = new Imagem();
        imagem.setNome(String.valueOf(this.estudanteRepository.findById(id).get()));

        Imagem imagemBanco = imagemRepository.save(imagem);

        ImagemDTO imagemDTO = ImagemMapper.of(imagemBanco);

        return ResponseEntity.status(200).body(imagemDTO);
    }

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Download concluido."),
            @ApiResponse(responseCode = "400", description = "Houve um problema na requisição."),
            @ApiResponse(responseCode = "401", description = "Não autorizado"),
    })

    @GetMapping(value = "/download/{idImagem}")
    public ResponseEntity<byte[]> download(@PathVariable("idImagem") Integer idImagem) throws IOException {
        Optional<Imagem> imagemOptional = imagemRepository.findById(idImagem);
        if (imagemOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Imagem imagemBanco = imagemOptional.get();
        File file = this.diretorioBase.resolve(imagemBanco.getCaminho()).toFile();

        if (!file.exists()) {
            return ResponseEntity.notFound().build();
        }

        byte[] fileContent = Files.readAllBytes(file.toPath());

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + imagemBanco.getCaminho());

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(fileContent);
    }


    private String formatarNomeArquivo(String nomeOriginal){
        return String.format("%s_%s", UUID.randomUUID(),nomeOriginal);
    }

    @GetMapping("/lista/imagens")
    public ResponseEntity<List<ImagemDTO>> listarImagens(){
        List<Imagem> imagens = imagemRepository.findAll();
        if (imagens.isEmpty()){
            return ResponseEntity.status(204).build();
       }
      List<ImagemDTO> imagemDTOS = new ArrayList<>();
      for (Imagem imagem : imagens){
           imagemDTOS.add(ImagemMapper.of(imagem));
        }
       return ResponseEntity.status(200).body(imagemDTOS);
   }

}
