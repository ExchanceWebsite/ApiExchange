package exchance.grupo.apiexchance.service.Mensagem;

import exchance.grupo.apiexchance.entidade.Estudante;
import exchance.grupo.apiexchance.entidade.HostFamily;
import exchance.grupo.apiexchance.entidade.Mensagem;
import exchance.grupo.apiexchance.repositorio.MensagemRepository;
import exchance.grupo.apiexchance.service.Estudante.EstudanteService;
import exchance.grupo.apiexchance.service.hostFamily.HostFamilyService;
import exchance.grupo.apiexchance.service.Mensagem.dto.MensagemDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

class MensagemServiceTest {

    @Mock
    private MensagemRepository mensagemRepository;

    @Mock
    private EstudanteService estudanteService;

    @Mock
    private HostFamilyService hostFamilyService;

    private MensagemService mensagemService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mensagemService = new MensagemService(mensagemRepository, estudanteService, hostFamilyService);
    }

    @Test
    void testCriarMensagem() {
        MensagemDTO mensagemDTO = new MensagemDTO();
        mensagemDTO.setTexto("Hello");
        mensagemDTO.setDataMensagem(LocalDate.now().atStartOfDay());

        Mensagem mensagem = new Mensagem();
        mensagem.setTexto("Hello");
        mensagem.setDataMensagem(LocalDate.now().atStartOfDay());

        when(mensagemRepository.save(any(Mensagem.class))).thenReturn(mensagem);

        mensagemService.criar(mensagemDTO);

        verify(mensagemRepository, times(1)).save(any(Mensagem.class));
    }

    @Test
    void testListarMensagensHostEstudante() {
        Integer idHost = 1;
        Integer idEstudante = 2;

        HostFamily hostFamily = new HostFamily();
        Estudante estudante = new Estudante();

        when(hostFamilyService.buscarPorID(idHost)).thenReturn(Optional.of(hostFamily));
        when(estudanteService.buscarPorId(idEstudante)).thenReturn(estudante);

        List<Mensagem> expectedMensagens = new ArrayList<>();
        when(mensagemRepository.findAllByDestinatarioAndProprietario(hostFamily, estudante)).thenReturn(expectedMensagens);

        List<Mensagem> mensagens = mensagemService.listarMensagensHostEstudante(idHost, idEstudante);

        verify(hostFamilyService, times(1)).buscarPorID(idHost);
        verify(estudanteService, times(1)).buscarPorId(idEstudante);
        verify(mensagemRepository, times(1)).findAllByDestinatarioAndProprietario(hostFamily, estudante);

        assertEquals(expectedMensagens, mensagens);
    }
}
