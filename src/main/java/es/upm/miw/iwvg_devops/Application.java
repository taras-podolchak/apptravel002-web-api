package es.upm.miw.iwvg_devops;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class}) // Not API: /error
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);// mvnw clean spring-boot:run
    }
    @Bean
    public RouterFunction<ServerResponse> indexRouter(
            @Value("classpath:/static/index.html") final Resource indexHtml) {

        // Serve static index.html at root, for convenient message publishing.
        return route(
                GET("/"),
                request -> ok().contentType(MediaType.TEXT_HTML).bodyValue(indexHtml));
    }
}
