package foodfinder;

import foodfinder.services.implementations.GradesServicesImpl;
import foodfinder.services.interfaces.GradesServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
public class FoodFinderApplication {



    public static void main(String[] args) {
        SpringApplication.run(FoodFinderApplication.class, args);

        }
}

