package foodfinder.repository;

import foodfinder.dto.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.sql.Timestamp;
import java.util.List;


public interface HistoryRepository extends JpaRepository<History, String> {

    History findHistoriesByHistoryId(Integer historyId);
    History findHistoriesByUserId(Integer userId);
    History findHistoriesByRestaurantId(Integer restaurantsId );
    History findHistoriesByDate(Timestamp date);

}
