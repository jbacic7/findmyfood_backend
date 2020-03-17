package foodfinder;


import foodfinder.dto.User;
import foodfinder.services.interfaces.UserService;
import org.aspectj.weaver.patterns.HasThisTypePatternTriedToSneakInSomeGenericOrParameterizedTypePatternMatchingStuffAnywhereVisitor;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.security.krb5.internal.crypto.dk.Des3DkCrypto;

import java.util.List;
import java.util.NoSuchElementException;

@SpringBootTest
@RunWith(SpringRunner.class)

public class UserServiceTest {

    @Autowired
    UserService userService;





    @Test
    public void fetchUserInfoTest() {

        List<User> fetchUserNameAndSurnameValues = userService.fetchUserInfo(null, null);

        Assert.assertTrue(fetchUserNameAndSurnameValues.size() > 1);


    }

    @Test
    public void fetchUserByIdTest() {

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

        User checkUserCreation = userService.createUser(user);

        Assert.assertTrue(checkUserCreation.getName() == "Nikola");

    }

    @Test
    public void createUserTest() {

        User user = new User();

        user.setName("Marko");
        user.setSurname("Padavac");
        user.setMail("Marko.Padavac@t.ht.hr");
        user.setPassword("pokrivamOkolo");

        User checkUserCreation = userService.createUser(user);

        Assert.assertTrue(checkUserCreation == user);

    }


    @Test
    public void updateAndHashUserPasswordTest() {

        String oldPassword = userService.fetchUserById(3).getPassword();

        userService.updateAndHashUserPassword(oldPassword, 3);

        String newPassword = userService.fetchUserById(3).getPassword();

        Assert.assertNotEquals(oldPassword, newPassword);

    }

    @Test
    public void updateUserEmailTest() {

        String newMail = "thisIsTestMail@hotmail.com";

        String userTwoCurrentMail = userService.fetchUserById(2).getMail();

        System.out.println(userTwoCurrentMail);

        userService.updateUserEmail(newMail, 2);

        Assert.assertEquals(newMail, userTwoCurrentMail);

    }


}
