package exchance.grupo.apiexchance.service.Reserva.dto;

import exchance.grupo.apiexchance.entidade.Acomodacao;
import exchance.grupo.apiexchance.entidade.Estudante;
import exchance.grupo.apiexchance.entidade.HostFamily;
import exchance.grupo.apiexchance.entidade.Reserva;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class ReservaDTO {


    private Estudante estudante;


    @FutureOrPresent
    private LocalDate entrada;


    @FutureOrPresent
    private LocalDate saida;

    private String formaPagamento;

    private Boolean reservado;


    private Acomodacao acomodacao;


    private HostFamily host;


    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public void setEntrada(LocalDate entrada) {
        this.entrada = entrada;
    }

    public void setSaida(LocalDate saida) {
        this.saida = saida;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public void setReservado(Boolean reservado) {
        this.reservado = reservado;
    }

    public Acomodacao getAcomodacao() {
        return acomodacao;
    }

    public void setAcomodacao(Acomodacao acomodacao) {
        this.acomodacao = acomodacao;
    }

    public HostFamily getHost() {
        return host;
    }

    public void setHost(HostFamily host) {
        this.host = host;
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


}
