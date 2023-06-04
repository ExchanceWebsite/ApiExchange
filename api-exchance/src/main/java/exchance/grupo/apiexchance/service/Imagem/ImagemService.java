package exchance.grupo.apiexchance.service.Imagem;

import com.azure.core.http.rest.Response;
import com.azure.storage.blob.*;
import com.azure.storage.blob.models.BlockBlobItem;
import com.azure.storage.blob.options.BlobParallelUploadOptions;
import com.azure.storage.common.StorageSharedKeyCredential;
import exchance.grupo.apiexchance.entidade.Estudante;
import exchance.grupo.apiexchance.entidade.HostFamily;
import exchance.grupo.apiexchance.entidade.Imagem;
import exchance.grupo.apiexchance.repositorio.ImagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;



@Service
public class ImagemService {
    @Autowired
    private ImagemRepository imagemRepository;

    private static final String CONNECTION_STRING = "DefaultEndpointsProtocol=https;AccountName=storageexchance;AccountKey=NPPjOKw6fSiniwyQNoPV9lY/2W4SK0LknKa0tj9tls7Rio+fIEMja+En2bWK4ZJ8C4WncOUmn4a9+ASt7JntaQ==;EndpointSuffix=core.windows.net";
    private static final String CONTAINER_NAME = "imagens-teste";

    public void criarFoto(Estudante estudante, HostFamily hostFamily) throws IOException {
        final Imagem imagem = new Imagem();

        imagem.setNome("file.getContentType()");
        imagem.setDocumento(false);
        imagem.setFoto(true);
        imagem.setEstudante(estudante);
        imagem.setHostFamily(hostFamily);

        // upload da imagem para o Azure Blob Storage
        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
                .endpoint("https://storageexchance.blob.core.windows.net/")
                .credential(new StorageSharedKeyCredential("storageexchance", "NPPjOKw6fSiniwyQNoPV9lY/2W4SK0LknKa0tj9tls7Rio+fIEMja+En2bWK4ZJ8C4WncOUmn4a9+ASt7JntaQ=="))
                .buildClient();

        BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient("imagens-teste");
        BlobClient blobClient = containerClient.getBlobClient(UUID.randomUUID() + "png");

        blobClient.uploadFromFile("C:\\Users\\Felipe\\Desktop\\icons\\Shadow.jpg");
        String url = blobClient.getBlobUrl();

        // set caminho da imagem na tabela Imagem
        imagem.setCaminho(url);

        this.imagemRepository.save(imagem);
    }

    public void criarDocumento(MultipartFile image, Estudante estudante, HostFamily hostFamily) throws IOException {
        byte[] bytes = image.getBytes();
        if (bytes.length == 0) {
            throw new IOException("Imagen not content blob");
        }

        String fileName = LocalDateTime.now() + image.getOriginalFilename();

        String constr = "DefaultEndpointsProtocol=https;" +
                "AccountName=storageexchance;" +
                "AccountKey=NPPjOKw6fSiniwyQNoPV9lY/2W4SK0LknKa0tj9tls7Rio+fIEMja+En2bWK4ZJ8C4WncOUmn4a9+ASt7JntaQ==;" +
                "EndpointSuffix=core.windows.net";

        final Imagem imagem = new Imagem();

        imagem.setNome(image.getOriginalFilename());
        imagem.setDocumento(true);
        imagem.setFoto(false);
        imagem.setEstudante(estudante);
        imagem.setHostFamily(hostFamily);

        BlobContainerClient container = new BlobContainerClientBuilder()
                .connectionString(constr)
                .containerName("ezschedules")
                .buildClient();

        BlobClient blob = container.getBlobClient(fileName);

        Response<BlockBlobItem> response =
                blob.uploadWithResponse(
                        new BlobParallelUploadOptions(new ByteArrayInputStream(bytes), bytes.length),
                        Duration.ofHours(5),
                        null);

        if (response.getStatusCode() != 201) {
            throw new IOException("request failed");
        }

        String url = blob.getBlobUrl();

        imagem.setCaminho(url);

        this.imagemRepository.save(imagem);
    }

    public String getCaminhoEstudante(String tipo, Integer fkEstudante){

        Optional<Imagem> imagemOptional;
        if (tipo != null && tipo.equalsIgnoreCase("foto")) {
            imagemOptional = imagemRepository.findByEstudanteAndIsFoto(fkEstudante, true);
        } else {
            imagemOptional = imagemRepository.findByEstudanteAndIsDocumento(fkEstudante, true);
        }

        return imagemOptional.map(Imagem::getCaminho).orElse(null);
    }


    public String getCaminhoHost(String tipo, Integer fkHost){

        Optional<Imagem> imagemOptional;
        if (tipo != null && tipo.equalsIgnoreCase("foto")) {
            imagemOptional = imagemRepository.findByHostFamilyAndIsFoto(fkHost, true);
        } else {
            imagemOptional = imagemRepository.findByHostFamilyAndIsDocumento(fkHost, true);
        }

        return imagemOptional.map(Imagem::getCaminho).orElse(null);
    }
}
