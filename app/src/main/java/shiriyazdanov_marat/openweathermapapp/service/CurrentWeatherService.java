package shiriyazdanov_marat.openweathermapapp.service;

import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import shiriyazdanov_marat.openweathermapapp.App;
import shiriyazdanov_marat.openweathermapapp.api.WeatherApi;
import shiriyazdanov_marat.openweathermapapp.entity.CurrentWeatherModel;

/**
 * Created by Marat_2 on 07.08.2017.
 */

public class CurrentWeatherService {

    public CurrentWeatherModel getData(String str) {

        Response response = null;
        try {
            response = App.getWeatherApi().getData(str, WeatherApi.WEATHER_UNITS, WeatherApi.KEY).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (CurrentWeatherModel) response.body();
    }
}
