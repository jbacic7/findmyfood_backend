package foodfinder.repository;

import foodfinder.dto.HistoryDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import java.sql.Timestamp;
import java.util.List;


public interface HistoryRepository extends JpaRepository<HistoryDTO, Integer> {

    HistoryDTO findHistoryByHistoryId(Integer historyId);

    List<HistoryDTO> findHistoriesByUserId(Integer userId);

    List<HistoryDTO> findHistoriesByRestaurantId(Integer restaurantsId);

    List<HistoryDTO> findHistoriesByDate(Timestamp date);


}
