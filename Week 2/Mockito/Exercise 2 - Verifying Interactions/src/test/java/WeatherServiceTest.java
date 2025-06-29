import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.Mockito;

public class WeatherServiceTest {

    @Test
    public void testVerifyInteraction() {

        WeatherAPI mockApi = Mockito.mock(WeatherAPI.class);

        WeatherService service = new WeatherService(mockApi);

        service.fetchWeather("Mumbai");

        verify(mockApi).getTemperature("Mumbai");
    }
}
