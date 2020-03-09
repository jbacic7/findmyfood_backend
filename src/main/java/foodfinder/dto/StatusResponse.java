package foodfinder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StatusResponse {

    private int statusCode;
    private HttpStatus  status;
    private String msg;

}
