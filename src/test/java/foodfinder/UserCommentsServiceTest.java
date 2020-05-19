package foodfinder;

import foodfinder.dto.Restaurant;
import foodfinder.dto.User;
import foodfinder.dto.UserComment;
import foodfinder.repository.UserCommentsRepository;
import foodfinder.services.interfaces.UserCommentsService;
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
public class UserCommentsServiceTest {

    @Autowired
    TestData testData;

    @Autowired
    UserCommentsService userCommentsService;

    UserComment userOne;

    UserComment userTwo;

    @Autowired
    UserCommentsRepository userCommentsRepository;

    @Before
    public void setUp(){

        userOne = userCommentsRepository.save(testData.userCommentTestData(99,"Comment65",5,4));

    }

    @After
    public void after(){

        userCommentsRepository.delete(userOne);

    }



    @Test
    public void getRestaurantCommentByRestaurantIdTest(){


        List<UserComment> userComment = userCommentsService.fetchUserCommentsForRestaurant(userOne.getRestaurantId());

        Assert.assertNotNull(userComment);


    }






}
