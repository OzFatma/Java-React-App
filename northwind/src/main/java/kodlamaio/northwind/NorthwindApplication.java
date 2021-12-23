package kodlamaio.northwind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2 //Swager ı etkin hale getirir
public class NorthwindApplication {

	public static void main(String[] args) {
		SpringApplication.run(NorthwindApplication.class, args);
	}
	// beanler springbootta class anlamında
	@Bean
	// bu blok apileri tarar ve swagger kullanımına hazır hale getirir.
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("kodlamaio.northwind"))
				.build();
	}
}
