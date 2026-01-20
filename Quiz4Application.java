package bd.edu.seu.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class Quiz4Application {

    public static void main(String[] args) {
        SpringApplication.run(Quiz4Application.class, args);
    }

}
