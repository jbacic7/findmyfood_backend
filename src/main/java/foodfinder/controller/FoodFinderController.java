package foodfinder.controller;

import foodfinder.dto.Restaurant;
import foodfinder.dto.User;
import foodfinder.repository.RestaurantRepository;
import foodfinder.services.interfaces.RestaurantService;
import foodfinder.services.interfaces.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@Slf4j
@Validated
@Component
public class FoodFinderController {

    @Autowired
    UserService userService;

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
    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<User> getUsers(@RequestParam(required = false, name = "userName") String userName, @RequestParam(required = false, name = "userSurname") String userSurname) {

        return userService.fetchUserInfo(userName,userSurname);

    }
    @CrossOrigin
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")

    public User getUserById(
            @PathVariable(value = "id") final Integer userId) {

        return userService.fetchUserId(userId);

    }

    @CrossOrigin
    @RequestMapping(value = "/users", method = RequestMethod.POST, produces = "application/json;charset=UTF-8", consumes ="application/json;" )
    public @ResponseBody User creatingUser(@RequestBody User userCreate) {

        return userService.userHandlerCreate(userCreate);
    }

    @CrossOrigin
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8", consumes ="application/json;" )
    public @ResponseBody void deletingUser(@PathVariable (value = "id") Integer userId) {

         userService.userDelete(userId);
    }
    @CrossOrigin
    @RequestMapping(value = "/users/{id}/password/update", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8", consumes ="application/json;" )
    public @ResponseBody void updateUserPassword(@PathVariable (value = "id") Integer userId, @RequestBody User user) {

        userService.updatePasswordHandler(user.getPassword(),userId );
    }

    @CrossOrigin
    @RequestMapping(value = "/users/{id}/mail/update", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8", consumes ="application/json;" )
    public @ResponseBody void updateUserMail (@PathVariable (value = "id") Integer userId, @RequestBody User user) {

        userService.updateUserEmail(user.getMail(),userId );
    }

    }




