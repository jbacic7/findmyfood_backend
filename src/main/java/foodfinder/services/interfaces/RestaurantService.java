package foodfinder.services.interfaces;


import foodfinder.dto.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RestaurantService {

    List<Restaurant> fetchRestaurantValues(final String restaurantName , final List<String> restaurantTypeList);

    Restaurant fetchRestaurantId(Integer restaurantId);
}
