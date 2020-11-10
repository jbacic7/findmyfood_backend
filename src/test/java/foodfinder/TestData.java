package foodfinder;

import foodfinder.dto.*;
import org.springframework.stereotype.Component;

@Component
public class TestData {


    public RestaurantGradeDTO restaurantGradeTestData(Integer grade, Integer userId, Integer restaurantId) {

        RestaurantGradeDTO restaurantGrade = new RestaurantGradeDTO();
        restaurantGrade.setGrade(grade);
        restaurantGrade.setIdUser(userId);
        restaurantGrade.setIdRestaurants(restaurantId);

        return restaurantGrade;
    }


    public UserDTO userTestData(String name, String password, String surname, String mail, Integer userId) {

        UserDTO user = new UserDTO();
        user.setUserId(userId);
        user.setName(name);
        user.setPassword(password);
        user.setSurname(surname);
        user.setMail(mail);

        return user;
    }


    public RestaurantDTO restaurantTestData(Integer restaurantId, String type, Float longitude, Float latitude, String name, String address) {

        RestaurantDTO testRestaurant = new RestaurantDTO();
        testRestaurant.setRestaurantId(restaurantId);
        testRestaurant.setType(type);
        testRestaurant.setLongitude(longitude);
        testRestaurant.setLatitude(latitude);
        testRestaurant.setName(name);
        testRestaurant.setAddress(address);
        return testRestaurant;
    }

    public FavoriteRestaurantDTO favoriteRestaurantTestData(Integer favoriteId, Integer userId, Integer restaurantId) {

        FavoriteRestaurantDTO testFavoriteRestaurantDTO = new FavoriteRestaurantDTO();

        testFavoriteRestaurantDTO.setFavoriteId(favoriteId);
        testFavoriteRestaurantDTO.setUserId(userId);
        testFavoriteRestaurantDTO.setRestaurantsId(restaurantId);

        return testFavoriteRestaurantDTO;

    }

    public UserCommentDTO userCommentTestData(Integer commentId, String comment, Integer restaurantId, Integer userId) {

        UserCommentDTO userComment = new UserCommentDTO();

        userComment.setCommentId(commentId);
        userComment.setComment(comment);
        userComment.setRestaurantId(restaurantId);
        userComment.setUserId(userId);

        return userComment;

    }

    public RestaurantTypeDTO restaurantTypeTestData(Integer typeId, String name, String description) {

        RestaurantTypeDTO restaurantType = new RestaurantTypeDTO();

        restaurantType.setTypeId(typeId);
        restaurantType.setName(name);
        restaurantType.setDescription(description);

        return restaurantType;

    }

    public RestaurantDTO restaurantNameAndTypeTestData(Integer restaurantId, String name, String type) {

        RestaurantDTO restaurant = new RestaurantDTO();

        restaurant.setRestaurantId(restaurantId);
        restaurant.setName(name);
        restaurant.setType(type);

        return restaurant;
    }

}




