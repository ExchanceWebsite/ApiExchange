package exchance.grupo.apiexchance.service.Estudante;

import exchance.grupo.apiexchance.entidade.Estudante;
import exchance.grupo.apiexchance.repositorio.EstudanteRepository;
import exchance.grupo.apiexchance.security.jwt.GerenciadorTokenJwt;
import exchance.grupo.apiexchance.service.Estudante.autenticacao.dto.EstudanteLoginDto;
import exchance.grupo.apiexchance.service.Estudante.autenticacao.dto.EstudanteTokenDto;
import exchance.grupo.apiexchance.service.Estudante.dto.EstudanteDTO;
import exchance.grupo.apiexchance.service.Estudante.dto.EstudanteMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class EstudanteServiceTest {

    private EstudanteService estudanteService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private EstudanteRepository estudanteRepository;

    @Mock
    private GerenciadorTokenJwt gerenciadorTokenJwt;

    @Mock
    private AuthenticationManager authenticationManager;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        estudanteService = new EstudanteService(passwordEncoder, estudanteRepository, gerenciadorTokenJwt, authenticationManager);
    }

    @Test
    public void testCriarEstudante() {
        // Arrange
        EstudanteDTO estudanteDTO = new EstudanteDTO();
        estudanteDTO.setNome("John Doe");
        estudanteDTO.setEmail("johndoe@example.com");
        estudanteDTO.setSenha("password");

        Estudante novoEstudante = new Estudante();
        novoEstudante.setNome("John Doe");
        novoEstudante.setEmail("johndoe@example.com");
        novoEstudante.setSenha("password");

        Mockito.when(passwordEncoder.encode(Mockito.anyString())).thenReturn("encodedPassword");
        Mockito.when(estudanteRepository.save(Mockito.any(Estudante.class))).thenReturn(novoEstudante);

        // Act
        estudanteService.criar(estudanteDTO);

        // Assert
        ArgumentCaptor<Estudante> estudanteCaptor = ArgumentCaptor.forClass(Estudante.class);
        Mockito.verify(passwordEncoder).encode("password");
        Mockito.verify(estudanteRepository).save(estudanteCaptor.capture());

        Estudante capturedEstudante = estudanteCaptor.getValue();
        Assertions.assertEquals("John Doe", capturedEstudante.getNome());
        Assertions.assertEquals("johndoe@example.com", capturedEstudante.getEmail());
        Assertions.assertEquals("encodedPassword", capturedEstudante.getSenha());
    }

    @Test
    public void testDeletarEstudante() {
        // Arrange
        Integer estudanteId = 1;
        Estudante estudante = new Estudante();
        estudante.setIdEstudante(estudanteId);

        Mockito.when(estudanteRepository.findById(estudanteId)).thenReturn(Optional.of(estudante));

        // Act
        boolean result = estudanteService.deletar(estudanteId);

        // Assert
        Mockito.verify(estudanteRepository).findById(estudanteId);
        Mockito.verify(estudanteRepository).delete(estudante);

        Assertions.assertTrue(result);
    }

    @Test
    public void testDeletarEstudanteNaoEncontrado() {
        // Arrange
        Integer estudanteId = 1;

        Mockito.when(estudanteRepository.findById(estudanteId)).thenReturn(Optional.empty());

        // Act
        boolean result = estudanteService.deletar(estudanteId);

        // Assert
        Mockito.verify(estudanteRepository).findById(estudanteId);
        Mockito.verify(estudanteRepository, Mockito.never()).delete(Mockito.any(Estudante.class));

        Assertions.assertFalse(result);
    }

    @Test
    public void testAtualizarEstudante() {
        // Arrange
        Integer estudanteId = 1;
        EstudanteDTO estudanteDTO = new EstudanteDTO();
        estudanteDTO.setNome("John Doe");
        estudanteDTO.setEmail("johndoe@example.com");
        estudanteDTO.setSenha("newPassword");

        Estudante estudante = new Estudante();
        estudante.setIdEstudante(estudanteId);

        Mockito.when(estudanteRepository.findById(estudanteId)).thenReturn(Optional.of(estudante));
        Mockito.when(passwordEncoder.encode(Mockito.anyString())).thenReturn("encodedPassword");
        Mockito.when(estudanteRepository.save(Mockito.any(Estudante.class))).thenReturn(estudante);

        // Act
        Estudante result = estudanteService.atualizar(estudanteId, estudanteDTO);

        // Assert
        Mockito.verify(estudanteRepository).findById(estudanteId);
        Mockito.verify(passwordEncoder).encode("newPassword");
        Mockito.verify(estudanteRepository).save(estudante);

        Assertions.assertEquals(estudante, result);
        Assertions.assertEquals("John Doe", estudante.getNome());
        Assertions.assertEquals("johndoe@example.com", estudante.getEmail());
        Assertions.assertEquals("encodedPassword", estudante.getSenha());
    }

    @Test
    public void testAtualizarEstudanteNaoEncontrado() {
        // Arrange
        Integer estudanteId = 1;
        EstudanteDTO estudanteDTO = new EstudanteDTO();

        Mockito.when(estudanteRepository.findById(estudanteId)).thenReturn(Optional.empty());

        // Act
        Estudante result = estudanteService.atualizar(estudanteId, estudanteDTO);

        // Assert
        Mockito.verify(estudanteRepository).findById(estudanteId);
        Mockito.verify(estudanteRepository, Mockito.never()).save(Mockito.any(Estudante.class));

        Assertions.assertNull(result);
    }

    @Test
    public void testBuscarEstudante() {
        // Arrange
        String email = "johndoe@example.com";
        String nome = "John Doe";
        Estudante estudante = new Estudante();
        estudante.setEmail(email);
        estudante.setNome(nome);

        Mockito.when(estudanteRepository.findByEmailAndNome(email, nome)).thenReturn(Optional.of(estudante));

        // Act
        Estudante result = estudanteService.buscar(email, nome);

        // Assert
        Mockito.verify(estudanteRepository).findByEmailAndNome(email, nome);

        Assertions.assertEquals(estudante, result);
        Assertions.assertEquals(email, estudante.getEmail());
        Assertions.assertEquals(nome, estudante.getNome());
    }

    @Test
    public void testBuscarEstudanteNaoEncontrado() {
        // Arrange
        String email = "johndoe@example.com";
        String nome = "John Doe";

        Mockito.when(estudanteRepository.findByEmailAndNome(email, nome)).thenReturn(Optional.empty());

        // Act
        Estudante result = estudanteService.buscar(email, nome);

        // Assert
        Mockito.verify(estudanteRepository).findByEmailAndNome(email, nome);

        Assertions.assertNull(result);
    }

    @Test
    public void testBuscarEstudantePorId() {
        // Arrange
        Integer estudanteId = 1;
        Estudante estudante = new Estudante();
        estudante.setIdEstudante(estudanteId);

        Mockito.when(estudanteRepository.findById(estudanteId)).thenReturn(Optional.of(estudante));

        // Act
        Estudante result = estudanteService.buscarPorId(estudanteId);

        // Assert
        Mockito.verify(estudanteRepository).findById(estudanteId);

        Assertions.assertEquals(estudante, result);
        Assertions.assertEquals(estudanteId, estudante.getIdEstudante());
    }

    @Test
    public void testBuscarEstudantePorIdNaoEncontrado() {
        // Arrange
        Integer estudanteId = 1;

        Mockito.when(estudanteRepository.findById(estudanteId)).thenReturn(Optional.empty());

        // Act
        Estudante result = estudanteService.buscarPorId(estudanteId);

        // Assert
        Mockito.verify(estudanteRepository).findById(estudanteId);

        Assertions.assertNull(result);
    }

    @Test
    public void testEncontrarIdEstudante() {
        // Arrange
        String email = "johndoe@example.com";
        String senha = "password";
        Integer estudanteId = 1;

        Mockito.when(estudanteRepository.findIdEstudanteBySenhaAndEmail(senha, email)).thenReturn(Optional.of(estudanteId));

        // Act
        Integer result = estudanteService.encontrarId(email, senha);

        // Assert
        Mockito.verify(estudanteRepository).findIdEstudanteBySenhaAndEmail(senha, email);

        Assertions.assertEquals(estudanteId, result);
    }

    @Test
    public void testEncontrarIdEstudanteNaoEncontrado() {
        // Arrange
        String email = "johndoe@example.com";
        String senha = "password";

        Mockito.when(estudanteRepository.findIdEstudanteBySenhaAndEmail(senha, email)).thenReturn(Optional.empty());

        // Act
        Integer result = estudanteService.encontrarId(email, senha);

        // Assert
        Mockito.verify(estudanteRepository).findIdEstudanteBySenhaAndEmail(senha, email);

        Assertions.assertNull(result);
    }

    @Test
    public void testAutenticarEstudante() {
        // Arrange
        String email = "johndoe@example.com";
        String senha = "password";
        String token = "jwtToken";

        EstudanteLoginDto estudanteLoginDto = new EstudanteLoginDto();
        estudanteLoginDto.setEmail(email);
        estudanteLoginDto.setSenha(senha);

        Estudante estudante = new Estudante();
        estudante.setEmail(email);

        Authentication authentication = Mockito.mock(Authentication.class);
        Mockito.when(authenticationManager.authenticate(Mockito.any(UsernamePasswordAuthenticationToken.class))).thenReturn(authentication);
        Mockito.when(estudanteRepository.findByEmail(email)).thenReturn(Optional.of(estudante));
        Mockito.when(gerenciadorTokenJwt.generateToken(authentication)).thenReturn(token);

        // Act
        EstudanteTokenDto result = estudanteService.autenticar(estudanteLoginDto);

        // Assert
        Mockito.verify(authenticationManager).authenticate(Mockito.any(UsernamePasswordAuthenticationToken.class));
        Mockito.verify(estudanteRepository).findByEmail(email);
        Mockito.verify(gerenciadorTokenJwt).generateToken(authentication);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(token, result.getToken());
    }

}
