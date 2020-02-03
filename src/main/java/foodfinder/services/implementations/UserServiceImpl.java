package foodfinder.services.implementations;

import foodfinder.dto.User;

import foodfinder.repository.UserRepository;
import foodfinder.services.interfaces.UserService;
import liquibase.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;




    @Override
    public List<User> fetchUserInfo(String userName, String userSurname) {

        if (userName == null || userName.isEmpty() && (userSurname == null || userSurname.isEmpty())) {

            return fetchAllUsers();
        }
        if (userName != null && !userName.isEmpty()) {


            return fetchUsersByName(userName);
        }

        if (StringUtils.isNotEmpty(userName)) {


            return fetchUsersBySurname(userSurname);
        }

        return null;
    }

    public User fetchUserById(Integer userId) {

        if (userId != 0) {

            return captureUserById(userId);
        }
        return null;
    }

    public void userDelete(Integer userId) {

        deleteUserInDb(userId);
    }

    public User userCreate(User user) {

        user.setPassword(passHashed(user.getPassword()));

        return saveUserInDb(user);
    }

    public void updateUserPassword(String password, Integer userId){


         updatePassword(passHashed(password), userId);
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


    private String passHashed(String password){


        return passwordEncoder.encode(password);
    }


    private List<User> fetchAllUsers() {

        return userRepository.findAll();

    }



    private List<User> fetchUsersByName(String userName) {

        return userRepository.findUsersByName(userName);
    }

    private List<User> fetchUsersBySurname(String userSurname) {

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
