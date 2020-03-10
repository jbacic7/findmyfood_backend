package foodfinder.services.impl;

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

        gradeRepository.save(restaurantGrade);

    }

    public Double averageRestaurantsGrade(Integer restaurantId) {

        return gradeRepository.countRestaurantGrade(restaurantId);

    }
}