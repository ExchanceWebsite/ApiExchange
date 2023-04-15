package exchance.grupo.apiexchance.dto;

import exchance.grupo.apiexchance.entidade.Estudante;
import exchance.grupo.apiexchance.entidade.Localidade;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

public class EstudanteDTO {

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
    private Localidade localidade;

    public EstudanteDTO(Estudante estudanteEntidade) {
        this.idEstudante = estudanteEntidade.getIdEstudante();
        this.nome = estudanteEntidade.getNome();
        this.idade = estudanteEntidade.getIdade();
        this.descricao = estudanteEntidade.getDescricao();
        this.email = estudanteEntidade.getEmail();
        this.telefone = estudanteEntidade.getTelefone();
        this.cpf = estudanteEntidade.getCpf();
        this.localidade = estudanteEntidade.getLocalidade();
    }

    public Integer getIdEstudante() {
        return idEstudante;
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

    public Localidade getFkLocalidade() {
        return localidade;
    }
}
