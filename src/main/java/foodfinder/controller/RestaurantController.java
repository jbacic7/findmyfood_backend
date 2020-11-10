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

    @GetMapping(value = "/type", produces = "application/json;charset=UTF-8")
    public List<RestaurantTypeDTO> getAllTypes() {

        return restaurantTypeService.fetchTypeList();

    }

    @GetMapping(value = "/restaurants", produces = "application/json;charset=UTF-8")
    public List<RestaurantDTO> getRestaurants(@RequestParam(required = false, name = "name") String restaurantName, @RequestParam(required = false, name = "type") List<String> restaurantTypeList) {

        return restaurantService.fetchRestaurantByNameAndType(restaurantName, restaurantTypeList);

    }

    @GetMapping(value = "/restaurants/{id}", produces = "application/json;charset=UTF-8")

    public RestaurantDTO getRestaurantsId(
            @PathVariable(value = "id") final Integer restaurantId) {

        return restaurantService.fetchRestaurantId(restaurantId);

    }

    @PostMapping(value = "/favorite-restaurant", produces = "application/json;charset=UTF-8", consumes = "application/json;")
    public @ResponseBody
    FavoriteRestaurantDTO saveFavoriteRestaurantToSpecificUser(@RequestBody FavoriteRestaurantDTO favoriteRestaurantDTO) {

        return favoriteRestaurantServices.saveFavoriteRestaurant(favoriteRestaurantDTO);

    }

    @GetMapping(value = "/favorite-restaurant/{user_id}", produces = "application/json;charset=UTF-8")

    public List<RestaurantDTO> getUserFavoriteRestaurant(
            @PathVariable(value = "user_id") final Integer userId) {

        return restaurantService.fetchFavoriteRestaurantByUserId(userId);

    }

    @PostMapping(value = "/grade", produces = "application/json;charset=UTF-8", consumes = "application/json;")
    public @ResponseBody
    void createRestaurantGrade(@RequestBody RestaurantGradeDTO restaurantGrade) {

        gradesServices.createRestaurantsGrade(restaurantGrade);

    }

    @GetMapping(value = "/restaurant-grades/{id}", produces = "application/json;charset=UTF-8")
    public List<Integer> getRestaurantsGradeByRestaurantId(
            @PathVariable(value = "id") final Integer restaurantId) {

        return gradesServices.findListOfGradesForRestaurantByRestaurantId(restaurantId);

    }

    @GetMapping(value = "/average-grade/{restaurant_id}", produces = "application/json;charset=UTF-8 ")
    public Double getAverageRestaurantGrade(@PathVariable(value = "restaurant_id") final Integer restaurantId) {

        return gradesServices.averageRestaurantsGrade(restaurantId);

    }

    @PostMapping(value = "/user-comment", produces = "application/json;charset=UTF-8")
    public @ResponseBody
    UserCommentDTO saveUserCommentaryForSpecificRestaurant(@RequestBody UserCommentDTO userComment) {

        return userCommentsService.saveUserComments(userComment);
    }

    @GetMapping(value = "/fetch-user-comment-for-specific-restaurant/{restaurant_id}", produces = "application/json;charset=UTF-8")
    public List<UserCommentDTO> getRestaurantCommentByRestaurantId(
            @PathVariable(value = "restaurant_id") final Integer restaurantId) {

        return userCommentsService.fetchUserCommentsForRestaurant(restaurantId);

    }

}
