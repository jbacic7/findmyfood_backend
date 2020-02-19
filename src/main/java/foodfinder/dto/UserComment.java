package foodfinder.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@NotNull
@Table(name = "user_comment")
public class UserComment {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_comment")
    @SequenceGenerator(name = "seq_comment", sequenceName = "seq_comment", initialValue = 1, allocationSize = 1)
    @Id
    @Column(name = "comment_id")
    Integer commentId;
    String comment;
    @Column(name = "user_id")
    Integer userId;
    @Column(name = "restaurant_id")
    Integer restaurantId;

}
