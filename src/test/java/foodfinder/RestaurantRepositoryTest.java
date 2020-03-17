package foodfinder;

import foodfinder.dto.Restaurant;
import foodfinder.repository.RestaurantRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestaurantRepositoryTest {


    @Autowired
    RestaurantRepository restaurantRepository;

    @Test
    public void checkingIsRestaurantFilled() {

        List<Restaurant> restaurant = restaurantRepository.findAll();

        Assert.assertNotNull(restaurant);
    }

    @Test
    public void checkRestaurantName() {

        String targetName = "Sofra";

        List<Restaurant> restaurantName = restaurantRepository.findRestaurantsByName("Sofra");

        for (Restaurant restaurant : restaurantName) {

            Assert.assertEquals(restaurant.getName(), targetName);
        }

    }

    @Test
    public void fetchFavoriteRestaurantTest() {

        List<Restaurant> userFavoriteRestaurantList = restaurantRepository.findFavoriteRestaurantByUserId(3);

        Assert.assertNotNull(userFavoriteRestaurantList);

    }

    @Test
    public void fetchRestaurantByTypeTest() {

        String targetTypeOfRestaurant = "kineska kuhinja";

        List<Restaurant> restaurantTargetType = restaurantRepository.findRestaurantsByType(targetTypeOfRestaurant);

        List<Restaurant> mrChenRestaurant = restaurantRepository.findRestaurantsByName("Mr. Chen");

        Assert.assertEquals(mrChenRestaurant, restaurantTargetType);

    }

}
