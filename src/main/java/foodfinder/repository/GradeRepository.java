package foodfinder.repository;

import foodfinder.dto.RestaurantGradeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface GradeRepository extends JpaRepository<RestaurantGradeDTO, Integer> {

    @Transactional
    @Query(value = "SELECT AVG(rg.grade) FROM restaurants_grade rg WHERE rg.id_restaurants = :restaurantId", nativeQuery = true)
    Double countRestaurantAvgGrade(@Param("restaurantId") Integer restaurantId);

    List<RestaurantGradeDTO> findRestaurantGradesByIdRestaurants(Integer idRestaurants);

}
