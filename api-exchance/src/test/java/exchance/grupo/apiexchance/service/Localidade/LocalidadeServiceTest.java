package exchance.grupo.apiexchance.service.Localidade;

import exchance.grupo.apiexchance.entidade.Localidade;
import exchance.grupo.apiexchance.repositorio.LocalidadeRepository;
import exchance.grupo.apiexchance.service.Localidade.dto.LocalidadeDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

class LocalidadeServiceTest {

    @Mock
    private LocalidadeRepository localidadeRepository;

    private LocalidadeService localidadeService;

    public LocalidadeServiceTest() {
        MockitoAnnotations.openMocks(this);
        localidadeService = new LocalidadeService(localidadeRepository);
    }

    @Test
    void testCriarLocalidade() {
        LocalidadeDTO localidadeDTO = new LocalidadeDTO();
        localidadeDTO.setEndereco("123 Main Street");

        Localidade localidade = new Localidade();
        localidade.setEndereco("123 Main Street");

        when(localidadeRepository.save(any(Localidade.class))).thenReturn(localidade);

        localidadeService.criar(localidadeDTO);

        verify(localidadeRepository, times(1)).save(any(Localidade.class));
    }

    @Test
    void testBuscarLocalidadePorEndereco_Existente() {
        String endereco = "123 Main Street";

        Localidade localidade = new Localidade();
        localidade.setEndereco(endereco);

        when(localidadeRepository.findByEndereco(endereco)).thenReturn(Optional.of(localidade));

        Localidade resultado = localidadeService.buscarLocalidadePorEndereco(endereco);

        verify(localidadeRepository, times(1)).findByEndereco(endereco);

        assertEquals(localidade, resultado);
    }

    @Test
    void testBuscarLocalidadePorEndereco_NaoExistente() {
        String endereco = "456 Elm Street";

        when(localidadeRepository.findByEndereco(endereco)).thenReturn(Optional.empty());

        Localidade resultado = localidadeService.buscarLocalidadePorEndereco(endereco);

        verify(localidadeRepository, times(1)).findByEndereco(endereco);

        assertNull(resultado);
    }
}
