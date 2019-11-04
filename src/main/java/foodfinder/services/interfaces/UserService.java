package foodfinder.services.interfaces;

import foodfinder.dto.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

     List<User>fetchUserInfo(final String userName, final String userSurname);

     User fetchUserId(final Integer userId);


}
