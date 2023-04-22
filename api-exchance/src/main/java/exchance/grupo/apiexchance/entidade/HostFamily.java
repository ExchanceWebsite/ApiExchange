package exchance.grupo.apiexchance.entidade;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class HostFamily {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHostFamily;


    private String nome;


    private String verificado;


    private String descricao;


    private String email;


    private String senha;

    @ManyToOne
    private Localidade localidade;

    @OneToMany(mappedBy = "host")
    private List<Acomodacao> acomodacoes;

    @OneToMany(mappedBy = "host")
    private List<Integrante> integrantes;

    @OneToMany(mappedBy = "destinatario")
    private List<Comentario> comentarios;

    public Integer getIdHostFamily() {
        return idHostFamily;
    }

    public void setIdHostFamily(Integer idHostFamily) {
        this.idHostFamily = idHostFamily;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getVerificado() {
        return verificado;
    }

    public void setVerificado(String verificado) {
        this.verificado = verificado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Localidade getLocalidade() {
        return localidade;
    }

    public void setLocalidade(Localidade localidade) {
        this.localidade = localidade;
    }
}
