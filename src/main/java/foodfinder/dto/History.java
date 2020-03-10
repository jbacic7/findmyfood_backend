package foodfinder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@NotNull
@NoArgsConstructor
@Data
@Table(name = "history")
public class History {

    @Id
    @Column(name = "history_id")
    private Integer historyId;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "restaurants_id")
    private Integer restaurantId;
    private Timestamp date;

}
