package foodfinder.services.interfaces;

import foodfinder.dto.RestaurantGrade;

import java.util.List;

public interface GradesServices {

    void createRestaurantsGrade(final RestaurantGrade restaurantGrade);

    Double averageRestaurantsGrade(Integer restaurantId);

    List<Integer> findListOfGradesForRestaurantByRestaurantId(Integer restaurantId);
}
