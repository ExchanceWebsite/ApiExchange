package exchance.grupo.apiexchance.dto;

import exchance.grupo.apiexchance.entidade.Localidade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LocalidadeDTO {

    private Integer idLocalidade;


    private String pais;


    private String cidade;


    private String endereco;


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
