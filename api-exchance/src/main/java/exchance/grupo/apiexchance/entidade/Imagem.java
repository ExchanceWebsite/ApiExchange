package exchance.grupo.apiexchance.entidade;


import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.NotBlank;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.sql.Blob;
import java.util.Scanner;


@Entity
public class Imagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idImagem;


    private String nome;


    private String caminho;


    private boolean isDocumento;


    private boolean isFoto;

    @ManyToOne
    private Estudante estudante;

    @ManyToOne
    private HostFamily hostFamily;

    // getters e setters

    // outros métodos, se necessário


    public Integer getIdImagem() {
        return idImagem;
    }

    public void setIdImagem(Integer idImagem) {
        this.idImagem = idImagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public boolean isDocumento() {
        return isDocumento;
    }

    public void setDocumento(boolean documento) {
        isDocumento = documento;
    }

    public boolean isFoto() {
        return isFoto;
    }

    public void setFoto(boolean foto) {
        isFoto = foto;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public HostFamily getHostFamily() {
        return hostFamily;
    }

    public void setHostFamily(HostFamily hostFamily) {
        this.hostFamily = hostFamily;
    }
}