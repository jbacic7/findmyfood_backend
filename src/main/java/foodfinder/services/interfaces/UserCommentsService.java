package foodfinder.services.interfaces;

import foodfinder.dto.UserCommentDTO;

import java.util.List;


public interface UserCommentsService {

    UserCommentDTO saveUserComments(UserCommentDTO userComment);

    List<UserCommentDTO> fetchUserCommentsForRestaurant(Integer restaurantId);


}
