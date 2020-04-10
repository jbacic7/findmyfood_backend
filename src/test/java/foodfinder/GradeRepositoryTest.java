package foodfinder;


import foodfinder.dto.RestaurantGrade;
import foodfinder.repository.GradeRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
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

    @Autowired
    TestData testData;

    RestaurantGrade restaurantGrade;

    RestaurantGrade savingRestaurantGrade;


    @Before
    public void setUp() {

        restaurantGrade = gradeRepository.save(testData.restaurantGradeTestData(random.nextInt(5), 4, random.nextInt(30)));

        savingRestaurantGrade = gradeRepository.save(testData.restaurantGradeTestData(5, 1, 10));
    }

    @After
    public void after() {

        gradeRepository.delete(restaurantGrade);

        gradeRepository.delete(savingRestaurantGrade);
    }

    @Test
    public void createRestaurantsGradeTest() {

        Assert.assertNotNull(restaurantGrade);

    }

    @Test
    public void restaurantGradeSaveTest() {

        Integer newGrade = savingRestaurantGrade.getGrade();

        Assert.assertSame(newGrade, savingRestaurantGrade.getGrade());

    }


}
