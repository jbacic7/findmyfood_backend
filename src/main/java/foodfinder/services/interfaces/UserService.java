package foodfinder.services.interfaces;

import foodfinder.dto.User;
import foodfinder.dto.UserComment;


import java.util.List;



public interface UserService {

    List<User> fetchUserInfo(final String userName, final String userSurname);

    User fetchUserById(final Integer userId);

    User createUser(User createUser);

    void userDelete(final Integer useId);

    void updateAndHashUserPassword(String password, Integer userId);

    void updateUserEmail(final String mail, Integer userId);

    void updateUserNameAndSurname(final User user, final Integer userId);





}
