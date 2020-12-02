package foodfinder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "restaurants_grade")
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

    public Integer getIdGrade() {
        return idGrade;
    }

    public void setIdGrade(Integer idGrade) {
        this.idGrade = idGrade;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getIdRestaurants() {
        return idRestaurants;
    }

    public void setIdRestaurants(Integer idRestaurants) {
        this.idRestaurants = idRestaurants;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }
}

