package foodfinder.services.interfaces;

import foodfinder.dto.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {

    List<User> fetchUserInfo(final String userName, final String userSurname);

    User fetchUserById(final Integer userId);

    User createUser(User createUser);

    void userDelete(final Integer useId);

    void updateUserPassword(String password, Integer userId);

    void updateUserEmail(final String mail, Integer userId);

    void updateUserNameAndSurname(final User user, final Integer userId);

}
