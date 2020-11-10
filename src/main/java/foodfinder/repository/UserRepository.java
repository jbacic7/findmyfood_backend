package foodfinder.repository;

import foodfinder.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<UserDTO, Integer> {

    UserDTO findUserByUserId(Integer userId);

    List<UserDTO> findUsersByName(String name);

    List<UserDTO> findUsersBySurname(String surname);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE UserDTO u set u.password = :password WHERE u.userId = :customerId")
    int updateUserPassword(@Param("password") String password, @Param("customerId") Integer customerId);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE UserDTO u set u.mail = :mail WHERE u.userId = :customerId")
    int updateUserMail(@Param("customerId") Integer customerId, @Param("mail") String mail);


}
