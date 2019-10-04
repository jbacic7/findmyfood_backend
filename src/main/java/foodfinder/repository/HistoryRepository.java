package foodfinder.repository;

import foodfinder.dto.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.sql.Timestamp;
import java.util.List;


public interface HistoryRepository extends JpaRepository<History, String> {

    History findHistoryByHistoryId(Integer historyId);
   List <History> findHistoriesByUserId(Integer userId);
   List <History> findHistoriesByRestaurantId(Integer restaurantsId );
   List <History> findHistoriesByDate(Timestamp date);

}
