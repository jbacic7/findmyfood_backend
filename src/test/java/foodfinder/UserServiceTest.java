package foodfinder;


import foodfinder.dto.UserDTO;
import foodfinder.repository.UserRepository;
import foodfinder.services.interfaces.UserService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TestData testData;

    UserDTO userOne;
    UserDTO userTwo;


    @Before
    public void setUp() {
        userOne = userRepository.save(testData.userTestData("Jurica", "pass", "Bacic", "emailNew@mail.com", 99));
        userTwo = userRepository.save(testData.userTestData("Marko", "password", "Ivanic", "ivanic@gmail.com", 98));

    }

    @After
    public void after() {

        userRepository.delete(userOne);
        userRepository.delete(userTwo);

    }

    @Test
    public void fetchUserInfoTest() {

        List<UserDTO> fetchUserNameAndSurnameValues = userService.fetchUserInfo(userOne.getName(), userOne.getSurname());

        Assert.assertTrue(fetchUserNameAndSurnameValues.size() > 1);

    }

    @Test
    public void fetchUserByIdTest() {

        Integer userOneId = userOne.getUserId();

        Assert.assertNotNull(userOneId);


    }

    @Test

    public void checkNameFromCreateNewUserTest() {

        UserDTO checkUserCreation = userService.createUser(userOne);

        Assert.assertTrue(checkUserCreation.getName() == "Jurica");


    }

    @Test
    public void createUserTest() {

        UserDTO user = userTwo;

        UserDTO checkUserCreation = userService.createUser(user);

        Assert.assertNotNull(checkUserCreation);

    }


    @Test
    public void updateAndHashUserPasswordTest() {

        String oldPassword = userService.fetchUserById(userOne.getUserId()).getPassword();

        userService.updateAndHashUserPassword(oldPassword, userOne.getUserId());

        String newPassword = userService.fetchUserById(userOne.getUserId()).getPassword();

        Assert.assertNotEquals(oldPassword, newPassword);

    }

    @Test
    public void updateUserEmailTest() {

        String newMail = "thisIsTestMail@hotmail.com";

        String userTwoCurrentMail = userService.fetchUserById(userOne.getUserId()).getMail();

        userService.updateUserEmail(newMail, userOne.getUserId());

        Assert.assertNotEquals(newMail, userTwoCurrentMail);

    }


}
