package foodfinder.services.interfaces;

import foodfinder.dto.FavoriteRestaurant;

import java.util.List;


public interface FavoriteRestaurantServices {


 FavoriteRestaurant saveFavoriteRestaurant(FavoriteRestaurant favoriteRestaurant);

 List<Integer> fetchFavoriteRestaurant(Integer userId);
}
