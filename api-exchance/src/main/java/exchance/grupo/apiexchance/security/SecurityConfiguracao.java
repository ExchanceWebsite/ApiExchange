package exchance.grupo.apiexchance.security;

import exchance.grupo.apiexchance.security.estudante.EstudanteAutenticacaoFilter;
import exchance.grupo.apiexchance.security.estudante.EstudanteAutenticacaoProvider;
/*import exchance.grupo.apiexchance.security.hostFamily.HostFamilyAutenticacaoFilter;
import exchance.grupo.apiexchance.security.hostFamily.HostFamilyAutenticacaoProvider;*/
import exchance.grupo.apiexchance.security.jwt.GerenciadorTokenJwt;
import exchance.grupo.apiexchance.service.Estudante.autenticacao.EstudanteAutenticacaoService;
/*import exchance.grupo.apiexchance.service.hostFamily.autenticacao.HostFamilyAutenticacaoService;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguracao {
    private static final String ORIGENS_PERMITIDAS = "*";

   /* @Autowired
    private HostFamilyAutenticacaoService hostFamilyAutenticacaoService;*/

    @Autowired
    private EstudanteAutenticacaoService estudanteAutenticacaoService;

    @Autowired
    private AutenticacaoEntryPoint autenticacaoJwtEntryPoint;

    private static final AntPathRequestMatcher[] URLS_PERMITIDAS = {
            new AntPathRequestMatcher("/swagger-ui/**"),
            new AntPathRequestMatcher("/swagger-ui.html"),
            new AntPathRequestMatcher("/swagger-resources"),
            new AntPathRequestMatcher("/swagger-resources/**"),
            new AntPathRequestMatcher("/configuration/ui"),
            new AntPathRequestMatcher("/configuration/security"),
            new AntPathRequestMatcher("/api/public/**"),
            new AntPathRequestMatcher("/api/public/authenticate"),
            new AntPathRequestMatcher("/webjars/**"),
            new AntPathRequestMatcher("/v3/api-docs/**"),
            new AntPathRequestMatcher("/actuator/*"),
            new AntPathRequestMatcher("/h2-console/**"),
            new AntPathRequestMatcher("/error/**"),
            new AntPathRequestMatcher("/estudantes/**"),
            new AntPathRequestMatcher("/reservas/**"),
            new AntPathRequestMatcher("/hosts/**"),
            new AntPathRequestMatcher("/acomodacoes/**"),
            new AntPathRequestMatcher("/integrantes/**"),
            new AntPathRequestMatcher("/localidades/**"),
            new AntPathRequestMatcher("/comentarios/**"),
            new AntPathRequestMatcher("/estudantes/login/**"),
            new AntPathRequestMatcher("/hosts/login/**"),
            new AntPathRequestMatcher("/api/**")
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.headers()
                .frameOptions().disable()
                .and()
                .cors()
                .configurationSource(request -> buildCorsConfiguration())
                .and()
                .csrf()
                .disable()
                .authorizeHttpRequests(authorize -> authorize.requestMatchers(URLS_PERMITIDAS)
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                )
                .exceptionHandling()
                .authenticationEntryPoint(autenticacaoJwtEntryPoint)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtAuthenticationFilterBean(), UsernamePasswordAuthenticationFilter.class);
       /* http.addFilterBefore(jwtAuthenticationFilterBean2(), UsernamePasswordAuthenticationFilter.class);*/


        return http.build();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
/*
        authenticationManagerBuilder.authenticationProvider(new HostFamilyAutenticacaoProvider(hostFamilyAutenticacaoService, passwordEncoder()));
*/
        authenticationManagerBuilder.authenticationProvider(new EstudanteAutenticacaoProvider(estudanteAutenticacaoService, passwordEncoder()));
        return authenticationManagerBuilder.build();
    }

    @Bean
    public AutenticacaoEntryPoint jwtAuthenticationEntryPointBean() {
        return new AutenticacaoEntryPoint();
    }

    @Bean
    public EstudanteAutenticacaoFilter jwtAuthenticationFilterBean() {
        return new EstudanteAutenticacaoFilter(estudanteAutenticacaoService, jwtAuthenticationUtilBean());
    }

   /* @Bean
    public HostFamilyAutenticacaoFilter jwtAuthenticationFilterBean2() {
        return new HostFamilyAutenticacaoFilter(hostFamilyAutenticacaoService, jwtAuthenticationUtilBean());
    }*/

    @Bean
    public GerenciadorTokenJwt jwtAuthenticationUtilBean() {
        return new GerenciadorTokenJwt();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private CorsConfiguration buildCorsConfiguration() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowedOriginPatterns(Collections.singletonList(ORIGENS_PERMITIDAS));
        configuration.setAllowedMethods(
                Arrays.asList(
                        HttpMethod.GET.name(),
                        HttpMethod.POST.name(),
                        HttpMethod.PUT.name(),
                        HttpMethod.DELETE.name())
        );

        configuration.setAllowedHeaders(Arrays.asList(HttpHeaders.CONTENT_TYPE, HttpHeaders.AUTHORIZATION));
        return configuration;
    }
}