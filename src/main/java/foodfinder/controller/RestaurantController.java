package foodfinder.controller;


import foodfinder.dto.Restaurant;
import foodfinder.dto.StatusResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class RestaurantController {

    StatusResponse statusResponse;

    @CrossOrigin
    @RequestMapping(value = "/getAllRestaurantsData", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResponseEntity<Object> allRestaurantData(

            @RequestBody Restaurant restaurant )  {

        restaurant.getName();
        restaurant.getAddress();
        restaurant.getLatitude();
        restaurant.getLongitude();

        statusResponse.setStatusCode(HttpStatus.ACCEPTED.value());
        statusResponse.setStatus(HttpStatus.ACCEPTED);
        statusResponse.setMsg("All restaurant data is here.");

        return new ResponseEntity<>(HttpStatus.OK);

    }

    }


