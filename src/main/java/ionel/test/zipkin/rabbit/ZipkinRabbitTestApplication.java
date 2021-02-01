package ionel.test.zipkin.rabbit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"ionel.test.zipkin.rabbit"})
public class ZipkinRabbitTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinRabbitTestApplication.class, args);
	}

}
