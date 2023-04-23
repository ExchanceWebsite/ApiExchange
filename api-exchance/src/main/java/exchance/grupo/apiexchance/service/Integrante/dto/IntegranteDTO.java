package exchance.grupo.apiexchance.service.Integrante.dto;

import exchance.grupo.apiexchance.entidade.HostFamily;
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
    private HostFamily host;


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

    public HostFamily getHost() {
        return host;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public void setHost(HostFamily host) {
        this.host = host;
    }
}
