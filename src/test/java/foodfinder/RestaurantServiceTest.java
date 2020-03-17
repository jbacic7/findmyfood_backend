package foodfinder;


import foodfinder.dto.Restaurant;
import foodfinder.repository.RestaurantRepository;
import foodfinder.services.interfaces.RestaurantService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
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
    public void fetchRestaurantIdTest() {

        Restaurant restaurant = restaurantService.fetchRestaurantId(1);

        Assert.assertEquals(1, restaurant.getRestaurantId().intValue());

    }

    @Test
    public void fetchRestaurantIdNullValueTest() {

        Restaurant restaurantNull = restaurantService.fetchRestaurantId(0);

        Assert.assertEquals(null, restaurantNull);

    }


}



