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
