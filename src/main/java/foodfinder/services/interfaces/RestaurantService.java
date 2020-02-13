package foodfinder.services.interfaces;


import foodfinder.dto.Restaurant;


import java.util.List;

public interface RestaurantService {

    List<Restaurant> fetchRestaurantValues(final String restaurantName , final List<String> restaurantTypeList);

    Restaurant fetchRestaurantId(Integer restaurantId);
}
