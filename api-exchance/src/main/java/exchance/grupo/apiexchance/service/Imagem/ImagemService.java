package exchance.grupo.apiexchance.service.Imagem;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.common.StorageSharedKeyCredential;
import exchance.grupo.apiexchance.entidade.Estudante;
import exchance.grupo.apiexchance.entidade.HostFamily;
import exchance.grupo.apiexchance.entidade.Imagem;
import exchance.grupo.apiexchance.repositorio.ImagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Service
public class ImagemService {
    @Autowired
    private ImagemRepository imagemRepository;

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

    public void criarDocumento(MultipartFile file, Estudante estudante, HostFamily hostFamily) throws IOException {
        final Imagem imagem = new Imagem();

        imagem.setNome(file.getName());
        imagem.setDocumento(true);
        imagem.setFoto(false);
        imagem.setEstudante(estudante);
        imagem.setHostFamily(hostFamily);

        // upload da imagem para o Azure Blob Storage
        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
                .endpoint("https://storageexchance.blob.core.windows.net/")
                .credential(new StorageSharedKeyCredential("storageexchance", "NPPjOKw6fSiniwyQNoPV9lY/2W4SK0LknKa0tj9tls7Rio+fIEMja+En2bWK4ZJ8C4WncOUmn4a9+ASt7JntaQ=="))
                .buildClient();

        BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient("imagens-teste");
        BlobClient blobClient = containerClient.getBlobClient(UUID.randomUUID() + file.getContentType());

        blobClient.upload(file.getInputStream(), file.getSize(), true);
        String url = blobClient.getBlobUrl();

        // set caminho da imagem na tabela Imagem
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
