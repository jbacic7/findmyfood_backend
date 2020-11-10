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

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    TestData testData;

    UserDTO userOne;

    UserDTO userTwo;
   
    UserDTO userDeleteTest;

    @Before
    public void setUp() {
        userOne = userRepository.save(testData.userTestData("Jurica", "pass", "Bacic", "emailNew@mail.com", 99));
        userTwo = userRepository.save(testData.userTestData("JuricaNew", "newPass", "NewSuraname", "newEmail", 98));
        userDeleteTest = userRepository.save(testData.userTestData("userForDelete", "deletePass", "deleteSurname", "deleteMail", 97));
    }

    @After
    public void after() {

        userRepository.delete(userOne);
        userRepository.delete(userTwo);
        userRepository.delete(userDeleteTest);
    }

    @Test
    public void updateUserNameTest() {

        UserDTO updateUserName = new UserDTO();

        updateUserName.setName("NewJurica");

        userService.updateUserNameAndSurname(updateUserName, userOne.getUserId());

        UserDTO findUserSurname = userRepository.findUserByUserId(userOne.getUserId());

        Assert.assertEquals("NewJurica", findUserSurname.getName() );
    }

    @Test
    public void updateUserSurnameTest() {

        UserDTO updateUserSurname = new UserDTO();

        updateUserSurname.setSurname("Legend");

        userService.updateUserNameAndSurname(updateUserSurname, userOne.getUserId());

        UserDTO findUserSurname = userRepository.findUserByUserId(userOne.getUserId());

        Assert.assertEquals("Legend", findUserSurname.getSurname());

    }

    @Test
    public void fetchAllUsersTest() {

        List<UserDTO> allUsers = userRepository.findAll();

        Assert.assertNotNull(allUsers);
    }

    @Test
    public void fetchUserByNameTest() {

        String userTargetName = userOne.getName();

        String targetNameOfUser = "Jurica";

        Assert.assertEquals(userTargetName, targetNameOfUser);

    }


    @Test
    public void checkUserByIdTest() {

        Integer targetId = userOne.getUserId();

        UserDTO filterUserById = userRepository.findUserByUserId(targetId);

        Assert.assertNotNull(filterUserById);

    }

    @Test
    public void checkSpecificUserById() {

        UserDTO filterUserNameById = userRepository.findUserByUserId(userOne.getUserId());

        Assert.assertEquals(userOne.getName(), filterUserNameById.getName());

    }

    @Test
    public void checkingIsUserFilled() {

        List<UserDTO> user = userRepository.findAll();

        Assert.assertEquals(true, !user.isEmpty());

    }

    @Test
    public void userDeleteTest() {

        if (userRepository.findUserByUserId(userDeleteTest.getUserId()) != null) {

            userRepository.deleteById(userDeleteTest.getUserId());

            UserDTO findingUser = userRepository.findUserByUserId(userDeleteTest.getUserId());

            Assert.assertEquals(null, findingUser);

        }
    }

}
