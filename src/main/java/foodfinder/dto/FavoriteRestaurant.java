package foodfinder.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user_favorite_restaurant")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteRestaurant {
    public Integer getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(Integer favoriteId) {
        this.favoriteId = favoriteId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRestaurantsId() {
        return restaurantsId;
    }

    public void setRestaurantsId(Integer restaurantsId) {
        this.restaurantsId = restaurantsId;
    }

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_favorite")
    @SequenceGenerator(name = "seq_favorite", sequenceName = "seq_favorite", initialValue = 1, allocationSize = 1)
    @Column(name = "id_favorite")
    @Id
    private Integer favoriteId;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "id_restaurants")
    private Integer restaurantsId;

}
