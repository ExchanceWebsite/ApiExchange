package exchance.grupo.apiexchance.entidade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class HostFamily {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHostFamily;

    @NotBlank
    @Size(min = 3)
    private String nome;

    @NotBlank
    @Size(max = 25)
    private String verificado;

    @NotBlank
    private String descricao;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 8)
    private String senha;

    @NotBlank
    private Integer fkLocalidade;


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

    public Integer getFkLocalidade() {
        return fkLocalidade;
    }

    public void setFkLocalidade(Integer fkLocalidade) {
        this.fkLocalidade = fkLocalidade;
    }
}
