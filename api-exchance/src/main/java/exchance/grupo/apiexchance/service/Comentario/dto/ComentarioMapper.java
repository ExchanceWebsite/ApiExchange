package exchance.grupo.apiexchance.service.Comentario.dto;


import exchance.grupo.apiexchance.entidade.Comentario;


public class ComentarioMapper {

  public static Comentario of(ComentarioDTO comentarioDTO) {

    Comentario comentario = new Comentario();

    comentario.setComentario(comentarioDTO.getComentario());
    comentario.setDestinatario(comentarioDTO.getDestinatario());
    comentario.setDataPostagem(comentarioDTO.getDataPostagem());
    comentario.setProprietario(comentarioDTO.getProprietario());

    return comentario;

  }

}
