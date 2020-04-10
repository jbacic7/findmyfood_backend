package foodfinder.services.impl;

import foodfinder.dto.FavoriteRestaurant;
import foodfinder.dto.Restaurant;
import foodfinder.repository.FavoriteRestaurantRepository;
import foodfinder.repository.RestaurantRepository;
import foodfinder.services.interfaces.FavoriteRestaurantServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FavoriteRestaurantImpl implements FavoriteRestaurantServices {

    @Autowired
    FavoriteRestaurantRepository favoriteRestaurantRepository;

    @Autowired
    RestaurantRepository restaurantRepository;


    @Override
    public FavoriteRestaurant saveFavoriteRestaurant(FavoriteRestaurant favoriteRestaurant) {

        if (favoriteRestaurant.getUserId() > 0) {

            FavoriteRestaurant favoriteRestaurantForSpecificUser = favoriteRestaurantRepository.save(favoriteRestaurant);

            return favoriteRestaurantForSpecificUser;

        }
        return null;
    }


}

