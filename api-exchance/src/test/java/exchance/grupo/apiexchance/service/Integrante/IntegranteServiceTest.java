package exchance.grupo.apiexchance.service.Integrante;

import exchance.grupo.apiexchance.entidade.Integrante;
import exchance.grupo.apiexchance.repositorio.IntegranteRepository;
import exchance.grupo.apiexchance.service.Integrante.dto.IntegranteDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

class IntegranteServiceTest {

    @Mock
    private IntegranteRepository integranteRepository;

    private IntegranteService integranteService;

    public IntegranteServiceTest() {
        MockitoAnnotations.openMocks(this);
        integranteService = new IntegranteService(integranteRepository);
    }

    @Test
    void testCriarIntegrante() {
        IntegranteDTO integranteDTO = new IntegranteDTO();
        integranteDTO.setNome("John Doe");

        Integrante integrante = new Integrante();
        integrante.setNome("John Doe");

        when(integranteRepository.save(any(Integrante.class))).thenReturn(integrante);

        integranteService.criar(integranteDTO);

        verify(integranteRepository, times(1)).save(any(Integrante.class));
    }

    @Test
    void testBuscarIdPorNome_Existente() {
        String nome = "John Doe";

        Integrante integrante = new Integrante();
        integrante.setNome(nome);

        when(integranteRepository.findIdIntegranteByNome(nome)).thenReturn(Optional.of(integrante));

        Integrante resultado = integranteService.buscarIdPorNome(nome);

        verify(integranteRepository, times(1)).findIdIntegranteByNome(nome);

        assertEquals(integrante, resultado);
    }

    @Test
    void testBuscarIdPorNome_NaoExistente() {
        String nome = "Jane Smith";

        when(integranteRepository.findIdIntegranteByNome(nome)).thenReturn(Optional.empty());

        Integrante resultado = integranteService.buscarIdPorNome(nome);

        verify(integranteRepository, times(1)).findIdIntegranteByNome(nome);

        assertNull(resultado);
    }

    @Test
    void testBuscarIdPorNomeHost_Existente() {
        String nome = "John Doe";
        Integer idHost = 1;

        Integrante integrante = new Integrante();
        integrante.setNome(nome);

        when(integranteRepository.findIdIntegranteByNomeAndHost(nome, idHost)).thenReturn(Optional.of(integrante));

        Integrante resultado = integranteService.buscarIdPorNomeHost(nome, idHost);

        verify(integranteRepository, times(1)).findIdIntegranteByNomeAndHost(nome, idHost);

        assertEquals(integrante, resultado);
    }

    @Test
    void testBuscarIdPorNomeHost_NaoExistente() {
        String nome = "Jane Smith";
        Integer idHost = 2;

        when(integranteRepository.findIdIntegranteByNomeAndHost(nome, idHost)).thenReturn(Optional.empty());

        Integrante resultado = integranteService.buscarIdPorNomeHost(nome, idHost);

        verify(integranteRepository, times(1)).findIdIntegranteByNomeAndHost(nome, idHost);

        assertNull(resultado);
    }

    @Test
    void testRemoverIntegrante() {
        Integrante integrante = new Integrante();

        integranteService.remover(integrante);

        verify(integranteRepository, times(1)).delete(integrante);
    }
}
