package foodfinder.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Builder
@AllArgsConstructor
@NotNull
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
