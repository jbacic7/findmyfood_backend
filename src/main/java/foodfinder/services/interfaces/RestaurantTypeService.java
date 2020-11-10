package foodfinder.services.interfaces;

import foodfinder.dto.RestaurantTypeDTO;

import java.util.List;


public interface RestaurantTypeService {


    List<RestaurantTypeDTO> fetchTypeList();

}
