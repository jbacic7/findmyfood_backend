package foodfinder;

import foodfinder.repository.GradeRepository;
import foodfinder.services.impl.GradesServicesImpl;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.VerificationCollector;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)

public class GradeServiceTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @InjectMocks
    private GradesServicesImpl gradesServices;

    @Mock
    private GradeRepository gradeRepository;

    private Integer restaurantId = 1;
    private Double avgResult = 2.0;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAverageRestaurantsGrade() {
        when(gradeRepository.countRestaurantAvgGrade(restaurantId)).thenReturn(avgResult);

        assertThat(gradesServices.averageRestaurantsGrade(restaurantId), is(avgResult));
    }

     @Test
    public void testAverageRestaurantsGradeWhenString() {

        thrown.expect(NumberFormatException.class);

        gradesServices.averageRestaurantsGrade(Integer.valueOf("test"));
    }

}
