package foodfinder.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "restaurants_grade")
public class RestaurantGrade {

    @Id
    @Column(name = "id_grade")
    private Integer idGrade;
    private Integer grade;
    @Column(name = "id_restaurants")
    private Integer idRestaurants;
    @Column(name = "id_user")
    private Integer idUser;

}

