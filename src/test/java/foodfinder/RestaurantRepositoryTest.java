package foodfinder;

import foodfinder.dto.Restaurant;
import foodfinder.repository.RestaurantRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
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
    TestData testData;

    @Autowired
    RestaurantRepository restaurantRepository;

    Restaurant restaurantOne;

    Restaurant restaurantsTwo;

    @Before
    public void setUp() {

        restaurantOne = restaurantRepository.save(testData.restaurantTestData(99, "market", 3f, 4f, "Name", "Address"));
        restaurantsTwo = restaurantRepository.save(testData.restaurantTestData(10, "kineska kuhinja", 16.003496f, 45.802265f, "Mr. Chen", "Ul. grada Vukovara 269D, 10000, Zagreb"));
    }

    @After
    public void after() {

        restaurantRepository.delete(restaurantOne);
    }


    @Test
    public void checkingIsRestaurantFilled() {

        List<Restaurant> restaurant = restaurantRepository.findAll();

        Assert.assertNotNull(restaurant);
    }

    @Test
    public void checkRestaurantName() {

        List<Restaurant> restaurantName = restaurantRepository.findRestaurantsByName("Name");

        for (Restaurant restaurants : restaurantName) {

            Assert.assertEquals(restaurants.getName(), restaurantOne.getName());
        }

    }

    @Test
    public void fetchFavoriteRestaurantTest() {

        List<Restaurant> userFavoriteRestaurantList = restaurantRepository.findFavoriteRestaurantByUserId(3);

        Assert.assertNotNull(userFavoriteRestaurantList);

    }

    @Test
    public void fetchRestaurantByTypeTest() {

        List<Restaurant> restaurantTargetType = restaurantRepository.findRestaurantsByType("kineska kuhinja");

        Assert.assertEquals(restaurantsTwo.getType(), restaurantTargetType.get(0).getType());

    }

}
