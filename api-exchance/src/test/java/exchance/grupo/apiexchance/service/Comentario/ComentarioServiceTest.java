package exchance.grupo.apiexchance.service.Comentario;

import exchance.grupo.apiexchance.entidade.Comentario;
import exchance.grupo.apiexchance.entidade.HostFamily;
import exchance.grupo.apiexchance.repositorio.ComentarioRepository;
import exchance.grupo.apiexchance.service.Comentario.dto.ComentarioDTO;
import exchance.grupo.apiexchance.service.hostFamily.HostFamilyService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

class ComentarioServiceTest {

    @Mock
    private ComentarioRepository comentarioRepository;

    @Mock
    private HostFamilyService hostFamilyService;

    private ComentarioService comentarioService;

    public ComentarioServiceTest() {
        MockitoAnnotations.openMocks(this);
        comentarioService = new ComentarioService(comentarioRepository, hostFamilyService);
    }

    @Test
    void testCriarComentario() {
        ComentarioDTO comentarioDTO = new ComentarioDTO();
        comentarioDTO.setComentario("Ótima família!");
        comentarioDTO.setDataPostagem(LocalDate.now());

        Comentario comentario = new Comentario();
        comentario.setComentario("Ótima família!");
        comentario.setDataPostagem(LocalDate.now());

        when(comentarioRepository.save(any(Comentario.class))).thenReturn(comentario);

        comentarioService.criar(comentarioDTO);

        verify(comentarioRepository, times(1)).save(any(Comentario.class));
    }

    @Test
    void testListarComentariosHost_Existente() {
        Integer idHost = 1;

        HostFamily hostFamily = new HostFamily();
        hostFamily.setIdHostFamily(idHost);

        Comentario comentario1 = new Comentario();
        comentario1.setComentario("Comentário 1");

        Comentario comentario2 = new Comentario();
        comentario2.setComentario("Comentário 2");

        List<Comentario> comentarios = new ArrayList<>();
        comentarios.add(comentario1);
        comentarios.add(comentario2);

        when(hostFamilyService.buscarPorID(idHost)).thenReturn(Optional.of(hostFamily));
        when(comentarioRepository.findAllByDestinatario(hostFamily)).thenReturn(comentarios);

        List<Comentario> resultado = comentarioService.listarComentariosHost(idHost);

        verify(hostFamilyService, times(1)).buscarPorID(idHost);
        verify(comentarioRepository, times(1)).findAllByDestinatario(hostFamily);

        assertEquals(comentarios, resultado);
    }

    @Test
    void testListarComentariosHost_NaoExistente() {
        Integer idHost = 2;

        when(hostFamilyService.buscarPorID(idHost)).thenReturn(Optional.empty());

        List<Comentario> resultado = comentarioService.listarComentariosHost(idHost);

        verify(hostFamilyService, times(1)).buscarPorID(idHost);
        verify(comentarioRepository, never()).findAllByDestinatario(any(HostFamily.class));

        assertNull(resultado);
    }

    @Test
    void testListarComentariosHost_SemComentarios() {
        Integer idHost = 3;

        HostFamily hostFamily = new HostFamily();
        hostFamily.setIdHostFamily(idHost);

        List<Comentario> comentarios = new ArrayList<>();

        when(hostFamilyService.buscarPorID(idHost)).thenReturn(Optional.of(hostFamily));
        when(comentarioRepository.findAllByDestinatario(hostFamily)).thenReturn(comentarios);

        List<Comentario> resultado = comentarioService.listarComentariosHost(idHost);

        verify(hostFamilyService, times(1)).buscarPorID(idHost);
        verify(comentarioRepository, times(1)).findAllByDestinatario(hostFamily);

        assertEquals(comentarios, resultado);
    }
}
