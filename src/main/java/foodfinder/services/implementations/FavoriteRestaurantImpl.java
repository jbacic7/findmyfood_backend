package foodfinder.services.implementations;

import foodfinder.dto.FavoriteRestaurant;
import foodfinder.repository.FavoriteRestaurantRepository;
import foodfinder.services.interfaces.FavoriteRestaurantServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FavoriteRestaurantImpl implements FavoriteRestaurantServices {

    @Autowired
    FavoriteRestaurantRepository favoriteRestaurantRepository;


    FavoriteRestaurant favoriteRestaurant;

    @Override
    public FavoriteRestaurant saveFavoriteRestaurant(FavoriteRestaurant favoriteRestaurant) {

        if (favoriteRestaurant.getUserId() > 0) {

            favoriteRestaurant.setUserId(favoriteRestaurant.getUserId());

            FavoriteRestaurant favoriteRestaurantForSpecificUser = favoriteRestaurantRepository.save(favoriteRestaurant);

            return favoriteRestaurantForSpecificUser;

        }
        return null;
    }
@Override
    public List<Integer> fetchFavoriteRestaurant(Integer user_id) {

        if (user_id >= 1) {

            List<Integer> listOfFavoriteRestaurantsFromUser = favoriteRestaurantRepository.findFavoriteRestaurantByUserId(user_id);


            return listOfFavoriteRestaurantsFromUser;
        }

        return null;

    }
}

