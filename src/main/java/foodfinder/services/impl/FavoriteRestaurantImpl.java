package foodfinder.services.impl;

import foodfinder.dto.FavoriteRestaurantDTO;
import foodfinder.repository.FavoriteRestaurantRepository;
import foodfinder.repository.RestaurantRepository;
import foodfinder.services.interfaces.FavoriteRestaurantServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FavoriteRestaurantImpl implements FavoriteRestaurantServices {

    @Autowired
    FavoriteRestaurantRepository favoriteRestaurantRepository;

    @Autowired
    RestaurantRepository restaurantRepository;


    @Override
    public FavoriteRestaurantDTO saveFavoriteRestaurant(FavoriteRestaurantDTO favoriteRestaurantDTO) {

        if (favoriteRestaurantDTO.getUserId() > 0) {

            return favoriteRestaurantRepository.save(favoriteRestaurantDTO);

        }

        return null;

    }


}

