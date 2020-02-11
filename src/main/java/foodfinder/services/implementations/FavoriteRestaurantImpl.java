package foodfinder.services.implementations;

import foodfinder.dto.FavoriteRestaurant;
import foodfinder.repository.FavoriteRestaurantRepository;
import foodfinder.services.interfaces.FavoriteRestaurantServices;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log
@Service
public class FavoriteRestaurantImpl implements FavoriteRestaurantServices {


    @Autowired
    FavoriteRestaurantRepository favoriteRestaurantRepository;

    @Override
    public FavoriteRestaurant saveFavoriteRestaurant(FavoriteRestaurant favoriteRestaurant) {

        if (favoriteRestaurant.getUserId() > 0) {

            favoriteRestaurant.setUserId(favoriteRestaurant.getUserId());

            FavoriteRestaurant listOfFavoriteRestaurantForSpecificUser =  favoriteRestaurantRepository.save(favoriteRestaurant);

            return listOfFavoriteRestaurantForSpecificUser;

        }

        return null;


    }


}
