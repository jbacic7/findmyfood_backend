package foodfinder.services.implementations;

import foodfinder.dto.Restaurant;
import foodfinder.repository.RestaurantRepository;
import foodfinder.services.interfaces.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {


    @Autowired
    RestaurantRepository restaurantRepository;


    @Override
    public  List<Restaurant> fetchRestaurantValues(String restaurantName, List<String> restaurantTypeList) {

        if (restaurantTypeList == null && (restaurantName == null || restaurantName.isEmpty())) {

            return fetchAllRestaurant();
        }

        if (restaurantName != null && !restaurantName.isEmpty()) {

            return fetchRestaurantByName(restaurantName);
        }

        if (restaurantTypeList != null || !restaurantTypeList.isEmpty()) {

            return fetchRestaurantByType(restaurantTypeList);
        }

        return fetchAllRestaurant();
    }

    public Restaurant fetchRestaurantId(Integer restaurantId) {

        if (restaurantId != 0) {

            return fetchAllRestaurantId(restaurantId);

        }
        return null;
    }

    private List<Restaurant> fetchAllRestaurant() {

        return restaurantRepository.findAll();
    }

    private List<Restaurant> fetchRestaurantByName(String restaurantName) {

        return restaurantRepository.findRestaurantsByName(restaurantName);
    }

    private List<Restaurant> fetchRestaurantByType(List<String> restaurantTypeList) {

        return restaurantRepository.findRestaurantsByTypeIn(restaurantTypeList);
    }

    private Restaurant fetchAllRestaurantId(Integer restaurantId) {

        return restaurantRepository.findRestaurantByRestaurantId(restaurantId);
    }

}
