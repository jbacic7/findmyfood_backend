package foodfinder.controller;

import foodfinder.dto.UserDTO;
import foodfinder.services.interfaces.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@Validated
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping(value = "/users", produces = "application/json;charset=UTF-8")
    public List<UserDTO> getUsers(@RequestParam(required = false, name = "userName") String userName, @RequestParam(required = false, name = "userSurname") String userSurname) {

        return userService.fetchUserInfo(userName, userSurname);

    }

    @GetMapping(value = "/user/{id}", produces = "application/json;charset=UTF-8")
    public UserDTO getUserById(
            @PathVariable(value = "id") final Integer userId) {

        return userService.fetchUserById(userId);

    }

    @PostMapping(value = "/create-user", produces = "application/json;charset=UTF-8", consumes = "application/json;")
    public @ResponseBody
    UserDTO creatingUser(@RequestBody UserDTO userPassword) {

        return userService.createUser(userPassword);

    }

    @DeleteMapping(value = "/users/{id}",  produces = "application/json;charset=UTF-8", consumes = "application/json;")
    public @ResponseBody
    void deletingUser(@PathVariable(value = "id") Integer userId) {

        userService.userDelete(userId);
    }

    @PutMapping(value = "/users/{id}/password/update", produces = "application/json;charset=UTF-8", consumes = "application/json;")
    public @ResponseBody
    void updateAndHashUserPassword(@PathVariable(value = "id") Integer userId, @RequestBody UserDTO user) {

        userService.updateAndHashUserPassword(user.getPassword(), userId);
    }

    @PutMapping(value = "/users/{id}/mail/update", produces = "application/json;charset=UTF-8", consumes = "application/json;")
    public @ResponseBody
    void updateUserMail(@PathVariable(value = "id") Integer userId, @RequestBody UserDTO user) {

        userService.updateUserEmail(user.getMail(), userId);
    }

    @PutMapping(value = "/update-user/{id}", produces = "application/json;charset=UTF-8", consumes = "application/json;")
    public @ResponseBody
    void updateUserSurnameOrName(@PathVariable(value = "id") Integer userId, @RequestBody UserDTO user) {

        userService.updateUserNameAndSurname(user, userId);
    }

}
