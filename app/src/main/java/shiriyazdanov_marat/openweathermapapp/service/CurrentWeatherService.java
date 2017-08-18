package shiriyazdanov_marat.openweathermapapp.service;

import android.util.Log;

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
    private  CurrentWeatherModel result;
    public CurrentWeatherService (){
    }

    public  void setResult(CurrentWeatherModel r){
        result = r;
    }

    public CurrentWeatherModel getData(String cityName, String units, String appid){
        App.getWeatherApi().getData(cityName,units,appid).enqueue(new Callback<CurrentWeatherModel>(){

            @Override
            public void onResponse(Call<CurrentWeatherModel> call, Response<CurrentWeatherModel> response) {
                result = response.body();
            }
            @Override
            public void onFailure(Call<CurrentWeatherModel> call, Throwable t) {
                Log.d("TAG", "FAIL");
                t.getMessage();
            }
        });
        return result;
    }
}
