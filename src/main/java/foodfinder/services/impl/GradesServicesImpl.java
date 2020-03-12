package foodfinder.services.impl;

import foodfinder.dto.Restaurant;
import foodfinder.dto.RestaurantGrade;
import foodfinder.repository.GradeRepository;
import foodfinder.services.interfaces.GradesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
public class GradesServicesImpl implements GradesServices {

    @Autowired
    GradeRepository gradeRepository;


    @Override
    public void createRestaurantsGrade(RestaurantGrade restaurantGrade) {

        gradeRepository.save(restaurantGrade);

    }

    public Double averageRestaurantsGrade(Integer restaurantId) {

        return gradeRepository.countRestaurantGrade(restaurantId);

    }


    public List<Integer> findListOfGradesForRestaurantByRestaurantId(Integer idRestaurants){

        if(idRestaurants > 0){

            List<RestaurantGrade> listOfGradesForRestaurant =  gradeRepository.findRestaurantGradesByIdRestaurants(idRestaurants);

            List<Integer> listOfGrades = new ArrayList<>();

            for (RestaurantGrade restaurantGrade : listOfGradesForRestaurant){

                listOfGrades.add(restaurantGrade.getGrade());

            }
            return listOfGrades;
        }

        return null;
    }
}
