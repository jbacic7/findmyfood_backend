package foodfinder.repository;

import foodfinder.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserByUserId(Integer userId);

    List<User> findUsersByName(String name);

    List<User> findUsersBySurname(String surname);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE User u set u.password = :password WHERE u.userId = :customerId")
    int updateUserPassword(@Param("password") String password, @Param("customerId") Integer customerId);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE User u set u.mail = :mail WHERE u.userId = :customerId")
    int updateUserMail(@Param("customerId") Integer customerId, @Param("mail") String mail);


}
