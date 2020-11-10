package foodfinder.services.interfaces;

import foodfinder.dto.UserDTO;


import java.util.List;



public interface UserService {

    List<UserDTO> fetchUserInfo(final String userName, final String userSurname);

    UserDTO fetchUserById(final Integer userId);

    UserDTO createUser(UserDTO createUser);

    void userDelete(final Integer useId);

    void updateAndHashUserPassword(String password, Integer userId);

    void updateUserEmail(final String mail, Integer userId);

    void updateUserNameAndSurname(final UserDTO user, final Integer userId);

}
