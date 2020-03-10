package foodfinder.repository;

import foodfinder.dto.RestaurantType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantTypeRepository extends JpaRepository<RestaurantType, Integer > {


}
