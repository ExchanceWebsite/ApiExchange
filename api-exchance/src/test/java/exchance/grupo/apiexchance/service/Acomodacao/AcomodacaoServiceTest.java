package exchance.grupo.apiexchance.service.Acomodacao;

import exchance.grupo.apiexchance.entidade.Acomodacao;
import exchance.grupo.apiexchance.repositorio.AcomodacaoRepository;
import exchance.grupo.apiexchance.service.Acomodacao.dto.AcomodacaoDTO;
import exchance.grupo.apiexchance.service.Acomodacao.dto.AcomodacaoMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AcomodacaoServiceTest {

    @Mock
    private AcomodacaoRepository acomodacaoRepository;

    private AcomodacaoService acomodacaoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        acomodacaoService = new AcomodacaoService(acomodacaoRepository);
    }

    @Test
    void testFindAccommodations() {
        Integer localidadeId = 1;
        LocalDate dataEntrada = LocalDate.of(2023, 6, 1);
        LocalDate dataSaida = LocalDate.of(2023, 6, 10);

        List<Acomodacao> acomodacoes = Arrays.asList(new Acomodacao(), new Acomodacao());
        Mockito.when(acomodacaoRepository.findAll((Specification<Acomodacao>) Mockito.any())).thenReturn(acomodacoes);

        List<Acomodacao> result = acomodacaoService.findAccommodations(localidadeId, dataEntrada, dataSaida);

        assertEquals(acomodacoes, result);
        Mockito.verify(acomodacaoRepository).findAll((Specification<Acomodacao>) Mockito.any());
    }
}
