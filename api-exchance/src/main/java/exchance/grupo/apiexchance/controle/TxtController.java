package exchance.grupo.apiexchance.controle;

import exchance.grupo.apiexchance.entidade.Acomodacao;
import exchance.grupo.apiexchance.entidade.Reserva;
import exchance.grupo.apiexchance.lista.ListaObj;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/txt")
public class TxtController {

    public static void gravaRegistro(String registro, String nomeArq) {
        BufferedWriter saida = null;

        try {
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        }
        catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo");
            System.exit(1);
        }

        try {
            saida.append(registro + "\n");
            saida.close();
        }
        catch (IOException erro) {
            System.out.println("Erro ao gravar no arquivo");
        }
    }

    public static void gravaArquivoTxt(ListaObj<Reserva> listaReserva,
                                       ListaObj<Acomodacao> listaAcomodacao, String nomeArq) {
        int contaRegDadosGravados = 0;

        String header = "00RESERVA/ACOMODACAO";
        header += LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        header += "01";

        gravaRegistro(header, nomeArq);

        String corpo;
        for (int i = 0; i < listaReserva.getTamanho(); i++) {
            Reserva reservas = listaReserva.getElemento(i);
            corpo = "02";
            corpo += String.format("%-10.10s", reservas.getEntrada().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            corpo += String.format("%-10.10s", reservas.getSaida());
            corpo += String.format("%-10.10s", reservas.getFormaPagamento());
            gravaRegistro(corpo, nomeArq);
            contaRegDadosGravados++;
        }
        String dados;
        for (int i = 0; i < listaAcomodacao.getTamanho(); i++) {
            Acomodacao acomodacoes = listaAcomodacao.getElemento(i);
            dados = "03";
            dados += String.format("%-300.300s", acomodacoes.getDescricao() );
            dados += String.format("%-10.10s", acomodacoes.getInicioDisponibilidade().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            dados += String.format("%-10.10s", acomodacoes.getFimDisponibilidade().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            dados += String.format("%8.8s", acomodacoes.getValorDiaria());
            dados += String.format("%-150.150s", acomodacoes.getRegras());
            gravaRegistro(dados, nomeArq);
            contaRegDadosGravados++;
        }
        String trailer = "01";
        trailer += String.format("%05d", contaRegDadosGravados);
        gravaRegistro(trailer, nomeArq);
    }

    ListaObj<Reserva> arquivoReservas = new ListaObj<>(2);
    ListaObj<Acomodacao> arquivoAcomodacoes = new ListaObj<>(2);
    @GetMapping("/download/txt")
    public ResponseEntity<Void> getFileTxt(){

        Reserva reserva1 = new Reserva();

        reserva1.setEntrada(LocalDate.ofEpochDay(2022-04-10));
        reserva1.setSaida(LocalDate.ofEpochDay(2022-06-30));
        reserva1.setFormaPagamento("Boleto");

        Acomodacao acomodacao1 = new Acomodacao();

        acomodacao1.setDescricao("Somos uma familia bem tranquila, e gostamos muito de sair" +
                ",temos filhos que já não moram mais conosco, e sentimos a casa muito vazia, seria uma honra recebe-los" +
                "em nossa casa.");
        acomodacao1.setInicioDisponibilidade(LocalDate.ofEpochDay(2022-03-10));
        acomodacao1.setFimDisponibilidade(LocalDate.ofEpochDay(2022-06-30));
        acomodacao1.setValorDiaria(312.00);
        acomodacao1.setRegras("Temos uma casa grande então gostamos de mante-la sempre limpa," +
                "é importante sempre ajudar na cozinha, e não lavamos suas roupas, isso ficara em sua" +
                "resposabilidade.");

        arquivoReservas.adiciona(reserva1);
        arquivoAcomodacoes.adiciona(acomodacao1);

        gravaArquivoTxt(arquivoReservas,arquivoAcomodacoes, "arquivos.txt");

        return ResponseEntity.status(200).build();
    }

}