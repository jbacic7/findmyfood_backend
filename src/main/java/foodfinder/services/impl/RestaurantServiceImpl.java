package foodfinder.services.impl;

import foodfinder.dto.Restaurant;
import foodfinder.repository.RestaurantRepository;
import foodfinder.services.interfaces.RestaurantService;
import liquibase.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {


    @Autowired
    RestaurantRepository restaurantRepository;


    @Override
    public List<Restaurant> fetchRestaurantByNameAndType(String restaurantName, List<String> restaurantTypeList) {

        if (!CollectionUtils.isEmpty(restaurantTypeList) && StringUtils.isNotEmpty(restaurantName)) {

            return restaurantRepository.findAll();
        }

        if (StringUtils.isNotEmpty(restaurantName)) {

            return restaurantRepository.findRestaurantsByName(restaurantName);
        }

        if (CollectionUtils.isEmpty(restaurantTypeList)) {

            return restaurantRepository.findRestaurantsByTypeIn(restaurantTypeList);
        }

        return restaurantRepository.findAll();
    }

    public Restaurant fetchRestaurantId(Integer restaurantId) {

        if (restaurantId != 0) {

            return restaurantRepository.findRestaurantByRestaurantId(restaurantId);

        }
        return null;
    }


}
