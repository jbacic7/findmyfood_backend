package foodfinder;

import foodfinder.dto.FavoriteRestaurant;
import foodfinder.repository.FavoriteRestaurantRepository;
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
//@Ignore
public class FavoriteRestaurantTest {

    @Autowired
    FavoriteRestaurantRepository favoriteRestaurantRepository;

    @Autowired
    FavoriteRestaurant favoriteRestaurant;


    @Test
    public void saveFavoriteRestaurantForSpecificUserTest() {

        favoriteRestaurant.setUserId(4);
        favoriteRestaurant.setRestaurantsId(27);

        FavoriteRestaurant savingFavoriteRestaurantValue = favoriteRestaurantRepository.save(favoriteRestaurant);

        Integer checkSpecificUserId = 4;

        Assert.assertSame(savingFavoriteRestaurantValue.getUserId(), checkSpecificUserId);

    }
    @Test
    public void getFavoriteRestaurantForSpecificUserTest(){

        List<Integer> userFavoriteRestaurantList =  favoriteRestaurantRepository.findFavoriteRestaurantByUserId(3);

        Assert.assertNotNull(userFavoriteRestaurantList);

    }

}
