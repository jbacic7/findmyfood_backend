package foodfinder;

import foodfinder.dto.Restaurant;
import foodfinder.dto.User;
import foodfinder.services.interfaces.RestaurantService;
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
@Ignore
public class UserValueTest {

    @Autowired
    UserService userService;


    @Test
    public void fetchUserNameAndSurnameValues() {

        List<User> fetchUserNameAndSurnameValues = userService.fetchUserInfo(null, null);

        Assert.assertTrue(fetchUserNameAndSurnameValues.size() > 1);

    }

    @Test
    public void fetchUserId() {

        Integer userId = 1;

        User fetchUserId = userService.fetchUserId(userId);

        Assert.assertEquals(1, fetchUserId.getUserId().intValue());

    }

    @Test
    public void checkNameFromCreateNewUserTest() {

        User user = new User();

        user.setName("Nikola");
        user.setSurname("Pokrivac");
        user.setMail("nikola.pokrivac@t.ht.hr");
        user.setPassword("pokrivamOkolo");

        User checkUserCreation = userService.userHandlerCreate(user);

        Assert.assertTrue(checkUserCreation.getName() == "Nikola");

    }

    @Test
    public void createNewUserTest() {

        User user = new User();

        user.setName("Marko");
        user.setSurname("Padavac");
        user.setMail("Marko.Padavac@t.ht.hr");
        user.setPassword("pokrivamOkolo");

        User checkUserCreation = userService.userHandlerCreate(user);

        Assert.assertTrue(checkUserCreation == user);

    }

    @Test
    public void removeUserWithSelectedIdTest() {

        Integer id = 22;

        if (userService.fetchUserId(id) == null) {

            throw new NoSuchElementException();
        }
        userService.userDelete(id);

        Assert.assertSame(null, userService.fetchUserId(id));
    }

    @Test
    public void userUpdatePasswordTest(){

        String expectedPassword = "newPassword";

        String userDbPassword = userService.fetchUserId(3).getPassword();

         userService.updatePasswordHandler(expectedPassword, 3 );

         Assert.assertEquals(expectedPassword, userDbPassword);

    }

    @Test
    public void userMailUpdateTest(){

        String newMail= "thisIsTestMail@hotmail.com";

        String userTwoCurrentMail = userService.fetchUserId(2).getMail();

        System.out.println(userTwoCurrentMail);

        userService.updateUserEmail(newMail, 2);

        Assert.assertEquals(newMail, userTwoCurrentMail);

    }

}
