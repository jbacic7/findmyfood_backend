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
        if (userName != null && !userName.isEmpty()){


            return fetchUserByName(userName);
        }

        if (userSurname != null && !userSurname.isEmpty()){


            return fetchUserBySurname(userSurname);
        }

        return null;
    }

    public User fetchUserId(Integer userId){

        if (userId != 0){

            return fetchUserById(userId);
        }
        return null;
    }

   private List<User> fetchUserNameAndSurname() {

        return userRepository.findAll();
    }
   private List<User> fetchUserByName(String userName){

        return userRepository.findUsersByName(userName);
    }
    private List<User> fetchUserBySurname(String userSurname){

        return userRepository.findUsersBySurname(userSurname);
    }
    private User fetchUserById(Integer userId){

        return userRepository.findUserByUserId(userId);

    }

}