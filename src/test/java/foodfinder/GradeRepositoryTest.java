package foodfinder;


import foodfinder.dto.RestaurantGrade;
import foodfinder.repository.GradeRepository;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GradeRepositoryTest {

    Random random = new Random();

    @Autowired
    GradeRepository gradeRepository;

    @Test
    public void createRestaurantsGradeTest() {

        RestaurantGrade restaurantGrade = new RestaurantGrade();

        restaurantGrade.setIdRestaurants(random.nextInt(30));

        restaurantGrade.setGrade(random.nextInt(5));

        restaurantGrade.setIdUser(4);

        RestaurantGrade savingRestaurantGrade = gradeRepository.save(restaurantGrade);

        Assert.assertNotNull(savingRestaurantGrade);

    }

    @Test
    public void restaurantGradeSaveTest() {

        RestaurantGrade restaurantGrade = new RestaurantGrade();

        restaurantGrade.setIdRestaurants(10);

        restaurantGrade.setGrade(5);

        restaurantGrade.setIdUser(1);

        RestaurantGrade savingRestaurantGrade = gradeRepository.save(restaurantGrade);

        Integer newGrade = restaurantGrade.getGrade().intValue();

        Assert.assertSame(newGrade.intValue(), savingRestaurantGrade.getGrade().intValue());

    }


}
