package foodfinder.services.impl;

import foodfinder.dto.User;
import foodfinder.dto.UserComment;
import foodfinder.exception.RecordNotFoundException;
import foodfinder.repository.UserCommentsRepository;
import foodfinder.repository.UserRepository;
import foodfinder.services.interfaces.UserService;
import liquibase.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserCommentsRepository userCommentsRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> fetchUserInfo(String userName, String userSurname) {

        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(userSurname)) {

            return userRepository.findAll();

        }
        if (StringUtils.isNotEmpty(userName)) {


            return userRepository.findUsersByName(userName);
        }

        if (StringUtils.isNotEmpty(userSurname)) {


            return userRepository.findUsersBySurname(userSurname);
        }

        return null;
    }


    public User fetchUserById(Integer userId) {

        User user = userRepository.findUserByUserId(userId);

        if (user == null ) {

            throw new RecordNotFoundException("User with " + userId + " not found!");
        }
        return user;
    }


    public void userDelete(Integer userId) {

        userRepository.deleteById(userId);
    }

    public User createUser(User user) {

        user.setPassword(passHashed(user.getPassword()));

        return userRepository.save(user);
    }

    public void updateAndHashUserPassword(String password, Integer userId) {

        userRepository.updateUserPassword(passHashed(password), userId);

    }

    public void updateUserEmail(String mail, Integer userId) {

        userRepository.updateUserMail(userId, mail);
    }

    public void updateUserNameAndSurname(User user, Integer userId) {

        User userDb = userRepository.findUserByUserId(userId);

        if (user.getName() != null) {

            userDb.setName(user.getName());

        }
        if (user.getSurname() != null) {

            userDb.setSurname(user.getSurname());

        }
        userRepository.save(userDb);
    }


    private String passHashed(String password) {


        return passwordEncoder.encode(password);
    }


}
