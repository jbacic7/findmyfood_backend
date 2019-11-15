package foodfinder.services.interfaces;
import foodfinder.dto.User;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public interface UserService {

    List<User> fetchUserInfo(final String userName, final String userSurname);

    User fetchUserId(final Integer userId);

    User userHandlerCreate(User userCreate);

    void userDelete(final Integer useId);

    void updatePasswordHandler( final String password, Integer userId);

    void updateUserEmail(final String mail, Integer userId);

    void updateUserName(final String name, final Integer userId);

    void updateUserSurname( final String surname,final Integer userId );

}
