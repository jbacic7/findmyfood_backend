package foodfinder.services.impl;

import foodfinder.dto.User;
import foodfinder.dto.UserComment;
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
    public UserComment createUserComments(UserComment userComment) {

        return userCommentsRepository.save(userComment);

    }

    @Override
    public List<UserComment> fetchUserCommentsByRestaurantId(Integer restaurantId ) {

        if(restaurantId != 0 ){

            List<UserComment> listOfComments = userCommentsRepository.findUserCommentByRestaurantId(restaurantId);

            return listOfComments;

        } else

            return null;
    }

}




