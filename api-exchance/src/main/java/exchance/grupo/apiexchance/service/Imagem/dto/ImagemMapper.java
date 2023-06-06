package exchance.grupo.apiexchance.service.Imagem.dto;

import exchance.grupo.apiexchance.entidade.Imagem;
import exchance.grupo.apiexchance.entidade.Integrante;
import exchance.grupo.apiexchance.service.Integrante.dto.IntegranteDTO;

public class ImagemMapper {
    public static ImagemDTO of(Imagem imagemDTO) {
        ImagemDTO imagemDto = new ImagemDTO();

        imagemDto.setIdImagem(imagemDTO.getIdImagem());
        imagemDto.setCaminho(imagemDTO.getCaminho());
        imagemDto.setNome(imagemDTO.getNome());
        imagemDto.setFoto(imagemDTO.isFoto());
        imagemDto.setDocumento(imagemDTO.isDocumento());
        imagemDto.setEstudante(imagemDTO.getEstudante());
        imagemDto.setHostFamily(imagemDTO.getHostFamily());

        return imagemDto;

    }
}
