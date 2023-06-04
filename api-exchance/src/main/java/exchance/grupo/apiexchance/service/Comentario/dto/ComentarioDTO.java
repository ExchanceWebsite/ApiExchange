package exchance.grupo.apiexchance.service.Comentario.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import exchance.grupo.apiexchance.entidade.Comentario;
import exchance.grupo.apiexchance.entidade.Estudante;
import exchance.grupo.apiexchance.entidade.HostFamily;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ComentarioDTO {

    private Integer idComentario;

    private Estudante proprietario;


    private HostFamily destinatario;


    @Size(min = 10)
    private String Comentario;


    @PastOrPresent
    private LocalDate dataPostagem;


    public Estudante getProprietario() {
        return proprietario;
    }

    public HostFamily getDestinatario() {
        return destinatario;
    }

    public String getComentario() {
        return Comentario;
    }

    public LocalDate getDataPostagem() {
        return dataPostagem;
    }


    public void setProprietario(Estudante proprietario) {
        this.proprietario = proprietario;
    }

    public void setDestinatario(HostFamily destinatario) {
        this.destinatario = destinatario;
    }

    public void setComentario(String comentario) {
        Comentario = comentario;
    }

    public void setDataPostagem(LocalDate dataPostagem) {

        this.dataPostagem = dataPostagem;
    }
}
