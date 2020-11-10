package foodfinder.services.interfaces;

import foodfinder.dto.RestaurantGradeDTO;

import java.util.List;

public interface GradesServices {

    void createRestaurantsGrade(final RestaurantGradeDTO restaurantGrade);

    Double averageRestaurantsGrade(Integer restaurantId);

    List<Integer> findListOfGradesForRestaurantByRestaurantId(Integer restaurantId);
}
