package ec.edu.uteq.inventario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

/**
 * Redis se habilita en la Parte 3 (cache-aside).
 * UserDetailsService por defecto se desactiva (JWT llega en Parte 4).
 */
@SpringBootApplication(exclude = {
        RedisAutoConfiguration.class,
        UserDetailsServiceAutoConfiguration.class
})
public class InventarioMercadoZamoraApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventarioMercadoZamoraApplication.class, args);
    }
}
