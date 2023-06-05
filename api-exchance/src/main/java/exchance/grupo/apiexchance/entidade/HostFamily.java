package exchance.grupo.apiexchance.entidade;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "HostFamily")
public class HostFamily {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHostFamily")
    private Integer idHostFamily;

    @Column(name = "nome")
    private String nome;

    @Column(name = "verificado")
    private String verificado;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @ManyToOne
    @JoinColumn(name = "fkLocalidade")
    private Localidade localidade;

    @OneToMany(mappedBy = "host")
    private List<Acomodacao> acomodacoes;

    @OneToMany(mappedBy = "host")
    private List<Integrante> integrantes;

    @OneToMany(mappedBy = "destinatario")
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "hostFamily")
    private List<Imagem> imagens;

    @OneToMany(mappedBy = "destinatario")
    private List<Mensagem> mensagens;

    public List<Integrante> pegarIntegrantes() {
        return this.integrantes;
    }


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
