package foodfinder;

import foodfinder.dto.History;
import foodfinder.dto.Restaurant;
import foodfinder.dto.User;
import foodfinder.repository.HistoryRepository;
import foodfinder.repository.RestaurantRepository;
import foodfinder.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatabaseTest {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void checkingIsRestaurantFilled() {

        List<Restaurant> restaurant = restaurantRepository.findAll();

        Assert.assertNotNull(restaurant);
    }

    @Test
    public  void checkingIsHistoryFilled(){

        List<History> history = historyRepository.findAll();

        Assert.assertNotNull(history);

    }
    @Test
    public void checkingIsUserFilled(){

        List<User> user = userRepository.findAll();

        Assert.assertNotNull(user);

    }

    @Test
    public void checkRestaurantName(){


        Restaurant restaurantName = restaurantRepository.findRestaurantByName("Sofra");

        String nameExpected = "Sofra";

        Assert.assertEquals( nameExpected, restaurantName.getName());

    }


}
