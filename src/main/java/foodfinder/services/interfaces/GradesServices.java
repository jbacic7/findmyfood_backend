package foodfinder.services.interfaces;

import foodfinder.dto.RestaurantGrade;

public interface GradesServices {

    void createRestaurantsGrade(final RestaurantGrade restaurantGrade);

    Double averageRestaurantsGrade(Integer restaurantId);
}
