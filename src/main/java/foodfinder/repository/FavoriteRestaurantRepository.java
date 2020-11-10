package foodfinder.repository;

import foodfinder.dto.FavoriteRestaurantDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRestaurantRepository extends JpaRepository<FavoriteRestaurantDTO, Integer> {


    FavoriteRestaurantDTO findFavoriteRestaurantByFavoriteId(Integer favoriteId);

    List<FavoriteRestaurantDTO> findFavoriteRestaurantByRestaurantsId(Integer restaurantsId);

}
