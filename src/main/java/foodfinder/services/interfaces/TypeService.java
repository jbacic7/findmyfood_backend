package foodfinder.services.interfaces;

import foodfinder.dto.Type;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TypeService {


    List<Type> fetchTypeList();

}
