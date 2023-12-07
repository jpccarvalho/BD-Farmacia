package br.com.farmaciapjr2.springbootapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Permitir requisições de qualquer origem
        config.addAllowedOrigin("*");

        // Permitir os métodos HTTP permitidos (GET, POST, PUT, DELETE, etc.)
        config.addAllowedMethod("*");

        // Permitir os cabeçalhos que você deseja expor
        config.addAllowedHeader("*");

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
