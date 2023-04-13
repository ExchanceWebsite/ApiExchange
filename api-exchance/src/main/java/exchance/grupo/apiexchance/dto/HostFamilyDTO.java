package exchance.grupo.apiexchance.dto;

import exchance.grupo.apiexchance.entidade.HostFamily;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class HostFamilyDTO {

    private Integer idHostFamily;


    private String nome;


    private String verificado;


    private String descricao;


    private String email;


    private Integer fkLocalidade;

    public HostFamilyDTO(HostFamily hostFamilyEntidade) {
        this.idHostFamily = hostFamilyEntidade.getIdHostFamily();
        this.nome = hostFamilyEntidade.getNome();
        this.verificado = hostFamilyEntidade.getVerificado();
        this.descricao = hostFamilyEntidade.getDescricao();
        this.email = hostFamilyEntidade.getEmail();
        this.fkLocalidade = hostFamilyEntidade.getFkLocalidade();
    }

    public Integer getIdHostFamily() {
        return idHostFamily;
    }

    public String getNome() {
        return nome;
    }

    public String getVerificado() {
        return verificado;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getEmail() {
        return email;
    }

    public Integer getFkLocalidade() {
        return fkLocalidade;
    }
}
