package foodfinder;


import foodfinder.dto.User;
import foodfinder.repository.UserRepository;
import foodfinder.services.interfaces.UserService;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.NoSuchElementException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Test
    public void fetchAllUserValues() {

        List<User> fetchUserNameAndSurnameValues = userService.fetchUserInfo(null, null);

        Assert.assertTrue(fetchUserNameAndSurnameValues.size() > 1);

    }

    @Test
    public void fetchUserById() {

        Integer userId = 1;

        User fetchUserId = userService.fetchUserById(userId);

        Assert.assertEquals(1, fetchUserId.getUserId().intValue());

    }

    @Test
    public void checkNameFromCreateNewUserTest() {

        User user = new User();

        user.setName("Nikola");
        user.setSurname("Pokrivac");
        user.setMail("nikola.pokrivac@t.ht.hr");
        user.setPassword("pokrivamOkolo");

        User checkUserCreation = userService.userCreate(user);

        Assert.assertTrue(checkUserCreation.getName() == "Nikola");

    }

    @Test
    public void createNewUserTest() {

        User user = new User();

        user.setName("Marko");
        user.setSurname("Padavac");
        user.setMail("Marko.Padavac@t.ht.hr");
        user.setPassword("pokrivamOkolo");

        User checkUserCreation = userService.userCreate(user);

        Assert.assertTrue(checkUserCreation == user);

    }

    @Test
    public void removeUserWithSelectedIdTest() {

        Integer id = 22;

        if (userService.fetchUserById(id) == null) {

            throw new NoSuchElementException();
        }
        userService.userDelete(id);

        Assert.assertSame(null, userService.fetchUserById(id));
    }

    @Test
    public void userUpdatePasswordTest(){

        String expectedPassword = "newPassword";

        String userDbPassword = userService.fetchUserById(3).getPassword();

         userService.updateUserPassword(expectedPassword, 3 );

         Assert.assertEquals(expectedPassword, userDbPassword);

    }

    @Test
    public void userMailUpdateTest(){

        String newMail= "thisIsTestMail@hotmail.com";

        String userTwoCurrentMail = userService.fetchUserById(2).getMail();

        System.out.println(userTwoCurrentMail);

        userService.updateUserEmail(newMail, 2);

        Assert.assertEquals(newMail, userTwoCurrentMail);

    }

    @Test
    public void userNameUpdateTest(){

    User updateUserName = new User();

    updateUserName.setName("Baba");

    userService.updateUserNameAndSurname(updateUserName, 2);

    User findUserName = userRepository.findUserByUserId(2);

    Assert.assertEquals(findUserName.getName(), "Baba");

    }

    @Test
    public void userSurnameUpdateTest(){

        User updateUSerSurname = new User();

        updateUSerSurname.setSurname("Manda");

        userService.updateUserNameAndSurname(updateUSerSurname, 2);

        User findUserSurname  = userRepository.findUserByUserId(2);

        Assert.assertEquals(findUserSurname.getSurname(),"Manda");

    }
}