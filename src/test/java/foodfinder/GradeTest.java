package foodfinder;


import foodfinder.dto.Restaurant;
import foodfinder.dto.RestaurantGrade;
import foodfinder.repository.GradeRepository;
import foodfinder.services.implementations.GradesServicesImpl;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Random;

@SpringBootTest
@RunWith(SpringRunner.class)
@Ignore
public class GradeTest {

    Random random = new Random();

    @Autowired
    GradesServicesImpl gradesServicesImpl;

    @Autowired
    RestaurantGrade restaurantGrade;

    @Autowired
    GradeRepository gradeRepository;

    @Test
    public void testIsThisAverageGrade() {

        Integer restaurantId = 11;

        Double trueResult = 2.75;

        Double restaurantGrade = gradesServicesImpl.averageRestaurantsGrade(restaurantId);

        Assert.assertEquals(trueResult, restaurantGrade);

    }

    @Test
    public void createRestaurantsGradeTest() {

        restaurantGrade.setIdRestaurants(random.nextInt(30));

        restaurantGrade.setGrade(random.nextInt(5));

        restaurantGrade.setIdUser(random.nextInt(10));

        RestaurantGrade savingRestaurantGrade = gradeRepository.save(restaurantGrade);

        Assert.assertNotNull(savingRestaurantGrade);

    }

    @Test
    public void isRestaurantGradeSavedTest() {

        restaurantGrade.setIdRestaurants(10);

        restaurantGrade.setGrade(5);

        restaurantGrade.setIdUser(1);

        RestaurantGrade savingRestaurantGrade = gradeRepository.save(restaurantGrade);

        Integer newGrade = restaurantGrade.getGrade().intValue();

        Assert.assertSame(newGrade,savingRestaurantGrade.getGrade().intValue());

    }

}
