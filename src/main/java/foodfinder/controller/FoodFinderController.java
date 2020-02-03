package foodfinder.controller;

import foodfinder.dto.Restaurant;
import foodfinder.dto.RestaurantGrade;
import foodfinder.dto.Type;
import foodfinder.dto.User;
import foodfinder.repository.RestaurantRepository;
import foodfinder.services.interfaces.GradesServices;
import foodfinder.services.interfaces.RestaurantService;
import foodfinder.services.interfaces.TypeService;
import foodfinder.services.interfaces.UserService;
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
    UserService userService;

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    RestaurantService restaurantService;

    @Autowired
    TypeService typeService;

    @Autowired
    GradesServices gradesServices;


    @RequestMapping(value = "/restaurants", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<Restaurant> getRestaurants(@RequestParam(required = false, name = "name") String restaurantName, @RequestParam(required = false, name = "type") List<String> restaurantTypeList) {

        return restaurantService.fetchRestaurantValues(restaurantName, restaurantTypeList);

    }

    @RequestMapping(value = "/restaurants/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")

    public Restaurant getRestaurantsId(
            @PathVariable(value = "id") final Integer restaurantId) {

        return restaurantService.fetchRestaurantId(restaurantId);

    }

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<User> getUsers(@RequestParam(required = false, name = "userName") String userName, @RequestParam(required = false, name = "userSurname") String userSurname) {

        return userService.fetchUserInfo(userName, userSurname);

    }

    @RequestMapping(value = "/type", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<Type> getAllTypes() {

        return typeService.fetchTypeList();

    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")

    public User getUserById(
            @PathVariable(value = "id") final Integer userId) {

        return userService.fetchUserById(userId);

    }

    @RequestMapping(value = "/users", method = RequestMethod.POST, produces = "application/json;charset=UTF-8", consumes = "application/json;")
    public @ResponseBody
    User creatingUser(@RequestBody User userCreate) {

        return userService.userCreate(userCreate);

    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8", consumes = "application/json;")
    public @ResponseBody
    void deletingUser(@PathVariable(value = "id") Integer userId) {

        userService.userDelete(userId);
    }

    @RequestMapping(value = "/users/{id}/password/update", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8", consumes = "application/json;")
    public @ResponseBody
    void updateUserPassword(@PathVariable(value = "id") Integer userId, @RequestBody User user) {

        userService.updateUserPassword(user.getPassword(), userId);
    }

    @RequestMapping(value = "/users/{id}/mail/update", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8", consumes = "application/json;")
    public @ResponseBody
    void updateUserMail(@PathVariable(value = "id") Integer userId, @RequestBody User user) {

        userService.updateUserEmail(user.getMail(), userId);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8", consumes = "application/json;")
    public @ResponseBody
    void updateUserSurnameOrName(@PathVariable(value = "id") Integer userId, @RequestBody User user) {

        userService.updateUserNameAndSurname(user, userId);
    }

    @RequestMapping(value = "/grade", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8", consumes = "application/json;")
    public @ResponseBody
    void updateUserMail(Integer idRestaurants, @RequestBody RestaurantGrade restaurantGrade) {

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

}




