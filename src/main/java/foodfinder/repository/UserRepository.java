package foodfinder.repository;

import foodfinder.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.*;
import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {

    List<User> findUsersByUserId(Integer userId);
    List<User> findUsersByName(String name);
    List<User> findUsersBySurname(String surname);
    List<User> findUsersByMail(String mail);
    List<User> findUsersByPassword(String password);


}
