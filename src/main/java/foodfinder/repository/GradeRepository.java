package foodfinder.repository;

import foodfinder.dto.RestaurantGrade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<RestaurantGrade, Integer> {

    RestaurantGrade getRestaurantGrade(Integer grade, Integer id_restaurants );
    RestaurantGrade updateRestaurantGrade(Integer grade, Integer id_restaurants);


}
