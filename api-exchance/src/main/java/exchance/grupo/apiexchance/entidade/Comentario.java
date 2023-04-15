package exchance.grupo.apiexchance.entidade;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idComentario;


    private Integer fkProprietario;


    private Integer fkDestinatario;



    private String Comentario;


    private LocalDate dataPostagem;

    public Integer getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public Integer getFkProprietario() {
        return fkProprietario;
    }

    public void setFkProprietario(Integer fkProprietario) {
        this.fkProprietario = fkProprietario;
    }

    public Integer getFkDestinatario() {
        return fkDestinatario;
    }

    public void setFkDestinatario(Integer fkDestinatario) {
        this.fkDestinatario = fkDestinatario;
    }

    public String getComentario() {
        return Comentario;
    }

    public void setComentario(String comentario) {
        Comentario = comentario;
    }

    public LocalDate getDataPostagem() {
        return dataPostagem;
    }

    public void setDataPostagem(LocalDate dataPostagem) {
        this.dataPostagem = dataPostagem;
    }
}
