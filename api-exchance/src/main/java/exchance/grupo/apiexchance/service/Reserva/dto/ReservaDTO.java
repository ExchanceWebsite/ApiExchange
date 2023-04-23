package exchance.grupo.apiexchance.service.Reserva.dto;

import exchance.grupo.apiexchance.entidade.Acomodacao;
import exchance.grupo.apiexchance.entidade.Estudante;
import exchance.grupo.apiexchance.entidade.HostFamily;
import exchance.grupo.apiexchance.entidade.Reserva;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class ReservaDTO {

    @NotBlank
    private Estudante estudantee;

    @NotBlank
    @FutureOrPresent
    private LocalDate entrada;

    @NotBlank
    @FutureOrPresent
    private LocalDate saida;

    private String formaPagamento;

    @NotBlank
    private Acomodacao acomodacao;

    @NotBlank
    private HostFamily host;


    public Estudante getEstudantee() {
        return estudantee;
    }

    public void setEstudantee(Estudante estudantee) {
        this.estudantee = estudantee;
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
