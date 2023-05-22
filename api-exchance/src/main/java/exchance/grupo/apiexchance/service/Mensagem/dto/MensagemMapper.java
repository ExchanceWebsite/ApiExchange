package exchance.grupo.apiexchance.service.Mensagem.dto;

import exchance.grupo.apiexchance.entidade.Comentario;
import exchance.grupo.apiexchance.entidade.Mensagem;
import exchance.grupo.apiexchance.service.Comentario.dto.ComentarioDTO;

public class MensagemMapper {

    public static Mensagem of(MensagemDTO mensagemDTO) {

        Mensagem mensagem = new Mensagem();

        mensagem.setDataMensagem(mensagemDTO.getDataMensagem());
        mensagem.setDestinatario(mensagemDTO.getDestinatario());
        mensagem.setProprietario(mensagemDTO.getProprietario());
        mensagem.setTexto(mensagemDTO.getTexto());

        return mensagem;

    }
}
