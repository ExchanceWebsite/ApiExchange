package exchance.grupo.apiexchance.entidade;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

@Entity
@Table(name = "Acomodacao")
public class Acomodacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAcomodacao")
    private Integer idAcomodacao;

    @ManyToOne
    @JoinColumn(name = "fkHost")
    private HostFamily host;

    @ManyToOne
    @JoinColumn(name = "fkLocalidade")
    private Localidade localidade;

    @Column(name = "reservado")
    private boolean reservado;

    @OneToOne(mappedBy = "acomodacao")
    private Reserva reserva;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "inicioDisponibilidade")
    private LocalDate inicioDisponibilidade;

    @Column(name = "fimDisponibilidade")
    private LocalDate fimDisponibilidade;

    @Column(name = "valorDiaria")
    private Double valorDiaria;

    @Column(name = "regras")
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

    public Localidade getLocalidade() {
        return localidade;
    }

    public void setLocalidade(Localidade localidade) {
        this.localidade = localidade;
    }

    public boolean getReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
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
