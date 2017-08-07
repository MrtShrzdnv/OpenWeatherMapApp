package shiriyazdanov_marat.openweathermapapp.service;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import shiriyazdanov_marat.openweathermapapp.WeatherApp;
import shiriyazdanov_marat.openweathermapapp.api.WeatherApi;
import shiriyazdanov_marat.openweathermapapp.entity.CurrentWeatherModel;

/**
 * Created by Marat_2 on 07.08.2017.
 */

public class CurrentWeatherService {
    private WeatherApi api = WeatherApp.getWeatherApi();
    private CurrentWeatherModel result = null;

    public CurrentWeatherService (){
    }

    public CurrentWeatherModel getData(String cityName, String units, String appid){
        api.getData(cityName,units,appid).enqueue(new Callback<CurrentWeatherModel>(){

            @Override
            public void onResponse(Call<CurrentWeatherModel> call, Response<CurrentWeatherModel> response) {
                result = response.body();
            }

            @Override
            public void onFailure(Call<CurrentWeatherModel> call, Throwable t) {

            }
        });
        return result;
    }
}
