package exchance.grupo.apiexchance.service.Mensagem.dto;

import exchance.grupo.apiexchance.entidade.Estudante;
import exchance.grupo.apiexchance.entidade.HostFamily;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MensagemDTO {
    private Integer idMensagem;


    private Estudante proprietario;


    private HostFamily destinatario;

    @Size(min = 10)
    private String texto;

    @PastOrPresent
    private LocalDateTime dataMensagem;

    public Integer getIdMensagem() {
        return idMensagem;
    }

    public void setIdMensagem(Integer idMensagem) {
        this.idMensagem = idMensagem;
    }

    public Estudante getProprietario() {
        return proprietario;
    }

    public void setProprietario(Estudante proprietario) {
        this.proprietario = proprietario;
    }

    public HostFamily getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(HostFamily destinatario) {
        this.destinatario = destinatario;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDateTime getDataMensagem() {
        return dataMensagem;
    }

    public void setDataMensagem(LocalDateTime dataMensagem) {
        LocalDateTime datahora = LocalDateTime.now();
        this.dataMensagem = datahora;
    }
}
