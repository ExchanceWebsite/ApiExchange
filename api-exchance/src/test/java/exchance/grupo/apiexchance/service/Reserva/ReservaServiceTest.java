package exchance.grupo.apiexchance.service.Reserva;

import exchance.grupo.apiexchance.entidade.Estudante;
import exchance.grupo.apiexchance.entidade.HostFamily;
import exchance.grupo.apiexchance.entidade.Reserva;
import exchance.grupo.apiexchance.repositorio.ReservaRepository;
import exchance.grupo.apiexchance.service.Acomodacao.AcomodacaoService;
import exchance.grupo.apiexchance.service.Estudante.EstudanteService;
import exchance.grupo.apiexchance.service.hostFamily.HostFamilyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ReservaServiceTest {

    private ReservaService reservaService;

    @Mock
    private ReservaRepository reservaRepository;

    @Mock
    private EstudanteService estudanteService;

    @Mock
    private HostFamilyService hostFamilyService;

    @Mock
    private AcomodacaoService acomodacaoService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        reservaService = new ReservaService(reservaRepository, estudanteService, hostFamilyService, acomodacaoService);
    }

    @Test
    void testListarReservasEstudante() {
        int idEstudante = 1;
        Estudante estudante = new Estudante();
        estudante.setIdEstudante(idEstudante);

        List<Reserva> reservas = new ArrayList<>();
        reservas.add(new Reserva());

        when(estudanteService.buscarPorId(idEstudante)).thenReturn(estudante);
        when(reservaRepository.findAllByEstudante(estudante)).thenReturn(reservas);

        List<Reserva> result = reservaService.listarReservasEstudante(idEstudante);

        assertEquals(reservas, result);
        verify(estudanteService, times(1)).buscarPorId(idEstudante);
        verify(reservaRepository, times(1)).findAllByEstudante(estudante);
    }

    @Test
    void testListarReservasHost() {
        int idHost = 1;
        HostFamily hostFamily = new HostFamily();
        hostFamily.setIdHostFamily(idHost);

        List<Reserva> reservas = new ArrayList<>();
        reservas.add(new Reserva());

        when(hostFamilyService.buscarPorID(idHost)).thenReturn(Optional.of(hostFamily));
        when(reservaRepository.findAllByHost(hostFamily)).thenReturn(reservas);

        List<Reserva> result = reservaService.listarReservasHost(idHost);

        assertEquals(reservas, result);
        verify(hostFamilyService, times(1)).buscarPorID(idHost);
        verify(reservaRepository, times(1)).findAllByHost(hostFamily);
    }
}
