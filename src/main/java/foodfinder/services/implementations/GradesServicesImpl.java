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

        return entityManager.createQuery("SELECT AVG(grade) FROM RestaurantGrade rg WHERE idRestaurants = ?1", Double.class).setParameter(1, restaurantId).getSingleResult();
    }


    private void saveRestaurantGradeInDb(RestaurantGrade restaurantGrade) {

        gradeRepository.save(restaurantGrade);

    }


}
