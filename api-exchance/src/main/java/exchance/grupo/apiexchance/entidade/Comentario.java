package exchance.grupo.apiexchance.entidade;


import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "Comentario")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idComentario")
    private Integer idComentario;

    @ManyToOne
    @JoinColumn(name = "fkProprietario")
    private Estudante proprietario;

    @ManyToOne
    @JoinColumn(name = "fkDestinatario")
    private HostFamily destinatario;

    @Column(name = "comentario")
    private String Comentario;

    @Column(name = "dataPostagem")
    private LocalDate dataPostagem;


    public Integer getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Integer idComentario) {
        this.idComentario = idComentario;
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
