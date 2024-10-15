package org.generation.guarniapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//permite solicitudes desde cualquier parte ("*")en toda la aplicacion
@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Aplica a todas las rutas API
                .allowedOrigins("*") // Permite solicitudes desde cualquier lado
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS"); // Métodos permitidos el options se pone porque a  veces los metodos get mandan primero una solicitud del tipo options
    }
}
