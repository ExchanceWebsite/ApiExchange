package exchance.grupo.apiexchance.service.Estudante.dto;

import exchance.grupo.apiexchance.entidade.Localidade;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

public class EstudanteDTO {



    @Size(min = 3)
    private String nome;

    @Min(13)
    @Positive
    private Integer idade;


    private String descricao;



    @Email
    private String email;



    @Size(min = 8)
    private String senha;


    @Size(max = 14)
    private String telefone;


    @CPF
    private String cpf;


    private Localidade localidade;

    public EstudanteDTO(String nome, Integer idade, String descricao, String email, String senha, String telefone, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.descricao = descricao;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.cpf = cpf;
    }

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

    @Override
    public String toString() {
        return "EstudanteDTO{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", descricao='" + descricao + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cpf='" + cpf + '\'' +
                ", localidade=" + localidade +
                '}';
    }
}
