package foodfinder.repository;

import foodfinder.dto.RestaurantGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface GradeRepository extends JpaRepository<RestaurantGrade, Integer> {


    @Transactional
    @Query(value = "SELECT AVG(rg.grade) FROM restaurants_grade rg WHERE rg.id_restaurants = :restaurantId", nativeQuery = true)
    Double countRestaurantGrade(@Param("restaurantId") Integer restaurantId);
}
