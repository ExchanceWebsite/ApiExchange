package exchance.grupo.apiexchance.entidade;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "Mensagem")
public class Mensagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMensagem")
    private Integer idMensagem;

    @ManyToOne
    @JoinColumn(name = "fkProprietario")
    private Estudante proprietario;

    @ManyToOne
    @JoinColumn(name = "fkDestinatario")
    private HostFamily destinatario;

    @Column(name = "texto")
    private String texto;

    @Column(name = "dataMensagem")
    private LocalDate dataMensagem;

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

    public String getDataMensagem() {
        return dataMensagem.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    public void setDataMensagem(LocalDateTime dataMensagem) {
        this.dataMensagem = LocalDate.from(dataMensagem);
    }
}
