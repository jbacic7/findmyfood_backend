package foodfinder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@NotNull
@Table(name = "users")
@Entity
@OnDelete(action = OnDeleteAction.CASCADE)
public class User {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "seq_user", initialValue = 1, allocationSize = 1)
    @Column(name = "user_id")
    @Id
    private Integer userId;
    private String name;
    private String surname;
    private String mail;
    private String password;
}
