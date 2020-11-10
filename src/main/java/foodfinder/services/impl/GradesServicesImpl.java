package foodfinder.services.impl;

import foodfinder.dto.RestaurantGradeDTO;
import foodfinder.repository.GradeRepository;
import foodfinder.services.interfaces.GradesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
public class GradesServicesImpl implements GradesServices {

    @Autowired
    GradeRepository gradeRepository;


    @Override
    public void createRestaurantsGrade(RestaurantGradeDTO restaurantGrade) {

        gradeRepository.save(restaurantGrade);

    }

    public Double averageRestaurantsGrade(Integer restaurantId) {

        return gradeRepository.countRestaurantAvgGrade(restaurantId);

    }


    public List<Integer> findListOfGradesForRestaurantByRestaurantId(Integer idRestaurants){

        if(idRestaurants > 0){

            List<RestaurantGradeDTO> listOfGradesForRestaurant =  gradeRepository.findRestaurantGradesByIdRestaurants(idRestaurants);

            List<Integer> listOfGrades = new ArrayList<>();

            for (RestaurantGradeDTO restaurantGrade : listOfGradesForRestaurant){

                listOfGrades.add(restaurantGrade.getGrade());

            }
            return listOfGrades;
        }

        return Collections.<Integer>emptyList();
    }
}
