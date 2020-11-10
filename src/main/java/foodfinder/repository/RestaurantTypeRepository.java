package foodfinder.repository;

import foodfinder.dto.RestaurantTypeDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantTypeRepository extends JpaRepository<RestaurantTypeDTO, Integer> {


}
