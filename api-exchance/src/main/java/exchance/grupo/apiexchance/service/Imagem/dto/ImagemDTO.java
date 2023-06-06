package exchance.grupo.apiexchance.service.Imagem.dto;

import exchance.grupo.apiexchance.entidade.Estudante;
import exchance.grupo.apiexchance.entidade.HostFamily;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ImagemDTO {

    private Integer idImagem;

    private String nome;

    @NotBlank
    private String caminho;

    @NotNull
    private boolean isDocumento;

    @NotNull
    private boolean isFoto;


    private Estudante estudante;


    private HostFamily hostFamily;

    public Integer getIdImagem() {
        return idImagem;
    }

    public void setIdImagem(Integer idImagem) {
        this.idImagem = idImagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public boolean isDocumento() {
        return isDocumento;
    }

    public void setDocumento(boolean documento) {
        isDocumento = documento;
    }

    public boolean isFoto() {
        return isFoto;
    }

    public void setFoto(boolean foto) {
        isFoto = foto;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public HostFamily getHostFamily() {
        return hostFamily;
    }

    public void setHostFamily(HostFamily hostFamily) {
        this.hostFamily = hostFamily;
    }
}
