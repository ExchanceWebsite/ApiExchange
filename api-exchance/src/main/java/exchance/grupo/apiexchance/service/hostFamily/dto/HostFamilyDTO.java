package exchance.grupo.apiexchance.service.hostFamily.dto;

import exchance.grupo.apiexchance.entidade.HostFamily;
import exchance.grupo.apiexchance.entidade.Localidade;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class HostFamilyDTO {


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
    private Localidade localidade;


    public String getNome() {
        return nome;
    }

    public String getVerificado() {
        return verificado;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getEmail() {
        return email;
    }

    public Localidade getLocalidade() {
        return localidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setVerificado(String verificado) {
        this.verificado = verificado;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setLocalidade(Localidade localidade) {
        this.localidade = localidade;
    }
}
