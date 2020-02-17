package foodfinder.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Entity
@Table(name = "user_favorite_restaurant_table")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Service
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
