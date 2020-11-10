package foodfinder;


import foodfinder.dto.RestaurantDTO;
import foodfinder.repository.RestaurantRepository;
import foodfinder.services.interfaces.RestaurantService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RestaurantServiceTest {

    @Autowired
    RestaurantService restaurantService;

    @Autowired
    RestaurantRepository restaurantRepository;

    RestaurantDTO restaurantOne;

    RestaurantDTO restaurantTwo;

    RestaurantDTO restaurantNull;

    @Autowired
    TestData testData;

    @Before
    public void setUp() {

        restaurantOne = testData.restaurantNameAndTypeTestData(99, "Dubravica", "pekarnica");
        restaurantTwo = testData.restaurantNameAndTypeTestData(98, "Sofra", null);
        restaurantNull = testData.restaurantNameAndTypeTestData(null, null, null);

    }

    @After
    public void after() {

        restaurantRepository.delete(restaurantOne);
        restaurantRepository.delete(restaurantTwo);
        restaurantRepository.delete(restaurantNull);

    }


    @Test
    public void fetchRestaurantByNameAndTypeTest() {

        Assert.assertNotNull(restaurantOne);

    }

    @Test
    public void fetchRestaurantValuesByNameTest() {

        String restaurantName = restaurantTwo.getName();

        RestaurantDTO restaurantNameGetter = restaurantTwo;

        Assert.assertEquals(restaurantNameGetter.getName(), restaurantName);

    }


    @Test
    public void fetchRestaurantIdTest() {

        Integer restaurantOneId = restaurantOne.getRestaurantId();

        Assert.assertEquals(99, restaurantOneId.intValue());

    }

    @Test
    public void fetchRestaurantIdNullValueTest() {

        Integer restaurantIdNull = restaurantNull.getRestaurantId();

        Assert.assertEquals(null, restaurantIdNull);

    }


}



