package foodfinder.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@NotNull
@Table(name = "users")
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

