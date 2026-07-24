package ec.edu.uteq.inventario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

/**
 * UserDetailsService por defecto se desactiva (JWT llega en Parte 4).
 */
@SpringBootApplication(exclude = UserDetailsServiceAutoConfiguration.class)
public class InventarioMercadoZamoraApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventarioMercadoZamoraApplication.class, args);
    }
}
