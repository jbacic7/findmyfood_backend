package foodfinder;


import foodfinder.dto.Restaurant;
import foodfinder.services.interfaces.RestaurantService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RestaurantServiceTest {

    @Autowired
    RestaurantService restaurantService;

    @Test
    public void checkIfListOfRestaurantsIsBiggerThenOne() {

        List<Restaurant> restaurantNameGetter = restaurantService.fetchAllRestaurantValues(null, null);

        Assert.assertTrue(restaurantNameGetter.size() > 1);

    }

    @Test
    public void checkIsRestaurantNameIsEmpty() {

        String restaurantName = "Sofra";

        List<Restaurant> restaurantNameGetter = restaurantService.fetchAllRestaurantValues(restaurantName, null);

        for (Restaurant restaurant : restaurantNameGetter) {

            Assert.assertEquals(restaurant.getName(), restaurantName);

        }
    }

    @Test
    public void checkIfRestaurantTypeListIsTwo() {

        List<String> typeList = new ArrayList<>();
        typeList.add("grill");
        typeList.add("market");

        List<Restaurant> restaurantList = restaurantService.fetchAllRestaurantValues(null, typeList);

        Assert.assertTrue(restaurantList.size() == 2);
    }

    @Test
    public void checkIfRestaurantTypeListIsOne() {

        List<String> typeList = new ArrayList<>();
        typeList.add("grill");

        List<Restaurant> restaurantList = restaurantService.fetchAllRestaurantValues(null, typeList);

        for (Restaurant restaurant : restaurantList) {

            Assert.assertTrue(restaurant.getType().equals("grill"));
        }

    }

    @Test
    public void checkRestaurantId() {

        Restaurant restaurant = restaurantService.FetchRestaurantId(1);

        Assert.assertEquals(1, restaurant.getRestaurantId().intValue());

    }

    @Test
    public void checkIsRestaurantIdNull() {

        Restaurant restaurantNull = restaurantService.FetchRestaurantId(0);

        Assert.assertEquals(null, restaurantNull);

    }

}



