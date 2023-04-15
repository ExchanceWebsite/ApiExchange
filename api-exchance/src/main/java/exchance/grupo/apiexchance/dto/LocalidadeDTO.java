package exchance.grupo.apiexchance.dto;

import exchance.grupo.apiexchance.entidade.Localidade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class LocalidadeDTO {

    private Integer idLocalidade;


    @NotBlank
    @Size(min = 3)
    private String pais;

    @NotBlank
    @Size(min = 3)
    private String cidade;

    @NotBlank
    @Size(min = 10)
    private String endereco;

    @NotBlank
    @Size(min = 3)
    private String cep;

    public LocalidadeDTO(Localidade localidadeEntidade) {
        this.idLocalidade = localidadeEntidade.getIdLocalidade();
        this.pais = localidadeEntidade.getPais();
        this.cidade = localidadeEntidade.getCidade();
        this.endereco = localidadeEntidade.getEndereco();
        this.cep = localidadeEntidade.getCep();
    }

    public Integer getIdLocalidade() {
        return idLocalidade;
    }

    public String getPais() {
        return pais;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCep() {
        return cep;
    }
}
