
package exchance.grupo.apiexchance.controle;

import exchance.grupo.apiexchance.lista.ListaObj;
import exchance.grupo.apiexchance.service.Estudante.dto.EstudanteDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;

@Controller
@RequestMapping("/api/csv")
public class CsvController {

    public static byte[] gravaArquivoCsv(ListaObj< EstudanteDTO > lista, String nomeArq){
        FileWriter arq = null;
        Formatter saida = null;
        Boolean deuRuim = false;

        nomeArq += ".csv";

        try{
            arq = new FileWriter(nomeArq,false);
            saida = new Formatter(arq);
        }
        catch (IOException erro){
            System.out.println("Erro ao abrir o arquivo");
            System.exit(1);
        }
        try {
            for (int i=0; i < lista.getTamanho(); i++){
                EstudanteDTO estudantes = lista.getElemento(i);
                saida.format("%s;%d;%s;%s;%s;%s\n",
                        estudantes.getNome(),
                        estudantes.getIdade(),
                        estudantes.getDescricao(),
                        estudantes.getEmail(),
                        estudantes.getTelefone(),
                        estudantes.getCpf());
            }
        }
        catch (FormatterClosedException erro){
            System.out.println("Erro ao gravar o arquivo");
            deuRuim = true;
        }
        finally {
            saida.close();
            try {
                arq.close();
            }
            catch (IOException erro){
                System.out.println("Erro ao fechar o arquivo");
                deuRuim=true;
            }
            if (deuRuim){
                System.exit(1);
            }
        }
        return nomeArq.getBytes();
    }

    ListaObj<EstudanteDTO> estudantes = new ListaObj<>(5);

    EstudanteDTO estudante1 = new EstudanteDTO("Ana", 25,"Estudiosa e inteligente","ana@gmail.com","12345",
            "011954337632","46949092822");

    @GetMapping("/download")
    public ResponseEntity<byte[]> getFile() {
     byte[] arquivoCsv = gravaArquivoCsv(estudantes, "arquivo");

        return ResponseEntity.status(200).body(arquivoCsv);
    }



}

