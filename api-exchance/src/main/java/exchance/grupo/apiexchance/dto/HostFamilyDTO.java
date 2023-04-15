package exchance.grupo.apiexchance.dto;

import exchance.grupo.apiexchance.entidade.HostFamily;
import exchance.grupo.apiexchance.entidade.Localidade;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class HostFamilyDTO {

    private Integer idHostFamily;


    @NotBlank
    @Size(min = 3)
    private String nome;

    @NotBlank
    @Size(max = 25)
    private String verificado;

    @NotBlank
    private String descricao;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 8)
    private String senha;

    @NotBlank
    private Localidade localidade;

    public HostFamilyDTO(HostFamily hostFamilyEntidade) {
        this.idHostFamily = hostFamilyEntidade.getIdHostFamily();
        this.nome = hostFamilyEntidade.getNome();
        this.verificado = hostFamilyEntidade.getVerificado();
        this.descricao = hostFamilyEntidade.getDescricao();
        this.email = hostFamilyEntidade.getEmail();
        this.localidade = hostFamilyEntidade.getLocalidade();
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

    public Localidade getFkLocalidade() {
        return localidade;
    }
}
