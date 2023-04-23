package exchance.grupo.apiexchance.service.Estudante.dto;

import exchance.grupo.apiexchance.entidade.Localidade;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

public class EstudanteDTO {


    @NotBlank
    @Size(min = 3)
    private String nome;

    @NotBlank
    @Min(13)
    @Positive
    private Integer idade;

    @NotBlank
    private String descricao;


    @NotBlank
    @Email
    private String email;


    @NotBlank
    @Size(min = 8)
    private String senha;

    @NotBlank
    @Size(max = 14)
    private String telefone;

    @NotBlank
    @CPF
    private String cpf;

    @NotBlank
    private Localidade localidade;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
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

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setLocalidade(Localidade localidade) {
        this.localidade = localidade;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public Localidade getLocalidade() {
        return localidade;
    }
}
