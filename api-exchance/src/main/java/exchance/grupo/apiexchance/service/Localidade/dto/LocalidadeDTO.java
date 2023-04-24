package exchance.grupo.apiexchance.service.Localidade.dto;

import exchance.grupo.apiexchance.entidade.Localidade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LocalidadeDTO {

    private Integer idLocalidade;



    @Size(min = 3)
    private String pais;


    @Size(min = 3)
    private String cidade;


    @Size(min = 10)
    private String endereco;


    @Size(min = 3)
    private String cep;

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

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
