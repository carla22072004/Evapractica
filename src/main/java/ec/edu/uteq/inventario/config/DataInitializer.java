package ec.edu.uteq.inventario.config;

import ec.edu.uteq.inventario.domain.Usuario;
import ec.edu.uteq.inventario.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner seedUsuarios(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            crearSiNoExiste(usuarioRepository, passwordEncoder, "user", "user123", "ROLE_USER");
            crearSiNoExiste(usuarioRepository, passwordEncoder, "admin", "admin123", "ROLE_ADMIN");
        };
    }

    private void crearSiNoExiste(
            UsuarioRepository repository,
            PasswordEncoder encoder,
            String username,
            String rawPassword,
            String rol) {
        if (repository.findByUsernameAndActivoTrue(username).isEmpty()) {
            Usuario usuario = new Usuario();
            usuario.setUsername(username);
            usuario.setPassword(encoder.encode(rawPassword));
            usuario.setRol(rol);
            usuario.setActivo(true);
            repository.save(usuario);
        }
    }
}
