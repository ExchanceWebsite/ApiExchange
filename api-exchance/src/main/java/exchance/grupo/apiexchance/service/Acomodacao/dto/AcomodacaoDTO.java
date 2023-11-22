package exchance.grupo.apiexchance.service.Acomodacao.dto;

import exchance.grupo.apiexchance.entidade.Acomodacao;
import exchance.grupo.apiexchance.entidade.HostFamily;
import exchance.grupo.apiexchance.entidade.Localidade;
import exchance.grupo.apiexchance.entidade.Reserva;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class AcomodacaoDTO {


    private HostFamily host;

    private Localidade localidade;


    private boolean reservado;

    private Reserva reserva;

    private String descricao;


    @PastOrPresent
    private LocalDate inicioDisponibilidade;


    @FutureOrPresent
    private LocalDate fimDisponibilidade;


    private Double valorDiaria;


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

    public Localidade getLocalidade() {
        return localidade;
    }

    public void setLocalidade(Localidade localidade) {
        this.localidade = localidade;
    }

    public boolean getReservado() {
        return reservado;
    }


    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
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
