package foodfinder.services.impl;

import foodfinder.dto.UserDTO;
import foodfinder.exception.RecordNotFoundException;
import foodfinder.repository.UserRepository;
import foodfinder.services.interfaces.UserService;
import liquibase.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserDTO> fetchUserInfo(String userName, String userSurname) {

        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(userSurname)) {

            return userRepository.findAll();

        }
        if (StringUtils.isNotEmpty(userName)) {


            return userRepository.findUsersByName(userName);
        }

        if (StringUtils.isNotEmpty(userSurname)) {


            return userRepository.findUsersBySurname(userSurname);
        }

        return Collections.<UserDTO>emptyList();
    }


    public UserDTO fetchUserById(Integer userId) {

        UserDTO user = userRepository.findUserByUserId(userId);

        if (user == null ) {

            throw new RecordNotFoundException("UserDTO with " + userId + " not found!");
        }
        return user;
    }


    public void userDelete(Integer userId) {

        userRepository.deleteById(userId);
    }

    public UserDTO createUser(UserDTO user) {

        user.setPassword(passHashed(user.getPassword()));

        return userRepository.save(user);
    }

    public void updateAndHashUserPassword(String password, Integer userId) {

        userRepository.updateUserPassword(passHashed(password), userId);

    }

    public void updateUserEmail(String mail, Integer userId) {

        userRepository.updateUserMail(userId, mail);
    }

    public void updateUserNameAndSurname(UserDTO user, Integer userId) {

        UserDTO userDb = userRepository.findUserByUserId(userId);

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
