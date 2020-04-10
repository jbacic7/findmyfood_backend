package foodfinder.repository;

import foodfinder.dto.FavoriteRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRestaurantRepository extends JpaRepository<FavoriteRestaurant, Integer> {


    FavoriteRestaurant findFavoriteRestaurantByFavoriteId(Integer favoriteId);

    List<FavoriteRestaurant> findFavoriteRestaurantByRestaurantsId(Integer restaurantsId);

}
