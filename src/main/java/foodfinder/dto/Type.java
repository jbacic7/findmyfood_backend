package foodfinder.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "type")
public class Type {

    @Id
    @NotNull
    @Column(name = "type_id")
    private Integer typeId;
    @NotNull
    private String name;
    @Nullable
    private String description;

}
