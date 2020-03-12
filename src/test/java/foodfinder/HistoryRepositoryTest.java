package foodfinder;

import foodfinder.dto.History;
import foodfinder.repository.HistoryRepository;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@Ignore
public class HistoryRepositoryTest {

    @Autowired
    private HistoryRepository historyRepository;

    @Test
    public void checkingIsHistoryEmpty() {

        List<History> history = historyRepository.findAll();

        Assert.assertEquals(true, history.isEmpty());

    }

}
