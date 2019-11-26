package foodfinder.services.interfaces;
import foodfinder.dto.User;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public interface UserService {

    List<User> fetchUserInfo(final String userName, final String userSurname);

    User fetchUserById(final Integer userId);

    User userCreate(User userCreate);

    void userDelete(final Integer useId);

    void updateUserPassword(final String password, Integer userId);

    void updateUserEmail(final String mail, Integer userId);

    void updateUserNameAndSurname(final User user,final Integer userId);



}
