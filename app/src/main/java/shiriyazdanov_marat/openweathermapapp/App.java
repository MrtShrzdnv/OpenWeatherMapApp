package shiriyazdanov_marat.openweathermapapp;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import shiriyazdanov_marat.openweathermapapp.api.WeatherApi;

/**
 * Created by Marat_2 on 05.08.2017.
 */

public class App extends Application {
    private static WeatherApi api;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();
        initApi();
    }

    private void initApi(){
        retrofit = new Retrofit.Builder()
                .baseUrl(WeatherApi.WEATHER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(WeatherApi.class);
    }

    public static WeatherApi getWeatherApi() {
        return api;
    }
}
