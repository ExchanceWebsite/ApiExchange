package exchance.grupo.apiexchance.controle;

import exchance.grupo.apiexchance.service.CSV.CsvService;
import org.apache.tomcat.util.file.ConfigurationSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.InputStream;

@Controller
@RequestMapping("/api/csv")
public class CsvController {

    @Autowired
    CsvService fileService;

    @GetMapping("/download")
    public ResponseEntity<Resource> getFile(){
        String fileName = "arquivo.csv";
        InputStreamResource file = new InputStreamResource((InputStream) fileService.load());

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("aplication/csv"))
                .build();
    }



}
