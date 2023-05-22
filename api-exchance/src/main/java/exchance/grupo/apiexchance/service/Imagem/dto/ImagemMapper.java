package exchance.grupo.apiexchance.service.Imagem.dto;

import exchance.grupo.apiexchance.entidade.Imagem;
import exchance.grupo.apiexchance.entidade.Integrante;
import exchance.grupo.apiexchance.service.Integrante.dto.IntegranteDTO;

public class ImagemMapper {
    public static Imagem of(ImagemDTO imagemDTO) {
        Imagem imagem = new Imagem();

        imagem.setCaminho(imagemDTO.getCaminho());
        imagem.setNome(imagemDTO.getNome());
        imagem.setFoto(imagemDTO.isFoto());
        imagem.setDocumento(imagemDTO.isDocumento());
        imagem.setEstudante(imagemDTO.getEstudante());
        imagem.setHostFamily(imagemDTO.getHostFamily());

        return imagem;

    }
}
