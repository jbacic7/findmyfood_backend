package foodfinder.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "restaurants_grade")
@Service
public class RestaurantGrade {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "grade_seq")
    @SequenceGenerator(name = "grade_seq", sequenceName = "seq_grade", initialValue = 1, allocationSize = 1)
    @Id
    @Column(name = "id_grade")

    private Integer idGrade;
    private Integer grade;
    @Column(name = "id_restaurants")
    private Integer idRestaurants;
    @Column(name = "id_user")
    private Integer idUser;

}

