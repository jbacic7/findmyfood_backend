package foodfinder.services.implementations;

import foodfinder.dto.User;
import foodfinder.repository.UserRepository;
import foodfinder.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> fetchUserInfo(String userName, String userSurname) {

        if (userName == null || userName.isEmpty() && (userSurname == null || userSurname.isEmpty())) {

            return fetchUserNameAndSurname();
        }
        if (userName != null && !userName.isEmpty()) {


            return fetchUserByName(userName);
        }

        if (userSurname != null && !userSurname.isEmpty()) {


            return fetchUserBySurname(userSurname);
        }

        return null;
    }

    public User fetchUserId(Integer userId) {

        if (userId != 0) {

            return captureUserById(userId);
        }
        return null;
    }

    public void userDelete(Integer userId) {

        deleteUserInDb(userId);
    }

    public User userHandlerCreate(User user) {

        return saveUserInDb(user);
    }

    public void updateUserPassword(String password, Integer userId){

         updatePassword(password, userId);
    }
    public void updateUserEmail(String mail, Integer userId){

        updateUserMail(mail, userId);
    }
    public void updateUserNameAndSurname( User user ,Integer userId ){

        User userDb  = userRepository.findUserByUserId(userId);

        if (user.getName() != null ){

            userDb.setName(user.getName());

        }
        if (user.getSurname() != null){

            userDb.setSurname(user.getSurname());

        }
        updateUserNameAndSurnameById(userDb);
    }

    private List<User> fetchUserNameAndSurname() {

        return userRepository.findAll();
    }

    private List<User> fetchUserByName(String userName) {

        return userRepository.findUsersByName(userName);
    }

    private List<User> fetchUserBySurname(String userSurname) {

        return userRepository.findUsersBySurname(userSurname);
    }

    private User captureUserById(Integer userId) {

        return userRepository.findUserByUserId(userId);

    }

    private User saveUserInDb(User userCreate) {

        return userRepository.save(userCreate);
    }

    private void deleteUserInDb(Integer userId) {

        userRepository.deleteById(userId);
    }

    private void updatePassword(String password, Integer userId){

        userRepository.updateUserPassword( userId, password);
    }

    private void updateUserMail(String mail, Integer userId){

        userRepository.updateUserMail(userId,mail);

    }
    private void updateUserNameAndSurnameById(User user){

        userRepository.save(user);

    }
}