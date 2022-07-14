package shop.betabeta.week03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class W3HomeWorkApplication {

    public static void main(String[] args) {
        SpringApplication.run(W3HomeWorkApplication.class, args);
    }

}
