package foodfinder.services.interfaces;

import foodfinder.dto.RestaurantGrade;
import org.springframework.stereotype.Service;

@Service
public interface GradesServices {

    void createRestaurantsGrade(final RestaurantGrade restaurantGrade );

}
