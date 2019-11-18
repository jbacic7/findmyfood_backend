package foodfinder.repository;

import foodfinder.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer > {

   User findUserByUserId(Integer userId);
   List <User> findUsersByName(String name);
   List <User> findUsersBySurname(String surname);


   @Modifying(clearAutomatically = true)
   @Transactional
   @Query("UPDATE User u set u.password = :password WHERE u.userId = :customerId")
   int updateUserPassword(@Param("customerId") Integer customerId, @Param("password") String password);


   @Modifying(clearAutomatically = true)
   @Transactional
   @Query("UPDATE User u set u.mail = :mail WHERE u.userId = :customerId")
   int updateUserMail(@Param("customerId") Integer customerId, @Param("mail") String mail);

   @Modifying(clearAutomatically = true)
   @Transactional
   @Query("UPDATE User u set u.name = :name WHERE u.userId = :customerId")
   int updateUserName(@Param("customerId") Integer customerId, @Param("name") String name);

   @Modifying(clearAutomatically = true)
   @Transactional
   @Query("UPDATE User u set u.surname = :surname WHERE u.userId = :customerId")
   int updateUserSurname(@Param("customerId") Integer customerId, @Param("surname") String surname);
}
