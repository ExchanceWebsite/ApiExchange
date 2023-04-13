package exchance.grupo.apiexchance.dto;

import exchance.grupo.apiexchance.entidade.Estudante;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

public class EstudanteDTO {

    private Integer idEstudante;


    private String nome;


    private Integer idade;


    private String descricao;


    private String email;


    private String telefone;


    private String cpf;


    private Integer fkLocalidade;

    public EstudanteDTO(Estudante estudanteEntidade) {
        this.idEstudante = estudanteEntidade.getIdEstudante();
        this.nome = estudanteEntidade.getNome();
        this.idade = estudanteEntidade.getIdade();
        this.descricao = estudanteEntidade.getDescricao();
        this.email = estudanteEntidade.getEmail();
        this.telefone = estudanteEntidade.getTelefone();
        this.cpf = estudanteEntidade.getCpf();
        this.fkLocalidade = estudanteEntidade.getFkLocalidade();
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

    public Integer getFkLocalidade() {
        return fkLocalidade;
    }
}
