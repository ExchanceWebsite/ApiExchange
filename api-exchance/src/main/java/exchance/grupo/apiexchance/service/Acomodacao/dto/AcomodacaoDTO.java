package exchance.grupo.apiexchance.service.Acomodacao.dto;

import exchance.grupo.apiexchance.entidade.Acomodacao;
import exchance.grupo.apiexchance.entidade.HostFamily;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class AcomodacaoDTO {

    @NotBlank
    private HostFamily host;

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


    public HostFamily getHost() {
        return host;
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

    public void setHost(HostFamily host) {
        this.host = host;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setInicioDisponibilidade(LocalDate inicioDisponibilidade) {
        this.inicioDisponibilidade = inicioDisponibilidade;
    }

    public void setFimDisponibilidade(LocalDate fimDisponibilidade) {
        this.fimDisponibilidade = fimDisponibilidade;
    }

    public void setValorDiaria(Double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public void setRegras(String regras) {
        this.regras = regras;
    }
}
