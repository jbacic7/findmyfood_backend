package foodfinder.repository;

import foodfinder.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer > {

   User findUserByUserId(Integer userId);
   List <User> findUsersByName(String name);
   List <User> findUsersBySurname(String surname);
   User findUserByMail(String mail);

}
