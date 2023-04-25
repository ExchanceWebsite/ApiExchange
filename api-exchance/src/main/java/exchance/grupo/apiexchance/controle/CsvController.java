
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

    public static void gravarCSV (ListaObj<Estudante> estudantes, String nomeArquivo) {

        FileWriter arq = null;
        Formatter saida = null;
        nomeArquivo += ".csv";

        // Bloco try-catch para abrir o arquivo
        try {
            arq = new FileWriter(nomeArquivo);
            saida = new Formatter(arq);
        }
        catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo");
        }

        // Bloco try-catch para gravar o arquivo
        try {
            for (int i = 0; i < estudantes.getTamanho(); i++) {
                saida.format("%s;%d;%s;%s;%s;%s;%s;\n",
                        estudantes.getElemento(i).getNome(),
                        estudantes.getElemento(i).getIdade(),
                        estudantes.getElemento(i).getDescricao(),
                        estudantes.getElemento(i).getEmail(),
                        estudantes.getElemento(i).getSenha(),
                        estudantes.getElemento(i).getTelefone(),
                        estudantes.getElemento(i).getCpf()
                );
            }
        }
        catch (FormatterClosedException erro) {
            System.out.println("Erro ao gravar o arquivo");
            erro.printStackTrace();
        }
        finally {
            saida.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
            }
        }
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

    ListaObj<Estudante> arquivoEstudantes = new ListaObj<>(2);





    @GetMapping("/download")
    public ResponseEntity<Void> getFile() {

        Estudante estudante1 = new Estudante();

        estudante1.setNome("Felipe");
        estudante1.setTelefone("11980928183");
        estudante1.setIdade(15);
        estudante1.setSenha("123456789");
        estudante1.setDescricao("Estudioso e curioso");
        estudante1.setCpf("47885458881");
        estudante1.setEmail("felipe@gmail.com");

        Estudante estudante2 = new Estudante();

        estudante2.setCpf("14346887778");
        estudante2.setNome("Marcio");
        estudante2.setTelefone("11930495969");
        estudante2.setIdade(22);
        estudante2.setSenha("123456789");
        estudante2.setDescricao("Estudioso e valente");
        estudante2.setEmail("marcio@gmail.com");

        gravarCSV(arquivoEstudantes, "arquivo");
    // byte[] leArquivo = leArquivoCsv(estudantes.toString());

        return ResponseEntity.status(200).build();
    }
}

