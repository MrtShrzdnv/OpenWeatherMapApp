package shiriyazdanov_marat.openweathermapapp.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import shiriyazdanov_marat.openweathermapapp.entity.CurrentWeather;

/**
 * Created by Marat_2 on 28.07.2017.
 */

public interface WeatherApi {
    String WEATHER_URL = "http://api.openweathermap.org/data/2.5/";
    @GET("weather")
    Call<CurrentWeather> getData(
            @Query("city name") String cityName,
            @Query("units") String units, // "metric"
            @Query("appid") String appid
    );
}
