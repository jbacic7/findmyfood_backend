package foodfinder;

import foodfinder.dto.FavoriteRestaurantDTO;
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


    FavoriteRestaurantDTO favoriteRestaurantDTO;

    @Autowired
    TestData testData;


    @Before
    public void setUp() {

        favoriteRestaurantDTO = favoriteRestaurantRepository.save(testData.favoriteRestaurantTestData(3, 1, 26));

    }

    @After
    public void after() {

        favoriteRestaurantRepository.delete(favoriteRestaurantDTO);
    }

    @Test
    public void saveFavoriteRestaurantTest() {

        Assert.assertSame(1,favoriteRestaurantDTO.getUserId() );

    }

}
