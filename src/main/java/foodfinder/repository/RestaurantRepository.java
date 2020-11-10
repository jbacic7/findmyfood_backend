package foodfinder.repository;


import foodfinder.dto.RestaurantDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;


public interface RestaurantRepository extends JpaRepository<RestaurantDTO, Integer> {

    RestaurantDTO findRestaurantByRestaurantId(Integer restaurantId);

    List<RestaurantDTO> findRestaurantsByName(String name);

    List<RestaurantDTO> findRestaurantsByAddress(String address);

    List<RestaurantDTO> findRestaurantsByType(String type );

    RestaurantDTO findRestaurantByLatitude(Float latitude);

    RestaurantDTO findRestaurantByLongitude(Float longitude);

    List<RestaurantDTO> findRestaurantsByTypeIn(List<String> typeList);

    @Transactional
    @Query(value = "SELECT res.* FROM restaurants res, user_favorite_restaurant ufr WHERE res.restaurant_id = ufr.id_restaurants AND ufr.user_id = :userId", nativeQuery = true)
    List<RestaurantDTO> findFavoriteRestaurantByUserId(Integer userId);




}
