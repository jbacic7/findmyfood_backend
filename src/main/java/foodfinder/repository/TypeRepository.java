package foodfinder.repository;

import foodfinder.dto.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Integer> {

    Type findTypesByTypeId (Integer type_Id);
    Type findTypesByName (String name);
    Type findTypesByDescription(String description);

}
