package foodfinder;

import foodfinder.dto.Restaurant;
import foodfinder.dto.RestaurantGrade;
import foodfinder.dto.User;
import foodfinder.repository.GradeRepository;
import foodfinder.repository.RestaurantRepository;
import foodfinder.repository.UserRepository;
import foodfinder.services.impl.GradesServicesImpl;
import foodfinder.services.impl.UserServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GradeServiceIntegrationTest {

    @Autowired
    private GradesServicesImpl gradesServices;

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private TestData testData;

    private RestaurantGrade restaurantGrade;


    private User user;

    private Restaurant restaurant;

    @Before
    public void setUp() {

        user = userService.createUser(testData.userTestData("ThisIsUserName", "password", "surname", "mailmailic@gmail.com", null));
        restaurant = restaurantRepository.save(testData.restaurantTestData(99, "bosanska kuhinja", 4f, 57f, "imeRestorana", "Radnička cesta 21, 10000, Zagreb"));
        restaurantGrade = testData.restaurantGradeTestData(3, user.getUserId(), restaurant.getRestaurantId());

    }

    @After
    public void after() {

        gradeRepository.delete(restaurantGrade);
        restaurantRepository.delete(restaurant);
        userRepository.delete(user);
    }

    @Test
    public void testAverageRestaurantsGrade() {

        gradeRepository.save(restaurantGrade);

        assertThat(gradesServices.averageRestaurantsGrade(restaurant.getRestaurantId()), is(3.0));

    }

}
