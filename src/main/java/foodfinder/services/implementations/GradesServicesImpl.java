package foodfinder.services.implementations;

import foodfinder.dto.RestaurantGrade;
import foodfinder.repository.GradeRepository;
import foodfinder.services.interfaces.GradesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;


@Service
public class GradesServicesImpl implements GradesServices {

    @Autowired
    GradeRepository gradeRepository;
    @Autowired
    EntityManager entityManager;

    @Override
    public void createRestaurantsGrade(RestaurantGrade restaurantGrade) {

        restaurantGrade.setGrade((restaurantGrade.getGrade()));

        saveRestaurantGradeInDb(restaurantGrade);

    }

    public Double averageRestaurantsGrade(Integer restaurantId) {

        return gradeRepository.countRestaurantGrade(restaurantId);

    }

    public Double avgRestaurantGradeCount(Integer grade, Integer idRestaurants){

    if(gradeRepository.countRestaurantGrade(grade.intValue()) == null){


    }

        return null;
    }

    private void saveRestaurantGradeInDb(RestaurantGrade restaurantGrade) {

        gradeRepository.save(restaurantGrade);

    }


}
