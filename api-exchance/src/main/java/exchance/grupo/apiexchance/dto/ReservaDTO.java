package exchance.grupo.apiexchance.dto;

import exchance.grupo.apiexchance.entidade.Reserva;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class ReservaDTO {

    private Integer idReserva;


    private Integer fkEstudante;


    private LocalDate entrada;


    private LocalDate saida;

    private String formaPagamento;


    private Integer fkAcomodacao;


    private Integer fkAcomodacaoHost;

    public ReservaDTO(Reserva reservaEntidade) {
        this.idReserva = reservaEntidade.getIdReserva();
        this.fkEstudante = reservaEntidade.getFkEstudante();
        this.entrada = reservaEntidade.getEntrada();
        this.saida = reservaEntidade.getSaida();
        this.formaPagamento = reservaEntidade.getFormaPagamento();
        this.fkAcomodacao = reservaEntidade.getFkAcomodacao();
        this.fkAcomodacaoHost = reservaEntidade.getFkAcomodacaoHost();
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public Integer getFkEstudante() {
        return fkEstudante;
    }

    public LocalDate getEntrada() {
        return entrada;
    }

    public LocalDate getSaida() {
        return saida;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public Integer getFkAcomodacao() {
        return fkAcomodacao;
    }

    public Integer getFkAcomodacaoHost() {
        return fkAcomodacaoHost;
    }
}
