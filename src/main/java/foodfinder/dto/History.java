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
@Table
public class History {

    @Id
    @Column
    private Integer historyId;
    private Integer userId;
    private Integer restaurantId;
    private Timestamp date;

}
