package clean.architecture;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * Spring Boot Starter
 *
 * @author James Zhan
 */
@EnableSwagger2WebMvc
@SpringBootApplication(scanBasePackages = { "clean.architecture" })
@MapperScan("clean.architecture.data")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
