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

    private RestaurantGrade restaurantGrade;

    private User user;

    private Restaurant restaurant;

    @Before
    public void setUp(){
        user =  userService.createUser(testUser("newUserTest","password","surname","mail@gmail.com"));
        restaurant = restaurantRepository.save(testRestaurant());
        restaurantGrade = testRestaurantGrade(5,user.getUserId(),restaurant.getRestaurantId());

    }

    @After
    public void after(){
        gradeRepository.delete(restaurantGrade);
        restaurantRepository.delete(restaurant);
        userRepository.delete(user);
    }

    @Test
    public void testAverageRestaurantsGrade(){
        gradeRepository.save(restaurantGrade);
        gradeRepository.save(restaurantGrade);

        assertThat(gradesServices.averageRestaurantsGrade(restaurant.getRestaurantId()),is(5.0));

    }

    private RestaurantGrade testRestaurantGrade(Integer grade, Integer userId, Integer restaurantId){
        RestaurantGrade restaurantGrade = new RestaurantGrade();
        restaurantGrade.setGrade(grade);
        restaurantGrade.setIdUser(userId);
        restaurantGrade.setIdRestaurants(restaurantId);

        return restaurantGrade;
    }

    private User testUser(String name, String password, String surname, String mail){
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setSurname(surname);
        user.setMail(mail);


        return user;
    }
    private Restaurant testRestaurant(){
        Restaurant testRestaurant = new Restaurant();
        testRestaurant.setRestaurantId(99999);
        testRestaurant.setType("market");
        testRestaurant.setLongitude(1f);
        testRestaurant.setLatitude(1f);
        testRestaurant.setName("name");
        testRestaurant.setAddress("address");
        return testRestaurant;
    }
}
