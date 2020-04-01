package foodfinder;


import foodfinder.dto.RestaurantGrade;
import foodfinder.repository.GradeRepository;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GradeRepositoryTest {

    Random random = new Random();

    @Autowired
    GradeRepository gradeRepository;

    private RestaurantGrade restaurantGradeTest(Integer grade, Integer userId, Integer restaurantId){
        RestaurantGrade restaurantGrade = new RestaurantGrade();
        restaurantGrade.setGrade(grade);
        restaurantGrade.setIdUser(userId);
        restaurantGrade.setIdRestaurants(restaurantId);

        return restaurantGrade;
    }

    @Test
    public void createRestaurantsGradeTest() {

        RestaurantGrade savingRestaurantGrade = gradeRepository.save(restaurantGradeTest(random.nextInt(5),4,random.nextInt(30)));

        Assert.assertNotNull(savingRestaurantGrade);

    }

    @Test
    public void restaurantGradeSaveTest() {

        RestaurantGrade savingRestaurantGrade = gradeRepository.save(restaurantGradeTest(5,1,10));

        Integer newGrade = savingRestaurantGrade.getGrade();

        Assert.assertSame(newGrade, savingRestaurantGrade.getGrade());

    }
    @Test
    public void integrationTestOfAverageRestaurantsGrade(){



    }


}
