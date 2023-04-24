package exchance.grupo.apiexchance.service.Reserva.dto;


import exchance.grupo.apiexchance.entidade.Reserva;

public class ReservaMapper {

  public static Reserva of(ReservaDTO reservaDTO) {
    Reserva reserva = new Reserva();

    reserva.setAcomodacao(reservaDTO.getAcomodacao());
    reserva.setEntrada(reservaDTO.getEntrada());
    reserva.setHost(reservaDTO.getHost());
    reserva.setSaida(reservaDTO.getSaida());
    reserva.setFormaPagamento(reservaDTO.getFormaPagamento());

    return reserva;
  }
}
