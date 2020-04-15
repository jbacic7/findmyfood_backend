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
    RestaurantTypeService restaurantTypeService;

    @RequestMapping(value = "/type", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<RestaurantType> getAllTypes() {

        return restaurantTypeService.fetchTypeList();

    }

    @RequestMapping(value = "/restaurants", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<Restaurant> getRestaurants(@RequestParam(required = false, name = "name") String restaurantName, @RequestParam(required = false, name = "type") List<String> restaurantTypeList) {

        return restaurantService.fetchRestaurantByNameAndType(restaurantName, restaurantTypeList);

    }

    @RequestMapping(value = "/restaurants/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")

    public Restaurant getRestaurantsId(
            @PathVariable(value = "id") final Integer restaurantId) {

        return restaurantService.fetchRestaurantId(restaurantId);

    }

    @RequestMapping(value = "/favorite-restaurant", method = RequestMethod.POST, produces = "application/json;charset=UTF-8", consumes = "application/json;")
    public @ResponseBody
    FavoriteRestaurant saveFavoriteRestaurantToSpecificUser(@RequestBody FavoriteRestaurant favoriteRestaurant) {

        return favoriteRestaurantServices.saveFavoriteRestaurant(favoriteRestaurant);

    }

    @RequestMapping(value = "/favorite-restaurant/{user_id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")

    public List<Restaurant> getUserFavoriteRestaurant(
            @PathVariable(value = "user_id") final Integer userId) {

        return restaurantService.fetchFavoriteRestaurantByUserId(userId);

    }

    @RequestMapping(value = "/grade", method = RequestMethod.POST, produces = "application/json;charset=UTF-8", consumes = "application/json;")
    public @ResponseBody
    void createRestaurantGrade(@RequestBody RestaurantGrade restaurantGrade) {

        gradesServices.createRestaurantsGrade(restaurantGrade);

    }

    @RequestMapping(value = "/restaurant-grades/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<Integer> getRestaurantsGradeByRestaurantId(
            @PathVariable(value = "id") final Integer restaurantId) {

        return gradesServices.findListOfGradesForRestaurantByRestaurantId(restaurantId);

    }

    @RequestMapping(value = "/averageGrade/{restaurant_id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8 ")
    public Double getAverageRestaurantGrade(@PathVariable(value = "restaurant_id") final Integer restaurantId) {

        return gradesServices.averageRestaurantsGrade(restaurantId);

    }

    @RequestMapping(value = "/user-comment", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    UserComment saveUserCommentaryForSpecificRestaurant(@RequestBody UserComment userComment) {

        return userCommentsService.createUserComments(userComment);
    }

    @RequestMapping(value = "/fetchUserCommentForSpecificRestaurant/{restaurant_id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<UserComment> getRestaurantCommentByRestaurantId(
            @PathVariable(value = "restaurant_id") final Integer restaurantId) {

        return userCommentsService.fetchUserCommentsByRestaurantId(restaurantId);

    }

}
