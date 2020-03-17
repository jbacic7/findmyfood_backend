package foodfinder;

import foodfinder.dto.User;
import foodfinder.repository.UserRepository;
import foodfinder.services.interfaces.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;




    @Test
    public void updateUserNameTest() {

        User updateUserName = new User();

        updateUserName.setName("Ignacio");

        userService.updateUserNameAndSurname(updateUserName, 2);

        User findUserName = userRepository.findUserByUserId(2);

        Assert.assertEquals(findUserName.getName(), "Ignacio");

    }

    @Test
    public void updateUserSurnameTest() {

        User updateUSerSurname = new User();

        updateUSerSurname.setSurname("Legend");

        userService.updateUserNameAndSurname(updateUSerSurname, 2);

        User findUserSurname = userRepository.findUserByUserId(2);

        Assert.assertEquals(findUserSurname.getSurname(), "Legend");

    }

    @Test
    public void fetchAllUsersTest() {

        List<User> allUsers = userRepository.findAll();

        Assert.assertNotNull(allUsers);
    }

    @Test
    public void fetchUserByNameTest() {

        String targetNameOfUser = "Kristijan";

        List<User> userTargetName = userRepository.findUsersByName(targetNameOfUser);

        for (User user : userTargetName) {

            Assert.assertEquals(user.getName(), targetNameOfUser);

        }
    }

    @Test
    public void checkUserByIdTest() {

        Integer targetId = 3;

        User filterUserById = userRepository.findUserByUserId(targetId);

        Assert.assertNotNull(filterUserById);

    }

    @Test
    public void checkSpecificUserById() {

        String name = "Jurica";

        Integer userId = 1;

        User filterUserNameById = userRepository.findUserByUserId(userId);

        Assert.assertEquals(name, filterUserNameById.getName());

    }

    @Test
    public void checkingIsUserFilled() {

        List<User> user = userRepository.findAll();

        Assert.assertEquals(true, !user.isEmpty());

    }

    @Test
    public void userDeleteTest() {

        Integer userId = 20;

        if (userRepository.findUserByUserId(userId) != null) {

            userRepository.deleteById(userId);

            User findingUser = userRepository.findUserByUserId(userId);

            Assert.assertEquals(null, findingUser);

        } else {

            System.out.println("Sry there is no longer user with that ID");

        }
    }

}
