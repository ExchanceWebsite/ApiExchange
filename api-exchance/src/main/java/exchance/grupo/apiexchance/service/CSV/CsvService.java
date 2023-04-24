package exchance.grupo.apiexchance.service.CSV;

import exchance.grupo.apiexchance.repositorio.CsvRepository;
import exchance.grupo.apiexchance.service.Estudante.dto.EstudanteDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CsvService {

    @Autowired
    CsvRepository csvRepository;

    public List<EstudanteDTO> load(){
        List<EstudanteDTO> reservas = csvRepository.findAll();

        return reservas;
    }

}
