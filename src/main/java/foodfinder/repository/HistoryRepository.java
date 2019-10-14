package foodfinder.repository;

import foodfinder.dto.History;
import org.springframework.data.jpa.repository.JpaRepository;



import java.sql.Timestamp;
import java.util.List;


public interface HistoryRepository extends JpaRepository<History, Integer > {

    History findHistoryByHistoryId(Integer historyId);
    List <History> findHistoriesByUserId(Integer userId);
    List <History> findHistoriesByRestaurantId(Integer restaurantsId );
    List <History> findHistoriesByDate(Timestamp date);


}
