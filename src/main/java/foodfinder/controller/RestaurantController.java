package foodfinder.controller;


import foodfinder.dto.*;
import foodfinder.repository.RestaurantRepository;
import foodfinder.services.interfaces.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@Validated
public class RestaurantController {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    RestaurantService restaurantService;

    @Autowired
    FavoriteRestaurantServices favoriteRestaurantServices;

    @Autowired
    GradesServices gradesServices;

    @Autowired
    UserCommentsService userCommentsService;


    @Autowired
    TypeService typeService;

    @RequestMapping(value = "/type", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<Type> getAllTypes() {

        return typeService.fetchTypeList();

    }

    @RequestMapping(value = "/restaurants", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<Restaurant> getRestaurants(@RequestParam(required = false, name = "name") String restaurantName, @RequestParam(required = false, name = "type") List<String> restaurantTypeList) {

        return restaurantService.fetchRestaurantValues(restaurantName, restaurantTypeList);

    }

    @RequestMapping(value = "/restaurants/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")

    public Restaurant getRestaurantsId(
            @PathVariable(value = "id") final Integer restaurantId) {

        return restaurantService.fetchRestaurantId(restaurantId);

    }

    @RequestMapping(value = "/favoriteRestaurant", method = RequestMethod.POST, produces = "application/json;charset=UTF-8", consumes = "application/json;")
    public @ResponseBody
    FavoriteRestaurant saveFavoriteRestaurantToSpecificUser(@RequestBody FavoriteRestaurant favoriteRestaurant) {

        return favoriteRestaurantServices.saveFavoriteRestaurant(favoriteRestaurant);

    }

    @RequestMapping(value = "/favoriteRestaurant/{user_id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")

    public List<Integer> getUserFavoriteRestaurant(
            @PathVariable(value = "user_id") final Integer user_id) {

        return favoriteRestaurantServices.fetchFavoriteRestaurant(user_id);

    }

    @RequestMapping(value = "/grade", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8", consumes = "application/json;")
    public @ResponseBody
    void updateUserMail(@RequestBody RestaurantGrade restaurantGrade) {

        gradesServices.createRestaurantsGrade(restaurantGrade);

    }

    @RequestMapping(value = "/grades/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")

    public Restaurant getRestaurantsGrade(
            @PathVariable(value = "id") final Integer restaurantId) {

        return restaurantService.fetchRestaurantId(restaurantId);

    }

    @RequestMapping(value = "/averageGrade/{restaurant_id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8 ")
    public Double getAverageRestaurantGrade(@PathVariable(value = "restaurant_id") final Integer restaurantId) {

        return gradesServices.averageRestaurantsGrade(restaurantId);

    }

    @RequestMapping(value = "/user_comment", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    UserComment saveUserCommentaryForSpecificRestaurant(@RequestBody UserComment userComment) {

        return userCommentsService.saveUserComments(userComment);
    }

    @RequestMapping(value = "/fetchUserCommentForSpecificRestaurant/{restaurant_id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<UserComment> getRestaurantCommentByRestaurantId(
            @PathVariable(value = "restaurant_id") final Integer restaurantId) {

        return userCommentsService.fetchUserCommentsForRestaurant(restaurantId);

    }


}
