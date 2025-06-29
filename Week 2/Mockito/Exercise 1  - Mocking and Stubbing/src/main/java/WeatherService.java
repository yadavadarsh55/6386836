public class WeatherService {
    private final WeatherAPI weatherApi;

    public WeatherService(WeatherAPI weatherApi) {
        this.weatherApi = weatherApi;
    }

    public String fetchWeather() {
        return weatherApi.getCurrentTemperature();
    }
}