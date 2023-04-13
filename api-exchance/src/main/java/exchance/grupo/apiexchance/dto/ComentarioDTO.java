package exchance.grupo.apiexchance.dto;

import exchance.grupo.apiexchance.entidade.Comentario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class ComentarioDTO {

    private Integer idComentario;


    private Integer fkProprietario;


    private Integer fkDestinatario;


    private String Comentario;


    private LocalDate dataPostagem;

    public ComentarioDTO(Comentario comentarioEntidade) {
        this.idComentario = comentarioEntidade.getIdComentario();
        this.fkProprietario = comentarioEntidade.getFkProprietario();
        this.fkDestinatario = comentarioEntidade.getFkDestinatario();
        this.Comentario = comentarioEntidade.getComentario();
        this.dataPostagem = comentarioEntidade.getDataPostagem();
    }

    public Integer getIdComentario() {
        return idComentario;
    }

    public Integer getFkProprietario() {
        return fkProprietario;
    }

    public Integer getFkDestinatario() {
        return fkDestinatario;
    }

    public String getComentario() {
        return Comentario;
    }

    public LocalDate getDataPostagem() {
        return dataPostagem;
    }
}
