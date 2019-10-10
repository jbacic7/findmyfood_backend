package foodfinder.repository;

import foodfinder.dto.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Integer > {

    Type findTypeByTypeId (Integer type_Id);
    Type findTypeByName (String name);

}