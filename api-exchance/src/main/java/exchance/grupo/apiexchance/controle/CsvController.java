
package exchance.grupo.apiexchance.controle;

import exchance.grupo.apiexchance.entidade.Estudante;
import exchance.grupo.apiexchance.lista.ListaObj;
import exchance.grupo.apiexchance.service.Estudante.dto.EstudanteDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

@Controller
@RequestMapping("/api/csv")
public class CsvController {

    public static byte[] gravaArquivoCsv(ListaObj<Estudante> lista, String nomeArq){
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
                Estudante estudantes = lista.getElemento(i);
                saida.format("%d;%s;%d;%s;%s;%s;%s;%s\n",
                        estudantes.getIdEstudante(),
                        estudantes.getNome(),
                        estudantes.getIdade(),
                        estudantes.getDescricao(),
                        estudantes.getEmail(),
                        estudantes.getSenha(),
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

//    public static byte[] leArquivoCsv(String nomeArq){
//        FileReader arq = null;
//        Scanner entrada = null;
//        Boolean deuRuim = false;
//
//        nomeArq += ".csv";
//
//        try{
//            arq = new FileReader(nomeArq);
//            System.out.println(arq);
//            entrada = new Scanner(arq).useDelimiter(";|\\n");
//        }
//        catch (FileNotFoundException erro){
//            System.out.println("Arquivo não encontrado");
//            System.exit(1);
//        }
//
//        try{
//            System.out.printf("%-10S %4S %13S %15S %15S %15S %12S\n", "nome",
//                    "idade","descricao","email",
//                    "telefone","cpf");
//            while (entrada.hasNext()){
//                String nome = entrada.next();
//                int idade = entrada.nextInt();
//                String descricao = entrada.next();
//                String email = entrada.next();
//                String telefone = entrada.next();
//                String cpf = entrada.next();
//                System.out.printf("%-10s %4d %13d %15s %-15s %15s %12s\n",
//                        nome,idade,descricao,email,telefone,cpf);
//            }
//        }
//        catch (NoSuchElementException erro){
//            System.out.println("Arquivo com problemas");
//            deuRuim=true;
//        }
//        catch (IllegalStateException erro){
//            System.out.println("Erro na leitura do arquivo");
//            deuRuim=true;
//        }
//        finally {
//            entrada.close();
//            try{
//                arq.close();
//            }
//            catch (IOException erro){
//                System.out.println("Erro ao fechar o arquivo");
//                deuRuim=true;
//            }
//            if (deuRuim){
//                System.exit(1);
//            }
//
//        }
//        return nomeArq.getBytes();
//    }

    ListaObj<Estudante> arquivoEstudantes = new ListaObj<>(5);


    @GetMapping("/download")
    public ResponseEntity<byte[]> getFile() {
     byte[] arquivoCsv = gravaArquivoCsv(arquivoEstudantes, "arquivo");
    // byte[] leArquivo = leArquivoCsv(estudantes.toString());

        return ResponseEntity.status(200).body(arquivoCsv);
    }
}

