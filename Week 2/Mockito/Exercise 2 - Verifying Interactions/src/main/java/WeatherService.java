public class WeatherService {
    private final WeatherAPI weatherApi;

    public WeatherService(WeatherAPI weatherApi) {
        this.weatherApi = weatherApi;
    }

    public void fetchWeather(String city) {
        weatherApi.getTemperature(city);
    }
}