package foodfinder;

import foodfinder.services.interfaces.GradesServices;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Ignore
public class GradeServiceTest {

    @Autowired
    GradesServices gradesServices;

    @Test
    public void averageRestaurantsGradeTest() {

        Integer restaurantId = 11;

        Double trueResult = 2.75;

        Double restaurantGrade = gradesServices.averageRestaurantsGrade(restaurantId);

        Assert.assertEquals(trueResult, restaurantGrade);

    }
}
