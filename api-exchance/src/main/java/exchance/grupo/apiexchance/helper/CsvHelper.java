package exchance.grupo.apiexchance.helper;

import exchance.grupo.apiexchance.lista.ListaObj;
import exchance.grupo.apiexchance.service.Estudante.dto.EstudanteDTO;
import exchance.grupo.apiexchance.service.Reserva.dto.ReservaDTO;

import java.io.ByteArrayInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;

public class CsvHelper {

    public static void gravaArquivoCsv(ListaObj<EstudanteDTO> lista, String nomeArq){
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
    }



}
