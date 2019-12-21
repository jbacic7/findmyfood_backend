package foodfinder.services.implementations;

import foodfinder.dto.RestaurantGrade;
import foodfinder.repository.GradeRepository;
import foodfinder.services.interfaces.GradesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class GradesServicesImpl implements GradesServices {

    @Autowired
    GradeRepository gradeRepository;

   @Override
   public void createRestaurantsGrade(RestaurantGrade restaurantGrade ) {

       restaurantGrade.setGrade((restaurantGrade.getGrade()));

        saveRestaurantGradeInDb(restaurantGrade );

   }

    private void saveRestaurantGradeInDb(RestaurantGrade restaurantGrade) {

      gradeRepository.save(restaurantGrade);

    }

}
