package foodfinder.repository;


import foodfinder.dto.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, String> {

    Restaurant findRestaurantByRestaurantId(Integer restaurant_id);
    List<Restaurant> findRestaurantsByName (String name);
    List<Restaurant> findRestaurantsByAddress(String address);
    List<Restaurant> findRestaurantsByType(String type);
    Restaurant findRestaurantByLatitude(Float latitude);
    Restaurant findRestaurantByLongitude(Float longitude);


}
