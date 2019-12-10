package foodfinder.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "restaurants_grade")
public class RestaurantGrade {

    @Id
    private Integer id_grade;
    private Integer grade;
    private Integer id_restaurants;
    private Integer id_user;

}

