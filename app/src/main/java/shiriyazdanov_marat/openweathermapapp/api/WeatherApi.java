package shiriyazdanov_marat.openweathermapapp.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import shiriyazdanov_marat.openweathermapapp.entity.CurrentWeatherModel;

/**
 * Created by Marat_2 on 28.07.2017.
 */

public interface WeatherApi {
    String WEATHER_URL = "http://api.openweathermap.org/data/2.5/";
    String KEY = "474b17b7b30d0bace07c1d74ac4f17d3";
    @GET("weather")
    Call<CurrentWeatherModel> getData(
            @Query("city name") String cityName,
            @Query("units") String units, // "metric"
            @Query("appid") String appid
    );
}
