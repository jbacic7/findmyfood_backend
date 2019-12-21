package foodfinder.repository;

import foodfinder.dto.RestaurantGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GradeRepository extends JpaRepository<RestaurantGrade, Integer> {


//   List<RestaurantGrade> findRestaurantGradesByIdRestaurants(  );


}
