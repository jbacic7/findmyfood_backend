package foodfinder.controller;

import foodfinder.dto.User;
import foodfinder.dto.UserComment;
import foodfinder.services.interfaces.UserCommentsService;
import foodfinder.services.interfaces.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@Validated
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserCommentsService userCommentsService;

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<User> getUsers(@RequestParam(required = false, name = "userName") String userName, @RequestParam(required = false, name = "userSurname") String userSurname) {

        return userService.fetchUserInfo(userName, userSurname);

    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public User getUserById(
            @PathVariable(value = "id") final Integer userId) {

        return userService.fetchUserById(userId);

    }

    @RequestMapping(value = "/create-user", method = RequestMethod.POST, produces = "application/json;charset=UTF-8", consumes = "application/json;")
    public @ResponseBody
    User creatingUser(@RequestBody User userPassword) {

        return userService.createUser(userPassword);

    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8", consumes = "application/json;")
    public @ResponseBody
    void deletingUser(@PathVariable(value = "id") Integer userId) {

        userService.userDelete(userId);
    }

    @RequestMapping(value = "/users/{id}/password/update", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8", consumes = "application/json;")
    public @ResponseBody
    void updateAndHashUserPassword(@PathVariable(value = "id") Integer userId, @RequestBody User user) {

        userService.updateAndHashUserPassword(user.getPassword(), userId);
    }

    @RequestMapping(value = "/users/{id}/mail/update", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8", consumes = "application/json;")
    public @ResponseBody
    void updateUserMail(@PathVariable(value = "id") Integer userId, @RequestBody User user) {

        userService.updateUserEmail(user.getMail(), userId);
    }

    @RequestMapping(value = "/update-user/{id}", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8", consumes = "application/json;")
    public @ResponseBody
    void updateUserSurnameOrName(@PathVariable(value = "id") Integer userId, @RequestBody User user) {

        userService.updateUserNameAndSurname(user, userId);
    }

    @RequestMapping(value = "/user/comment/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<UserComment> getUserCommentByUserId(
            @PathVariable(value = "id") final Integer restaurantId) {

        return userCommentsService.fetchUserCommentsByRestaurantId(restaurantId);

    }


}
