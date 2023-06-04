package exchance.grupo.apiexchance.service.hostFamily;

import exchance.grupo.apiexchance.entidade.HostFamily;
import exchance.grupo.apiexchance.repositorio.HostFamilyRepository;
import exchance.grupo.apiexchance.security.jwt.GerenciadorTokenJwt;
import exchance.grupo.apiexchance.service.hostFamily.autenticacao.dto.HostFamilyLoginDto;
import exchance.grupo.apiexchance.service.hostFamily.autenticacao.dto.HostFamilyTokenDto;
import exchance.grupo.apiexchance.service.hostFamily.dto.HostFamilyDTO;
import exchance.grupo.apiexchance.service.hostFamily.dto.HostFamilyMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class HostFamilyServiceTest {

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private HostFamilyRepository hostFamilyRepository;

    @Mock
    private GerenciadorTokenJwt gerenciadorTokenJwt;

    @Mock
    private AuthenticationManager authenticationManager;

    @InjectMocks
    private HostFamilyService hostFamilyService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testDeletar_ValidId_ReturnsTrue() {
        Integer id = 1;
        HostFamily hostFamily = new HostFamily();

        when(hostFamilyRepository.findById(id)).thenReturn(Optional.of(hostFamily));

        assertTrue(hostFamilyService.deletar(id));

        verify(hostFamilyRepository, times(1)).delete(hostFamily);
    }

    @Test
    void testDeletar_InvalidId_ReturnsFalse() {
        Integer id = 1;

        when(hostFamilyRepository.findById(id)).thenReturn(Optional.empty());

        assertFalse(hostFamilyService.deletar(id));

        verify(hostFamilyRepository, never()).delete(any());
    }

    @Test
    void testAtualizar_InvalidId_ReturnsNull() {
        Integer id = 1;
        HostFamilyDTO hostFamilyDTO = new HostFamilyDTO();

        when(hostFamilyRepository.findById(id)).thenReturn(Optional.empty());

        HostFamily result = hostFamilyService.atualizar(id, hostFamilyDTO);

        assertNull(result);

        verify(hostFamilyRepository, never()).save(any());
    }

    @Test
    void testBuscar_ValidEmailAndNome_ReturnsHostFamily() {
        String email = "test@example.com";
        String nome = "Test";

        HostFamily hostFamily = new HostFamily();

        when(hostFamilyRepository.findByEmailAndNome(email, nome)).thenReturn(Optional.of(hostFamily));

        HostFamily result = hostFamilyService.buscar(email, nome);

        assertNotNull(result);
        assertEquals(hostFamily, result);
    }

    @Test
    void testBuscar_InvalidEmailAndNome_ReturnsNull() {
        String email = "test@example.com";
        String nome = "Test";

        when(hostFamilyRepository.findByEmailAndNome(email, nome)).thenReturn(Optional.empty());

        HostFamily result = hostFamilyService.buscar(email, nome);

        assertNull(result);
    }

    @Test
    void testBuscarPorID_ValidId_ReturnsOptionalHostFamily() {
        Integer id = 1;
        HostFamily hostFamily = new HostFamily();

        when(hostFamilyRepository.findById(id)).thenReturn(Optional.of(hostFamily));

        Optional<HostFamily> result = hostFamilyService.buscarPorID(id);

        assertNotNull(result);
        assertTrue(result.isPresent());
        assertEquals(hostFamily, result.get());
    }

    @Test
    void testBuscarPorID_InvalidId_ReturnsEmptyOptional() {
        Integer id = 1;

        when(hostFamilyRepository.findById(id)).thenReturn(Optional.empty());

        Optional<HostFamily> result = hostFamilyService.buscarPorID(id);

        assertNotNull(result);
        assertFalse(result.isPresent());
    }

    @Test
    void testAutenticar_ValidCredentials_ReturnsHostFamilyTokenDto() {
        HostFamilyLoginDto hostFamilyLoginDto = new HostFamilyLoginDto();
        hostFamilyLoginDto.setEmail("test@example.com");
        hostFamilyLoginDto.setSenha("password");

        HostFamily hostFamily = new HostFamily();
        hostFamily.setEmail(hostFamilyLoginDto.getEmail());

        Authentication authentication = mock(Authentication.class);

        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenReturn(authentication);
        when(hostFamilyRepository.findByEmail(hostFamilyLoginDto.getEmail())).thenReturn(Optional.of(hostFamily));
        when(gerenciadorTokenJwt.generateToken(authentication)).thenReturn("token");

        HostFamilyTokenDto result = hostFamilyService.autenticar(hostFamilyLoginDto);

        assertNotNull(result);
        assertEquals(hostFamily.getEmail(), result.getEmail());
        assertEquals("token", result.getToken());
    }


}
