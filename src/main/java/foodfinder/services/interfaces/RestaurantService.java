package foodfinder.services.interfaces;



import foodfinder.dto.RestaurantDTO;

import java.util.List;

public interface RestaurantService {

    List<RestaurantDTO> fetchRestaurantByNameAndType(final String restaurantName, final List<String> restaurantTypeList);

    RestaurantDTO fetchRestaurantId(Integer restaurantId);

    List<RestaurantDTO> fetchFavoriteRestaurantByUserId(Integer userId);
}
