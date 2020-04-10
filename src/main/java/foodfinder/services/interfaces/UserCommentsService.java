package foodfinder.services.interfaces;

import foodfinder.dto.UserComment;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserCommentsService {

    UserComment saveUserComments(UserComment userComment);

    List<UserComment> fetchUserCommentsForRestaurant(Integer restaurantId);


}
