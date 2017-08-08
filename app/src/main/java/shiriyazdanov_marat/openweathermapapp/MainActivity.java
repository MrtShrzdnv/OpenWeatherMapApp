package shiriyazdanov_marat.openweathermapapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import shiriyazdanov_marat.openweathermapapp.adapter.WeatherAdapter;
import shiriyazdanov_marat.openweathermapapp.api.WeatherApi;
import shiriyazdanov_marat.openweathermapapp.entity.CurrentWeatherModel;
import shiriyazdanov_marat.openweathermapapp.entity.Main;
import shiriyazdanov_marat.openweathermapapp.entity.Wind;
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

        list = new ArrayList<>();
        service = new CurrentWeatherService();

        recyclerView = (RecyclerView) findViewById(R.id.rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        WeatherAdapter adapter = new WeatherAdapter(list);
        recyclerView.setAdapter(adapter);

        model = service.getData("London","metric", WeatherApi.KEY);
        //model = new CurrentWeatherModel(new Main(25.0), new Wind(2.0, 4), "Gorod");
/*
        WeatherApp.getWeatherApi().getData("Kazan","metric",WeatherApi.KEY).enqueue(new Callback<CurrentWeatherModel>(){

            @Override
            public void onResponse(Call<CurrentWeatherModel> call, Response<CurrentWeatherModel> response) {
                model = response.body();
                list.add(model);
                recyclerView.getAdapter().notifyDataSetChanged();
                //Toast.makeText(MainActivity.this,String.valueOf(model.getWindData().getSpeed()),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<CurrentWeatherModel> call, Throwable t) {
                Log.d("TAG", "FAIL");
                t.getMessage();
                Toast.makeText(MainActivity.this,"bad",Toast.LENGTH_SHORT).show();
            }
        });
        */

        //Toast.makeText(MainActivity.this,String.valueOf(model == null),Toast.LENGTH_SHORT).show();
        if (model != null) {
            list.add(model);
            recyclerView.getAdapter().notifyDataSetChanged();
        }

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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
