package shiriyazdanov_marat.openweathermapapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import shiriyazdanov_marat.openweathermapapp.adapter.WeatherAdapter;
import shiriyazdanov_marat.openweathermapapp.api.WeatherApi;
import shiriyazdanov_marat.openweathermapapp.entity.CurrentWeatherModel;
import shiriyazdanov_marat.openweathermapapp.entity.Main;
import shiriyazdanov_marat.openweathermapapp.entity.Wind;
import shiriyazdanov_marat.openweathermapapp.service.CityStorage;
import shiriyazdanov_marat.openweathermapapp.service.CurrentWeatherService;


public class MainActivity extends Activity {

    RecyclerView recyclerView;
    List<CurrentWeatherModel> list;
    CurrentWeatherService service;
    CurrentWeatherModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CityStorage.init(MainActivity.this);
        list = new ArrayList<>();
        service = new CurrentWeatherService();
        List<String> cities = CityStorage.getAll();
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        WeatherAdapter adapter = new WeatherAdapter(list);
        recyclerView.setAdapter(adapter);
        downloadDates(cities);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_add) {
            Intent intent = new Intent(this, SecondActivity.class);
            startActivityForResult(intent, 1);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == 1){
            if(resultCode == Activity.RESULT_OK){
                ArrayList<CurrentWeatherModel> result = data.getParcelableArrayListExtra("result");
                for(CurrentWeatherModel model : result){
                    list.add(model);
                    CityStorage.addProperty(model.getName(),model.getName());
                }
                recyclerView.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private void downloadDates(List<String> cities){
        list.clear();
        for(String str : cities){
            App.getWeatherApi().getData(str,WeatherApi.WEATHER_UNITS,WeatherApi.KEY).enqueue(new Callback<CurrentWeatherModel>(){

                @Override
                public void onResponse(Call<CurrentWeatherModel> call, Response<CurrentWeatherModel> response) {
                    if (response.code() == 200){
                        list.add(response.body());
                        recyclerView.getAdapter().notifyDataSetChanged();
                    }
                }
                @Override
                public void onFailure(Call<CurrentWeatherModel> call, Throwable t) {
                    Log.d("TAG", "FAIL");
                    t.getMessage();
                }
            });
        }
    }
}
