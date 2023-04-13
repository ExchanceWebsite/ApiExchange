package exchance.grupo.apiexchance.entidade;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReserva;


    @NotBlank
    private Integer fkEstudante;

    @NotBlank
    @FutureOrPresent
    private LocalDate entrada;

    @NotBlank
    @FutureOrPresent
    private LocalDate saida;

    private String formaPagamento;

    @NotBlank
    private Integer fkAcomodacao;

    @NotBlank
    private Integer fkAcomodacaoHost;

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Integer getFkEstudante() {
        return fkEstudante;
    }

    public void setFkEstudante(Integer fkEstudante) {
        this.fkEstudante = fkEstudante;
    }

    public LocalDate getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDate entrada) {
        this.entrada = entrada;
    }

    public LocalDate getSaida() {
        return saida;
    }

    public void setSaida(LocalDate saida) {
        this.saida = saida;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Integer getFkAcomodacao() {
        return fkAcomodacao;
    }

    public void setFkAcomodacao(Integer fkAcomodacao) {
        this.fkAcomodacao = fkAcomodacao;
    }

    public Integer getFkAcomodacaoHost() {
        return fkAcomodacaoHost;
    }

    public void setFkAcomodacaoHost(Integer fkAcomodacaoHost) {
        this.fkAcomodacaoHost = fkAcomodacaoHost;
    }
}
