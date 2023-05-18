package exchance.grupo.apiexchance.entidade;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Mensagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMensagem;


    @ManyToOne
    private Estudante proprietario;

    @ManyToOne
    private HostFamily destinatario;


    private String texto;


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
        this.dataMensagem = dataMensagem;
    }
}
