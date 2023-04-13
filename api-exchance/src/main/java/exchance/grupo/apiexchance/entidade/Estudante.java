package exchance.grupo.apiexchance.entidade;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Estudante {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstudante;

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
    private Integer fkLocalidade;

    public Integer getIdEstudante() {
        return idEstudante;
    }

    public void setIdEstudante(Integer idEstudante) {
        this.idEstudante = idEstudante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getFkLocalidade() {
        return fkLocalidade;
    }

    public void setFkLocalidade(Integer fkLocalidade) {
        this.fkLocalidade = fkLocalidade;
    }
}
