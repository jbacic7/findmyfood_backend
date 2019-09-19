package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class History {

    private Integer idHistory;
    private Integer idUser;
    private Integer idRestaurant;


}
