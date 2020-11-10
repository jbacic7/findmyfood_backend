package foodfinder.services.impl;

import foodfinder.dto.UserCommentDTO;
import foodfinder.repository.UserCommentsRepository;
import foodfinder.services.interfaces.UserCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserCommentsImpl implements UserCommentsService {

    @Autowired
    UserCommentsRepository userCommentsRepository;




    @Override
    public UserCommentDTO saveUserComments(UserCommentDTO userComment) {

        return userCommentsRepository.save(userComment);

    }

    @Override
    public List<UserCommentDTO> fetchUserCommentsForRestaurant(Integer restaurantId) {

        return userCommentsRepository.findUserCommentsByRestaurantId(restaurantId);

    }

}




