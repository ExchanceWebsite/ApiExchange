package exchance.grupo.apiexchance.dto;

import exchance.grupo.apiexchance.entidade.Acomodacao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class AcomodacaoDTO {

    private Integer idAcomodacao;


    @NotBlank
    private Integer fkHost;

    @NotBlank
    private String descricao;

    @NotBlank
    @PastOrPresent
    private LocalDate inicioDisponibilidade;

    @NotBlank
    @PastOrPresent
    private LocalDate fimDisponibilidade;

    @NotBlank
    private Double valorDiaria;

    @NotBlank
    private String regras;

    public AcomodacaoDTO(Acomodacao acomodacaoEntidade) {
        this.idAcomodacao = acomodacaoEntidade.getIdAcomodacao();
        this.fkHost = acomodacaoEntidade.getFkHost();
        this.descricao = acomodacaoEntidade.getDescricao();
        this.inicioDisponibilidade = acomodacaoEntidade.getInicioDisponibilidade();
        this.fimDisponibilidade = acomodacaoEntidade.getFimDisponibilidade();
        this.valorDiaria = acomodacaoEntidade.getValorDiaria();
        this.regras = acomodacaoEntidade.getRegras();
    }

    public Integer getIdAcomodacao() {
        return idAcomodacao;
    }

    public Integer getFkHost() {
        return fkHost;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getInicioDisponibilidade() {
        return inicioDisponibilidade;
    }

    public LocalDate getFimDisponibilidade() {
        return fimDisponibilidade;
    }

    public Double getValorDiaria() {
        return valorDiaria;
    }

    public String getRegras() {
        return regras;
    }
}
