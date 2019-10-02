package foodfinder.repository;

import foodfinder.dto.History;
import foodfinder.dto.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, String> {

    List<Restaurant> findRestaurantByRestaurantId(Integer restaurant_id);
    List<Restaurant> findRestaurantByName (String name);
    List<Restaurant> findRestaurantByAddress(String address);
    List<Restaurant> findRestaurantByType(String type);
    List<Restaurant> findRestaurantByLatitude(Float latitude);
    List<Restaurant> findRestaurantByLongitude(Float longitude);

}
