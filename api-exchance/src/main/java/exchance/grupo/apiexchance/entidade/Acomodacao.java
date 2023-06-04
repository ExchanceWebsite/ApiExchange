package exchance.grupo.apiexchance.entidade;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

@Entity
public class Acomodacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAcomodacao;

    @ManyToOne
    private HostFamily host;

    @OneToOne(mappedBy = "acomodacao")
    private Reserva reserva;


    private String descricao;


    private LocalDate inicioDisponibilidade;


    private LocalDate fimDisponibilidade;


    private Double valorDiaria;


    private String regras;

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Integer getIdAcomodacao() {
        return idAcomodacao;
    }

    public void setIdAcomodacao(Integer idAcomodacao) {
        this.idAcomodacao = idAcomodacao;
    }

    public HostFamily getHost() {
        return host;
    }

    public void setHost(HostFamily host) {
        this.host = host;
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
