package foodfinder.repository;

import foodfinder.dto.FavoriteRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface FavoriteRestaurantRepository extends JpaRepository<FavoriteRestaurant, Integer> {


    FavoriteRestaurant findFavoriteRestaurantByFavoriteId(Integer favoriteId);
    List<FavoriteRestaurant> findFavoriteRestaurantByRestaurantsId(Integer restaurantsId);

    @Transactional
    @Query(value = "SELECT (fr.id_favorite) FROM  user_favorite_restaurant fr WHERE fr.user_id = :userId", nativeQuery = true)
    List<Integer> findFavoriteRestaurantByUserId(@Param("userId") Integer userId);
}
