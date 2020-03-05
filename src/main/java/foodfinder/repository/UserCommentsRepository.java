package foodfinder.repository;

import foodfinder.dto.UserComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserCommentsRepository extends JpaRepository<UserComment, Integer > {


  List<UserComment> findUserCommentsByRestaurantId(Integer restaurantId );

}
