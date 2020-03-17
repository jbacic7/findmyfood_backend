package foodfinder;

import foodfinder.dto.FavoriteRestaurant;
import foodfinder.dto.Restaurant;
import foodfinder.repository.FavoriteRestaurantRepository;
import foodfinder.repository.RestaurantRepository;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FavoriteRestaurantRepositoryTest {

    @Autowired
    FavoriteRestaurantRepository favoriteRestaurantRepository;

    @Test
    public void saveFavoriteRestaurantTest() {

        FavoriteRestaurant favoriteRestaurant = new FavoriteRestaurant();

        favoriteRestaurant.setUserId(4);

        favoriteRestaurant.setRestaurantsId(27);

        FavoriteRestaurant savingFavoriteRestaurantValue = favoriteRestaurantRepository.save(favoriteRestaurant);

        Integer checkSpecificUserId = 4;

        Assert.assertSame(savingFavoriteRestaurantValue.getUserId(), checkSpecificUserId);

    }


}
