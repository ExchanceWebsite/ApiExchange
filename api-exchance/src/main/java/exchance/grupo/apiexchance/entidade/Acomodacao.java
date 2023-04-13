package exchance.grupo.apiexchance.entidade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

@Entity
public class Acomodacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Integer getIdAcomodacao() {
        return idAcomodacao;
    }

    public void setIdAcomodacao(Integer idAcomodacao) {
        this.idAcomodacao = idAcomodacao;
    }

    public Integer getFkHost() {
        return fkHost;
    }

    public void setFkHost(Integer fkHost) {
        this.fkHost = fkHost;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getInicioDisponibilidade() {
        return inicioDisponibilidade;
    }

    public void setInicioDisponibilidade(LocalDate inicioDisponibilidade) {
        this.inicioDisponibilidade = inicioDisponibilidade;
    }

    public LocalDate getFimDisponibilidade() {
        return fimDisponibilidade;
    }

    public void setFimDisponibilidade(LocalDate fimDisponibilidade) {
        this.fimDisponibilidade = fimDisponibilidade;
    }

    public Double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(Double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public String getRegras() {
        return regras;
    }

    public void setRegras(String regras) {
        this.regras = regras;
    }
}
