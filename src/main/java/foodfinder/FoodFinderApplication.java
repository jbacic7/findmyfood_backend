package foodfinder;

import foodfinder.services.implementations.GradesServicesImpl;
import foodfinder.services.interfaces.GradesServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class FoodFinderApplication {



    public static void main(String[] args) {
        SpringApplication.run(FoodFinderApplication.class, args);

        }

}

