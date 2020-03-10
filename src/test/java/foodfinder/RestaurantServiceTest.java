package foodfinder;


import foodfinder.dto.Restaurant;
import foodfinder.repository.RestaurantRepository;
import foodfinder.services.interfaces.RestaurantService;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class RestaurantServiceTest {

    @Autowired
    RestaurantService restaurantService;

    @Autowired
    RestaurantRepository restaurantRepository;

    @Test
    public void fetchAllRestaurantValuesTest() {

        List<Restaurant> restaurantNameGetter = restaurantService.fetchRestaurantByNameAndType(null, null);

        Assert.assertTrue(restaurantNameGetter.size() > 1);

    }

    @Test
    public void fetchRestaurantValuesByNameTest() {

        String restaurantName = "Sofra";

        List<Restaurant> restaurantNameGetter = restaurantService.fetchRestaurantByNameAndType(restaurantName, null);

        for (Restaurant restaurant : restaurantNameGetter) {

            Assert.assertEquals(restaurant.getName(), restaurantName);

        }
    }

    @Test
    public void fetchRestaurantValuesByTwoTypeTest() {

        List<String> typeList = new ArrayList<>();
        typeList.add("grill");
        typeList.add("market");
        List<Restaurant> restaurantList = restaurantService.fetchRestaurantByNameAndType(null, typeList);

        Assert.assertTrue(restaurantList.size() == 2);
    }

    @Test
    public void fetchRestaurantValuesByOneTypeTest() {

        List<String> typeList = new ArrayList<>();
        typeList.add("grill");

        List<Restaurant> restaurantList = restaurantService.fetchRestaurantByNameAndType(null, typeList);

        for (Restaurant restaurant : restaurantList) {

            Assert.assertTrue(restaurant.getType().equals("grill"));
        }

    }

    @Test
    public void fetchRestaurantIdTest() {

        Restaurant restaurant = restaurantService.fetchRestaurantId(1);

        Assert.assertEquals(1, restaurant.getRestaurantId().intValue());

    }

    @Test
    public void fetchRestaurantIdNullValueTest() {

        Restaurant restaurantNull = restaurantService.fetchRestaurantId(0);

        Assert.assertEquals(null, restaurantNull);

    }

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
}



