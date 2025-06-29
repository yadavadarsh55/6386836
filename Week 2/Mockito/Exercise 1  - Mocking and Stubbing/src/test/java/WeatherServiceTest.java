import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;

public class WeatherServiceTest {

    @Test
    public void testExternalApi() {
        WeatherAPI mockApi = Mockito.mock(WeatherAPI.class);
        when(mockApi.getCurrentTemperature()).thenReturn("30°C");
        WeatherService service = new WeatherService(mockApi);
        String result = service.fetchWeather();
        assertEquals("30°C", result);
    }
}
