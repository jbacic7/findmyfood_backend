package foodfinder.controller;

import foodfinder.dto.Restaurant;
import foodfinder.repository.RestaurantRepository;
import foodfinder.services.interfaces.RestaurantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@Validated
public class FoodFinderController {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    RestaurantService restaurantService;


    @RequestMapping(value = "/restaurants", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<Restaurant> getRestaurants(@RequestParam(required = false, name = "name") String restaurantName, @RequestParam(required = false, name = "type") List<String> restaurantTypeList) {

        return restaurantService.fetchRestaurantValues(restaurantName, restaurantTypeList);

    }

    @CrossOrigin
    @RequestMapping(value = "/restaurants/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")

    public Restaurant getRestaurantsId(
            @PathVariable(value = "id") final Integer restaurantId) {

        return restaurantService.fetchRestaurantId(restaurantId);

    }
}




