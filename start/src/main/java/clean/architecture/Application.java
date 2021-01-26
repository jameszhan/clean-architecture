package clean.architecture;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.Arrays;

/**
 * Spring Boot Starter
 *
 * @author James Zhan
 */
@Slf4j
@EnableSwagger2WebMvc
@SpringBootApplication(scanBasePackages = { "clean.architecture" })
@MapperScan("clean.architecture.data")
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Application started with arguments {}!", Arrays.toString(args));
    }
}
