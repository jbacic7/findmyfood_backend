package foodfinder.repository;


import foodfinder.dto.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;


public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    Restaurant findRestaurantByRestaurantId(Integer restaurantId);

    List<Restaurant> findRestaurantsByName(String name);

    List<Restaurant> findRestaurantsByAddress(String address);

    List<Restaurant> findRestaurantsByType(String type );

    Restaurant findRestaurantByLatitude(Float latitude);

    Restaurant findRestaurantByLongitude(Float longitude);

    List<Restaurant> findRestaurantsByTypeIn(List<String> typeList);

    @Transactional
    @Query(value = "SELECT res.* FROM restaurants res, user_favorite_restaurant ufr WHERE res.restaurant_id = ufr.id_restaurants AND ufr.user_id = :userId", nativeQuery = true)
    List<Restaurant> findFavoriteRestaurantByUserId(Integer userId);




}
