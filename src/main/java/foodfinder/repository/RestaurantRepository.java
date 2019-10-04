package foodfinder.repository;

import foodfinder.dto.History;
import foodfinder.dto.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, String> {

    Restaurant findRestaurantByRestaurantId(Integer restaurant_id);
    Restaurant findRestaurantByName (String name);
    Restaurant findRestaurantByAddress(String address);
    Restaurant findRestaurantByType(String type);
    Restaurant findRestaurantByLatitude(Float latitude);
    Restaurant findRestaurantByLongitude(Float longitude);


}
