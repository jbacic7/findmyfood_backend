package foodfinder.repository;

import foodfinder.dto.FavoriteRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface FavoriteRestaurantRepository extends JpaRepository<FavoriteRestaurant, Integer> {


    FavoriteRestaurant findFavoriteRestaurantByFavoriteId(Integer favoriteId);
    List<FavoriteRestaurant> findFavoriteRestaurantByUserId(Integer userId);
    List<FavoriteRestaurant> findFavoriteRestaurantByRestaurantsId(Integer restaurantsId);


}
