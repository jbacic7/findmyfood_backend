package foodfinder.services.interfaces;

import foodfinder.dto.RestaurantType;

import java.util.List;


public interface RestaurantTypeService {


    List<RestaurantType> fetchTypeList();

}
