package foodfinder;

import foodfinder.dto.*;
import org.springframework.stereotype.Component;

@Component
public class TestData {


    public RestaurantGrade restaurantGradeTestData(Integer grade, Integer userId, Integer restaurantId) {

        RestaurantGrade restaurantGrade = new RestaurantGrade();
        restaurantGrade.setGrade(grade);
        restaurantGrade.setIdUser(userId);
        restaurantGrade.setIdRestaurants(restaurantId);

        return restaurantGrade;
    }


    public User userTestData(String name, String password, String surname, String mail, Integer userId) {

        User user = new User();
        user.setUserId(userId);
        user.setName(name);
        user.setPassword(password);
        user.setSurname(surname);
        user.setMail(mail);

        return user;
    }


    public Restaurant restaurantTestData(Integer restaurantId, String type, Float longitude, Float latitude, String name, String address) {

        Restaurant testRestaurant = new Restaurant();
        testRestaurant.setRestaurantId(restaurantId);
        testRestaurant.setType(type);
        testRestaurant.setLongitude(longitude);
        testRestaurant.setLatitude(latitude);
        testRestaurant.setName(name);
        testRestaurant.setAddress(address);
        return testRestaurant;
    }

    public FavoriteRestaurant favoriteRestaurantTestData(Integer favoriteId, Integer userId, Integer restaurantId) {

        FavoriteRestaurant testFavoriteRestaurant = new FavoriteRestaurant();

        testFavoriteRestaurant.setFavoriteId(favoriteId);
        testFavoriteRestaurant.setUserId(userId);
        testFavoriteRestaurant.setRestaurantsId(restaurantId);

        return testFavoriteRestaurant;

    }

    public UserComment userCommentTestData(Integer commentId, String comment, Integer restaurantId, Integer userId) {

        UserComment userComment = new UserComment();

        userComment.setCommentId(commentId);
        userComment.setComment(comment);
        userComment.setRestaurantId(restaurantId);
        userComment.setUserId(userId);

        return userComment;

    }

    public RestaurantType restaurantTypeTestData(Integer typeId, String name, String description) {

        RestaurantType restaurantType = new RestaurantType();

        restaurantType.setTypeId(typeId);
        restaurantType.setName(name);
        restaurantType.setDescription(description);

        return restaurantType;

    }

    public Restaurant restaurantNameAndTypeTestData(Integer restaurantId, String name, String type) {

        Restaurant restaurant = new Restaurant();

        restaurant.setRestaurantId(restaurantId);
        restaurant.setName(name);
        restaurant.setType(type);

        return restaurant;
    }

}




