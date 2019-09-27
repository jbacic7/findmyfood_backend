package foodfinder.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Builder
@Data
@AllArgsConstructor
@NotNull
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @Column(name = "restaurant_id")
    private Integer restaurantId;
    private String name;
    private String address;
    private String type;
    private Float latitude;
    private Float longitude;

}
