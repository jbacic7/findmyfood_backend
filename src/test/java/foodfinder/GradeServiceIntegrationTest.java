package foodfinder;

import foodfinder.dto.RestaurantGrade;
import foodfinder.dto.User;
import foodfinder.repository.GradeRepository;
import foodfinder.repository.UserRepository;
import foodfinder.services.impl.GradesServicesImpl;
import foodfinder.services.impl.UserServiceImpl;
import foodfinder.services.interfaces.GradesServices;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.engine.script.Script;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
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

    private RestaurantGrade restaurantGrade;

    private User user;

    @Before
    public void setUp(){
        user =  userService.createUser(testUser("newUserTest","password","surname","mail@gmail.com"));

        restaurantGrade = restaurantGradeTest(5,user.getUserId(),10);
        System.out.println(user.getUserId());
    }

    @After
    @Sql(scripts = "db/sql-test-scheme/test-delete-user-schema.sql")
    public void after(){
        userService.userDelete(user.getUserId());
        gradeRepository.deleteById(restaurantGrade.getIdGrade());
    }

    @Test

    public void testAverageRestaurantsGrade(){
        gradeRepository.save(restaurantGrade);
        gradeRepository.save(restaurantGrade);

        assertThat(gradesServices.averageRestaurantsGrade(10),is(4.5));

    }

    private RestaurantGrade restaurantGradeTest(Integer grade, Integer userId, Integer restaurantId){
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
        //user.setUserId(userId);

        return user;
    }
}
