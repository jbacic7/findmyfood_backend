package foodfinder;

import foodfinder.dto.FavoriteRestaurant;
import foodfinder.repository.FavoriteRestaurantRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FavoriteRestaurantRepositoryTest {

    @Autowired
    FavoriteRestaurantRepository favoriteRestaurantRepository;


    FavoriteRestaurant favoriteRestaurant;

    @Autowired
    TestData testData;


    @Before
    public void setUp() {

        favoriteRestaurant = favoriteRestaurantRepository.save(testData.favoriteRestaurantTestData(3, 1, 26));

    }

    @After
    public void after() {

        favoriteRestaurantRepository.delete(favoriteRestaurant);
    }

    @Test
    public void saveFavoriteRestaurantTest() {

        Assert.assertSame(favoriteRestaurant.getUserId(), 1);

    }

}
