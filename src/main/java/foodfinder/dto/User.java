package foodfinder.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id")
    private Integer userId;
    private String name;
    private String surname;
    private String mail;
    private String password;

}
