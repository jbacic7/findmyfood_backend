package foodfinder.repository;

import foodfinder.dto.UserCommentDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserCommentsRepository extends JpaRepository<UserCommentDTO, Integer> {


    List<UserCommentDTO> findUserCommentsByRestaurantId(Integer restaurantId);

}
