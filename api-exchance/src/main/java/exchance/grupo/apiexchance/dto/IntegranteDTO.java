package exchance.grupo.apiexchance.dto;

import exchance.grupo.apiexchance.entidade.Integrante;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class IntegranteDTO {

    private Integer idIntegrante;


    @NotBlank
    @Size(min = 3)
    private String nome;

    @NotBlank
    private String parentesco;

    @NotBlank
    @Positive
    private Integer idade;

    @NotBlank
    private Integer fkHost;

    public IntegranteDTO(Integrante integranteEntidade) {
        this.idIntegrante = integranteEntidade.getIdIntegrante();
        this.nome = integranteEntidade.getNome();
        this.parentesco = integranteEntidade.getParentesco();
        this.idade = integranteEntidade.getIdade();
        this.fkHost = integranteEntidade.getFkHost();
    }

    public Integer getIdIntegrante() {
        return idIntegrante;
    }

    public String getNome() {
        return nome;
    }

    public String getParentesco() {
        return parentesco;
    }

    public Integer getIdade() {
        return idade;
    }

    public Integer getFkHost() {
        return fkHost;
    }
}
